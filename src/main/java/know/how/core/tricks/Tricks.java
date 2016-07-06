package know.how.core.tricks;

public class Tricks {
	private static int[][] test = new int[3][];

	static {
		int m = 10;
		st = m;
	}

	static int st = 33;

	public static void main(String[] args) {
		System.out.println(st);
		
		int[] a = {1,02,3,4};
		int b = 10;
		int [][] c = {{1,2}, {1,2,3}, {1,2,3,4}};
		
		System.out.println(a instanceof Object);
//		System.out.println(b instanceof Object);  // compilation fails
		
		for (int i : a) System.out.println(i);
		
		// multi dimensional arrays
		int[][] mul = new int[3][];
		mul[1] = new int[]{1,2,3};
		mul[2] = new int[]{4,6,3,6};
		mul[0] = new int[2];
		
		for (int[] i : mul) {
			for (int j: i)
				System.out.print(j + " ");
			System.out.println();
		}
		
		int[] zz;
		zz = new int[]{3,4,6};
		
		int[] ex = new int[]{1,4,3,3};
		int[] ex2 = {1,4,3,3};
		
//		assert ex[0] > 10 : go();

		switch (b) {
		case 2: { System.out.println(); }
		case 4: 
		}
		int as = 9;
		System.out.println("value is - " + (as<9 ? 9.99 : 9));
		
		Integer [][] tt = new Integer[2][];
		Integer [] con = new Integer[2];
		if (con[0] == null) {
			
		}
		System.out.println(tt[1][1]);
	}

	public static int go() {
		return 10;
	}
}
