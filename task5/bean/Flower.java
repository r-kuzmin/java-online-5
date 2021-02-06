package by.jonline.oop.task5.bean;

import by.jonline.oop.task5.enumer.Colors;
import by.jonline.oop.task5.enumer.FlowerType;

public class Flower {

	private FlowerType type;
	private Colors color;
	
	public Flower() {
		this(null, null);
	}

	public Flower(FlowerType type, Colors color) {
		super();
		this.type = type;
		this.color = color;
	}

	public FlowerType getType() {
		return type;
	}

	public void setType(FlowerType type) {
		this.type = type;
	}

	public Colors getColor() {
		return color;
	}

	public void setColor(Colors color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		if (color != other.color)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flower [type=" + type + ", color=" + color + "]";
	}
	
}
