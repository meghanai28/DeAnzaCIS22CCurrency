//JK version
public class Dollar extends Currency {
    private String nameCurr;
    
    public Dollar() {
        super();
        nameCurr = "Dollar";
    }

    public Dollar(double val) throws Exception {
        super(val);
        nameCurr = "Dollar";
    }

    public Dollar (Dollar copy) throws Exception {
        super(copy);
        nameCurr = "Dollar";
    }

    public String getName() {
        return nameCurr;
    }

    @Override
    public String toString() {
		String value = getCurrNoteVal() + "." + String.format("%02d", getCurrCoinVal()) + " " + getName();
        return value;
    }
}
