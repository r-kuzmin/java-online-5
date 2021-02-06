package by.jonline.oop.task4.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.jonline.oop.task4.bean.Treasure;

/**
 * Хранилище информации о сокровищах в текстовом формате.
 * 
 * Для хранения больших объемов данных не годится, лучше использовать
 * полноценную БД.
 * 
 * Информация из файла читается в кеш один раз, при создании dao. Каждый раз при
 * изменении объектов кеш сбрасывается на диск. Объект cache имитирует реальную БД,
 * поэтому там хранятся копии пользовательских объектов. 
 * 
 * @author R. Kuzmin
 *
 */
public class TextTreasureDao implements TreasureDao {

	private File file;
	private Set<Treasure> cache;

	public TextTreasureDao(String path) throws IOException {
		this.file = new File(path);
		readFile();
	}

	@Override
	public int create(Treasure treasure) {

		int id = getNextId();
		
		if (id == 0) {
			// В хранилище кончилось свободные id.
			return 0;
		}

		// Копия объекта в хранилище.
		Treasure image = treasure.clone();
		image.setId(id);

		if (cache.add(image)) {
			try {
				writeFile();
			} catch (IOException e) {
				delete(id); // Восстанавливаем кеш.
				return 0;
			}
		} else {
			return 0;
		}

		treasure.setId(id);
		
		return id;
	}

	@Override
	public Treasure read(int id) {

		for (Treasure image : cache) {
			if (image.getId() == id) { 
				return image.clone();
			}
		}

		return null;
	}

	@Override
	public boolean update(Treasure treasure) {
		
		for (Treasure image : cache) {
			if (image.getId() == treasure.getId()) {
				
				// Копия данных для восстановления в случае ошибки.
				Treasure temp = image.clone();
				
				// Изменяем данные в кеше и пробуем сбросить на диск.
				image.setName(treasure.getName());
				image.setPrice(treasure.getPrice());
				
				try {
					writeFile();
				} catch (IOException e) {
					image.setName(temp.getName());
					image.setPrice(temp.getPrice());
					return false;
				}
				
				break;
			}
		}
		
		return true;
	}

	@Override
	public boolean delete(int id) {

		for (Treasure treasure : cache) {
			if (treasure.getId() == id) {
				return cache.remove(treasure);
			}
		}
		
		return false;
	}

	@Override
	public List<Treasure> getAll() {
		return new ArrayList<>(cache);
	}

	private void readFile() throws IOException {

		cache = new HashSet<Treasure>();

		FileReader fr = new FileReader(file, Charset.forName("UTF-8"));
		BufferedReader reader = new BufferedReader(fr);
		
		try {
			String line = reader.readLine();

			while (line != null) {

				String[] parts = line.split(";");

				if (parts.length == 3) {
					int id = Integer.parseInt(parts[0]);
					int price = Integer.parseInt(parts[2]);
					Treasure treasure = new Treasure(id, parts[1], price);

					cache.add(treasure);
				}

				line = reader.readLine();
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}

	private void writeFile() throws IOException {

		FileWriter fw = new FileWriter(file, Charset.forName("UTF-8"), false);
		BufferedWriter writer = new BufferedWriter(fw);
		
		try {
			for (Treasure treasure : cache) {
				Integer id = treasure.getId();
				Integer price = treasure.getPrice();
				String record = String.join(";", id.toString(), treasure.getName(), price.toString());
				
				writer.append(record);
				writer.newLine();
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		
	}

	private int getNextId() {

		int id = 0;

		if (cache.size() == 999_999) {
			return id;
		}

		do {
			id = (int) (Math.random() * 1_000_000);
		} while (read(id) != null);

		return id;
	}

}
