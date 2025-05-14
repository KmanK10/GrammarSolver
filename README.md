
# Grammar Solver

## Overview
Grammar Solver is a Java program that generates random elements of a formal language defined by a Backus-Naur Form (BNF) grammar. The program reads a BNF grammar from a text file, processes it into a structured format, and allows users to generate random phrases or sentences based on specified non-terminal symbols. It uses recursion to expand non-terminals into sequences of terminals, creating valid expressions in the language.

## Features
- **Grammar Parsing**: Reads a BNF grammar file, parsing rules into non-terminals and their expansions.
- **Random Generation**: Generates random phrases for any non-terminal symbol using a recursive algorithm, ensuring valid combinations of terminals.
- **Symbol Management**: Provides methods to check if a symbol is a non-terminal and to retrieve all non-terminals in the grammar.
- **User Interaction**: Integrates with a provided `GrammarMain.java` client to prompt users for symbols and the number of phrases to generate.
- **Custom Grammar**: Includes some sample BNF grammar files for testing, with support for user-defined grammars.

## Usage
1. **Prerequisites**: Ensure Java is installed and the support files (`GrammarMain.java`, `sentence.txt`, and other input files) are in the same directory as the project.
2. **Running the Program**:
   - Compile and run `GrammarMain.java`.
   - Enter the name of a BNF grammar file (e.g., `sentence.txt` or `grammar.txt`) when prompted.
   - Select a non-terminal symbol from the displayed list and specify how many random phrases to generate.
   - Press Enter without a symbol to exit.
3. **Output**:
   - The program displays a list of available non-terminal symbols.
   - For each generation request, it outputs the specified number of random phrases derived from the chosen non-terminal.

## Example Interaction
```
Welcome to the CSE 143 random sentence generator!
What is the name of the grammar file? sentence.txt
Available symbols to generate are: [<adj>, <adjp>, <dp>, <iv>, <n>, <np>, <pn>, <s>, <tv>, <vp>]
What do you want to generate (Enter to quit)? <np>
How many do you want me to generate? 5
a wonderful father
the faulty man
Spot
the subliminal university
Sally
```

## File Structure
- `GrammarSolver.java`: Core class that parses the BNF grammar, stores rules in a Map, and generates random phrases recursively.
- `grammar.txt`: A custom BNF grammar file with at least 5 non-terminals, provided for testing.
- `GrammarMain.java`: Provided client program for file processing and user interaction.
- `sentence.txt`: Sample BNF grammar file for testing.

## Example Grammar (`sentence.txt`)
```
<s>::=<np> <vp>
<np>::=<dp> <adjp> <n>|<pn>
<dp>::=the|a
<adjp>::=<adj>|<adj> <adjp>
<adj>::=big|fat|green|wonderful|faulty|subliminal|pretentious
<n>::=dog|cat|man|university|father|mother|child|television
<pn>::=John|Jane|Sally|Spot|Fred|Elmo
<vp>::=<tv> <np>|<iv>
<tv>::=hit|honored|kissed|helped
<iv>::=died|collapsed|laughed|wept
```

## Dependencies
- Java Standard Library (including `java.util` for `Map`, `Set`, `List`, and `Random`)

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
