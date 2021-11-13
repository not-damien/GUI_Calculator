package NumbersAndMath;

/**
 * Parent to all custom data types in this project.
 */
public abstract class AbstractNumber {
    protected String myData;// String representation of the value held



    /**
     *
     * @return long value of the objects data
     *
     */
    abstract long longValue();

    @Override
    public String toString() {
        return myData;
    }



    //converting static methods
    public static String binToHex(String theBin){
        return new Hexadecimal(new Binary(theBin).longValue()).toString();
    }
    public static String hexToBin(String value) {
        return String.valueOf(new Binary(new Hexadecimal(value).toString()));
    }

}
