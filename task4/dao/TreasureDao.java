package by.jonline.oop.task4.dao;

import java.util.List;

import by.jonline.oop.task4.bean.Treasure;

public interface TreasureDao {

	/**
	 * Создает новый объект в хранилище данных и возвращает присвоенный объекту id.
	 * 
	 * @param treasure - данные для записи.
	 * @return 0 - в случае ошибки создания новой записи.
	 */
	int create(Treasure treasure);

	/**
	 * Возвращает объект из хранилища по его id.
	 * 
	 * @param id
	 * @return
	 */
	Treasure read(int id);

	/**
	 * Обновляет запись об объекте в хранилище.
	 * 
	 * @param treasure
	 * @return false в случае ошибки обновления.
	 */
	boolean update(Treasure treasure);

	/**
	 * Удаляет запись из хранилища.
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(int id);
	
	/**
	 * Возвращает список всех объектов хранилища.
	 * 
	 * @return
	 */
	List<Treasure> getAll();
}
