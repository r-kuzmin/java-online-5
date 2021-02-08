package by.epam.training.task4.bean;

import java.io.Serializable;

public class Treasure implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 6620709572289665130L;
	
	private int id;
	private String name;
	private int price;
	
	public Treasure() {
		this(0, "New treasure", 0);
	}

	public Treasure(String name, int price) {
		this(0, name, price);
	}

	public Treasure(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public Treasure clone() { 
		return new Treasure(id, name, price);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
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
		Treasure other = (Treasure) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treasure [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
