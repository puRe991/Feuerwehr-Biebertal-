const LOCAL_DIRECTUS_URL = 'http://localhost:8055';

const rawCmsAdminUrl =
  import.meta.env.PUBLIC_CMS_ADMIN_URL ||
  import.meta.env.PUBLIC_DIRECTUS_URL ||
  import.meta.env.DIRECTUS_URL ||
  (import.meta.env.DEV ? LOCAL_DIRECTUS_URL : undefined);

const normalizeBaseUrl = (url: string) => url.trim().replace(/\/+$/, '');

const toValidHttpUrl = (value: unknown) => {
  if (typeof value !== 'string' || !value.trim()) return undefined;

  try {
    const url = new URL(normalizeBaseUrl(value));
    if (url.protocol !== 'https:' && url.protocol !== 'http:') return undefined;
    return url.toString().replace(/\/+$/, '');
  } catch {
    return undefined;
  }
};

export const cmsAdminUrl = toValidHttpUrl(rawCmsAdminUrl);
export const hasCmsAdmin = Boolean(cmsAdminUrl);
export const usesLocalCmsFallback =
  !configuredCmsAdminUrl && import.meta.env.DEV && cmsAdminUrl === LOCAL_DIRECTUS_URL;
