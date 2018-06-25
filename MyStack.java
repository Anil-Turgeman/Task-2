
public class MyStack<T> {
	private T[] data;
	private final int INIT_SIZE = 5;
	private int place;
	
	public MyStack(){
		data = (T[])(new Object[INIT_SIZE]);
		place = 0;// index of the first free place
	}
	public MyStack(int size){
		data = (T[])(new Object[size]);
		place = 0;// index of the first free place
	}
	public boolean push(T val){//O(1)
		boolean ans = true;
		if (place == data.length){
			ans = false;
			System.out.println("stack overflow");
		}
		else{
			data[place++] = val;
		}
		return ans;
	}
	public T pop(){//O(1)
		T ans;
		if (place > 0){
			ans = data[--place];
		}
		else{
			ans = null;
			System.out.println("stack is emplty");
		}
		return ans;
	}
	public int size(){//O(1)
		return place;
	}
	public boolean isEmpty(){//O(1)
		return place == 0;
	}
	public String toString(){//O(n)
		String ans = "[";
		for (int i = 0; i < place-1; i++){
			ans = ans + data[i] + ", ";
		}
		if (place > 0) ans = ans + data[place-1] + "]";
		else ans = ans + "]";
		return ans;
	}
	public static void main(String[] args) {
		MyStack st = new MyStack();
		System.out.println("st.isEmpty()? "+st.isEmpty());
		System.out.println("size = "+st.size());
		System.out.println(st);
		st.push(2);
		st.push(7);
		st.push(-8);
		st.push(12);
		st.push(15);
		//st.push(-12);
		System.out.println("size = "+st.size());
		System.out.println("st.isEmpty()? "+st.isEmpty());
		System.out.println(st);
		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
		System.out.println("st.isEmpty()? "+st.isEmpty());
		System.out.println(st);
	}
	
	

}
