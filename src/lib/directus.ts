import { einsatzberichte as fallbackEinsatzberichte, type Einsatzbericht } from '@/data/einsatzberichte';
import { news as fallbackNews, type NewsItem } from '@/data/news';

type DirectusListResponse<T> = {
  data?: T[];
};

type DirectusNewsItem = Partial<{
  slug: string;
  titel: string;
  title: string;
  kategorie: NewsItem['kategorie'];
  category: NewsItem['kategorie'];
  datum: string;
  date: string;
  teaser: string;
  status: string;
}>;

type DirectusEinsatzbericht = Partial<{
  slug: string;
  datum: string;
  date: string;
  einsatzart: string;
  incident_type: string;
  ortsteil: string;
  district: string;
  kurzbeschreibung: string;
  summary: string;
  einheiten: string[] | string;
  units: string[] | string;
  datenschutzHinweis: string;
  privacy_notice: string;
  status: string;
}>;

const DIRECTUS_URL = import.meta.env.DIRECTUS_URL || import.meta.env.PUBLIC_DIRECTUS_URL;
const DIRECTUS_TOKEN = import.meta.env.DIRECTUS_TOKEN;
const ENABLE_DIRECTUS = String(import.meta.env.ENABLE_DIRECTUS ?? 'true') !== 'false';

const NEWS_CATEGORIES = new Set<NewsItem['kategorie']>(['Veranstaltung', 'Presse', 'Hinweis']);

const isNewsItem = (item: NewsItem | undefined): item is NewsItem => Boolean(item);
const isEinsatzbericht = (item: Einsatzbericht | undefined): item is Einsatzbericht => Boolean(item);

const isConfigured = () => ENABLE_DIRECTUS && typeof DIRECTUS_URL === 'string' && DIRECTUS_URL.trim().length > 0;

const normalizeBaseUrl = (url: string) => url.replace(/\/+$/, '');

const asNonEmptyString = (value: unknown) => (typeof value === 'string' && value.trim() ? value.trim() : undefined);

const asDateString = (value: unknown) => {
  const raw = asNonEmptyString(value);
  if (!raw) return undefined;

  const date = new Date(raw);
  if (Number.isNaN(date.getTime())) return undefined;

  return date.toISOString().slice(0, 10);
};

const asUnits = (value: DirectusEinsatzbericht['einheiten']) => {
  if (Array.isArray(value)) return value.map(asNonEmptyString).filter(Boolean) as string[];
  const raw = asNonEmptyString(value);
  if (!raw) return [];
  return raw.split(',').map((unit) => unit.trim()).filter(Boolean);
};

const getJson = async <T>(collection: string, searchParams: URLSearchParams): Promise<T[]> => {
  if (!isConfigured()) return [];

  const url = new URL(`${normalizeBaseUrl(DIRECTUS_URL)}/items/${collection}`);
  searchParams.forEach((value, key) => url.searchParams.set(key, value));

  const headers: HeadersInit = { Accept: 'application/json' };
  if (DIRECTUS_TOKEN) headers.Authorization = `Bearer ${DIRECTUS_TOKEN}`;

  try {
    const response = await fetch(url, { headers });
    if (!response.ok) {
      console.warn(`Directus collection "${collection}" konnte nicht geladen werden: ${response.status} ${response.statusText}`);
      return [];
    }

    const payload = (await response.json()) as DirectusListResponse<T>;
    return Array.isArray(payload.data) ? payload.data : [];
  } catch (error) {
    console.warn(`Directus collection "${collection}" konnte nicht geladen werden.`, error);
    return [];
  }
};

const mapNewsItem = (item: DirectusNewsItem): NewsItem | undefined => {
  const slug = asNonEmptyString(item.slug);
  const titel = asNonEmptyString(item.titel) || asNonEmptyString(item.title);
  const datum = asDateString(item.datum) || asDateString(item.date);
  const teaser = asNonEmptyString(item.teaser);
  const category = item.kategorie || item.category;
  const kategorie = category && NEWS_CATEGORIES.has(category) ? category : undefined;

  if (!slug || !titel || !datum || !teaser || !kategorie) return undefined;
  return { slug, titel, kategorie, datum, teaser };
};

const mapEinsatzbericht = (item: DirectusEinsatzbericht): Einsatzbericht | undefined => {
  const slug = asNonEmptyString(item.slug);
  const datum = asDateString(item.datum) || asDateString(item.date);
  const einsatzart = asNonEmptyString(item.einsatzart) || asNonEmptyString(item.incident_type);
  const ortsteil = asNonEmptyString(item.ortsteil) || asNonEmptyString(item.district);
  const kurzbeschreibung = asNonEmptyString(item.kurzbeschreibung) || asNonEmptyString(item.summary);
  const einheiten = asUnits(item.einheiten || item.units);
  const datenschutzHinweis = asNonEmptyString(item.datenschutzHinweis) || asNonEmptyString(item.privacy_notice);

  if (!slug || !datum || !einsatzart || !ortsteil || !kurzbeschreibung || !datenschutzHinweis) return undefined;
  return { slug, datum, einsatzart, ortsteil, kurzbeschreibung, einheiten, datenschutzHinweis };
};

export const getNews = async (): Promise<NewsItem[]> => {
  const params = new URLSearchParams({
    fields: '*',
    'filter[status][_eq]': 'published',
  });
  const items = (await getJson<DirectusNewsItem>('news', params))
    .map(mapNewsItem)
    .filter(isNewsItem)
    .sort((a, b) => String(b.datum).localeCompare(String(a.datum)));
  return items.length > 0 ? items : fallbackNews;
};

export const getEinsatzberichte = async (): Promise<Einsatzbericht[]> => {
  const params = new URLSearchParams({
    fields: '*',
    'filter[status][_eq]': 'published',
  });
  const items = (await getJson<DirectusEinsatzbericht>('einsatzberichte', params))
    .map(mapEinsatzbericht)
    .filter(isEinsatzbericht)
    .sort((a, b) => String(b.datum).localeCompare(String(a.datum)));
  return items.length > 0 ? items : fallbackEinsatzberichte;
};
