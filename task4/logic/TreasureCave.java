package by.jonline.oop.task4.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import by.jonline.oop.task4.bean.Treasure;
import by.jonline.oop.task4.dao.TextTreasureDao;
import by.jonline.oop.task4.dao.TreasureDao;

public class TreasureCave {
	
	private TreasureDao dao;
	
	/**
	 * Поиск пещеры с сокровищами по указанному пути.
	 * 
	 * @param path - путь к файлу.
	 * @throws IOException 
	 */
	public TreasureCave(String path) throws IOException {
		this.dao = new TextTreasureDao(path);
	}
	
	/**
	 * Возвращает список всех предметов в пещере.
	 * 
	 * @return
	 */
	public List<Treasure> getAll() {
		return dao.getAll();
	}
	
	/**
	 * Возвращает описание самого дорогого сокровища.
	 * 
	 * @return
	 */
	public Treasure getMostExpensive() {
		
		Treasure item = new Treasure();
		
		for (Treasure treasure : dao.getAll()) {
			if (treasure.getPrice() > item.getPrice()) {
				item = treasure;
			}
		}
		
		return item;
	}
	
	/**
	 * Список сокровищ на указанную сумму.
	 * 
	 * @return
	 */
	public List<Treasure> getAmountList(int amount) {
		
		List<Treasure> list = new ArrayList<Treasure>();
		
		// Получим все элементы и отсортируем по возрастанию.
		List<Treasure> all = dao.getAll();
		Collections.sort(all, new ComparatorByPrice(false));
		
		// Перебираем и суммируем элементы, пока текущая сумма не приблизится к искомой.
		int current = 0;
		
		for (Treasure treasure : all) {
			if (current + treasure.getPrice() <= amount) {
				list.add(treasure);
				current += treasure.getPrice();
			}
		}
		
		return list;
	}
	
	/**
	 * Добавить сокровище в пещеру.
	 * 
	 * @param treasure
	 */
	public void add(Treasure treasure) {
		dao.create(treasure);
	}
	
	private static class ComparatorByPrice implements Comparator<Treasure> {

		private boolean ascending;
		
		public ComparatorByPrice(boolean ascending) {
			this.ascending = ascending;
		}
		
		@Override
		public int compare(Treasure o1, Treasure o2) {
			if (ascending) {
				return o1.getPrice() - o2.getPrice();
			} else {
				return o2.getPrice() - o1.getPrice();
			}
		}
		
	}

}
