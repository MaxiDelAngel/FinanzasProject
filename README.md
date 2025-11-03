# Mi App KMP 📱

Este es un proyecto de **Kotlin Multiplatform** (KMP) para **Android** e **iOS**.

Usa **Compose Multiplatform** para compartir la UI. ¡Escribes el código de la UI una vez y funciona en ambas plataformas!

## ✨ ¿Qué tecnologías usa?

* **Kotlin:** El lenguaje principal para todo.
* **Compose Multiplatform:** Para hacer la UI compartida.
* **Coroutines:** Para manejar cosas en segundo plano (como llamadas a internet).
* **[Ktor/Retrofit]:** Para conectarse a una API. (Proximamente)
* **[Koin/Hilt]:** Para inyección de dependencias. (Proximamente)

---

## 🚀 Cómo ejecutar el proyecto

### Requisitos

* Android Studio (para KMP)
* Xcode (para la app de iOS)

### ▶️ En Android

1.  Abre el proyecto en Android Studio.
2.  Espera que Gradle termine de sincronizar.
3.  Elige **`androidApp`** en las configuraciones de ejecución.
4.  Selecciona tu emulador o teléfono.
5.  ¡Dale a "Run" (▶️)!

### ▶️ En iOS

1.  Abre el archivo `iosApp.xcworkspace` (o `.xcodeproj`) dentro de la carpeta `/iosApp` con Xcode.
2.  Elige un simulador (ej. iPhone 15).
3.  ¡Dale a "Run" (▶️) en Xcode!

---

## 📂 Estructura de Carpetas

* `/composeApp`: Aquí está **todo el código compartido**.
    * `commonMain`: La lógica y las pantallas (Compose) que usan Android e iOS.
    * `androidMain`: Código específico solo para Android (si se necesita).
    * `iosMain`: Código específico solo para iOS (si se necesita).
* `/androidApp`: El proyecto "contenedor" de Android.
* `/iosApp`: El proyecto "contenedor" de Xcode para iOS.
