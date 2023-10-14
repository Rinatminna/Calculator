import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws Exception {
            Scanner input = new Scanner(System.in);
            System.out.println("Input:");
            String expression = input.nextLine();
            String answer = Calcul.calc(expression);

            System.out.println("Output:\n" + answer);
        }

}

