package NumbersAndMath;

/**
 * The type Binary.
 */
public class Binary extends AbstractNumber {
    /**
     * Instantiates a new Binary.
     *
     * @param theBin a String representation of a Binary value i.e "0101"
     */
    public Binary(String theBin){
        myData = theBin;
    }

    /**
     *
     * @return the value of the object in long form
     */
    @Override
    public long longValue() {
        long res = 0;
        for (int i = 1; i <= myData.length(); i++) {
            int c = myData.charAt(i - 1) - 48;
            res += c * Math.pow(2, myData.length() - i);
        }
        return res;
    }
}
