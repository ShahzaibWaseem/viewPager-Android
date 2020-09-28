# ViewPager 2 Animations - Android

## Description
The application is written in Kotlin and uses viewPager and mimics the implementation of animations in android.
The Animations are not made using the default animation methods in android.

### Technical Specifications
- AndroidX
- Target SDK Version: 30
- Minimum SDK Version: 23
- Design Dependencies
    - Constraint Layout Version 2.0.1
    - ViewPager2 Version1.0.0

### Implementation Details
The main implementation of animations is done in the [```app/src/main/java/com/shahzaib/viewpager/ViewPagerAdapter```](https://github.com/ShahzaibWaseem/viewPager-Android/blob/master/app/src/main/java/com/shahzaib/viewpager/ViewPagerAdapter.kt) where the animation for the current page is provided with the animations (i.e. animations for images and texts separately) of the incoming page.

```kotlin
// Handles incoming animations for the current page

tab1.animateImages(positionOffset, positionOffsetPixels)
tab1.animateText(positionOffset, -positionOffsetPixels)

// Handles incoming animations for the incoming page

tab2.animateImages(1 - positionOffset, maxPixels - positionOffsetPixels)
tab2.animateText(1 - positionOffset, maxPixels - positionOffsetPixels)
```

### APK File
Click this link to download [app-debug.apk](https://github.com/ShahzaibWaseem/viewPager-Android/blob/master/app/build/outputs/apk/debug/app-debug.apk).