//JK version
public abstract class Currency {

    private int currNoteVal; // whole part
    private int currCoinVal; // fractional part

    // Default Constructor
    public Currency() {
        currNoteVal = 0;
        currCoinVal = 0;
    }

    // Constructor
    public Currency(double val) throws Exception {
        if (val < 0) {
            throw new Exception ("value must not be negative");
        }
        currNoteVal = (int)val;
        currCoinVal = (int)((val - (double)currNoteVal) * 100);
    }

    // Copy Constructor
    public Currency (Currency copy) throws Exception {

        if (copy.getClass() != this.getClass()) {
            throw new Exception("can only use copy constructor when objects are of the same type");
        }
        currNoteVal = copy.currNoteVal;
        currCoinVal = copy.currCoinVal;
    }



    // Setters
    public void setCurrNoteVal (int noteVal) throws Exception {

        if (noteVal < 0) {
            throw new Exception("note value must be greater than 0");
        }
        currNoteVal = noteVal;
    }

    public void setCurrCoinVal (int coinVal) throws Exception {

        if (coinVal < 0) {
            throw new Exception("coin value must be greater than 0");
        }
        currCoinVal = coinVal;
        while (currCoinVal >= 100) {
            currNoteVal++;
            currCoinVal -= 100;
        }
    }

    // Getters
    public int getCurrNoteVal() {
        return currNoteVal;
    }

    public int getCurrCoinVal() {
        return currCoinVal;
    }

    public void add(Currency val) throws Exception {
        if (val.getClass() != this.getClass()) {
            throw new Exception ("addition is not possible");
        }

        this.currNoteVal += val.currNoteVal;
        this.currCoinVal += val.currCoinVal;
        
        if (this.currCoinVal>= 100) {
			this.currNoteVal ++;
			this.currCoinVal -=100;
		}
    }

    public void subtract(Currency val) throws Exception {
        if (val.getClass() != this.getClass() || val.isGreater(this)) {
            throw new Exception("subtraction is not possible");
        }
        this.currNoteVal -= val.currNoteVal;
        this.currCoinVal -= val.currCoinVal;
        if (this.currCoinVal < 0) {
            this.currNoteVal--;
            this.currCoinVal += 100;
        }
    }

    public boolean isEqual(Currency val) throws Exception {
        if (val.getClass() != this.getClass()) {
            throw new Exception("cannot compare two objects of different type");
        }
        if (val.currNoteVal == this.currNoteVal && val.currCoinVal == this.currCoinVal) {
            return true;
        }
        return false;
    }

    public boolean isGreater(Currency val) throws Exception {
        if (val.getClass() != this.getClass()) {
            throw new Exception("cannot compare two objects of different type");
        }
        if (this.currNoteVal > val.currNoteVal) {
            return true;
        }
        else if (this.currNoteVal == val.currNoteVal && this.currCoinVal > val.currCoinVal) {
            return true;
        }
        return false;
    }

    public abstract String toString();
}




