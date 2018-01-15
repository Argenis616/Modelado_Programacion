import java.io.UnsupportedEncodingException;
/**
 * Sb = {{sa1, sa2,...san}, {sb1, sb2,..., sbn}, ..., {sq1, sq2, ..., sqn}}
 * Ss = {{sa1, sb1, ..., sq1}, {sa2, sb2,..., sq2},... {san, sbn, ..., sqn}}
 */
public class StringShare {
    private Share[][] byteShares;
    private int numShares;

    public StringShare(String secret, int threshold, int numShares) throws UnsupportedEncodingException {
        this.numShares = numShares;
        byte[] bytes = secret.getBytes("US-ASCII");
        byteShares = new Share[bytes.length][2];
        for (int i = 0; i < bytes.length; i++) {
            ByteShare temp = new ByteShare(bytes[i], threshold, numShares);
            byteShares[i] = temp.CreateShares();
        }
    }

    public Point[] getShares() {
        Point[] stringShares = new Point[numShares];
        String concatY;
        for (int i = 0; i < byteShares[0].length; i++) {
            concatY = "";
            for (int j = 0; j < byteShares.length; j++) {
                concatY += (byteShares[j][i].gety().toString() + " ");
            }
            stringShares[i] = new Point(byteShares[0][i].getx().byteValueExact() + "", concatY);
        }
        return stringShares;
    }

    public int getPrime() {
        return ByteShare.PRIME.intValueExact();
    }

}
