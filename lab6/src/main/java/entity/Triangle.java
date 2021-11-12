package entity;

public class Triangle {

    public boolean isTriangleExists(Integer firstSide, Integer secondSide, Integer thirdSide) throws ArithmeticException {
        if (firstSide > 0 && secondSide > 0 && thirdSide > 0) {
            if ((firstSide + secondSide > thirdSide) && (firstSide + thirdSide > secondSide)
                    && (secondSide + thirdSide > firstSide)) return true;
        } else { throw new ArithmeticException("Side cant be negative or zero"); }

        return false;
        }
    }

