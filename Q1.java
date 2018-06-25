public class Q1 {
	public static void ReverseN(MyLinkedList<Integer> L, int k){//O(n+k)
		MyStack<Node> stack = new MyStack<Node>(k);
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		Node n = L.head;
		boolean flag = false;
		for (int i = 1; i <= L.size; i++) {//O(n)
			stack.push(n);
			n = n.next;
			if ((i%k) == 0) {//(1)
				while (stack.isEmpty() == flag) {//O(k)
					list.add(stack.pop().data);
				}
			}
		}
		L.head = list.head;
	}

	public static void RotateN(MyLinkedList<Integer> L, int n){//O(2n)
		MyQueue<Node> temp1 = new MyQueue<Node>(n);
		MyQueue<Node> temp2 = new MyQueue<Node>(n);
		MyLinkedList<Integer> Mylist = new MyLinkedList<Integer>();
		Node x = L.head;
		for (int i = 0; i < L.size; i++) {//O(n)
			if (i < n){//O(1)
				temp1.push(x);
			}
			if(i >= (L.size-n)){//O(1)
				temp2.push(x);
			}
			x = x.next;
			}
		x = L.head;
		for (int i = 0; i < L.size; i++) {//O(n)
			if (i < n)//O(1)
				Mylist.add(temp2.poll().data);
			else if(i >= (L.size-n))//O(1) 
				Mylist.add(temp1.poll().data);
			else//O(1) 
				Mylist.add(x.data);
			x = x.next;
		}
		L.head = Mylist.head;
			}
		
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.add(3);
		list.add(10);
		list.add(5);
		list.add(3);
		list.add(8);
		list.add(9);
		list.add(0);
		list.add(11);
		list.add(20);
		MyLinkedList<Integer> list2 = new MyLinkedList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(9);
		list2.add(10);
		ReverseN(list, 3);
		System.out.println("first part:");
		System.out.println(list);
		RotateN(list2, 1);
		System.out.println("second part:");
		System.out.println(list2);
	}
}
