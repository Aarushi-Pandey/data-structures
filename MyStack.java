//Stack is a LIFO Last in, First out
// (FILO)
//A specific type of list

//this class contains 2 data members and 6 functions

public class MyStack<E> {	//wrapper class

	//data members
	private int top;	//size of stack
	private MyLinkedList<E> mystack=new MyLinkedList<>();	//create an object of type MyLinkedList
	
	//method to check if the stack is empty i.e. has 0 elements
	public boolean isEmpty() {
		return mystack.isEmpty();
	}
	
	//method to add a Node at the beginning of the linked list
	public void push(E s) {
		mystack.addFirst(s);
		top=mystack.getSize();	//updating value of top
	}
	
	//method to display the first node of the list
	public E peek() {
		return mystack.getFirstElement();
	}
	
	//method to remove the first node in the list
	public void pop() {
		mystack.removeFirst();
		top=mystack.getSize();	//updating value of top
	}
	
	//method to search for a particular node in the list
	public boolean search(E key) {
		return mystack.search(key);
	}
	
	//method to print all the nodes in the list
	public void print() {
		mystack.print();
	}
}
