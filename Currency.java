
public abstract class Currency {
	private int currNoteVal; //currency's note value
	private int currCoinVal; // currency's coin value
	
	/**
	 * Constructor that intializes private fields currNoteVal and currCoinVal to 0.
	 */
	public Currency()
	{
		currNoteVal = 0;
		currCoinVal = 0;
		
	}
	
	/**
	 * Constructor that intializes private fields currNoteVal and currCoinVal using a given double.
	 * @precondition any value that is not two decimal points will be shortened to two decimal points.
	 * @postcondition
	 * @param val, a double that is used to represent a money value, and to be split into notes and coins.
	 */
	public Currency(double val )
	{
		currNoteVal = (int) val;
		double value = Math.round(100*(val - currNoteVal));
		currCoinVal = (int)value;
	}
	
	/**
	 * Constructor that intializes private fields currNoteVal and currCoinVal copying another object currency.
	 * @precondition copy must be of type currency that is being initalized.
	 * @postcondition
	 * @param copy, the currency object to be copied.
	 * @throws Exception is thrown when inputed currency is not same type as object invoked on.
	 */
	public Currency (Currency copy) throws Exception
	{
		if((copy.getClass()!= this.getClass()))
		{
			throw new Exception("can only use copy constructor when objects are same type");
		}
		this.currNoteVal = copy.currNoteVal;
		this.currCoinVal = copy.currCoinVal;
	}
	
	/**
	 * This is a getter method that returns the value of private feild currNoteVal
	 * @precondition
	 * @postcondition
	 * @return an int that is the value of currNoteVal
	 */
	public int getCurrNoteVal()
	{
		return currNoteVal;
	}
	
	/**
	 * This is a getter method that returns the value of private field currCoinVal
	 * @precondition
	 * @postcondition
	 * @return an int that is the value of currCoinVal
	 */
	public int getCurrCoinVal()
	{
		return currCoinVal;
	}
	
	/**
	 * This is a setter method that sets the currNoteVal to some inputed value
	 * @precondition cannot enter a negative note value for noteVal
	 * @postcondition
	 * @param noteVal the int value to be used to set currNoteVal
	 * @throws Exception when a user inputs a negative note value for noteVal
	 */
	public void setCurrNoteVal(int noteVal) throws Exception
	{
		if(noteVal<0)
		{
			throw new Exception("coinNote must greater than 0");
		}
		currNoteVal = noteVal;
	}
	
	/**
	 * This is a setter method that sets the currCoinVal to some inputed value
	 * @precondition cannot enter a negative coin value for coinVal
	 * @postcondition any coin value above 100, makes appropriate changes to currNoteVal and currCoinVal
	 * @param coinVal, the int value to be used to set currCoinVal
	 * @throws Exception when a user inputs a negative coin value for coinVal
	 */
	public void setCurrCoinVal(int coinVal) throws Exception
	{
		if(coinVal<0)
		{
			throw new Exception("coinVal must greater than 0");
		}
		
		currCoinVal = coinVal;
		while(currCoinVal>=100)
		{
			currNoteVal ++;
			currCoinVal -=100;
		}
	}
	
	/**
	 * Adds two currency objects of same type, changing the value of the object which this method is invoked on
	 * @precondition both objects must be of same type
	 * @postcondition whenever coin value is greater than 100, currNoteVal and currCoinVal are adjusted
	 * @param val a currency type to be added to object which method is invoked on
	 * @throws Exception is thrown when the the object this method is invoked on is not the same as parameter object.
	 */
	public void add(Currency val) throws Exception
	{
		if((val.getClass()!= this.getClass()))
		{
			throw new Exception("Invalid Addition");
		}
		this.currNoteVal += val.currNoteVal;
		this.currCoinVal += val.currCoinVal;
		if(this.currCoinVal>= 100)
		{
			this.currNoteVal ++;
			this.currCoinVal -=100;
		}
	}
	
	/**
	 * Subtracts two currency objects of same type, changing the value of the object which this method is invoked on
	 * @precondition val must be less than object on which method is invoked on
	 * @postcondition whenever coin value is less than 0, currNoteVal and currCoinVal are adjusted
	 * @param val a currency type to be subtracted from object which method is invoked on
	 * @throws Exception is thrown when the the object this method is invoked on is not the same as parameter object.
	 * 			and when val is greater than object on which method is invoked on.
	 */
	public void subtract(Currency val) throws Exception
	{
			if((val.getClass()!= this.getClass())|| val.isGreater(this))
			{
				throw new Exception("Invalid Subtraction");
			}
			this.currNoteVal -= val.currNoteVal;
			this.currCoinVal -= val.currCoinVal;
			if(this.currCoinVal< 0)
			{
				this.currNoteVal --;
				this.currCoinVal += 100;
			}
	}
	
	/**
	 * Checks to see if currency on which this method is invoked on is equal to inputed value
	 * @precondition val must be same object as object which method is invoked on
	 * @postcondition
	 * @param val the inputed value to be compared with
	 * @return boolean, true if invoked object is equal, false otherwise
	 * @throws Exception when the object being compared is not the same time as object on which method is
	 * 			invoked on.
	 */
	public boolean isEqual(Currency val) throws Exception
	{
		if((val.getClass()!= this.getClass()))
		{
			throw new Exception("can only compare with the same type object on which isEqual is invoked");
		}
		if((val.currCoinVal == this.currCoinVal) && (val.currNoteVal == this.currNoteVal))
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * Checks to see if currency on which this method is invoked on is greater than inputed value
	 * @precondition val must be same object as object which method is invoked on
	 * @postcondition
	 * @param val the inputed value to be compared with
	 * @return boolean, true if invoked object is greater, false otherwise
	 * @throws Exception when the object being compared is not the same time as object on which method is
	 * 			invoked on.
	 */
	public boolean isGreater(Currency val) throws Exception
	{
		if((val.getClass()!= this.getClass()))
		{
			throw new Exception("can only compare with the same type object on which isGreater is invoked");
		}
		if(this.currNoteVal> val.currNoteVal)
		{
			return true;
		}
		else if(this.currNoteVal == val.currNoteVal && this.currCoinVal> val.currCoinVal)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * An abstract toString method to be overidden in child class. This will
	 * be implemented to print out a string containing value and type of currency.
	 */
	public abstract String toString();
	
	
	
}
