package stack;
import java.util.EmptyStackException;
public class stackImplement implements Stack
{	
 java.util.Stack<Integer> Instack = new java.util.Stack<Integer>();
private int i;
private int n = 0;	

public void setup (int i)
{
 this.i = i;	
}

public  void push( int p)
{
	try
	{
		if(n<i)
		{
		Instack.push(p);
		System.out.println("Stack after pushing "+p+" --> "+Instack);
		n++;
		}
		else
		{
			System.out.println("Stack Overflow..");
			System.out.println("Stack can hold only "+i+" elements");
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

public int pop()
{
	try
	{
		int y= Instack.peek();
		System.out.println("Stack --> "+Instack);
		int x = Instack.pop();
		System.out.println("Stack after pop of "+y+" --> "+Instack);
		n--;
		return x;
		}
		catch (EmptyStackException e)
		{
			System.out.println("---Stack is empty---");
			System.out.println("No more elements to POP");;
		}
		return 0;
}

public int size()
{
	int size = Instack.size();
	return size;
}

public int top()
{
	System.out.println("Stack --> "+Instack);
	try
	{
	int peek = Instack.peek();
	return peek;
	}
	catch(EmptyStackException e)
	{
		System.out.println("Stack is empty... No elements are present");
	}
	return 0;
}
	
public void search (int a)
{
	int b =Instack.search(a);
	if(b==-1)
	{
		System.out.println("Element not found in stack");
		
	}
	else
	{
		System.out.println("Stack --> "+Instack);
		System.out.println("Element found.. It is in Stack position:"+b);
	}
}
	
public void displayStack()
{
	System.out.println("Stack --> "+Instack);
}
public void clearStack()
{
	Instack.clear();
	System.out.println("Stack is cleared");
	System.out.println("Stack -->"+Instack);
}
}
