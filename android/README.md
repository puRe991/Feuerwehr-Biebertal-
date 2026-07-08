# Feuerwehr Biebertal – Android App

Native Android-App (Kotlin, Jetpack Compose, Material 3) für die Freiwillige Feuerwehr Biebertal. Losgelöst von der Astro-Website in `../src`, mit eigenem Feuerwehr-Design und realen, recherchierten Inhalten.

## Design

- Eigenes Feuerwehr-Design statt generischem Material-Look: Schild-Wappen mit Verlaufs-Flamme (`ic_wappen`) im `AppHeader` auf jedem Screen, darunter ein rot/leuchtgelb-grüner Chevron-Warnstreifen (`HazardStripe`), wie er als Heckmarkierung auf echten Einsatzfahrzeugen zu finden ist.
- Eigene Vektorgrafiken mit Farbverläufen in `app/src/main/res/drawable/`: Schild-Wappen (`ic_wappen`), farbiges Feuerwehrauto für die Fahrzeugliste (`ic_fire_truck_color`) und vereinfachte Silhouette für die Bottom-Navigation (`ic_fire_truck`), Drohne (`ic_drone`).
- Alle Grafiken wurden vor der Umsetzung als SVG entworfen und per Headless-Chromium-Screenshot visuell geprüft, bevor sie 1:1 als Android-VectorDrawables (inkl. Gradients) übernommen wurden.
- Adaptive App-Icon und animiertes Splash-Icon nutzen dieselbe Verlaufs-Flamme wie das Wappen im Header – ein durchgängiges Markenbild statt Einzelgrafiken.
- Notruf-Karte (112) auf dem Start-Bildschirm mit Rot-Verlauf, Pill-Button und direktem Wahl-Intent.

## Technik

- Kotlin + Jetpack Compose, Material 3
- Navigation über `androidx.navigation-compose` mit Bottom Navigation: Start, Meldungen, Einsätze, Fahrzeuge, Kontakt
- Splash Screen über `androidx.core.splashscreen`
- Inhalte als statische Kotlin-Daten in `app/src/main/java/de/feuerwehrbiebertal/app/data/*.kt`
- minSdk 26, targetSdk/compileSdk 34
- Keine Netzwerkzugriffe, keine Tracking-SDKs

## Inhalte und Quellen

Die Inhalte wurden anhand öffentlich zugänglicher Quellen recherchiert und in den Datendateien hinterlegt:

- [feuerwehr-biebertal.de](https://www.feuerwehr-biebertal.de/) – Kontakt, Schutzbereichsleitung, Fahrzeugübersicht, aktuelle Meldungen
- [biebertal.de](https://www.biebertal.de/politik-verwaltung/oeffentliche-einrichtungen/feuerwehr/feuerwehr.html) – Organisationsstruktur, Ortsteile, Leitung
- [feuerwehr.hessen.de – Feuerwehr des Monats](https://feuerwehr.hessen.de/ehrenamt/feuerwehr-des-monats/freiwillige-feuerwehr-biebertal) – Auszeichnung Dezember 2019, Einsatzzahlen
- [ffw-frankenbach.de/Geschichte](https://ffw-frankenbach.de/Geschichte/) – Historie der Wehr Frankenbach (Schutzbereich Nord)
- [Vogelsberger Zeitung, 3. Mai 2026](https://www.vogelsberger-zeitung.de/2026/05/03/biebertal-toedlicher-verkehrsunfall/) und [Gießener Anzeiger, 11. April 2022](https://www.giessener-anzeiger.de/lokales/biebertal-ort1521682/dritter-grossbrand-in-folge-91471066.html) – Grundlage für die zwei Einträge in `Einsatzbericht.kt`

Namen, Adressen und Zahlen (z. B. Mitgliederzahlen, Fahrzeugtypen) stammen von dort und können sich ändern – bei Zweifeln bitte gegen die offizielle Website prüfen. Genaue Funkrufnamen einzelner Fahrzeuge sind nicht öffentlich gelistet und wurden daher bewusst nicht erfunden; stattdessen werden die realen Fahrzeugtyp-Kurzbezeichnungen (z. B. `HLF 20`, `GW-L KatS`) verwendet.

## Fahrzeugfotos und Social Media

Es gibt keine frei lizenzierten echten Fotos der Biebertaler Fahrzeuge (kein Wikimedia-Commons-Bestand). Statt urheberrechtlich geschützte Fotos von Facebook/Instagram ungefragt in die App zu kopieren, verlinkt die App auf die echten Kanäle:

- WhatsApp-Kanal (`WHATSAPP_CHANNEL_URL` in `SocialLinks.kt`) – auch als Aktion in der Meldung "Neuer WhatsApp-Kanal"
- Facebook (`FACEBOOK_URL`) – u. a. als "Echte Einsatzfotos ansehen"-Link auf dem Fahrzeuge-Screen
- Instagram (`INSTAGRAM_URL`)

Alle drei sind zusätzlich im Kontakt-Screen unter "Folgen & Fotos" verlinkt.

## Einsatzberichte

`Einsatzbericht.kt` enthält zwei Einträge. Die Feuerwehr Biebertal veröffentlicht selbst keine Einsatzberichte ohne interne Freigabe; da keine solchen Berichte öffentlich vorliegen, fassen die beiden Einträge stattdessen bereits von der Lokalpresse öffentlich berichtete Einsätze zusammen (siehe Quellen oben) – bewusst ohne Namen, Kennzeichen oder sonstige personenbezogene Angaben. Einer der beiden Einsätze betrifft einen tödlichen Verkehrsunfall; wer das nicht in der App zeigen möchte, kann den Eintrag `verkehrsunfall-l3047-2026` einfach aus der Liste entfernen.

## Öffnen und bauen

1. Android Studio (Koala oder neuer) öffnen, Projektordner `android/` auswählen.
2. Gradle-Sync abwarten (lädt AGP 8.5.2, Kotlin 2.0.21, Compose BOM 2024.06.00).
3. App auf Emulator oder Gerät starten (Run ▶️).

Kommandozeile (Android SDK muss lokal installiert und `ANDROID_HOME`/`local.properties` gesetzt sein):

```bash
./gradlew assembleDebug
```

Die fertige APK liegt danach unter `app/build/outputs/apk/debug/app-debug.apk`.

## Inhalte pflegen

Da die App aktuell ausschließlich mit statischen Daten arbeitet, werden neue Meldungen, Einsatzberichte, Fahrzeuge oder Ansprechpartner direkt in den Kotlin-Dateien unter `app/src/main/java/de/feuerwehrbiebertal/app/data/` gepflegt und erfordern einen neuen App-Build.

Siehe Abschnitt "Einsatzberichte" unten zur Herkunft der aktuellen Einträge.

## Bekannte Grenzen dieser Version

- Keine Anbindung an das Directus-CMS der Website; Inhalte sind rein statisch und offline.
- Fahrzeuge sind anhand öffentlich bekannter Typen den Schutzbereichen zugeordnet; die exakte Verteilung aller 16 Fahrzeuge ist nicht vollständig öffentlich dokumentiert.
- Keine automatisierten Tests (Unit/UI) enthalten.
