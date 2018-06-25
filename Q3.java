import java.util.Stack;

public class Q3 {

	private Stack first;
	private Stack second;
	private int size;

	public Q3(){
		clear();
	}

	public boolean empty(){
		return (size == 0);
	}

	public void clear(){
		first = new Stack();
		second = new Stack();
		size = 0;
	}

	public void push(Object data){//O(1)
		second.push(data);
		size++;
	}

	public Object peek(){
		Object f;
		if(second.empty())
			return null;
		while(!second.empty()){
			first.push(second.pop());
		}
		f = first.peek();
		while(!first.empty()){
			second.push(first.pop());
		}
		return f;
	}

	public Object pop(){
		Object f;
		if(second.empty())
			return null;
		while(!second.empty()){
			first.push(second.pop());
		}
		f = first.pop();
		while(!first.empty()){
			second.push(first.pop());
		}
		return f;
	}

	public String toString(){//O(1)
		String s = " ";
		while(!second.empty()){//O(1)
			Object f = second.pop();
			s = f + "," + s;
			first.push(f);
		}
		while(!first.empty()){//O(1)
			second.push(first.pop());
		}
		s = s.substring(0, s.length()-1);
		return s;
	}

	public int getSize(){
		return size;
	}

	public static void main(String[] args) {
		Q3 queue = new Q3();
		queue.push(3);
		queue.push(13);
		queue.push(31);
		queue.push(15);

		System.out.println("empty? " + queue.empty());

		System.out.println("queue: " + queue);

	}	
}