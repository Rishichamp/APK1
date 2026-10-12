# Android Calculator App (APK1)

[![build](https://github.com/Rishichamp/APK1/actions/workflows/build.yml/badge.svg)](https://github.com/Rishichamp/APK1/actions/workflows/build.yml)

This Android application performs basic mathematical calculations including **square, cube, square root, and cube root**.

The project is built using **Java and Android Studio** and demonstrates simple UI interaction and mathematical operations in an Android application.

---

## Purpose

This project was created as a learning exercise to understand how to build a simple **Android calculator application** and implement mathematical computations using Java.

It demonstrates how to:
- Take user input
- Perform mathematical calculations like square,cube,square root,cube root
- Display results in an Android interface

---

## Features

- Calculate square of a number
- Calculate cube of a number
- Calculate square root
- Calculate cube root
- Simple user interface
- Instant result display

---

## Technologies Used

- Java
- Android Studio
- Android SDK
- XML Layouts

---

## Project Structure

Main components of the project:

- `MainActivity.java` → Handles user input and mathematical calculations  
- `activity_main.xml` → Defines the user interface of the calculator  

---

## How the App Works

1. User enters a number.
2. The app performs the selected mathematical operation.
3. The result is displayed on the screen.

Supported operations:

- Square
- Cube
- Square Root
- Cube Root

---

## Screenshots

<p align="center">
  <img src="calculator_app_1.png" width="200">
  <img src="calculator_app_2.png" width="200">
  <img src="calculator_app_3.png" width="200">
</p>

<p align="center">
  <img src="calculator_app_4.png" width="200">
  <img src="calculator_app_5.png" width="200">
</p>

---

## 2026 update

- **Tooling:** upgraded from Gradle 7.3 / AGP 7.2 (which don't run on the JDK 21 in current Android Studio) to Gradle 8.11.1, AGP 8.7.3, compileSdk 35 / targetSdk 34, Java 17 and current AndroidX libraries.
- Typing just "." crashed the app; now it shows an error.
- The "Number field can't be empty" message was set on a hidden view, so it never appeared.
- Square root of a negative number showed NaN; now it explains there's no real root.
- The result box no longer cuts off long answers; the button reads **Calculate**.
- **Tests:** 4 unit tests and 3 on-device UI tests, all passing on an Android 11 emulator, plus a 2,000-event monkey stress test with no crashes. GitHub Actions builds, unit-tests and lints the app on every push.

## Author

Rishi Singh
