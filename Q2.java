import java.util.Stack;

public class Q2{
	public static double Calculate(String st){
        char[] equation = st.toCharArray();
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> symbols = new Stack<Character>();

        for (int i = 0; i < equation.length; i++){
            if (equation[i] >= '0' && equation[i] <= '9'){
                StringBuffer str = new StringBuffer();
                
                while (i < equation.length && equation[i] >= '0' && equation[i] <= '9')
                    str.append(equation[i++]);
                values.push(Integer.parseInt(str.toString()));
                i--;
            }
 
            else if (equation[i] == '(')
                symbols.push(equation[i]);
 
            else if (equation[i] == ')'){
                while (symbols.peek() != '(')
                  values.push(solver(symbols.pop(), values.pop(), values.pop()));
                symbols.pop();
            }
 
            else if (equation[i] == '+' || equation[i] == '-' ||
                     equation[i] == '*' || equation[i] == '/'){

                while (!symbols.empty() && Precedence(equation[i], symbols.peek()))
                  values.push(solver(symbols.pop(), values.pop(), values.pop()));
 
                symbols.push(equation[i]);
            }
        }
        int val = 0;
        while (!symbols.empty()){
        	if(!values.isEmpty())

        	values.push(solver(symbols.pop(), values.pop(), values.pop()));
        	val = values.peek();
        }

        return val;
    }
 
    public static boolean Precedence(char op1, char op2){
        if (op1 == '(' || op2 == '(' )
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    public static int solver(char symbols, int b, int a){
        switch (symbols){
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
            	System.out.println("Cannot divide by zero");
            else
            return a / b;
        }
        return 0;
    }

    public static void main(String[] args){
    	String st = "5*(6+2)-12/4";
        System.out.println(Calculate(st));
    }
}