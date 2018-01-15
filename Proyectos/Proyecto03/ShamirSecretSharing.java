import java.util.Scanner;

/**
 * Main entry point of program.
 */
public class ShamirSecretSharing {
    public static void main(String[] args) {
		System.out.println("press c to encrypt and d to decipher");
        Scanner console = new Scanner(System.in);
        InputHandler handler = new InputHandler(args);
        handler.driver();
        System.out.println("press c to encrypt and d to decipher");
    }
}
