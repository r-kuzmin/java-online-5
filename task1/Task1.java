package by.epam.training.task1;

/**
 * Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить,
 * удалить.
 * 
 * @author R. Kuzmin
 *
 */
public class Task1 {

	public static void main(String[] args) {
		
		Directory dir = new Directory("Каталог с файлами");
		dir.add(new Directory("Ещё один каталог"));
		
		File file1 = new TextFile("Текст 1", "Однажды в студёную зимнюю пору.");
		File file2 = new TextFile("Текст 2", "Я из лесу вышел. Был сильный мороз.");

		dir.add(file1);
		dir.add(file2);
		
		View.printDirectory(dir);
	}

}
