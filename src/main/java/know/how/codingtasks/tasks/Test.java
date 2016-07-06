package know.how.codingtasks.tasks;

public class Test {
	
	/*
		Tym razem mamy utworzyć metodę która przyjmuje jako argument liczbę całkowitą N (nie ujemną). 
		Metoda ma wydrukować liczby z przedziału 1…N, każdą w oddzielnej linii, 
		przy czym jeśli napotkana liczba jest podzielna przez 3, 5 lub 7 to liczba 
		ta powinna zostać zastąpiona przez słowo Fizz, Buzz lub Woof odpowiednio.
	
		Założenia:
		N jest liczbą z przedziału: [1…1,000];
		Metoda nie zwraca żadnej wartości;
		Celem zadania jest skupienie się na poprawności algorytmu, nie na złożoności obliczeniowej;
	*/
	static void run(int N) {
		if (N <= 0) {
			System.err.println("Liczba musi być nieujemna z przedziału 1...1,000");
		}
		
		for (int i=1; i<= N; i++) {
			StringBuilder strB = new StringBuilder();

			if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
				if (i % 3 == 0) strB.append("Fizz");
				if (i % 5 == 0) strB.append("Buzz");
				if (i % 7 == 0) strB.append("Woof");
			} else {
				strB.append(i);
			}
			
			System.out.println(strB.toString());
		}
	}
	
	/*
	   Mamy na wejściu podaną tablicę zawierającą N-elementów i liczbę całkowitą M 
	   która określa maksymalną wartość elementów w tablicy. Mamy stworzyć metodę która 
	   zwróci element tablicy który występuje najczęściej (w przypadku kilku elementów o 
	   tej samej liczbie wystąpień zwróci dowolny).
		Załóżenia:
		N jest liczbą z przedziału: [1…200,000];
		M jest liczbą z przedziału: [1…10,000];
		każdy element tablicy jest liczbą z przedziału [0…M];
		Złożoność:
		Pesymistyczna złożoność czasowa: O(N+M);
		Pesymistyczna złożoność pamięciowa: O(M), pomijając pamięć potrzebną dla wejściowych argumentów;
		Elementy tablicy wejściowej mogą być zmieniane.
	 */
	static void findDominantElem(int[] tab, int M) {
		int[] tmpTab = new int[M+1];
		
		int max = 0;
		int idx = -1;
		for (int i=0; i<tab.length; i++) {
			tmpTab[tab[i]]++;
			
			if (tmpTab[tab[i]] > max) {
				max = tmpTab[tab[i]];
				idx = i;
			}
		}
		System.out.println("liczba: " + tab[idx] + " index: " + idx + " wystapien: " + max);
	}

	public static void main(String[] args) {
		int x = 55; // 1 ... 1,000
//		Test.run(x);
		
        int[] tab = {1,2,2,0,0,0,2,1,2,3,6,7,9,1,2,0};
		Test.findDominantElem(tab, 9);
		
	}
}
