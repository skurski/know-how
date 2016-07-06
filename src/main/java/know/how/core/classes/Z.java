package know.how.core.classes;

class X {
	Y b = new Y();
	Y c = new Y();
	Y e = new Y();

	X() {
		System.out.println("X");
		System.out.println("Koniec obiektu nadklasy ------------");
	}
}

class Y {
	Y() {
		System.out.println("Y");
	}
}

public class Z extends X {
	Y y = new Y();

	Z() {
		System.out.println("Z");
	}

	public static void main(String[] args) {
		new Z();
	}
}


//class Base {
//	int i = 99;
//
//	public void amethod() {
//		System.out.println("Base.amethod()");
//	}
//
//	Base() {
//		amethod();
//	}
//}
//
//public class Z extends Base {
//	int i = -1;
//
//	public static void main(String argv[]) {
//		Base b = new Z();
//		System.out.println(b.i);
//		b.amethod();
//	}
//
//	public void amethod() {
//		System.out.println("Derived.amethod()");
//	}
//}