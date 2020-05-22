//This file contains 2 classes: MyBST<E> and MyTreeNode<E>. MyBST<E> contains 2 data members and 
//8 functions. MyTreeNode<E> contains 3 data members and 1 constructor.

public class MyBST<E extends Comparable<E>> { //E should be comparable

	//data members
	private MyTreeNode<E> root;		//stores root of binary search tree
	private int size;				//stores size of binary search tree
	
	//method to check if the binary tree is empty or not by checking whether the size of the 
	//binary search tree is 0 (returns boolean)
	public boolean isEmpty() {
		return size==0;
	}
	
	//method to insert an element (input parameter) into the binary search tree
	//it returns false only when that element already exists in the bst
	public boolean insert(E e) {
		
		MyTreeNode<E> newTreeNode = new MyTreeNode<E> (e);	//to store the new element
		
		//checks if the tree is empty
		if (isEmpty()) { //it is the first element in the tree
			root = newTreeNode;
		} else { //there exist other elements in the tree
			MyTreeNode<E> current = root;	//to traverse through the tree
			MyTreeNode<E> parent = root;	//to store the parent of current node
			
			//executes until no nodes left in tree
			while (current!=null) {
				//checks if current node's element is greater than, less than or equal to 
				//the input element
				if (e.compareTo(current.element) < 0) {	//element is less 
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {	//element is more
					parent = current;
					current = current.right;
				} else {
					return false;	//duplication
				}
			}
			
			//checks whether element should be added to the left or right of the subtree of parent node
			if (e.compareTo(parent.element) < 0) {	//added to left
				parent.left = newTreeNode;
			}else {	//added to right
				parent.right = newTreeNode;
			}
		}
		size++;	//size of tree increased
		return true;	//successfully added element to tree
	}
	
	//this method searches for a particular element in the bst and returns true or false accordingly
	public boolean search(E key) {
		MyTreeNode<E> current = root;	//to traverse through tree
		//executes until no nodes left in tree
		while (current != null) {	
			//checks if current node's element is greater than, less than or equal to 
			//the input element key
			if (key.compareTo(current.element) < 0) {	//key is less 
				current = current.left;
			} else if (key.compareTo(current.element) > 0) {	//key is more
				current = current.right;
			} else {
				return true; //key is found in tree
			}
		}
		return false; //key is not present in tree
	}
	
	//method to print the nodes in the tree in bfs as well as the size of the tree
	public void print() {
		//dfs();
		bfs();
		System.out.println("Size= "+size);
	}

	//this method prints elements from left to right on each level starting from the root of the tree
	private void bfs() { //inorder - queue
		
		MyQueue<MyTreeNode<E>> queue = new MyQueue<MyTreeNode<E>> (); 	//queue to store nodes in required order
		queue.enqueue(root);	//adding root of tree to queue
		//executes until queue contains 0 elements
		while (!queue.isEmpty()) {
			MyTreeNode<E> current = queue.dequeue();	//stores first node in queue
			System.out.print(current.element+" ");		//prints its value
			//checks if the node contains any left nodes
			if (current.left != null) {
				queue.enqueue(current.left);	//adding node to queue
			} 
			//checks if the node contains any right nodes
			if (current.right != null) {
				queue.enqueue(current.right);	//adding node to queue
			}
		}
		System.out.println();
	}

	//this method calls the helper recursive method to print the nodes of the tree
	private void dfs() { //inorder - recursive
		dfs(root);	
		System.out.println();
	}

	//this helper method prints the left node, then the root node, and then the right nose (inorder)
	//this is a recursive function
	private void dfs(MyTreeNode<E> current) {
		//checks if there are any nodes left in the list (base case)
		if (current != null) {	//nodes left
			dfs(current.left);	//function called on left node of current node
			System.out.print(current.element + " ");	//current node printed
			dfs(current.right);	//function called on left node of current node
		} 
	}
	
	//this method deletes the input element in the tree 
	public void delete(E e) {
		
		//checks if the tree is empty
		if (!isEmpty()) {
			//nodes to traverse through the tree
			MyTreeNode<E> current = root;
			MyTreeNode<E> parent = root;
			
			//executes until no nodes left to traverse in the tree
			while (current != null) {	
				if (e.compareTo(current.element) < 0) {	//e is less than current node's element
					parent = current;
					current = current.left;		//starts traversing left subtree
				} else if (e.compareTo(current.element) > 0) {	//e is greater than current node's element
					parent = current;
					current = current.right;	//starts traversing right subtree
				} else	//node found in tree
					break;
			}
			
			//checks if current is leftmost node
			if (current.left == null) { //case 1
				//checks if current is root of the bst
				if (current == root) {
					root = current.right;
				} else {
					//checks if parent node is less than current node
					if (e.compareTo(parent.element) < 0 ) {
						parent.left = current.right;
					}else {
						parent.right = current.right;
					}
				}
			} //end of case 1
			else { //case 2
				//nodes to traverse through the list
				MyTreeNode<E> parentOfRightMost = current;
				MyTreeNode<E> rightMost = current.left;
				
				//executes until rightmost node of list reached
				while(rightMost.right != null) {
					parentOfRightMost = rightMost;
					rightMost =rightMost.right;
				}
				
				current.element = rightMost.element;
				
				//checks if rightmost node is the same as the left node of current
				if(rightMost.equals(current.left)) {
					parentOfRightMost.left = rightMost.left;
				} else {
					parentOfRightMost.right = rightMost.left;
				}
			} //end of case 2
			size--;	//since node is deleted from tree
		}
		else {
			System.out.println("Element "+e+" not found in list!");
		}
	}
	
}

class MyTreeNode<E> {
	
	//data members
	E element;				//to store value
	MyTreeNode<E> left;		//left node
	MyTreeNode<E> right;	//right node
	
	//constructor to initialize element
	MyTreeNode(E e) {
		this.element = e;
	}
	
}
