### Mars Rover

Mars Rover is a proof-of-concept Android app designed to data gathered by NASA's Curiosity, Opportunity, and Spirit rovers on Mars and make it more easily available to other developers, educators, and citizen scientists.
---------

## Table of contents

- [Features](#features)
- [Installation](#Installation)
- [Implementation Details](#implementation-details)
- [API](#api)
- [App Architecture](#app-architecture)
- [Preview](#preview)
- [License](#license)

---------

## Features

* User can browse a screen that displays a list of Images from all Rovers and all available cameras.
* Each List item displays <br>
  ·Which rover took the picture. (ex: Curiosity) <br>
  ·The date the picture was taken. (ex: 2015-05-30) <br>
  ·Which camera was used. (ex : Front Hazard Avoidance Camera) <br>
* User can view the images list and endlessly scroll through images.
* User can click on any list item to view more details on this specific image.
* User can navigate to an image details screen which displays the photo with <br>
  ·Name. (ex: Curiosity) <br>
  ·Launch date. (ex: 2012-08-06) <br>
  ·Landing date. (ex: 2011-11-26) <br>
  .Status. (ex: active) <br>
* App monitors network connectivity and error handling.
* App allow retry loading images in case of a failure occurred.

--------

## Installation

Clone this repository and import into **Android Studio**
```bash
git clone git@github.com:MhmoudAlim/MarsRover.git
```

### `Demo`

Download App Apk : [Mars Rover](https://github.com/MhmoudAlim/MarsRover/blob/master/blob/app-release.apk)

------

## Implementation Details

### `Layout`
-The app layout interface is implemented by XML imperative views.


### `Permission`
-The App requires runtime permissions of
* **INTERNET**
* **ACCESS_NETWORK_STATE**


### `Data`
-The app uses a Rest Api to fetch data from a NASA remote Api.

### `Error Handling`
-The performed requests handle successful results, failure results and no internet connection


### `Technologies used`

- Kotlin
- Clean Architecture
- MVVM pattern
- Repository Pattern
- View Binding
- Data Binding
- Observer Pattern
- Kotlin Dsl Gradle
- Dependency Injection using Dagger Hilt
- Paging 3
- Kotlin Coroutines
- Kotlin Flow
- Android Jetpack
- Android-KTX
- Navigation Component
- Retrofit & OkHttp
- Moshi

<br/>

---------

## Api

- [Nasa Mars Rover](https://api.nasa.gov/?search=rover)

---------

## App Architecture
<br/>


<img src="https://github.com/MhmoudAlim/MarsRover/blob/master/blob/app_arch.png?raw=true" alt="App Architecture" width="380"/>


<br/>
<br/>
<br/>


### Application data Flow
<br/>

<img src="https://github.com/MhmoudAlim/MarsRover/blob/master/blob/architecture.png?raw=true" alt="Data Flow" height="300"/>

<br/>


### Why Clean Architecture ?

- Clean, Testable, Maintainable and extendable Codebase
- Apply high cohesion and low coupling
- Apply Separation of concerns principle
- Apply Single source of truth principle
- Fine-grained dependency control.
- Improve re-usability across other apps.
- Improves the ownership & the quality of the codebase.

<br/>

---------


## Preview

|                                                1                                                |                                            2                                            |
|:-----------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------:|
| ![screenshot](https://github.com/MhmoudAlim/MarsRover/blob/master/blob/Screenshot_1.jpg?raw=true) | ![](https://github.com/MhmoudAlim/MarsRover/blob/master/blob/Screenshot_2.jpg?raw=true) |




---------


### License

<details>
    <summary>
        Click to reveal License
    </summary>

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

</details>
