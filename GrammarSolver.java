import java.util.*;
public class GrammarSolver {
    private Map<String, ArrayList<String>> rules;

    /* In this constructor you should initialize a new grammar solver over the given BNF grammar rules, where each rule
    corresponds to one line of text as shown in the file on the previous page. Your constructor should break apart the rules
    and store them into a Map so that you can later look up parts of the grammar efficiently. Do not modify the list passed.
    You should throw an IllegalArgumentException if the list is null, or empty (size 0). You should also throw an
    IllegalArgumentException if the grammar contains more than one line for the same non-terminal. For example, if
    two lines both specified rules for symbol "<s>" , this would be illegal and should result in the exception being thrown. */
    public GrammarSolver(List<String> rules) {
        this.rules = new HashMap<>();

        String[] parts;
        for (String rule : rules) {
            parts = rule.split("::=");
            System.out.println(parts);
        }
    }

    /* In this method you should return true if the given symbol is a non-terminal in the grammar and false otherwise. For
    example, when using the grammar described previously, you would return true for a call of contains("<s>") and
    false for a call of contains("<foo>") or contains("green") ("green" is a terminal in the language). You
    should throw an IllegalArgumentException if the string is null or has a length of 0.
    You may want to look up the methods of the Random class in java.util to help you make random choices between
    rules. You should throw an IllegalArgumentException if the string is null or has a length of 0. */
    public boolean contains(String symbol) {
        return true;
    }

    /* In this method you should return all non-terminal symbols of your grammar as a set of strings. This is the keySet of
    your map. For example, when using the previous grammar, getSymbols() would return a set containing the ten
    elements ["<adj>", "<adjp>", "<dp>", "<iv>", "<n>", "<np>", "<pn>", "<s>", "<tv>", "<vp>"]. */
    public Set<String> getSymbols() {
        return new HashSet<>();
    }

    /* In this method you should use the grammar to generate a random occurrence of the given symbol and you should return
    it as a String. If the string passed is a non-terminal in your grammar, you should use the grammar's rules to
    recursively expand that symbol fully into a sequence of terminals. For example, when using the grammar described on
    the previous pages, a call of generate("<np>") might potentially return the string, "the green wonderful
    child". If the string passed is not a non-terminal in your grammar, you should assume that it is a terminal symbol and
    simply return it. For example, a call of generate("green") should return "green". (Note there is not a space
    before/after "green".) */
    public String generate(String symbol) {
        return new String();
    }

}