package know.how.core.strings;

import java.util.regex.Pattern;

public class RegexTest {
	  private static final String REGEX = "\\d";
	    private static final String INPUT =
	        "one9two4three7four1five";

	    public static void main(String[] args) {
	        Pattern p = Pattern.compile("\\d");
	        String[] res = p.split(INPUT);
	        
	        //String object
	        String[] res2 = INPUT.split(REGEX);
	        
	        for (String s: res) System.out.println(s);
	        for (String s: res2) System.out.println(s);
	    }
}
