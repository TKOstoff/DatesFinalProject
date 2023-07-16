import java.util.Scanner;

public class DatesFinalProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter which day of the week represents the 1st of January (type a number form 1 to 7): ");
        byte firstDayOfTheWeek = input.nextByte();
            while (firstDayOfTheWeek < 1 || firstDayOfTheWeek > 7) {
                System.out.print("Invalid day, enter another number: ");
                firstDayOfTheWeek = input.nextByte();
            }
            generateCalendar(firstDayOfTheWeek);
    }


    public static void generateCalendar(int firstDayOfTheWeek) {
        String[] daysOfWeek = {"П", "В", "С", "Ч", "П", "С", "Н"};
        String[] months = {"януари", "февруари", "март", "април", "май", "юни", "юли", "август", "септември", "октомври", "ноември", "декември"};
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int month = 0; month < 12; month++) {
            System.out.println();
            System.out.println("\n" + months[month]);
            System.out.println("___________________________");

            for (int i = 0; i < daysOfWeek.length; i++) {
                System.out.print(daysOfWeek[i] + "\t");
            }
            System.out.println();

            int firstDayOfMonth = getFirstDayOfMonth(firstDayOfTheWeek, daysInMonth, month);

            for (int i = 0; i < firstDayOfMonth; i++) {
                System.out.print("\t");
            }

            int dayOfMonth = 1;
            while (dayOfMonth <= daysInMonth[month]) {
                System.out.print(dayOfMonth + "\t");

                if ((firstDayOfMonth + dayOfMonth) % 7 == 0) {
                    System.out.println();
                }

                dayOfMonth++;
            }
        }
    }

    public static int getFirstDayOfMonth(int firstDayOfTheWeek, int[] daysInMonth, int month) {
        int totalDays = 0;
        for (int i = 0; i < month; i++) {
            totalDays += daysInMonth[i];
        }
        return (totalDays + firstDayOfTheWeek - 1) % 7;
    }

    }
