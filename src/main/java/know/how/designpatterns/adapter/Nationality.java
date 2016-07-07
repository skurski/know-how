package know.how.designpatterns.adapter;

public enum Nationality {
	ENGLISH("English"), FRENCH("French");
	
	private String nationality;
	
	Nationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getNationality() {
		return nationality;
	}

}
