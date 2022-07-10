import java.util.Scanner;
public class Lab02Main {
	
	public static void main(String [] args) throws Exception
	{
		Dollar dollar = new Dollar();
		Pound pound = new Pound();
		Currency[] primCurr = {dollar, pound};
		Scanner readIn = new Scanner(System.in);
		System.out.println("Welcome to Assignment two:");
		System.out.println("You will have to enter 2 characters, one double, and one string seperated by lines below");
		System.out.println("Your first character should be a, s, or q. ");
		System.out.println(" a: Addition, s:Subtraction, q:Quit Program ");
		System.out.println("Your second character should be d(Dollars) or p(Pounds). ");
		System.out.println("Your double should be a valid currency amount. Any currency like: 67.8999 will be shortened to 67.89");
		System.out.println("Your string should be either 'dollar' or 'pound'");
		System.out.println("Here is an example: 'a d 0.23 dollar' ");
		
		
		do
		{
			System.out.println("\nPlease enter the input for program below: ");
			String[] strArr;
	        strArr = readIn.nextLine().split(" ");
			if(strArr[0].equalsIgnoreCase("q"))
			{
				System.out.println("program exited");
				break;
			}
			if(strArr.length!=4)
			{
				System.out.println("Invalid input");
				continue;
			}
			
			char operation = strArr[0].charAt(0);
			char currType = strArr[1].charAt(0);
			double value = Double.parseDouble(strArr[2]);
			char currOper = strArr[3].charAt(0);
			
			switch(operation)
			{
				case 'a':
				{	
					if(currType == currOper)
					{
						if(currType== 'd')
						{
							Dollar val = new Dollar(value);
							dollar.add(val);
						}
						else if(currType== 'p')
						{
							Pound val = new Pound(value);
							pound.add(val);
						}
						else
						{
							System.out.println("Invalid input for second char");
						}	
						
					}
					else
					{
						System.out.println("Invalid Addition");
					}
					break;
				}
				case 's':
				{
					if(currType == currOper)
					{
						if(currType== 'd')
						{
								try
								{
									Dollar val = new Dollar(value);
									dollar.subtract(val);
								}
								catch(Exception e)
								{
									System.out.println("Invalid Subtraction");
								}
			
						}
						else if(currType == 'p')
						{
							try
							{
								Pound val = new Pound(value);
								pound.subtract(val);
							}
							catch(Exception e)
							{
								System.out.println("Invalid Subtraction");
							}
						}
					}
					else
					{
						System.out.println("Invalid Subtraction");
					}
					break;
				}
				default:
				{
					System.out.println("Invalid input for first char");
				}
			
			}
			System.out.println(dollar.toString());
			System.out.println(pound.toString());
	
		}
		while(true);
		
		
	}
}
