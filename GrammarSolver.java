import java.io.FileNotFoundException;
import java.util.*;
public class GrammarSolver {
    private Map<String, ArrayList<ArrayList<String>>> rules;
    private Random random = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> lines = GrammarMain.readLines("simple.txt");

        // construct grammar solver and begin user input loop
        GrammarSolver solver = new GrammarSolver(lines);

        solver.generate("num");
    }

    /**
     * Breaks apart the BNF grammar rules and stores them into the Map "rules".
     * @throws IllegalArgumentException If the list is empty or if the grammar contains more than one line for the same non-terminal
     */
    public GrammarSolver(List<String> rules) throws IllegalArgumentException {
        this.rules = new HashMap<>();
        if (rules.isEmpty()) throw new IllegalArgumentException("Grammar rules cannot be empty"); // Check for empty rules

        String[] mainParts;
        String[] ruleParts;
        for (String rule : rules) {
            mainParts = rule.split("::=");

            // Check if we have a duplicate rule or it's invalid
            if (mainParts.length != 2 || this.rules.containsKey(trim(mainParts[0])))
                throw new IllegalArgumentException("Duplicate or invalid rule for: " + mainParts[0]);

            this.rules.put(trim(mainParts[0]), new ArrayList<>()); // Inititate our rule array

            ruleParts = mainParts[1].split("[|]"); // Split up the rules

            ArrayList<String> symbols;
            for (String part : ruleParts) {
                symbols = new ArrayList<>();

                // Split up each symbol from the rule
                for (String s : part.trim().split("[ \\t]+"))
                    if (!s.isEmpty())
                        symbols.add(trim(s));

                if (!symbols.isEmpty()) this.rules.get(trim(mainParts[0])).add(symbols); // Initiate each rule
            }
        }
    }

    /**
     * Checks if the String passed is a non-terminal or not.
     * @return True if the given symbol is a non-terminal and false otherwise
     * @throws IllegalArgumentException If the string is null
     */
    public boolean contains(String symbol) {
        return rules.containsKey(trim(symbol));
    }

    /**
     * Gets all non-terminal symbols of the grammar.
     * @return The symbols as a Set of Strings
     */
    public Set<String> getSymbols() {
        return rules.keySet();
    }

    /**
     * Generates a random occurrence of the given symbol.
     * If the string passed is a non-terminal, uses the grammar's rules to recursively expand that symbol into a sequence of terminals.
     * If the string passed is not a non-terminal, assumes it's a terminal symbol and returns it.
     * @throws IllegalArgumentException If the string is null
     */
    public String generate(String symbol) throws IllegalArgumentException {
        if (symbol.length() == 0) throw new IllegalArgumentException(); // Make sure the symbol passed in was valid

        symbol = trim(symbol);

        // Check if symbol is non-terminal
        if (contains(symbol)) {
            String temp = "";

            // Get a random rule and call generate again for each symbol of that rule
            for (String s : rules.get(symbol).get(random.nextInt(rules.get(symbol).size()))) {
                temp += generate(s) + " ";
            }

            return temp.trim();
        }
        
        return symbol; // It's a terminal symbol
    }

    /**
     * Removes leading and trailing spaces from the input along with any surounding angle brackets.
     */
    private String trim(String s) {
        return s.trim().replaceAll("^<|>$", "");
    }
}