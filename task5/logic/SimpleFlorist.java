package by.jonline.oop.task5.logic;

import by.jonline.oop.task5.bean.Flower;
import by.jonline.oop.task5.bean.SimpleBouquet;
import by.jonline.oop.task5.bean.Wrapping;
import by.jonline.oop.task5.enumer.Colors;
import by.jonline.oop.task5.enumer.FlowerType;
import by.jonline.oop.task5.enumer.WrappingType;

public class SimpleFlorist implements Florist {

	@Override
	public SimpleBouquet getRandomBouquet(int flowerQuantity) {

		if (flowerQuantity < 1) {
			return null;
		}

		SimpleBouquet bouquet = new SimpleBouquet();

		bouquet.setWrapping(new Wrapping(WrappingType.random(), Colors.random()));

		do {
			bouquet.add(new Flower(FlowerType.random(), Colors.random()));
		} while (bouquet.size() < flowerQuantity);

		return bouquet;
	}

}
