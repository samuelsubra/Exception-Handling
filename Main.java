import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Scanner s1 = new Scanner(System.in);
            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            int answer1 = numSeconds(s1.nextLine());
            System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
            int answer2 = numSeconds(s1.nextLine());
            int difference = answer2 - answer1;
            System.out.println("Difference in seconds: " + difference);
        }
        catch(InvalidTimeException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Enter a valid time");
        }
    }

    public static int numSeconds(String s) throws InvalidTimeException
    {
        int count = 0;
        String[] myTime = s.split(":");
        int hours = Integer.parseInt(myTime[0]);
        int minutes = Integer.parseInt(myTime[1]);
        int seconds = Integer.parseInt(myTime[2]);
        if (hours < 24 && hours >= 0)
        {
            count += 3600 * hours;
        }
        else
        {
            throw new InvalidTimeException("Hour must be below 24");
        }
        if (minutes < 60 && minutes >= 0)
        {
            count += 60 * minutes;
        }
        else
        {
            throw new InvalidTimeException("Minutes must be less than 60");
        }
        if (seconds < 60 && seconds >= 0)
        {
            count += seconds;
        }
        else
        {
            throw new InvalidTimeException("Seconds must be less than 60");
        }
        return count;
    }
}