package Chrono;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * A cool tool to time your code.
 *
 * @author LouisVallat
 */
public class Chrono {

    /**
     * The start time
     */
    Calendar start;

    /**
     * The end time
     */
    Calendar end;

    /**
     * The Date format
     */
    static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");

    /**
     * The instance's title
     */
    String title;

    /**
     * The difference between start and end time
     */
    long diff;

    /**
     * Start the timer with a title
     *
     * @param titre the title to set
     */
    public void start(String titre) {
        start = Calendar.getInstance();
        title = titre;
        System.out.println(title + " started at : " + format.format(new Date()));
    }

    /**
     * Start the timer without title
     */
    public void start() {
        start = Calendar.getInstance();
        System.out.println("Timer started at : " + format.format(new Date()));
    }

    /**
     * Stop the timer
     */
    public void stop() {
        end = Calendar.getInstance();
        if (title == null) {
            System.out.println("Timer ended at : " + format.format(new Date()));
        } else {
            System.out.println(title + " timer ended at : " + format.format(new Date()));
        }
        printDiff();
    }

    /**
     * Print the difference between end and start time
     */
    private void printDiff() {
        diff = end.getTimeInMillis() - start.getTimeInMillis();
        System.out.println("Completed in : " + formatMilli(diff));
    }

    /**
     * Takes milliseconds and prints it usable and readable for the user.
     *
     * @param diff the difference in milliscond
     * @return formatted text
     */
    private static String formatMilli(long diff) {
        Date date = new Date(diff);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }
}
