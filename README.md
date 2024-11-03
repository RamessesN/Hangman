# Hangman
Hangman is a GUI game, which is designed to ask people to guess words.

## Functions
- **Startup Screen**: Show the information of the program and provide a interface to access the game screen.
- **Health Panel**: Show as several red and green squares, whose total number is equal to the number of unique letters in the word.
- **Word Panel**: Show '_' before guess and transfer into relative letter after guessing successfully.
- **Button Panel**: Show 26 letters provide players to choose.
- **Tip Panel**: Show a random word when press the 'Tip' button.
- **Winning Screen**: Show a dialog to notice players they won and ask whether continue to play.
- **Losing Screen**: Show a dialog to notice players they failed and ask whether continue to play.

## Installation
1. Make sure you have the JDK installed and that it supports version 7.0 or higher.
2. Download and clone this repository:
   ```bash
   git clone https://github.com/RamessesN/Hangman.git
   ```
3. Open the project in your IDE, ensuring that all dependencies are correctly set up.

## Usage
1. Run the game:
- **Start the Run class (e.g., Main) using the command line or your IDE.**
2. In the startup screen, review the program information, then click the “Start Game” button to enter the game interface.
3. In the game interface, the health panel will display your health (represented by red and green squares).
4. Guess letters by clicking the letter buttons; correct letters will display in the word panel.
5. If you need a hint, click the “Tip” button to show a random word.
6. If you run out of guesses, the game will display the losing screen, asking if you want to continue playing.
7. If you successfully guess the word, a winning screen will appear, asking if you want to continue playing.

## Directory Structure
Hangman/
├── src/                    # Source code
│   ├── Run/                # Main program entry
│   ├── gui/                # GUI components
│   ├── logic/              # Game logic
│   └── resources/          # Resource files (e.g., icons, fonts)
├── README.md               # Project description file
└── LICENSE                 # License file

## Dependencies
- **Java 7.0+**
- **JavaFX (if using JavaFX for GUI development)**

## Contributing
Contributions are welcome! Please submit issues and pull requests to help improve this project. Before submitting, make sure to adhere to the coding style and test all functionalities.

## Author
Stanley ZHAO

## License
This project is licensed under the MIT License. See the LICENSE file for details.