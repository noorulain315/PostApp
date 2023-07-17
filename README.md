<h1 align="center">Post App</h1>


PosApp - A single activity based MVVM architecture with layer based modularization.

## Prerequisite (To Build Project)

- Android Studio
- Gradle 7.1.3

## Techstack & Libs

- JetPack
    - Lifecycle
    - ViewModel
    - Android Navigation Component
    - Compose
    - State
- Hilt
- Retrofit
- Coroutines
- Architecture
    - MVVM Architecture
- 
  - Repository pattern

## Modules

- Core (A simple library module to provide utility classes and Constants)
- App (Main App module that contains UI(activities, fragments) and VMs)
- Data (It contains data(models), repository and its implementations)
- Domain (It contain usecases and ui data mapper)

## Models
- Remote Models (Remote models with no formatting and to have more data stored here returned from endpoint)
- UI Models (To represent UI data and state)
- Entity Models (To represent internal entity)
- Mapper Classes (To Map from Remote, Entity to UI and vice versa)

## Note
This application focuses more on clean and reasonable architecture and Ui is kept simple. 
Because app stability and scalability directly depends on architecture. The compose Ui is also integrated with 
fragments to give a mix match of legacy and advance tech. Unit tests are provided for VM, usecases and Repo. 
These tests majorly focus on post and ignore comments and users due to time constraints. 

In case, project don't build, Do the following. Sync project with Gradle files Build > Clean
project, Rebuild Project.
