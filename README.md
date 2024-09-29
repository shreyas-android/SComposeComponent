# SComposeComponent

This library contains a compose component like customizable Multi-Color Linear Progress Bar built using Jetpack Compose. The component allows developers to enhance their app's UI with a different compoenets like progress indicator featuring multiple colors.


## Features

- **Customizable Styles**: Easily change the appearance and style of the calendar to align with your app's design.
- **Interactive Callbacks**: Provide callbacks for clicking and interacting with specific dates, enabling seamless integration with your app's functionality.
- **User-friendly Interface**: Intuitive and user-friendly design for hassle-free navigation and interaction within the calendar.
- **Jetpack Glance Integration**: Built using the Jetpack Glance library, ensuring robust performance and compatibility with the latest Android development standards.

- **Multi-Color Support**: Progress bar can display multiple colors dynamically.
- **Customizable**: Easily modify colors, progress, and animation duration.
- **Compose-Ready**: Built entirely using Jetpack Compose, it integrates seamlessly with any Compose-based Android app.


## Installation

Step 1. Add the JitPack repository to your build file

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Step 2. Add the dependency

```
dependencies {
      implementation("com.github.shreyas-android:SComposeComponent:1.0.0")
}
```

## Usage
To use the component in your Android application, add this code below:

Infinite linear progress indicator
```
InfiniteMultiColorLinearProgressIndicator(
                                 modifier = Modifier.fillMaxWidth(),
                                thickness = 2.dp,
                                colors = listOf(Color.Red, Color.Green))
```

Normal linear progress indicator
```
 MultiColorLinearProgressIndicator(
                                progress = 0.8f, modifier = Modifier.fillMaxWidth(),
                                thickness = 2.dp, backgroundColor = Color.Blue.copy(alpha = 0.4f),
                                colors = listOf(Color.Red, Color.Green))
```

Mediuam post: - https://medium.com/@avengers14.blogger/multi-colour-linear-progress-jetpack-compose-android-b8387c253b01
