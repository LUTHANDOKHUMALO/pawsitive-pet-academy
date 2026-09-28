#  Pawsitive Pet Academy

A native Android app that lets clients browse pet training and care courses, calculate enrollment fees with automated VAT and discount processing, and manage bookings through a simple, intuitive interface.

## Features

- **Browse courses** – view pet training and care courses on offer
- **Fees calculator** – calculate enrollment fees with VAT and discounts applied automatically
- **Register** – create an account / sign up for courses
- **Bookings** – manage your course bookings

## Tech Stack

- **Language:** Kotlin
- **Platform:** Android (native)
- **Build system:** Gradle (Kotlin DSL)
- **IDE:** Android Studio

### Run the app

1. Clone the repository:
   ```bash
   git clone https://github.com/LUTHANDOKHUMALO/pawsitive-pet-academy.git
   ```
2. Open the project in Android Studio.
3. Wait for Gradle to sync.
4. Select a device or emulator and click **Run ▶**.

## Project Structure

```
pawsitive-pet-academy/
├── app/                  # Main application module
│   └── src/main/
│       ├── java/         # Kotlin source (activities, logic)
│       └── res/layout/   # XML layouts (register, fees calculator, etc.)
├── gradle/               # Gradle wrapper and version catalog
├── build.gradle.kts      # Project-level build config
└── settings.gradle.kts   # Project settings
```

