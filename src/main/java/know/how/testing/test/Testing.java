package know.how.testing.test;

import java.util.HashSet;
import java.util.Set;

public class Testing {
	private static int result = 0;
	
	int comp(String s1, String s2) {
		char[] str1 = s1.toCharArray();
		char[] str2 = s1.toCharArray();
		
		int len = s1.length();
		if (len != s2.length()) return 0;
		
		for (int i=0, j=len-1; i<len && j>=0; i++, j--) {
			if (str1[i] != str2[j]) 
				return 0;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(new Testing().comp("do it ti od", "do it ti od"));
		
		Set<Integer> col = new HashSet<Integer>();
	}
}
