import java.util.Scanner;

public class FinanceRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a region in the world: ");
        String region = s.nextLine();
        System.out.print("What language would you like: ");
        String language = s.nextLine();
        System.out.print("What symbol would you like to look at?: ");
        String symbol = s.nextLine();

        FinanceAPI api = new FinanceAPI();
        api.quotes(region, language, symbol);
    }

}
