//this class tests the bst with elements of the type Integer and String

public class TestMyBST {

	public static void main(String[] args) {
		
//		//testing the bst methods with Integer elements
//		MyBST<Integer> bst1 = new MyBST<Integer>();	//creating binary search tree
//		//inserting elements
//		bst1.insert(60);
//		bst1.insert(55);
//		bst1.insert(100);
//		bst1.insert(45);
//		bst1.insert(57);
//		bst1.insert(67);
//		bst1.insert(107);
//		bst1.insert(101);
//		bst1.insert(59);
//		//testing methods 
//		System.out.println(bst1.insert(107));
//		System.out.println(bst1.search(107));
//		System.out.println(bst1.search(108));
//		bst1.print();	//printing bst
//		
//		System.out.println();
//		
//		//testing the bst methods with String elements
//		MyBST<String> bst2 = new MyBST<String>();	//creating binary search tree
//		//inserting elements
//		bst2.insert("C");
//		bst2.insert("F");
//		bst2.insert("B");
//		bst2.insert("D");
//		bst2.insert("A");
//		bst2.insert("I");
//		bst2.insert("E");
//		bst2.insert("G");
//		bst2.insert("H");
//		//testing methods
//		System.out.println(bst2.insert("E"));
//		System.out.println(bst2.search("E"));
//		System.out.println(bst2.search("L"));
//		bst2.print();	//printing bst
		
		//testing the bst methods with Integer elements
		MyBST<Integer> bst3 = new MyBST<Integer>();	//creating binary search tree
		//inserting elements
		bst3.insert(20);
		bst3.insert(10);
		bst3.insert(40);
		bst3.insert(16);
		bst3.insert(30);
		bst3.insert(80);
		bst3.insert(14);
		bst3.insert(27);
		bst3.insert(50);
		//testing methods
		bst3.delete(20); //case 2
		bst3.delete(16); //case 2
		bst3.delete(14); //case 2
		bst3.delete(10); //case 1
		bst3.print();	//printing bst
		
		System.out.println();
		
		//testing the bst methods with String elements
		MyBST<String> bst4 = new MyBST<String>();	//creating binary search tree
		//inserting elements
		bst4.insert("20");
		bst4.insert("10");
		bst4.insert("40");
		bst4.insert("16");
		bst4.insert("30");
		bst4.insert("80");
		bst4.insert("14");
		bst4.insert("27");
		bst4.insert("50");
		//testing methods
		bst4.delete("20"); //case 2
		bst4.delete("16"); //case 2
		bst4.delete("14"); //case 2
		bst4.delete("10"); //case 1
		bst4.print();	//printing bst	
	}
}
