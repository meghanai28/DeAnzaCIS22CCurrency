


public abstract class Currency {

    private int currNoteVal; // whole part
    private int currCoinVal; // fractional part

    /**
	 * Constructor that intializes private fields currNoteVal and currCoinVal to 0.
	 * @precondition
	 * @postcondition private fields initalized
	 */
    public Currency() {
        currNoteVal = 0;
        currCoinVal = 0;
    }

    /**
	 * Constructor that intializes private fields currNoteVal and currCoinVal using a given double.
	 * @precondition any value that is not two decimal points will be shortened to two decimal points, no negative values allwed for val.
	 * @postcondition private fields initalized
	 * @param val, a double that is used to represent a money value, and to be split into notes and coins.
	 * @throws exception when value inputed is less than 0.
	 */
    public Currency(double val) throws Exception {
        if (val < 0) {
            throw new Exception ("value must not be negative");
        }
        currNoteVal = (int)val;
        double round = Math.round(((val - (double)currNoteVal) * 100));
        currCoinVal = (int)round;
    }

    /**
	 * Constructor that intializes private fields currNoteVal and currCoinVal copying another object currency.
	 * @precondition copy must be of type currency that is being initalized.
	 * @postcondition private fields initalized
	 * @param copy, the currency object to be copied.
	 * @throws Exception is thrown when inputed currency is not same type as object invoked on.
	 */
    public Currency (Currency copy) throws Exception {

        if (copy.getClass() != this.getClass()) {
            throw new Exception("can only use copy constructor when objects are of the same type");
        }
        currNoteVal = copy.currNoteVal;
        currCoinVal = copy.currCoinVal;
    }



   /**
	 * This is a setter method that sets the currNoteVal to some inputed value
	 * @precondition cannot enter a negative note value for noteVal
	 * @postcondition sets currNoteVal to given value
	 * @param noteVal the int value to be used to set currNoteVal
	 * @throws Exception when a user inputs a negative note value for noteVal
	 */
    public void setCurrNoteVal (int noteVal) throws Exception {

        if (noteVal < 0) {
            throw new Exception("note value must be greater than 0");
        }
        currNoteVal = noteVal;
    }

	/**
	 * This is a setter method that sets the currCoinVal to some inputed value
	 * @precondition cannot enter a negative coin value for coinVal
	 * @postcondition any coin value above 100, makes appropriate changes to currNoteVal and currCoinVal. sets currCoinVal to given val.
	 * @param coinVal, the int value to be used to set currCoinVal
	 * @throws Exception when a user inputs a negative coin value for coinVal
	 */
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

    /**
	 * This is a getter method that returns the value of private feild currNoteVal
	 * @precondition
	 * @postcondition
	 * @return an int that is the value of currNoteVal
	 */
    public int getCurrNoteVal() {
        return currNoteVal;
    }

	/**
	 * This is a getter method that returns the value of private field currCoinVal
	 * @precondition
	 * @postcondition
	 * @return an int that is the value of currCoinVal
	 */
    public int getCurrCoinVal() {
        return currCoinVal;
    }
    
    /**
	 * Adds two currency objects of same type, changing the value of the object which this method is invoked on
	 * @precondition both objects must be of same type
	 * @postcondition whenever coin value is greater than 100, currNoteVal and currCoinVal are adjusted. the value of the object which this method is invoked on changes.
	 * @param val a currency type to be added to object which method is invoked on
	 * @throws Exception is thrown when the the object this method is invoked on is not the same as parameter object.
	 */
    public void add(Currency val) throws Exception {
        if (val.getClass() != this.getClass()) {
            throw new Exception ("Invalid Addition");
        }

        this.currNoteVal += val.currNoteVal;
        this.currCoinVal += val.currCoinVal;
        
        if (this.currCoinVal>= 100) {
			this.currNoteVal ++;
			this.currCoinVal -=100;
		}
    }
    
    
	/**
	 * Subtracts two currency objects of same type, changing the value of the object which this method is invoked on
	 * @precondition val must be less than object on which method is invoked on
	 * @postcondition whenever coin value is less than 0, currNoteVal and currCoinVal are adjusted. the value of the object which this method is invoked on changes.
	 * @param val a currency type to be subtracted from object which method is invoked on
	 * @throws Exception is thrown when the the object this method is invoked on is not the same as parameter object.
	 * 			and when val is greater than object on which method is invoked on.
	 */
    public void subtract(Currency val) throws Exception {
        if (val.getClass() != this.getClass() || val.isGreater(this)) {
            throw new Exception("Invalid Subtraction");
        }
        this.currNoteVal -= val.currNoteVal;
        this.currCoinVal -= val.currCoinVal;
        if (this.currCoinVal < 0) {
            this.currNoteVal--;
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
    public boolean isEqual(Currency val) throws Exception {
        if (val.getClass() != this.getClass()) {
            throw new Exception("cannot compare two objects of different type");
        }
        if (val.currNoteVal == this.currNoteVal && val.currCoinVal == this.currCoinVal) {
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
    
    
    /**
	 * An abstract toString method to be overidden in child class. This will
	 * be implemented to print out a string containing value and type of currency.
	 */
    public abstract String toString();
}
