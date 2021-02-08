package by.epam.training.task2;

import java.util.ArrayList;
import java.util.List;

public class Payment {

	private List<Product> list;

	public Payment() {
		this(new ArrayList<Product>());
	}

	public Payment(List<Product> list) {
		super();
		this.list = list;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public boolean addProduct(Product product) {
		return list.add(product);
	}

	public boolean removeProduct(Product product) {
		return list.remove(product);
	}

	public double getTotal() {

		double total = 0;

		for (Product product : list) {
			total += product.price * product.quantity;
		}

		return total;
	}

	/**
	 * Product не может быть статическим, потому что конкретный товар (строка
	 * документа) должен получить ссылку на объект-родитель. Нет смысла создавать
	 * независимые экземпляры Product в отрыве от Payment. А если это не так, тогда
	 * Product не должен быть вложенным.
	 * 
	 * @author R. Kuzmin
	 *
	 */
	public class Product {

		private String name;
		private double price;
		private double quantity;

		public Product() {
			this("new product", 0, 0);
		}

		public Product(String name, double price, double quantity) {
			super();
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public double getQuantity() {
			return quantity;
		}

		public void setQuantity(double quantity) {
			this.quantity = quantity;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(quantity);
			result = prime * result + (int) (temp ^ (temp >>> 32));
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
			Product other = (Product) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			if (Double.doubleToLongBits(quantity) != Double.doubleToLongBits(other.quantity))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		Payment other = (Payment) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder("Payment [");

		for (Product product : list) {
			sb.append("\n\t" + product.toString());
		}

		sb.append("\n\tTotal=" + getTotal());

		return sb.append("\n]").toString();
	}

}
