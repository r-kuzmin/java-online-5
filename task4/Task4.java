package by.jonline.oop.task4;

import java.io.IOException;

import by.jonline.oop.task4.logic.TreasureCave;
import by.jonline.oop.task4.view.Console;

/**
 * Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в
 * пещере дракона. Реализовать возможность просмотра сокровищ, выбора самого
 * дорогого по стоимости сокровища и выбора сокровищ на заданную сумму.
 * 
 * @author R. Kuzmin
 *
 */
public class Task4 {

	public static void main(String[] args) throws IOException {
		
		TreasureCave cave = new TreasureCave("src\\by\\jonline\\oop\\task4\\res\\treasures.txt");
		
		Console.printList(cave.getAll(), "All treasures:");
		Console.prinItem(cave.getMostExpensive(), "Most expensive item:");
		
		int amount = 2000;
		Console.printList(cave.getAmountList(amount), "Treasures worth $" + amount + ":");
	}

}
