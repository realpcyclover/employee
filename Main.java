
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static int checkInt(int Min, int Max) {
        int Ret = 0;
        String input = "";
        do {
            try {
                input = sc.nextLine();
                Ret = Integer.parseInt(input);
                if (Ret >= Min && Ret <= Max) {
                    break;
                }
                System.out.println("Out of range, please enter in range: "+"(" + + Min + " -> " + Max + ")");
            } catch (Exception e) {
                if (input.matches("\\-?\\d*")) {
                    System.out.println("Out of range of integer number.");
                }
                System.err.println("Invalid number input, please enter an integer number only.");
            }
        } while (true);
        return Ret;
    }

    static void displaymenu() {
        System.out.println("=========Main menu==========");
        System.out.println("     1. Add employees");
        System.out.println("     2. Update employees");
        System.out.println("     3. Remove employees");
        System.out.println("     4. Search employees");
        System.out.println("     5. Sort employees by salary ");
        System.out.println("     6. Exit");
    }

    static Manager manager = new Manager();

    public static void main(String[] args) {
        int choice = 0;
        manager.userAdd();
        do {
            displaymenu();
            System.out.print("Your choice <1 -> 6>: ");
            choice = checkInt(1, 6);
            switch (choice) {
                case 1:
                    manager.add();
                    break;
                case 2:
                    manager.update();
                    break;
                case 3:
                    manager.remove();
                    break;
                case 4:
                    manager.searchName();
                    break;
                case 5:
                    manager.sortBySalary();
                    break;
                case 6:
                    return;

            }
        } while (choice > 0 && choice < 7);

    }

}
