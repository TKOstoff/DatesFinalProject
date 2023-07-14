import java.util.Scanner;

public class DatesFinalProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter which day of the week represents the 1st of January (type a number form 1 to 7): ");
        byte weekDayFirstJanuary = input.nextByte();
        if (weekDayFirstJanuary < 1 || weekDayFirstJanuary > 7) {
            System.out.println("Invalid day, enter another number: ");
        }
    }

    }
