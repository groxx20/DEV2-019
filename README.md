# TIC TAC DOE DEV2-019

A simple and interactive Tic Tac Toe game built with Kotlin and Jetpack Compose for Android. 

## Architecture

- **Data layer**: contains the BoardRepository which handles the state of the current game.
- **Domain Layer**: contains all the use cases of the game, which handle the game logic and get the data from the repository as the only source of truth.
- **Presentation Layer**: hosts the view model which is in charge of communication between the domain and the UI.
- **UI**: build using Jetpack Compose

The MVVM architecture makes a clean separation of business logic and the UI, making the code easier to maintain and test. Each layer has a defined responsibility.

## Role of Flow

All the layers use Flow to communicate and it's worth to mention its advantages:
- Reactivity: used to create a reactive data stream that emits updates whenever the game state changes
- Separation of concerns: by using flow the domain-data layer can handle the game state logic while VM simply observes and reacts to changes, keeping the responsibilities separated.
- Efficiency: can handle the stream of data efficiently, which ensure that UI updates only when needed.
- Simplicity: using Flow simplifies the data handling in the app, which leads to writing less callbacks and listeners.

## Installation Guide
- To run this project, clone the repository and open it in Android Studio.
- Build and Run on Android Emulator or physical Android device

## Usage
- The turn of the player is indicated at the top
- Select a cell to place your mark ( X or O )
- The game will automatically switch turns between players
- Once a player wins or the game ends in a draw, the game state will be updated
- Button Reset will become available in the screen
- By clicking reset button you restart the game and the first to go is the player that lost the previous round.

## Notes
- The App is built considering the TDD approach, testing each layer with several cases and checking that the logic is behaving as expected.
- The UI solution is very simple, which is made in consideration of the time spent on the development of the game

## Libraries added to the base project
- Coroutines: for reactive data stream
- Koin: for dependency injection
- Mockito: to mock the classes in the tests

