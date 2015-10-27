
public class ElementWrapper <T extends Comparable<? super T>> {
	public T element;
	public int counter;

	public ElementWrapper(T content)
	{
		element = content;
	}
	
	public int compareTo(T o) {
		return this.element.compareTo(o);
	}
}
