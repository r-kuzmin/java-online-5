package by.jonline.oop.task2;

public class Task2 {

	public static void main(String[] args) {
		
		Payment payment = new Payment();
		
		payment.addProduct(payment.new Product("Товар 1", 100, 2));
		payment.addProduct(payment.new Product("Товар 2", 150, 5));

		System.out.println(payment);
	}

}
