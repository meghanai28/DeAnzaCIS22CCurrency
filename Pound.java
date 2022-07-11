public class Pound extends Currency {
    private String nameCurr;

    public Pound() {
        super();
        nameCurr = "Pound";
    }

    public Pound(double val) throws Exception {
        super(val);
        nameCurr = "Pound";
    }

    public Pound(Pound copy) throws Exception {
        super(copy);
        nameCurr = "Pound";
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