//Stack is a LIFO Last in, First out
// (FILO)
//A specific type of list

public class MyStackOfArrayList<E> {	//wrapper class

	private int top;	//size
	private MyArrayList<E> mystack=new MyArrayList<>();
	
	public boolean isEmpty() {
		return mystack.isEmpty();
	}
	
	public void push(E s) {
		mystack.addFirst(s);
		top=mystack.getSize();
	}
	
	public E peek() {
		return mystack.getElement(top-1);
	}
	
	public void pop() {
		mystack.removeLast();
		top=mystack.getSize();
	}
	
	public boolean search(E key) {
		return mystack.search(key);
	}
	
	public void print() {
		mystack.print();
	}
}
