package by.jonline.oop.task5.enumer;

public enum WrappingType {
	PAPER("Бумага"),
	MEMBRANE("Плёнка"),
	FOIL("Фольга");
	
	private String name;
	
	WrappingType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static WrappingType random() {	
		WrappingType[] array = WrappingType.values();
		int i = (int) (Math.random() * array.length);
		return array[i];
	}
}
