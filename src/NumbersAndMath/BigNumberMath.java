package NumbersAndMath;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * The type Big number math.
 */
public class BigNumberMath {
    /**
     * takes in two BigDecimals and returns a BigDecimal containing the value of the Greatest common factor
     *
     * @param first  the first BigDecimal
     * @param second the second BigDecimal
     * @return a BigDecimal with the value of the Greatest common denominator of the given values
     */
    public static BigDecimal GCD(BigDecimal first, BigDecimal second){
        int firstScale = first.scale();
        int secondScale = second.scale();
        BigInteger unscaledOne = first.unscaledValue();
        BigInteger unscaledTwo = second.unscaledValue();
        if(firstScale == secondScale){
            return new BigDecimal(unscaledOne.gcd(unscaledTwo), firstScale);
        }else if(firstScale > secondScale){
            unscaledTwo = unscaledTwo.multiply(new BigInteger(String.valueOf((int)Math.pow(10, firstScale))));
            return new BigDecimal(unscaledOne.gcd(unscaledTwo), firstScale);
        }else if(firstScale < secondScale){
            unscaledOne = unscaledOne.multiply(new BigInteger(String.valueOf((int)Math.pow(10, secondScale))));
            return new BigDecimal(unscaledOne.gcd(unscaledTwo), secondScale);
        }
        return null;
    }

    /**
     * Lcm big decimal.
     *
     * @param first     the first value
     * @param second    the second value
     * @param precision the scale,this method involves division,this is the number of decimal places of accuracy required
     * @return a BigDecimal containing the Least common multiple of the two given The Least Common multiple
     */
    public static BigDecimal LCM(BigDecimal first, BigDecimal second, int precision){
        return (first.multiply(second).abs()).divide(second,precision, RoundingMode.HALF_DOWN);
    }
}
