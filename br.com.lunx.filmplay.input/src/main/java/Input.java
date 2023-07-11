import java.util.Scanner;

public class Input {

    Scanner input = new Scanner(System.in);

    public String getString(){

        return input.nextLine();

    }

    public int getInt(){

        return input.nextInt();

    }
}
