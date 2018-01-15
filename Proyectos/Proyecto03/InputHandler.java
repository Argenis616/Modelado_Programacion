import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.*;

//This class is the menu.

public class InputHandler {
    public int prime;
    private List<String> arguments;
    private Map<String, Runnable> func;
    private Scanner console;
    private Point[] shares;
    private String secret;

    public InputHandler(String[] arguments) {
        this.arguments = new ArrayList<>(Arrays.asList(arguments));
        func = new HashMap<>();
        func.put("c", this::shareWrapper);
        func.put("d", this::combine);
        console = new Scanner(System.in);
    }

    // Takes a list of list of shares to reconstructs the secret.
    private void combine() {
        List<List<Integer>> shareList = new ArrayList<>();
        int prime;
        try {
            prime = Integer.parseInt(arguments.get(2));
            console = new Scanner(new File(arguments.get(1)));
        } catch (NumberFormatException e) {
            System.out.println("Error.  Invalid syntax for 'd'");
            return;
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        getListOfShares(console, shareList);
        List<Point[]> points = createPoints(shareList);
        byte[] bytes = new byte[points.size()];
        for (int i = 0; i < points.size(); i++) {
            bytes[i] = SecretFind.combine(Point.toShare(points.get(i)), BigInteger.valueOf(prime));
        }
        try {
            this.secret = new String(bytes, "US-ASCII");
            System.out.println(secret);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // Returns a reconstructed secret after 'combine' has been called.
    public String getSecret() {
        return secret;
    }

    // Helper method which constructs points out of a list representation of the points values.
    private List<Point[]> createPoints(List<List<Integer>> shareList) {
        List<Point[]> points = new LinkedList<>();
        Point[] row;
        for (int i = 1; i < shareList.get(0).size(); i++) {
            row = new Point[shareList.size()];
            for (int j = 0; j < shareList.size(); j++) {
                row[j] = new Point(shareList.get(j).get(0) + "", shareList.get(j).get(i) + "");
            }
            points.add(row);
        }
        return points;
    }

    // Helper method which marshals the text from the file into a list
    private void getListOfShares(Scanner console, List<List<Integer>> shareList){
        Scanner lineScan;
        List<Integer> row;
        while (console.hasNextLine()) {
            row = new ArrayList<>();
            String line = console.nextLine();
            lineScan = new Scanner(line);
            while (lineScan.hasNextInt()) {
                row.add(lineScan.nextInt());
            }
            shareList.add(row);
        }
    }

    // Abstraction of 'share'
    private void shareWrapper() {
        try {
            share();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // Takes a secret and creates Shares, printing them to stdout
    private void share() throws UnsupportedEncodingException {
        String secret = readToString(arguments.get(1));
        if (secret == null) {
            System.out.println("Please enter a direction valid");
        }
        int threshold, numShares;
        try {
            threshold = Integer.parseInt(arguments.get(2));
            numShares = Integer.parseInt(arguments.get(3));
        }
        catch (NumberFormatException e) {
            System.out.println("Error.  Invalid syntax for 'create'");
            return;
        }
        StringShare stringShare = new StringShare(secret, threshold, numShares);
        this.prime = stringShare.getPrime();
        shares = stringShare.getShares();

        //for (Point p : shares) {
        //    System.out.println(p);
        FileWriter fichero = null;
        PrintWriter pw = null;
          try {
            fichero = new FileWriter("polynomial.txt");
            pw = new PrintWriter(fichero);
              for (Point p : shares){
                pw.println(p);
                pw.println("Prime: " + prime);
              }
              
            } catch (Exception e) {
              e.printStackTrace();
            } finally {
              try {
                // We have to use finally 
                // because we need to close the file
                if (null != fichero)
                fichero.close();
                } catch (Exception e2) {
                  e2.printStackTrace();
                }
              }
        //}
        //System.out.println("Prime: " + prime);
    }

    // Helper function which reads the input file containing a secret into a single string
    private String readToString(String path) {
        String fileContents;
        try {
            fileContents = new Scanner(new File(path)).useDelimiter("\\Z").next();
            return fileContents;
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
            return null;
        }
    }

    // Entry point of the program
    public void driver() {
        Runnable cmd;
        String commandPrefix;
        if (arguments.size() <= 1) {
           System.out.println("I'm sorry incorrectly syntaxis");
        } else {
            commandPrefix = arguments.get(0);
            cmd = func.get(commandPrefix);
            if (cmd != null) {
                cmd.run();
            } else {
                System.out.println("Error.  Command " + commandPrefix + " is not valid");
            }
        }
    }


    public Point[] getShares() {
        return shares;
    }

}
