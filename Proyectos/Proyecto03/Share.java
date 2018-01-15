import java.math.BigInteger;

public class Share {
    private BigInteger xVal;
    private BigInteger yVal;

    public Share(int xVal, int yVal) {
        this.xVal = BigInteger.valueOf(xVal);
        this.yVal = BigInteger.valueOf(yVal);
    }

    public Share(String xVal, String yVal) {
        this.xVal = new BigInteger(xVal);
        this.yVal = new BigInteger(yVal);

    }

    public Share(BigInteger xVal, BigInteger yVal) {
        this.xVal = xVal;
        this.yVal = yVal;
    }

    public Share(int xVal, BigInteger yVal) {
        this.xVal = BigInteger.valueOf(xVal);
        this.yVal = yVal;
    }

    public BigInteger getx() {
        return xVal;
    }

    public BigInteger gety() {
        return yVal;
    }

    public String toString() {
        return("(" + xVal.toString() + ", " + yVal.toString() + ")");
    }
}
