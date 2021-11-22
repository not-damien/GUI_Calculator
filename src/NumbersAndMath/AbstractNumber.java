package NumbersAndMath;

/**
 * Parent to all custom data types in this project.
 */
public abstract class AbstractNumber {
    /**
     * Holds a String representation of the number
     */
    protected String myData;// String representation of the value held


    /**.
     *for use to get the value repressed by the number in long form
     * @return long value of the objects data
     */
    abstract long longValue();

    @Override
    public String toString() {
        return myData;
    }


    /**
     * Bin to hex string.

     * @param theBin A string representation of the Binary value
     * @return A hex representation of the given binary value
     */
//converting static methods
    public static String binToHex(String theBin){
        return new Hexadecimal(new Binary(theBin).longValue()).toString();
    }

    /**
     * Hex to bin string.
     *
     * @param value a string representation of the hex value
     * @return the value of the given hex value represented in a binary string
     */
    public static String hexToBin(String value) {
        return String.valueOf(new Binary(new Hexadecimal(value).toString()));
    }

}
