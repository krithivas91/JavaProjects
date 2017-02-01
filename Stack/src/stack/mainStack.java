package stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainStack {
	public static void main (String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Stack Size:");
		int s = Integer.parseInt(br.readLine());
		stackImplement stImp = new stackImplement();
		stImp.setup(s);
		boolean status = true;
		while(status)
		{
		System.out.println("\nSTACK OPERATIONS\nEnter the option \n 1.push \n 2.pop \n 3.size \n 4.top \n 5.Search \n 6.Clear  \n 7.Display\n 8.Exit");
		try {
			int a = Integer.parseInt(br.readLine());
			switch (a) {
			case 1:
				System.out.println("Enter the number to push:");
				int p= Integer.parseInt(br.readLine());
				stImp.push(p);
				break;	
			case 2:
				int z= stImp.pop();
				System.out.println("popped element --> " +z);
				break;
			case 3:
				int sz = stImp.size();
				System.out.println("Current size of the stack--> "+sz);
				break;
			case 4:
				int top = stImp.top();
				System.out.println("Top element of the stack --> "+top);
				break;
			case 5:
				System.out.println("Enter the element you want to search: ");
				int search = Integer.parseInt(br.readLine());
				stImp.search(search);
				break;
			case 6:
				stImp.clearStack();;
				break;	
			case 7:
				stImp.displayStack();
				break;	
			case 8:
				System.out.println("Exiting bye....");
				status =false;
				break;
				
			}
			
		}
		catch (NumberFormatException | IOException e) 
		{
			
			System.out.println("Enter valid option");
		}
		}
	}
}