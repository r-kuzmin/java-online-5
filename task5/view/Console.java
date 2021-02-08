package by.epam.training.task5.view;

import by.epam.training.task5.bean.Bouquet;
import by.epam.training.task5.bean.Flower;
import by.epam.training.task5.bean.Wrapping;
import by.epam.training.task5.enumer.Colors;
import by.epam.training.task5.enumer.FlowerType;

public class Console {

	public static void show(Bouquet bouquet) {

		System.out.println(bouquet.getClass().getSimpleName() + ":");
		
		for (Flower flower : bouquet) {
			
			FlowerType ft = flower.getType();
			Colors cl = flower.getColor();
			
			String color = ft.isMan() ? cl.getName() : cl.getFemaleName(); 
			System.out.println("\t" + color + " " + ft.getName().toLowerCase());
		}

		Wrapping wr = bouquet.getWrapping();
		String color = wr.getColor().getFemaleName().toLowerCase();
		String type = wr.getType().getName().toLowerCase();
		System.out.println("\tУпаковка: " + color + " " + type);
	}

	public static void print(String string) {
		System.out.println(string);
	}
	
}
