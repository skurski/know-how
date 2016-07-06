package know.how.codingtasks.tasks;

public class AreAnagrams {
	
    public static boolean areAnagrams(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;
        
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int aa = 0;
        int bb = 0;
        
        for (char c : str1) aa += c;
        for (char c : str2) bb += c;
        
        if (aa == bb) return true;
        
    	return false;
    }
    
    public static int stringCmp(String a, String b) {
    	if (a == null && b == null) return 0; 
    	if (a == null) return 1;
    	if (b == null) return -1;
    	
    	int len1 = a.length();
    	int len2 = b.length();
    	int minLen = len1 <= len2 ? len1 : len2;
    	
    	for (int i=0; i< minLen; i++) {
    		char ac = a.charAt(i);
    		char bc = b.charAt(i);
    		
    		if (ac != bc) return ac - bc;
    	}
    	
    	return a.length() - b.length();
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("momdad", "dadmom"));
        System.out.println(stringCmp("momdad", "momdadsss"));
        
        String a = "abc";
        String b = "eew";
        
        System.out.println(a.compareTo(b));
    }
}