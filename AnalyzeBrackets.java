import java.util.Stack;

public class AnalyzeBrackets {

	String valid = "([]{}){}";
	String invalid = "([]{)}";

	final static char CUROPEN = '{';
	final static char CURCLOSE = '}';
	final static char PAROPEN = '(';
	final static char PARCLOSE = ')';
	final static char BRACKETOPEN = '[';
	final static char BRACKETCLOSE = ']';
	
	
	
	public static void main(final String... args) {
		String cadena = "([]{}){}";
		// final String cadena = args[0];
		final AnalyzeBrackets analyzeBrackets = new AnalyzeBrackets();
		final boolean valid = analyzeBrackets.analyzeString(cadena);
		if (valid) {
			System.out.println("La cadena " + cadena + " es valida");
		} else {
			System.out.println("La cadena " + cadena + " no es valida");
		}
	}

	private boolean analyzeString(final String string) {
		boolean valid = true;
		Stack<Character> stack = new Stack<>();
		final char[] array = string.toCharArray();
		for (int i = 0; i < array.length; i++) {
			char current = array[i];
			//open parenthesis
			if( current == CUROPEN ) {
				stack.add(current);
			}
			if( current == PAROPEN ) {
				stack.add(current);
			}
			if( current == BRACKETOPEN  ) {
				stack.add(current);
			}	
			// close parenthesis
			if( current == CURCLOSE ) {
				char pop = stack.pop();
				if( pop != CUROPEN ) {
					valid = false;
					break;
				}
			}
			if( current == BRACKETCLOSE ) {
				char pop = stack.pop();
				if( pop != BRACKETOPEN ) {
					valid = false;
					break;
				}
			}
			if( current == PARCLOSE ) {
				char pop = stack.pop();
				if ( pop != PAROPEN ) {
					valid = false;
					break;
				}
			}
		}
		return valid;
	}

}

