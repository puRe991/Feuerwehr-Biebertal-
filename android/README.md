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

Namen, Adressen und Zahlen (z. B. Mitgliederzahlen, Fahrzeugtypen) stammen von dort und können sich ändern – bei Zweifeln bitte gegen die offizielle Website prüfen. Genaue Funkrufnamen einzelner Fahrzeuge sind nicht öffentlich gelistet und wurden daher bewusst nicht erfunden; stattdessen werden die realen Fahrzeugtyp-Kurzbezeichnungen (z. B. `HLF 20`, `GW-L KatS`) verwendet.

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

`Einsatzbericht.kt` ist absichtlich leer, solange keine Einsatzberichte intern freigegeben sind (siehe Datenschutzhinweise in der Haupt-README).

## Bekannte Grenzen dieser Version

- Keine Anbindung an das Directus-CMS der Website; Inhalte sind rein statisch und offline.
- Fahrzeuge sind anhand öffentlich bekannter Typen den Schutzbereichen zugeordnet; die exakte Verteilung aller 16 Fahrzeuge ist nicht vollständig öffentlich dokumentiert.
- Keine automatisierten Tests (Unit/UI) enthalten.
