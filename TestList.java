//import java.io.IOException;
////class contains main method to test MyArrayList<E> and MyLinkedList<E> with both String and Integer type
//public class TestList {
//
//	public static void main(String[] args) throws IOException {
//		MyLinkedList<String> list1=new MyLinkedList<>();
//		list1.addFirst("a");
//		list1.addFirst("b");
//		list1.print();
//		list1.removeFirst();
//		list1.print();
//		list1.addLast("c");
//		list1.addLast("d");
//		list1.print();
//		list1.remove("c");
//		list1.print();
//		list1.removeLast();
//		list1.print();
//		list1.print();
//		System.out.println();
//		
//		MyLinkedList<Integer> list2=new MyLinkedList<>();
//		list2.addFirst(1);
//		list2.addFirst(2);
//		list2.print();
//		list2.removeFirst();
//		list2.print();
//		list2.addLast(3);
//		list2.addLast(4);
//		list2.print();
//		list2.remove(3);
//		list2.print();
//		list2.removeLast();
//		list2.print();
//		list2.print();
//		System.out.println();
//		
//		MyArrayList<String> list3=new MyArrayList<>();
//		System.out.println(list3.getSize());
//		list3.print();
//		list3.addFirst("a");
//		list3.addFirst("b");
//		list3.print();
//		list3.add("c",list3.getSize());
//		list3.print();
//		list3.add("d",0);
//		list3.print();
//		list3.add("a",2);
//		list3.addFirst("a");
//		list3.print();
//		list3.removeDuplication();
//		list3.print();
//		String s3=(String) list3.getElement(0);
//		System.out.println(s3.equals("d"));
//		System.out.println();
//		
//		MyArrayList<Integer> list4=new MyArrayList<>();
//		System.out.println(list4.getSize());
//		list4.print();
//		list4.addFirst(1);
//		list4.addFirst(2);
//		list4.print();
//		list4.add(3,list4.getSize());
//		list4.print();
//		list4.add(4,0);
//		list4.print();
//		list4.add(1,2);
//		list4.addFirst(1);
//		list4.print();
//		list4.removeDuplication();
//		list4.print();
//		Integer s4=(Integer) list4.getElement(0);
//		System.out.println(s4.equals(4));
//		System.out.println();
//		
////		//MyStackOfArrayList stack= new MyStackOfArrayList();
////		MyStackOfLinkedList<String> stack= new MyStackOfLinkedList<>();
////		System.out.println(stack.isEmpty());
////		stack.print();
////		stack.push("a");
////		stack.push("b");
////		stack.push("c");
////		stack.print();
////		System.out.println(stack.search("b"));
////		System.out.println(stack.peek());
////		stack.pop();
////		stack.print();
////		stack.pop();
////		stack.print();
////		stack.pop();
////		stack.print();
////		
////		MyQueue<String> queue=new MyQueue<>();
////		System.out.println(queue.isEmpty());
////		queue.print();
////		queue.enqueue("a");
////		queue.enqueue("b");
////		queue.enqueue("c");
////		queue.print();
////		queue.dequeue();
////		queue.print();
////		queue.dequeue();
////		queue.print();
////		queue.dequeue();
//	}
//}
