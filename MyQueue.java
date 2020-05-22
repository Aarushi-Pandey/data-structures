//Queue is a FIFO First in, First out
//(LILO)
//A specific type of list

//this class is a wrapper class of MyLinkedList

//this class contains 1 data member and 4 functions

public class MyQueue<E> {

	//data member
	private MyLinkedList<E> myqueue= new MyLinkedList<>();	//create an object of type MyLinkedList
	
	//method to check if the queue is empty i.e. has 0 elements
	public boolean isEmpty() {
		return myqueue.isEmpty();	
	}
	
	//method to add a Node at the end of the linked list
	public void enqueue(E s) {
		myqueue.addLast(s);
	}
	
	/*//method to remove the first node in the list
	public void dequeue()  {
		myqueue.removeFirst();
	}*/
	
	//method to remove the first node in the list
	public E dequeue()  {
		return myqueue.removeFirstElement();
	}
	
	//method to print all the nodes in the list
	public void print() {
		myqueue.print();
	}
}
