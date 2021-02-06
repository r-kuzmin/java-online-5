package by.jonline.oop.task5.logic;

import by.jonline.oop.task5.bean.Flower;
import by.jonline.oop.task5.bean.Ikebana;
import by.jonline.oop.task5.bean.Wrapping;
import by.jonline.oop.task5.enumer.Colors;
import by.jonline.oop.task5.enumer.FlowerType;
import by.jonline.oop.task5.enumer.WrappingType;

/**
 * Мастер по составлению икебана должен быть только один (Singleton).
 * 
 * @author R. Kuzmin
 *
 */
public class IkebanaMaster implements Florist {

	private static IkebanaMaster instance;

	private IkebanaMaster() {
	}

	public static Florist getInstance() {
		if (instance == null)
			instance = new IkebanaMaster();
		return instance;
	}

	@Override
	public Ikebana getRandomBouquet(int flowerQuantity) {

		if (flowerQuantity < 1 || flowerQuantity > Ikebana.MAX_FLOWERS) {
			return null;
		}

		Ikebana bouquet = new Ikebana();

		Wrapping wrapping = new Wrapping(WrappingType.random(), Colors.random());
		bouquet.setWrapping(wrapping);

		do {
			Flower flower = new Flower(FlowerType.random(), Colors.random());
			bouquet.add(flower);
		} while (bouquet.size() < flowerQuantity);

		return bouquet;
	}

}
