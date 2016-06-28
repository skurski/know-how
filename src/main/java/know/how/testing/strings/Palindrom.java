package know.how.testing.strings;

public class Palindrom {
	
	public static boolean isPalindrom(String str) {
		StringBuilder build = new StringBuilder(str);
		build.reverse();
		System.out.println(str);
		System.out.println(build);
		
		return str.equals(build.toString());
	}
	
	public static void main(String[] args) {
		String str = "do it ti od";
		
		System.out.println(Palindrom.isPalindrom(str));
	}
}
