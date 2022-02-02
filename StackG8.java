import java.util.ArrayList;

public class StackG8<E> implements Stack<E> {

	private ArrayList<E> nums;
	
	
	
	public StackG8() {
		nums = new ArrayList<E>();
	}
	
	
	public void add(E item) {
		nums.add(item);
	}
	
	public E remove() {
		return nums.remove(size()-1);
	}
	
	public E peek() {
		return nums.get(size()-1);
	}
	
	public boolean empty() {
		return size()== 0;
	}
	
	public int size() {
		return nums.size();
	}
	

}
