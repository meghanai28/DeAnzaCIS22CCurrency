
public class Dollar extends Currency {
	private String name;
	
	public Dollar ()
	{
		super();
		name = "Dollar";
	}
	
	public Dollar (double val)
	{
		super(val);
		name = "Dollar";
	}
	
	public Dollar (Dollar copy)
	{
		super(copy);
		name = "Dollar";
	}
	
	public String getName()
	{
		return name;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String value = getCurrNoteVal() + "." + getCurrCoinVal() + " " + getName();
		return value;
	}
	
	
}
