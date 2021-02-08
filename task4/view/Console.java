package by.epam.training.task4.view;

import java.util.List;

import by.epam.training.task4.bean.Treasure;

public class Console {

	public static void printList(List<Treasure> list,  String title) {
		System.out.println(title);

		for (Treasure item : list) {
			System.out.println("\tItem " + item.getId() + ": " + item.getName() + " - $" + item.getPrice());
		}
	}

	public static void prinItem(Treasure item, String title) {
		System.out.println(title);
		System.out.println("\tItem " + item.getId() + ": " + item.getName() + " - $" + item.getPrice());
	}
	
}
