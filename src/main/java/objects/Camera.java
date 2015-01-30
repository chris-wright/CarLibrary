package objects;

public enum Camera {
	
	I("i"),
	F("f"),
	R("r"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	ELEVEN("11"),
	TWELVE("12");
	
	private String value;
	
	private Camera(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
