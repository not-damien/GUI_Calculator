package NumbersAndMath;
public class Hexadecimal extends AbstractNumber {
    /**
     * Constructs A Hexadecimal object represented by the string passed
     * @param myHex a string of 0-9 or A-f representing a hex value
     */
    public Hexadecimal(String myHex) {myData = myHex;}

    public Hexadecimal(long theNum) {
        myData = Integer.toHexString( (int) theNum).toUpperCase() ;//make this cleaner
    }


    /**
     *
     * @return the value held within the object as a long
     */
    @Override
    public long longValue() {
        long res = 0;
        if (!myData.equals("0")) {
            char[] c = myData.toLowerCase().toCharArray();
            for (int i = c.length - 1; i >= 0; i--) {
                //single out chars that represent ints
                if ((c[i] <= 57) && c[i] >= 48) res +=
                        (((int) c[i] - 48) *  Math.pow(16, c.length - (i + 1)));// works
                else res += (((int) c[i] - 87) * Math.pow(16, c.length - (i + 1)));
            }
        }
        return res;
    }




//static methods
    public static long hexToLong(String theNum){
        return new Hexadecimal(theNum).longValue();
    }
    public static String addHex(String one, String two ){//make this more elegant maybe with static hexConvert
        return new Hexadecimal(hexToLong(one)+hexToLong(two)).toString();
    }
    public static String minusHex(String first, String second) {
        return new Hexadecimal(hexToLong(first) - hexToLong(second)).toString();
    }

    public static String divideHex(String first, String second) {
        return new Hexadecimal(hexToLong(first) / hexToLong(second)).toString();
    }

    public static String multiplyHex(String first, String second) {
        return new Hexadecimal(hexToLong(first) * hexToLong(second)).toString();
    }

    @Override
    public String toString() {
        return myData;
    }
}