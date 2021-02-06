package by.jonline.oop.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import by.jonline.oop.task4.bean.Treasure;
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
		
		TreasureCave cave = new TreasureCave(getCavePath());
		
		Console.printList(cave.getAll(), "All treasures:");
		Console.prinItem(cave.getMostExpensive(), "Most expensive item:");
		
		int amount = 2000;
		Console.printList(cave.getAmountList(amount), "Treasures worth $" + amount + ":");
		
		cave.add(new Treasure("New unique item", 999));
	}

	private static String getCavePath() throws IOException {
		
		String path = System.getProperty("user.dir") + "\\treasures.txt";
		
		if (Files.notExists(Path.of(path), LinkOption.NOFOLLOW_LINKS)) {
			String template = Task4.class.getResource("/by/jonline/oop/task4/res/treasures.txt").getPath();
			Files.copy(Path.of(template.substring(1)), Path.of(path));
		}
		
		return path;
	}
}
