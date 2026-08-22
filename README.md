# ParkKro — Smart Parking System

An Android app for booking parking slots, built with Java and Firebase. Users sign in with a phone number OTP, reserve a parking slot with a time and vehicle number, pay online via Razorpay, and can optionally add EV charging or car wash services during their stay.

## Features

- **Phone number login via OTP** — users register their name, phone, and vehicle number, and sign in with Firebase Phone Authentication (`Account`, `verify_OTP`).
- **Parking slot selection** — a visual slot map lets users pick an available parking spot and set a reservation time (`Slots`).
- **Booking summary** — shows name, phone, vehicle number, slot, rate/time, and cost before confirming (`MainActivity`).
- **Online payment** — slot bookings are paid for through Razorpay checkout integration (`Payment`).
- **EV charging add-on** — users can browse charging options (Ola, Ather) for electric vehicles while parked (`Charging`).
- **Car wash add-on** — users can request a car wash, with a one-tap call button to the service number (`Wash`).
- **Local session memory** — signed-in user details (name, phone, vehicle number) persist across app restarts via local file storage (`MemoryData`), and a splash/routing screen (`Loding_page`) sends returning users straight to the slots screen instead of login.
- **Live slot data** — booking records are synced to Firebase Realtime Database, keyed by user and slot info (`User` model).

## Tech stack

- **Language:** Java
- **Platform:** Android (min SDK 24, target SDK 33, compiled against SDK 34)
- **Backend:** Firebase — Realtime Database, Phone Authentication
- **Payments:** Razorpay Checkout SDK
- **UI:** Android Views, CardView, ViewBinding, Material Components, BottomNavigationView
- **Build system:** Gradle (Kotlin DSL — `build.gradle.kts`)

## Project structure

app/src/main/java/com/example/parkkro/
├── Loding_page.java # Splash screen — routes to login or straight to slots for returning users
├── Account.java # Registration/login: name, phone, vehicle number, triggers OTP
├── verify_OTP.java # 6-digit OTP entry and Firebase verification
├── Slots.java # Parking slot map, time picker, and navigation to add-on services
├── MainActivity.java # Booking summary before payment
├── Payment.java # Razorpay checkout and payment confirmation
├── Charging.java # EV charging service options
├── Wash.java # Car wash request / call-to-book
├── User.java # Booking data model (type, time, slot, name, vehicle number, phone)
└── MemoryData.java # Local file-based storage for the signed-in user's session data


## Setup

1. Clone the repo and open the `ParkKro` folder in **Android Studio**.
2. This project uses **Firebase** (Realtime Database, Phone Authentication) — add your own `google-services.json` from the Firebase console into `app/`.
3. This project uses **Razorpay** for payments — you'll need a Razorpay account/API key to test the payment flow (`Payment.java`).
4. Let Gradle sync, then build and run on an emulator or device (min SDK 24).

## Known limitations

- Payment success/failure handling could be made more robust — currently relies on Razorpay's callback interface without extensive retry/error UI.
- No slot-conflict checking shown yet (i.e. preventing two users from booking the same slot at an overlapping time) beyond what's visible in `Slots.java`.
- No automated tests beyond the default Android boilerplate (`ExampleUnitTest`, `ExampleInstrumentedTest`).
- Session storage uses plain local files (`MemoryData`) rather than encrypted `SharedPreferences` or a keystore — fine for a demo, but should be hardened before handling real payment users.

## License

Add a license of your choice (e.g. MIT) if you plan to share or open-source this project.
