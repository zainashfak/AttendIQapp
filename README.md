# AttendIQ - Smart Class Attendance Tracker

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com/)
[![Language](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

**AttendIQ** is an Android application designed to help students manage and track their class attendance efficiently. It offers a clean, user-friendly interface for navigation, user authentication, profile management, and attendance-related tools.

---

## 📱 Features

* **Splash Screen**: Branded initial loading screen.
* **User Authentication**:
  * Secure Login & New User Registration.
  * Password recovery flow (**Forgot Password** & **Reset Password**).
* **Session Management**: Persistent user sessions using `SharedPreferences`.
* **Dashboard**: Main hub with quick access to attendance-related sections.
* **User Profile**: View user details with logout functionality.
* **Form Validation**: Input checks for email format, password criteria, and required fields.

---

## 🛠️ Technologies & Tools Used

* **Language**: Java
* **UI Design**: XML Layouts
* **IDE**: Android Studio
* **Core Components**: Activities, Intents, SharedPreferences, Form Validation
* **Target OS**: Android 5.0 (API Level 21) and above

---

## 🖼️ Application Navigation Flow

```text
[Splash Screen]
       │
       ├──► (If Logged In) ──► [Dashboard Screen] ──► [Profile Screen]
       │                                                   │
       └──► (If Logged Out)                                └──► [Logout] ──┐
                 │                                                          │
                 ▼                                                          │
           [Login Screen] ◄─────────────────────────────────────────────────┘
                 │
                 ├──► [Register Screen] ──► (Success) ──► [Login Screen]
                 │
                 └──► [Forgot Password] ──► [Reset Password] ──► [Login Screen]
```

---

## 🚀 Getting Started

Follow these steps to set up and run the project locally on your machine.

### Prerequisites
* [Android Studio](https://developer.android.com/studio) (Hedgehog or newer recommended)
* JDK 11 or higher
* Android Virtual Device (AVD) or physical device running Android 5.0+ with USB debugging enabled.

### Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/zainashfak/AttendIQapp.git
   ```

2. **Open in Android Studio:**
   * Open Android Studio.
   * Click on **File > Open...**
   * Select the cloned `AttendIQapp` project folder.

3. **Sync Gradle:**
   * Wait for Android Studio to finish indexing and syncing dependencies via Gradle.

4. **Run the App:**
   * Select your target emulator or physical device from the top device dropdown menu.
   * Click the green **Run** button (`Shift + F10`) to build and deploy the application.

---

## 🔮 Future Roadmap

- [ ] **Subject & Course Management**: Dynamic addition, editing, and deletion of subjects.
- [ ] **Daily Attendance Tracker**: Quick mark options (Present, Absent, Cancelled).
- [ ] **Safe-to-Skip Calculator**: Smart algorithm predicting safe skips based on required attendance percentage (e.g., 75%).
- [ ] **Reminders & Notifications**: Local reminders after scheduled class hours.
- [ ] **Attendance Reports**: Graphical overview of attendance trends and statistics.

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 👤 Author

* **Zain Ashfak** - [GitHub Profile](https://github.com/zainashfak)