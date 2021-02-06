package by.jonline.oop.task5.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import by.jonline.oop.task5.enumer.Colors;
import by.jonline.oop.task5.enumer.FlowerType;

public abstract class Bouquet extends ArrayList<Flower> {

	private static final long serialVersionUID = -1793462286870224279L;

	private Wrapping wrapping;

	public Bouquet() {
		super();
	}
	
	public Wrapping getWrapping() {
		return wrapping;
	}

	public void setWrapping(Wrapping wrapping) {
		this.wrapping = wrapping;
	}

	/**
	 * Количество различных типов цветов в букете.
	 * @return
	 */
	public int flowersTypeCount() {

		Set<FlowerType> counter = new HashSet<>();

		for (Flower item : this) {
			counter.add(item.getType());
		}

		return counter.size();
	}

	/**
	 * Количество различных оттенков в букете.
	 * @return
	 */
	public int colorsCount() {

		Set<Colors> counter = new HashSet<>();

		// Цвет упаковки также учитываем.
		counter.add(wrapping.getColor());

		for (Flower item : this) {
			counter.add(item.getColor());
		}

		return counter.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((wrapping == null) ? 0 : wrapping.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bouquet other = (Bouquet) obj;
		if (wrapping == null) {
			if (other.wrapping != null)
				return false;
		} else if (!wrapping.equals(other.wrapping))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bouquet [wrapping=" + wrapping + ", flowers=" + super.toString() + "]";
	}

}
