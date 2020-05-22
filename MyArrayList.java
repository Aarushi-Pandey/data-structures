import java.io.InputStreamReader;
import java.io.BufferedReader;
//import java.io.IOException;

//this class contains 3 data members and 17 functions, implements MyList
public class MyArrayList<E> implements MyList<E>{
	
	//data members
	private Object[] list;		//stores elements in array list
	private int capacity=4;		//total number of elements allowed in array
	private int size;			//total number of elements currently in array
	
	//to read input
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	
	//default constructor to initialize array
	public MyArrayList() {
		this.list=new Object[this.capacity];
	}
	
	//parameterized constructor to initialize array
	public MyArrayList(int capacity) {
		//checks if the capacity of the list exceeds the minimum capacity required by the array
		if (capacity > 4)
			this.capacity=capacity;
		this.list=new Object[this.capacity];
		//this()
	}
	
	//getter method for size
	public int getSize() {
		return this.size;
	}
	
	//checks if the array contains any elements
	public boolean isEmpty() {
		return size==0;
	}
	
	//add element at the end of the list
	public void addFirst(E s) {// 0(1)
		//checks if there is any space left in the array
		if (size>=capacity)
			resize(this.capacity*2);	//increases size of the array
		list[size]=s;	//adds element to the array
		size++;	//increases size
	}
	
	/*//add element at the end of the list
		public void add() throws IOException{// 0(1)
			//accepts value to be stored by user
			System.out.print("Enter element to be added: ");
			E s=in.readLine();
			add(s);	//calls function to add an element in the array
		}*/
	
	//adding element to end of list
	public void addLast(E s) {
		add(s,capacity-1);
	}
	
	//it can act like adding element to the beginning of the list
	public void add(E s,int index) {	//O(n)
		//checks if the index is valid
		if(index>=0 && index<=size) {	//index is valid
			//checks if there is any space left in the array
			if(size>=capacity)
				resize(this.capacity*2);	//increases size of the array
			for (int k=size-1; k>=index;k--) {	//shifting element
				list[k+1]=list[k];
			}
			list[index]=s;	//add element to the index
			size++;	//increases size
		} else {	//index is not valid
			System.out.println("index "+index+" is out or range!");
		}
	}
	
	/*//it can act like adding element to the beginning of the list
		public void add(int index) throws IOException{	//O(n)
			//Scanner input=new Scanner(System.in);
			System.out.print("Enter element to be added: ");
			Object s=in.readLine();
			add(s,index);	//calls function to add an element at a particular index of the array
		}*/

	//remove element from the end of the list
	public void removeFirst() {// O(1)
		//checks if the array contains any elements
		if (!isEmpty()) {	//contains elements
			size--;	//decreases size
			Object temp= list[size];	//temporary variable to store the element to be removed
			list[size]=null;	//deleting element from array
			//checks if the size of array is not 0 and less than 25% of the capacity of the array
			if (size!=0 && capacity/size >=4)
				resize(this.capacity/2);	//decreasing size of array
			System.out.println(temp+" removed!");
		} else {	//contains 0 elements
			System.out.println("List is empty!");
		}
	}
	
	//removing last element from list
	public void removeLast( ) {
		remove(size);
	}
	
	//if u have duplication
	public void removeDuplication() {
		//checks if the array contains any elements
		if (!isEmpty()) {	//contains elements
			//loop to execute for every element in the array
			for (int i=0;i<size-1;i++) {
				Object element=list[i];	//to store value of element in array
				//loop to execute for every element after the current element in the list
				for (int j=i+1;j<size;j++) {
					//checks if there is are 2 elements in the list with the same value
					if (element==list[j]) {
						remove(j);	//calls function to remove that element from array
					}
				}
			}
		}
		else {	//contains 0 elements
			System.out.println("List is empty!");
		}
	}
	
	//removes element at particular index of array
	public void remove(int index) {
		//checks if the index is valid
		if(index>=0 && index<=size) {
			for (int k=index;k<size;k++) {	//shifting element
				list[k]=list[k+1];
			}
			size--;		//decreases size
			//checks if the size of array is not 0 and less than 25% of the capacity of the array
			if (size!=0 && capacity/size >=4)
				resize(this.capacity/2);	//decreasing size of array
		} else {	//index is not valid
			System.out.println("index "+index+" is out or range!");
		}
	}
	
	//can act as removing element from beginning of the list
	public void remove(E key) {	//O(n)
		//checks if there is an element with the same value as the key
		int index=compareTo(key);	
		if (index!=-1) {	//element exists in array
			for (int k=index+1; k<=size;k++) {	//shifting element
				list[k-1]=list[k];
			}
			size--;	//decreasing size
			//checks if the size of array is not 0 and less than 25% of the capacity of the array
			if (size!=0 && capacity/size >=4)
				resize(this.capacity/2);	//decreasing size of array
			System.out.println(key+" removed!");
		} else {	//element doesn't exist in array
			System.out.println(key +" is not in the list");
		}
	}
	
	//linear search
	private int compareTo(E key) {	//O(n)
		//loop executes until an element is found with the same value as the key
		for (int i=0;i<size;i++) {
			//checks if the element value is the same as the key
			if (list[i].equals(key))
				return i;	//returns index of the array
		}
		return -1;
	}
	
	//returns element at particular index in array
	public E getElement(int index) {	//O(1)
		//checks if the index is valid
		if (index>=0 && index<size)
			return (E) list[index];	//returns element at particular index
		return null;
	}
	
	//changes the capacity of the array
	private void resize(int capacity) {// O(N)
		this.capacity=capacity;
		E[] temp=(E[])list;	//temporary list that stores old array
		//array of new required length initialized
		list=new Object[this.capacity];
		//loop executes until all elements are copied from temp to list array
		for (int i=0;i<size;i++) {
			list[i]=temp[i];
		}
	}
	
	//prints all elements of array
	public void print() {
		System.out.print("|");
		//loop executes until all elements of the list are printed
		for (int i=0;i<capacity;i++) {
			System.out.print(list[i]+" |");
		}
		System.out.println();
	}

	//linear search
	@Override
	public boolean search(E key) {
		return compareTo(key) !=-1;
	}
	
	/*public void removeLast() {
		remove(capacity-1);
	}*/
	
}
