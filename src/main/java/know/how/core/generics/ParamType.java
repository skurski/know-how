package know.how.core.generics;

class ParamType
{
	public static void main(String[] args) {
		// Parametrized type
		Box<Integer> b = new Box<Integer>(100);
		Box<String> c = new Box<String>("Umieszczenie liczby - blad kompilacji");
		
		// Generic type but use raw type
		Box<String> d = new Box<>("Umieszczenie liczby - blad kompilacji");
		Box e = new Box<String>("Umieszczenie liczby - blad kompilacji");
//		d.setT(10); //blad kompilacji
		e.setT(10); //brak bledu
	
		// Raw type, T became Object
		Box box = new Box(10);
		box.setT("String");
		System.out.println(box.getT());
	}
}

class Box<T>
{
	private T t;
	
	Box(T t) {
		this.t = t;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}
}
