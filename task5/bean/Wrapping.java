package by.jonline.oop.task5.bean;

import by.jonline.oop.task5.enumer.Colors;
import by.jonline.oop.task5.enumer.WrappingType;

public class Wrapping {

	private WrappingType type;
	private Colors color;
	
	public Wrapping() {
		this(null, null);
	}

	public Wrapping(WrappingType type, Colors color) {
		super();
		this.type = type;
		this.color = color;
	}

	public WrappingType getType() {
		return type;
	}

	public void setType(WrappingType type) {
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
		Wrapping other = (Wrapping) obj;
		if (color != other.color)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wrapping [type=" + type + ", color=" + color + "]";
	}
	
}
