package by.epam.training.task5.logic;

import by.epam.training.task5.bean.Bouquet;

public interface Florist {

	/**
	 * Создаёт случайным образом подобранный букет. Тип букета зависит от типа
	 * флориста (Factory Method).
	 * 
	 * @param flowerQuantity - количество цветов в букете.
	 * @return
	 */
	Bouquet getRandomBouquet(int flowerQuantity);

}
