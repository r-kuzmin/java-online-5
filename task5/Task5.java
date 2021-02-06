package by.jonline.oop.task5;

import by.jonline.oop.task5.bean.Bouquet;
import by.jonline.oop.task5.logic.Florist;
import by.jonline.oop.task5.logic.IkebanaMaster;
import by.jonline.oop.task5.logic.SimpleFlorist;
import by.jonline.oop.task5.view.Console;

/**
 * Реализовать приложение, позволяющее создавать цветочные композиции (объект,
 * представляющий собой цветочную композицию). Составляющими цветочной
 * композиции являются цветы и упаковка.
 * 
 * @author R. Kuzmin
 *
 */
public class Task5 {

	public static void main(String[] args) {

		Florist florist = new SimpleFlorist();
		Bouquet bouquet = florist.getRandomBouquet(5);
		
		if (bouquet != null) {
			Console.show(bouquet);
		} else {
			Console.print("Не получилось сформировать букет.");
		}
		
		Florist master = IkebanaMaster.getInstance();
		Bouquet ikebana = master.getRandomBouquet(3);

		if (ikebana != null) {
			Console.show(ikebana);
		} else {
			Console.print("Не получилось сформировать икебану.");
		}
		
	}

}
