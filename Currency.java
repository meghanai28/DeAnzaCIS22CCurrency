
public abstract class Currency {
	private int currNoteVal;
	private int currCoinVal;
	
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
	
	public int getCurrNoteVal()
	{
		return currNoteVal;
	}
	
	public int getCurrCoinVal()
	{
		return currCoinVal;
	}
	
	public void setCurrNoteVal(int noteVal)
	{
		currNoteVal = noteVal;
	}
	
	public void getCurrNoteVal(int coinVal)
	{
		currCoinVal = coinVal;
	}
	
	/**
	 * Not finished
	 * @param val
	 */
	public void add(Currency val)
	{
		
	}
	
	/**
	 * not finsiehd
	 * @param val
	 */
	public void subtract(Currency val)
	{
		
	}
	
	/**
	 * Not finished
	 * @param val
	 * @return
	 */
	public boolean isEqual(Currency val)
	{
		return true;
	}
	
	/**
	 * Not finished
	 * @param val
	 * @return
	 */
	public boolean isGreater(Currency val)
	{
		return true;
	}
	
	public abstract String toString();
	
	
	
}
