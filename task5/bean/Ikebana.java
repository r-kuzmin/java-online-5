package by.jonline.oop.task5.bean;

/**
 * Икебана должна содержать не более 10 цветов одного типа и не более 2 различных
 * оттенков.
 * 
 * @author R. Kuzmin
 *
 */
public class Ikebana extends Bouquet {

	private static final long serialVersionUID = -6136031526948097611L;

	public static final int MAX_FLOWERS = 10;
	public static final int MAX_FLOWERS_TYPE = 1;
	public static final int MAX_COLORS = 2;

	public Ikebana() {
		super();
	}

	@Override
	public boolean add(Flower item) {

		if (size() == MAX_FLOWERS) {
			return false;
		}
		
		super.add(item);

		if (flowersTypeCount() > MAX_FLOWERS_TYPE || colorsCount() > MAX_COLORS) {
			this.remove(item);
			return false;
		}

		return true;
	}

}
