package NumbersAndMath;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigNumberMath {
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

    public static BigDecimal LCM(BigDecimal first, BigDecimal second, int precision){
        return (first.multiply(second).abs()).divide(second,precision, RoundingMode.HALF_DOWN);
    }
}
