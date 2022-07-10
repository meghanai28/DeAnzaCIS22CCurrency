/**
 * 
 * @author 
 *
 */
public abstract class Currency {
	private int currNoteVal; //currency's note value
	private int currCoinVal; // currency's coin value
	
	public Currency()
	{
		currNoteVal = 0;
		currCoinVal = 0;
		
	}
	
	public Currency(double val )
	{
		currNoteVal = (int) val;
		currCoinVal = (int)(100*(val - currNoteVal));
	}
	
	public Currency (Currency copy)
	{
		this.currNoteVal = copy.currNoteVal;
		this.currCoinVal = copy.currCoinVal;
	}
	
	/**
	 * returns the currency's note value
	 * @return an int that is the currency's note value
	 */
	public int getCurrNoteVal()
	{
		return currNoteVal;
	}
	
	/**
	 * returns the currency's coin value
	 * @return an int that is the currency's coin value
	 */
	public int getCurrCoinVal()
	{
		return currCoinVal;
	}
	
	/**
	 * Sets the currency's note value to a given int
	 * @param noteVal
	 */
	public void setCurrNoteVal(int noteVal)
	{
		currNoteVal = noteVal;
	}
	
	/**
	 * Sets the currency's coin value to a given int
	 * @param coinVal
	 * @throws Exception 
	 */
	public void setCurrCoinVal(int coinVal) throws Exception
	{
		if(coinVal>=100 || coinVal<0)
		{
			throw new Exception("coinVal must be less than 100 and greater than 0");
		}
		currCoinVal = coinVal;
	}
	
	/**
	 * Adds two of the same currency together
	 * @param val the currency value to be added to the current currency
	 */
	public void add(Currency val)
	{
		this.currNoteVal += val.currNoteVal;
		this.currCoinVal += val.currCoinVal;
		if(this.currCoinVal>= 100)
		{
			this.currNoteVal ++;
			this.currCoinVal -=100;
		}
	}
	
	/**
	 * Subtracts two of the same currency from each other
	 * Does not accept subtraction that results in negative values
	 * @param val the currency value to be subtracted from the current currency
	 */
	public void subtract(Currency val) throws Exception
	{
			if(val.isGreater(this))
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
	 * Sees if two currency's are equal to each other
	 * @param val the value to be compared
	 * @return a boolean that is true when the two currencies are equal, false otherwise
	 */
	public boolean isEqual(Currency val)
	{
		if((val.currCoinVal == this.currCoinVal) && (val.currNoteVal == this.currNoteVal))
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * Sees if a currency is greater than the other.
	 * @param val the value to be compared
	 * @return a boolean that is true when the current currency is greater than val
	 */
	public boolean isGreater(Currency val)
	{
		if(this.currNoteVal> val.currNoteVal)
		{
			return true;
		}
		else if(this.currCoinVal> val.currCoinVal)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public abstract String toString();
	
	
	
}
