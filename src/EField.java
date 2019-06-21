
public class EField {
	String type;
	String name;
	
	public EField(String type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public String toString() {
		return type + " " + name;
	}
}
