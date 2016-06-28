package know.how.testing.sort;

public class Simple {
	private int[] tab;
	
	Simple(int[] t) {
		tab = t;
	}
	
	void bubbleSort(int tab[]) {
		boolean flag = true;
		int temp = 0;
		
		while (flag) {
			flag = false;
			for (int i=tab.length-1; i>0; i--) {
				if (tab[i] < tab[i-1]) {
					temp = tab[i];
					tab[i] = tab[i-1];
					tab[i-1] = temp;
					flag = true;
				}
			}
		}
	}
	
	void insertionSort(int tab[]) {
		for (int i=tab.length-1; i>0; i--) {
			int temp = tab[i];
			int idx = i;
			
			for (int j=i; j>0 && temp < tab[j]; j--) {
				if (temp < tab[j]) {
					temp = tab[j];
					idx = j;
				}
			}
			tab[idx] = tab[i];
			tab[i] = temp;
		}
		this.tab = tab;
	}
	
	//selection sort
	
	public String toString() {
		StringBuilder numbers = new StringBuilder();
		for (int i: tab) {
			numbers.append(i).append(' ');
		}
		return numbers.toString();
	}
	
	public static void main(String[] args) {
		int[] tab = {1,2,3,8,5,3,2,1,3};
		Simple simple = new Simple(tab);
		System.out.println(simple);
//		simple.bubbleSort(tab);
//		System.out.println(simple);
		
		simple.insertionSort(tab);
		System.out.println(simple);

//		Collections.sort(new ArrayList<Integer>());
	}
}
