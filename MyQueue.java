
public class MyQueue<T> {
	private T [] data;
	private int count, front, tail, maxSize;

	public MyQueue(int maxSize){
		this.count = this.front = this.tail = 0;
		this.maxSize = maxSize;
		data = (T[])(new Object[maxSize]);	
	}

	public boolean push(T val){//O(1)
		boolean ans = true;
		if (count < maxSize){
			data[tail] = val;
			tail = (tail+1) % maxSize;
			count++;
		}
		else{
			ans = false;
			System.out.println("the queue is full");
		}
		return ans;
	}
	
	public T poll(){//O(1)
		T ans = null;
		if (count > 0){
			ans = data[front];
			front = (front + 1) % maxSize;
			count--;
		}
		else{
			System.out.println("the queue is empty");
		}
		return ans;
	}
	
	public int size(){return count;}//O(1)

	public boolean isEmpty(){return count == 0;}//O(1)

	public String toString(){//O(n)
		String ans = "the queue: [";
		for (int i = 0; i < count; i++){
			int index = (i + front) % maxSize;
			ans = ans + data[index] + ", ";
		}
		ans+="]";
		return ans;
	}
	
	public boolean contains(T val){//O(n)
		boolean ans = false;
		for (int i = 0; !ans && i < count; i++){
			int index = (i + front) % maxSize;
			if (data[index].equals(val)) ans = true;
		}
		return ans;
	}

	public T element(int index){
		if (index >= 0 && index < count) return data[(index+front)%maxSize];
		else{
				return null;
		}
	}

	public static void main(String[] args) {
		int max = 3;
		MyQueue<Integer> q = new MyQueue<Integer>(max);
		q.push(10);
		q.push(20);
		q.push(30);
		q.push(33);
		System.out.println(q);
		System.out.println(q.poll());
		q.push(40);
		System.out.println(q.toString());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}
}