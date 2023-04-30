import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class memory {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int N = 4; // length of random string
        int M = 5; // number of seconds to display random string
        int K = 3; // number of attempts
        
        int correctCount = 0; // number of correct attempts
        Random random = new Random();
        String randomString = generateRandomString(N, random);
        System.out.println("Remember this string for " + M + " seconds: " + randomString);
        
        try {
            Thread.sleep(M * 1000);
            clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < K; i++) {
            System.out.print("Enter the remembered string: ");
            String input = scanner.nextLine();
            
            if (input.equals(randomString)) {
                correctCount++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect.");
            }
        }
        
        System.out.println("You got " + correctCount + " out of " + K + " correct.");

        scanner.close();
    }
    
    private static String generateRandomString(int length, Random random) {
        StringBuilder sb = new StringBuilder();
        String characters = "0123456789";
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    private static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            // handle exception
        }
    }
}
