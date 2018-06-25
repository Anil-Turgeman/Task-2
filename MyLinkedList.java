
@SuppressWarnings("hiding")
public class MyLinkedList<Integer> {
	Node head;
	int size;
	
	public MyLinkedList(){
		size = 0;
		head = null;
	}
	
	public MyLinkedList(MyLinkedList<Integer> other){
		Node n = other.head;
		while (n != null){
			this.add(n.data);
			n = n.next;
		}
	}
	
	public void add(int val){
		if (head == null){
			head = new Node(val, null);
			size++;
		}
		else{
			Node n = head;
			while (n.next != null) n = n.next;
			n.next = new Node(val, null);
			size++;
		}
	}
	
	public Integer remove(Integer val){
		Integer ans = null;
		if (head != null){
			if (head.data == val){
				head = head.next;
				size--;
				ans = val;
			}
			else{
				Node n = head;
				Node prev = head;
				while (n != null && !(n.data == val)){
					prev = n;
					n = n.next;
				}
				if (n != null){
					prev.next = n.next;
					ans = val;
					size--;
				}
			}
		}
		return ans;
	}
	
	public String toString(){
		String ans = "";
		if (head == null){
			ans = "[]";
		}
		else{
			Node n = head;
			while (n != null){
				ans = ans + n.data + ", ";
				n = n.next;
			}
		}
		return ans;
	}
	
	public int size(){return size;}
	
	public boolean isEmpty(){return head==null;}
	
	public void clean(){
		head = null;
		size = 0;
	}
	
	
	
	
}