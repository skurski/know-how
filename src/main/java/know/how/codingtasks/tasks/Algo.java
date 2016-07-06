package know.how.codingtasks.tasks;

public class Algo {

	//Write a program to reverse the words in a sentence, i.e. "My name is hero" becomes "hero is name My."
	String convertString(String str) {
		StringBuilder strNew = new StringBuilder();
		
		int flag = str.length()-1;
		for (int i=str.length()-1; i>=0; i--) {
			if (str.charAt(i) == ' ') {
				strNew.append(str.substring(i+1, flag+1)).append(" ");
				flag = i-1;
			}
		}
		
		strNew.append(str.substring(0, flag+1)).append(".");
		
		return strNew.toString();
	}
	
	String anotherWay(String entryStr) {
		if (entryStr == null) throw new NullPointerException();
		
		StringBuilder res = new StringBuilder();
		
		int i = entryStr.length()-1;
		int flag = i;
		while (i >= 0) {
			if (entryStr.charAt(i) == ' ') {
				res.append(entryStr.substring(i+1, flag+1)).append(' ');
				flag = i-1;
			}
			--i;
		}
		
		return res.append(entryStr.substring(0,flag+1)).append('.').toString();
	}
	
	// Znajdz dominante w tablicy i zwroc ja oraz ilosc wystapien
	// parametry - tablica oraz maksymalna wartosc w tablicy
	int findDom(int tab[], int max) {
		int counter[] = new int[max+1];
		int occur = 0;
		int idx = 0;
		
		for (int i=0; i<tab.length; i++) {
			++counter[tab[i]];
			if (counter[tab[i]] > occur) {
				occur = counter[tab[i]];
				idx = i;
			} 
		}
		
		System.out.println("liczba wystapien: " + occur);
		return tab[idx];
	}
	
	public static void main(String[] args) {
		Algo a = new Algo();
		String test = "My name is hero";
		System.out.println(a.anotherWay(test));
		
		//test tablicy
		int tab[] = {9,9,1,2,3,4,5,4,3,2,4,5,6,7,8,7,8,9,9,9,9};
		int res = a.findDom(tab, 9);
		System.out.println("Liczba: " + res);
		
		char c1 = 'ą';
		char c2 = 'ć';
		int cx = c1-c2;
		System.out.println("Ciąg: " + cx);

	}
}
