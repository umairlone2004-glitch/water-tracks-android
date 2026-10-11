# Water Tracks 💧

A polished Android water-tracking app built with **Kotlin** and **Jetpack Compose**, using a clean blue **Material 3** design.

## Features

- **Daily goal of 8 glasses** with a large circular progress indicator
- **Add Glass** button to log each glass
- **Reset** button to start the day over
- **Persistence** — the count is stored with Jetpack DataStore and restored after the app is closed
- Clean blue Material 3 theme with light and dark support

## Project structure

```
app/src/main/java/com/example/watertracks/
├── MainActivity.kt              # Entry point, sets the Compose content
├── data/WaterRepository.kt      # DataStore-backed persistence
└── ui/
    ├── WaterViewModel.kt        # State holder + Add Glass / Reset logic
    ├── WaterScreen.kt           # The Compose UI
    └── theme/                   # Color, Type, Theme (Material 3)
```

## How it works

- `WaterRepository` exposes the glass count as a `Flow<Int>` backed by `preferencesDataStore`.
- `WaterViewModel` exposes that flow as a `StateFlow` and writes changes back on **Add Glass** / **Reset**.
- `WaterScreen` renders a `CircularProgressIndicator` whose progress is `count / 8`, animated with `animateFloatAsState`, plus the two action buttons.

## Build & run

Open the project in **Android Studio** (Ladybug or newer) and run it on a device or emulator (min SDK 24).

From the command line, generate the Gradle wrapper once and build:

```bash
gradle wrapper          # only needed if ./gradlew is missing
./gradlew assembleDebug
```

The debug APK is written to `app/build/outputs/apk/debug/app-debug.apk`.

## Tech

- Kotlin 1.9.24
- Android Gradle Plugin 8.5.2, Gradle 8.7
- Jetpack Compose (BOM 2024.09.00), Material 3
- Jetpack DataStore Preferences 1.1.1
- Compile/target SDK 34, min SDK 24
