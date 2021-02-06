package by.jonline.oop.task5.enumer;

public enum FlowerType {
	ROSE("Роза", false),
	TULIP("Тюльпан", true),
	LILY("Лилия", false),
	CHRYSANTHEMUM("Хризантема", false),
	PION("Пион", true),
	GERBERA("Гербера", false),
	ASTER("Астра", false);
	
	private String name;
	private boolean man;
	
	FlowerType(String name, boolean man) {
		this.name = name;
		this.man = man;
	}

	public String getName() {
		return name;
	}
	
	public boolean isMan() {
		return man;
	}

	public static FlowerType random() {	
		FlowerType[] array = FlowerType.values();
		int i = (int) (Math.random() * array.length);
		return array[i];
	}
	
}
