import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class memory {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE LENGTH OF THE STRING.");
        int N = scanner.nextInt(); // length of random string
        System.out.println("ENTER THE LENGTH OF TIME TO DISPLAY THE STRING.");
        int M = scanner.nextInt(); // number of seconds to display random string
        System.out.println("ENTER THE NUMBER OF ATTEMPTS TO GUESS THE STRING.");
        int K = scanner.nextInt(); // number of attempts
        
        Random random = new Random();
        String randomString = generateRandomString(N, random);
        System.out.println("Remember this string for " + M + " seconds: " + randomString);
        
        try {
            Thread.sleep(M * 1000);
            clear();
            System.out.println("Enter the string that was just displayed.");
        } catch (InterruptedException e) {
            System.out.println("Something went wrong:(");
            e.printStackTrace();
        }
       
        Scanner scanner1 = new Scanner(System.in);
        String input = scanner1.nextLine().toString();
        
        if(input.equals(randomString)){
            System.out.println("correct!");
        }   

      
        scanner.close();
        scanner1.close();
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
