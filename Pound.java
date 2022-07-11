public class Pound extends Currency{
	private String name; // name of currency
	
	/**
	 * Constructor that intializes fields by calling super constructor and giving name a value.
	 * @precondition 
	 * @postcondition intializes private fields
	 */
	public Pound ()
	{
		super();
		name = "Pound";
	}
	
	/**
	 * Constructor that intializes fields by calling super constructor.
	 * @precondition any value that is not two decimal points will be shortened to two decimal points, no negative values allwed for val.
	 * @postcondition intializes private fields
	 * @param val a double that is used to represent a pound value, and to be split into notes and coins.
	 * @throws Exception when value is a negative number
	 */
	public Pound (double val) throws Exception
	{
		super(val);
		name = "Pound";
	}
	
	/**
	 * Constructor that intializes private fields copying another object pound.
	 * @precondition copy must be of type pound that is being initalized.
	 * @postcondition private fields initalized
	 * @param pound, the currency object to be copied.
	 * @throws Exception is thrown when inputed pound is not same type as object invoked on.
	 */
	public Pound (Pound copy) throws Exception 
	{
		super(copy);
		name = "Pound";
		
	}
	
	/**
	 * A getter method to get the value of the private field name
	 * @precondition
	 * @postcondition
	 * @return returns String name
	 */
	public String getName()
	{
		return name;
	}
	
	
	/**
	 * An overidden method, that formats dollar value into a string with common currency notation.
	 * @precondition
	 * @postcondition
	 * @return a string formatted using the value of the pound object
	 */
	public String toString() {
		// TODO Auto-generated method stub
		String value = getCurrNoteVal() + "." + String.format("%02d", getCurrCoinVal()) + " " + getName();
		return value;
	}
	
	

}
