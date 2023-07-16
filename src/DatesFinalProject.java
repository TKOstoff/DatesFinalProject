import java.util.Scanner;

public class DatesFinalProject {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Задайте на кой ден от семицата отговаря 1-ви Януари за съответната година (напишете число от 1 до 7): ");
        byte firstDayOfTheWeek = input.nextByte();
            while (firstDayOfTheWeek < 1 || firstDayOfTheWeek > 7) {
                System.out.print("Невалиден ден, въведете ново число от 1 до 7: ");
                firstDayOfTheWeek = input.nextByte();
            }
            generateCalendar(firstDayOfTheWeek);
        System.out.println();
        input.nextLine();
        System.out.print("Въведете дата (dd/MM/yyyy): " );
        String date = input.nextLine();
        System.out.println(date);
        System.out.print("Изберете формат (1 - dd/MM/yyyy, 2 - MM/dd/yyyy, 3 - dd-MMM-yyyy): ");
        int formatChoice = input.nextInt();
        printDate(date, formatChoice);
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
    public static void printDate(String date, int formatChoice){
        String formattedDate = formatDate(date, formatChoice);
        System.out.println("Форматираната дата: " + formattedDate);
    }
    public static String formatDate(String date, int formatChoice) {
        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        String formattedDate;

        switch (formatChoice) {
            case 1:
                formattedDate = String.format("%02d/%02d/%04d", day, month, year);
                break;
            case 2:
                formattedDate = String.format("%02d/%02d/%04d", month, day, year);
                break;
            case 3:
                String[] monthNames = {
                        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                formattedDate = String.format("%02d-%s-%04d", day, monthNames[month - 1], year);
                break;
            default:
                formattedDate = date;
        }

        return formattedDate;
    }
}

