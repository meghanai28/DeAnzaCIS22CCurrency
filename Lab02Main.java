import java.util.Scanner;
public class Lab02Main {
	
	public static void main(String [] args) throws Exception
	{
		
		Currency[] primCurr = {new Dollar(), new Pound()};
		Scanner readIn = new Scanner(System.in);
		System.out.println("Welcome to Assignment two:");
		System.out.println("You will have to enter 2 characters, one double, and one string seperated by spaces below");
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
			
			char operation = strArr[0].toLowerCase().charAt(0);
			char currType = strArr[1].toLowerCase().charAt(0);
			double value = Double.parseDouble(strArr[2]);
			char currOper = strArr[3].toLowerCase().charAt(0);
			
			switch(operation)
			{
				case 'a':
				{	
					Currency val = null;
					
					if(currOper == 'd')
					{
						val = new Dollar(value);
					}
					else if(currOper == 'p')
					{
						val = new Pound(value);
					}
					else
					{
						System.out.println("Incorrect input for program.");
						continue;
					}
						if(currType== 'd')
						{
							try
							{
								primCurr[0].add(val);
							}
							catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
						}
						else if(currType== 'p')
						{
							try
							{
								primCurr[1].add(val);
							}
							catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
						}
						else
						{
							System.out.println("Incorrect input for program.");
							continue;
						}	
					
					break;
				}
				case 's':
				{
					Currency val = null;
					
					if(currOper == 'd')
					{
						val = new Dollar(value);
					}
					else if(currOper == 'p')
					{
						val = new Pound(value);
					}
					else
					{
						System.out.println("Incorrect input for program.");
						continue;
					}
						if(currType== 'd')
						{
								try
								{
									primCurr[0].subtract(val);
								}
								catch(Exception e)
								{
									System.out.println(e.getMessage());
								}
			
						}
						else if(currType == 'p')
						{
							try
							{
								primCurr[1].subtract(val);
							}
							catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
						}
						else
						{
							System.out.println("Incorrect input for program.");
							continue;
						}
						break;
				}
				default:
				{
					System.out.println("Incorrect input for program.");
					continue;
				}
			}
				
			
			System.out.println(primCurr[0].toString());
			System.out.println(primCurr[1].toString());
	
		}
		while(true);
		
		
	}
}
