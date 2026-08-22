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

## How to Run
1. Clone the repository
```bash
   git clone https://github.com/shreya-User/smart-parking-system.git
   cd smart-parking-system
```
2. Open the `ParkKro` project folder in **Android Studio**
3. Add your own `google-services.json` file (from Firebase Console) into the `app/` folder
4. Set up a Razorpay account/API key for payment testing
5. Let Gradle sync automatically
6. Connect an Android device or start an emulator
7. Click **Run** ▶ in Android Studio

## Project Structure
| File | Purpose |
|------|---------|
| `Loding_page.java` | Splash screen — routes to login or slots |
| `Account.java` | Registration/login, sends OTP |
| `verify_OTP.java` | OTP entry and verification |
| `Slots.java` | Parking slot map and time picker |
| `MainActivity.java` | Booking summary before payment |
| `Payment.java` | Razorpay checkout and payment confirmation |
| `Charging.java` | EV charging service options |
| `Wash.java` | Car wash request/call |
| `User.java` | Booking data model |
| `MemoryData.java` | Saves session data on the device |



## Known limitations

- Payment success/failure handling could be made more robust — currently relies on Razorpay's callback interface without extensive retry/error UI.
- No slot-conflict checking shown yet (i.e. preventing two users from booking the same slot at an overlapping time) beyond what's visible in `Slots.java`.
- No automated tests beyond the default Android boilerplate (`ExampleUnitTest`, `ExampleInstrumentedTest`).
- Session storage uses plain local files (`MemoryData`) rather than encrypted `SharedPreferences` or a keystore — fine for a demo, but should be hardened before handling real payment users.

## License

Add a license of your choice (e.g. MIT) if you plan to share or open-source this project.
