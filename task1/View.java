package by.jonline.oop.task1;

public class View {
	
	public static void printDirectory(Directory dir) {
		
		System.out.println("Directory: " + dir.getName());
		
		Directory parent = dir.getParent();
		if (parent != null) {
			System.out.println("parent: " + parent.getName());
		}
		
		System.out.println("nested objects:");
		for (File nested : dir.getNested()) {
			System.out.println("\t" + nested.getName() + " (" + nested.getClass().getSimpleName() + ")");
		}
		
	}
}
