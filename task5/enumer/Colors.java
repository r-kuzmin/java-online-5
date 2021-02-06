package by.jonline.oop.task5.enumer;

public enum Colors {
	RED("Красный", "Красная"),
	ORANGE("Оранжевый", "Оранжевая"),
	YELLOW("Желтый", "Желтая"),
	GREEN("Зелёный", "Зелёная"),
	BLUE("Синий", "Синяя"),
	PURPLE("Фиолетовый", "Фиолетовая");
	
	private String name;
	private String femaleName;
	
	Colors(String name, String femaleName) {
		this.name = name;
		this.femaleName = femaleName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFemaleName() {
		return femaleName;
	}

	public static Colors random() {	
		Colors[] array = Colors.values();
		int i = (int) (Math.random() * array.length);
		return array[i];
	}
	
}
