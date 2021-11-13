package NumbersAndMath;


public class BigInteger extends AbstractNumber {
    boolean[] myBIts = new boolean[128];
    public BigInteger(String value){
        myData = value;
    }

    @Override
    long longValue() {
        return 0;
    }
}
