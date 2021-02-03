package by.jonline.oop.task1;

import java.util.HashSet;
import java.util.Set;

public class Directory extends File {

	private Directory parent;
	private Set<File> nested;

	public Directory() {
		this("new directory", null);
	}

	public Directory(String name) {
		this(name, null);
	}

	public Directory(String name, Directory parent) {
		super(name);
		this.parent = parent;
		this.nested = new HashSet<File>();
	}

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public Set<File> getNested() {
		return nested;
	}

	public boolean add(File file) {

		if (file instanceof Directory) {
			((Directory) file).setParent(this);
		}

		return nested.add(file);
	}

	public boolean delete(File file) {
		return nested.remove(file);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nested == null) ? 0 : nested.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
		Directory other = (Directory) obj;
		if (nested == null) {
			if (other.nested != null)
				return false;
		} else if (!nested.equals(other.nested))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Directory [parent=" + parent + ", nested=" + nested + "]";
	}

}
