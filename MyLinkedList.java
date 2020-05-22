//This file contains 2 classes: MyLinkedList and MyNode. MyLinkedList contains 3 global variables and 11 functions.
// MyNode contains 3 global variables and 0 functions, implements MyList

public class MyLinkedList<E> implements MyList<E>{

	//data members
	private MyNode<E> first;	//stores pointer to first element in LinkedList
	private MyNode<E> last;	//stores pointer to last element in LinkedList
	private int size;		//stores size of Linked List
	 
	//returns first element of list
	public E getFirstElement() {
		return (E) first.element;
	}
	
	//returns last element of list
	public E getLastElement() {
		return (E) last.element;
	}
	
	//function to check if the linked list contains any nodes
	@Override
	public boolean isEmpty() {
		return first==null;
	}
	
	//getter function to return size of the linked list
	public int getSize() {
		return this.size;
	}	
		
	//function to add an element before the first element in the linked list
	public void addFirst(E s) {	//O(1)
		MyNode<E> newNode=new MyNode<>(s);	//creating a new node to be added before the first node in linked list
		//checks if the linked list contains any nodes
		if (isEmpty()) { //if the new node is the very first node in the linked list
			last=newNode;	//if the list contains only 1 node, both first and last point to it
		}else { //not the only node in the linked list
			newNode.next=first;	
		}
		first=newNode;
		size++;		//size has increased by 1
	}
	
	//function to add a node after the last node in the linked list
	public void addLast(E s) {	//O(1)
		MyNode<E> newNode=new MyNode<>(s);	//creating a new node
		//checks if the linked list contains any nodes
		if (isEmpty()) {	//if the new node is the very first node in the linked list
			first=newNode;	//if the list contains only 1 node, both first and last point to it
		} else {	//not the only node in the linked list
			last.next=newNode;
		}
		last=newNode;
		size++;		//size has increased by 1
	}
	
	//function to remove the first element from the linked list
	public void removeFirst() {	//0(1)
		//checks if the linked list contains any nodes
		if (!isEmpty()) {	//checks if there is a node in the list to be removed
			E temp= (E)first.element;	//stores value of the element to be removed
			if (first==last) { //if there is only one element in the list
				first = last =null;	//if the list contains only 1 node, both first and last point to it so 
									//both pointers need to be changed
			} else {	//if there is more than one element in the list
				first=first.next;	
			}
			size--;	//size of list is decreased by 1
			System.out.println(temp+" is removed!");	
		}else {	//if there are no elements in the list
			System.out.println("List is empty!");
		}
	}
	
	//function to remove the first element from the linked list
		public E removeFirstElement() {	//0(1)
			//checks if the linked list contains any nodes
			if (!isEmpty()) {	//checks if there is a node in the list to be removed
				E temp= (E)first.element;	//stores value of the element to be removed
				if (first==last) { //if there is only one element in the list
					first = last =null;	//if the list contains only 1 node, both first and last point to it so 
										//both pointers need to be changed
				} else {	//if there is more than one element in the list
					first=first.next;	
				}
				size--;	//size of list is decreased by 1
				return temp;	
			}else {	//if there are no elements in the list
				return null;
			}
		}
	
	//function to remove the last element from the linked list
	public void removeLast() { //O(n)
		//checks if the linked list contains any nodes
		if (!isEmpty()) {
			E temp= (E)last.element;	//stores value of the element to be removed
			if (last==first) {	//if there is only one element in the list
				first=last=null;	//if the list contains only 1 node, both first and last point to it so 
									//both pointers need to be changed
			} else {	//if there is more than one element in the list
				MyNode<E> prev=first;		//a pointer to traverse through the linked list
				//executes until it reaches the node before the last node of the list
				while (first.next!=last) {
					prev=prev.next;	//goes to the next node
				}
				//removing node from list
				prev.next=null;
				last=prev;
			}
			size--;		//size of list is decreased by 1
			System.out.println(temp+" is removed!");
		}else {	//if there are no elements in the list
			System.out.println("List is empty!");
		}
	}
	
	//function to search for a particular element in the linked list
	public boolean search(E key) { //O(n)
		//pointer to traverse through the list
		MyNode<E> current=first;
		//executes until there are no nodes left or the element that is being searched is found in the list
		while (current!=null && !current.element.equals(key)) {
			current=current.next;	//goes to the next node
		}
		return current!=null;	//returns whether the element was found in the list or not
	}
	
	//function to remove an element from the list
	public void remove(E key) {
		//checks if the element exists in the linked list
		if (search(key)) {	//element is found in the list
			//pointers to traverse through the linked list
			MyNode<E> prev=first;
			MyNode<E> current=first;
			//executes until the current pointer reaches the end of the linked list or
			//the node to be removed is found in the list
			while (current!=null && !current.element.equals(key)) {
				//pointers go to the next element in the linked list
				prev=current;
				current=current.next;
			}
			//checks if the pointer is pointing to the first or last node of the list
			if (current==first)	//if it is pointing to the first node of the list
				removeFirst();	//function to remove the first node of the list
			else if (current==last)	//if it is pointing to the last node of the list
				removeLast();	//function to remove the last node of the list
			else {	//it is pointing to an node in the middle of 2 nodes
				prev.next=current.next;
				size--;	//decreasing the size of the linked list
				System.out.println(key+" is removed!");
			}
		} else {	//element is not found in the list
			System.out.println(key+" is not in the list");
		}
	}
	
	//function to print all the elements in the nodes of the linked list
	public void print() {
		System.out.println("Elements in the list: ");
		MyNode<E> current=first;	//pointer to traverse through the list
		//checks if the list contains any elements
		if (!isEmpty()) {	//list contains nodes
			//executes until it reaches the end of the list
			while (current!=null) {
				//prints the element of the current node
				System.out.print(current.element+" ");
				current=current.next;	//goes to the next node
			}
			System.out.println();
			System.out.println("Size= "+getSize());	//prints the size of the linked list
		}else {	//list doesn't contain any nodes
			System.out.println("List is empty!");
		}
	}
}


class MyNode<E> {
	
	//data members
	public E element;	
	public MyNode<E> next;	//by default value of next is null
	
	//parameterized constructor to create a node
	public MyNode (E element) {
		this.element=element;
	}
	
}
