public class Pound extends Currency{
	private String name;
	
	public Pound ()
	{
		super();
		name = "Pound";
	}
	
	public Pound (double val)
	{
		super(val);
		name = "Pound";
	}
	
	public Pound (Pound copy) throws Exception 
	{
		super(copy);
		name = "Pound";
		
	}
	
	public String getName()
	{
		return name;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String value = getCurrNoteVal() + "." + String.format("%02d", getCurrCoinVal()) + " " + getName();
		return value;
	}
	
	

}
