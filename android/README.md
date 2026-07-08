# Feuerwehr Biebertal – Android App

Native Android-App (Kotlin, Jetpack Compose, Material 3) für die Freiwillige Feuerwehr Biebertal. Losgelöst von der Astro-Website in `../src`, aber inhaltlich mit deren Fallback-Daten synchron.

## Technik

- Kotlin + Jetpack Compose, Material 3
- Navigation über `androidx.navigation-compose` mit Bottom Navigation (Meldungen, Einsätze, Fahrzeuge, Kontakt)
- Inhalte als statische Kotlin-Daten in `app/src/main/java/de/feuerwehrbiebertal/app/data/*.kt`, portiert aus `../src/data/*.ts`
- minSdk 26, targetSdk/compileSdk 34
- Keine Netzwerkzugriffe, keine Tracking-SDKs

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

Da die App aktuell ausschließlich mit statischen Daten arbeitet, werden neue Meldungen, Einsatzberichte, Fahrzeuge oder Ansprechpartner direkt in den Kotlin-Dateien unter `app/src/main/java/de/feuerwehrbiebertal/app/data/` gepflegt und erfordern einen neuen App-Build. Die Struktur ist bewusst deckungsgleich mit den TypeScript-Fallbacks der Website gehalten, damit beide Quellen leicht synchron bleiben.

`einsatzberichte.kt` ist absichtlich leer, solange keine Einsatzberichte intern freigegeben sind (siehe Datenschutzhinweise in der Haupt-README).

## Bekannte Grenzen dieser ersten Version

- Keine Anbindung an das Directus-CMS der Website; Inhalte sind rein statisch und offline.
- App-Icon ist aus dem bestehenden `favicon.svg`-Design abgeleitet, aber nicht pixelgenau mit dem Image-Asset-Tool von Android Studio nachbearbeitet.
- Keine automatisierten Tests (Unit/UI) enthalten.
