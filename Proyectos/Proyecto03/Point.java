/**
 * The class point
 */
public class Point {
    private String x;
    private String y;

/**
     * The empty buldier.
     */


   
    public Point() {
        this("", "");
    }

/**
     * This is the unique builder.
     */
    
public Point(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public static Share[] toShare(Point[] points) {
        Share[] shares = new Share[points.length];
        for (int i = 0; i < points.length; i++) {
            shares[i] = new Share(points[i].getX(), points[i].getY());
        }
        return shares;
    }

/**
     * Method that returns the element <tt>x</tt>.
     * @return The element <tt>x</tt>.
     */


    public String getX() {
        return x;
    }


/**
     * Method that returns the element <tt>y</tt>.
     * @return The element <tt>y</tt>.
     */


    public String getY() {
        return y;
    }



/**
     * Method that returns a string with the representation of the polynomial.
     * @return a string with the representation of the polynomial.
     */


    public String toString() {
        return x + " " + y;
    }

    public String prettyPrint() {
        return "(" + x + ", " + y + ")";
    }
}
