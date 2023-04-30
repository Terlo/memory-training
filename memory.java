import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class memory {
    public static void main(String[] args) {
        
        
        int N = 4; // length of random string
        int M = 5; // number of seconds to display random string
        int K = 3; // number of attempts
        
        Random random = new Random();
        String randomString = generateRandomString(N, random);
        System.out.println("Remember this string for " + M + " seconds: " + randomString);
        
        try {
            Thread.sleep(M * 1000);
            clear();
            System.out.println("Enter the string that was just displayed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toString();
        System.out.println("your input was :\n"+input+"\nthe actual value was\n"+randomString);
        
        if(input.equals(randomString)){
            System.out.println("correct!");
        }   

      
        scanner.close();
    }
    

    //generates the number to be memorised.
    private static String generateRandomString(int length, Random random) {
        StringBuilder sb = new StringBuilder();
        String characters = "0123456789";
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
    //clears the screen after a set time has elapsed.
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
