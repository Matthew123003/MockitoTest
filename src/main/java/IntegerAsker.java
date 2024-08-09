import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IntegerAsker {

    private final Scanner scanner;
    private final PrintStream out;

    public IntegerAsker(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public int ask(String message) {
        out.println(message);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        getBoundIntegerFromUser(new main.IntegerAsker(System.in, System.out));
    }

    public static int getBoundIntegerFromUser(main.IntegerAsker asker) {
        int input = asker.ask("Give a number between 1 and 10");
        while (input < 1 || input > 10)
            input = asker.ask("Wrong number, try again.");
        return input;
    }
}
