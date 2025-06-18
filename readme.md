# CountriesApp

**CountriesApp** is a sample Android application demonstrating a robust MVVM architecture. It fetches a list of countries from a remote JSON endpoint and displays them in a scrollable, responsive `RecyclerView`.

---

## 🎯 Project Description

`CountriesApp` showcases best practices in modern Android development, using:

- **MVVM** (Model–View–ViewModel) for clear separation of concerns
- **Retrofit + Gson** for networking and JSON parsing
- **Kotlin Coroutines** for asynchronous operations
- **LiveData** for reactive UI updates
- **View Binding** for type-safe view lookups
- **Cleartext Traffic** configuration for non-HTTPS endpoints

This project contains clean, maintainable code and an up‑to‑date Android tech stack.

---

## 🚀 Features

- Fetches countries JSON from: `https://gist.githubusercontent.com/peymano-wmt/.../countries.json`
- Displays each country’s **Name**, **Region**, **Code**, and **Capital** in a custom card layout
- Loading and error states with retry capability
- Configuration-change resilience (device rotation) via ViewModel
- Localizable strings with resource placeholders

---

## 🗂 Folder Structure

```
app/
├─ src/main/
│  ├─ java/com/example/walmartcodingapp/
│  │  ├─ data/
│  │  │  ├─ model/          # Country.kt
│  │  │  ├─ network/        # Retrofit setup, CountriesApiService.kt
│  │  │  └─ repository/     # CountryRepository.kt
│  │  ├─ ui/
│  │  │  ├─ countries/      # CountriesFragment.kt, RecyclerView setup
│  │  │  └─ adapter/        # CountryAdapter.kt
│  │  └─ viewmodel/         # CountriesViewModel.kt, Factory
│  └─ res/
│     ├─ layout/            # fragment_countries.xml, item_country.xml
│     └─ values/            # strings.xml
└─ test/                    # unit tests for ViewModel and Repository
```

---

## 🛠 Getting Started

### Prerequisites

- Android Studio Flamingo 2022.2.1 (April 2023) or newer
- JDK 11+
- Gradle 7+

### Installation

1. **Clone** the repo:
   ```bash
   git clone https://github.com/meternx01/CountriesApp.git
   ```
2. **Open** in Android Studio
3. **Sync** Gradle and **Run** on emulator or device

---

## 📋 Usage

- App launches directly into the `CountriesFragment`.
- Scroll through the list of countries.
- If the network call fails, an error message appears with details.

---

## 🎯 Technical Highlights

- **Robust Networking**: Uses Retrofit with a custom Network Security Config for cleartext host whitelisting.
- **Error Handling**: `Result`-based repository with `onSuccess`/`onFailure` flows.
- **Localization**: All user-facing text in `strings.xml` with placeholders.

---

## 🤝 Contributing

Contributions are welcome! Please open an issue or submit a pull request.

---

