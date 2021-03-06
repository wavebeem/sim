import java.util.*;
import java.io.*;

public class Loader {
    public void load(String filename) {
        try {
            java.io.File file = new java.io.File(filename);
            parse(new Scanner(file));
        }
        catch (FileNotFoundException e) {
            Debug.printf("Looks like that file didn't exist: %s\n", filename);
        }
    }

    public void parse(Scanner in) {
        while (in.hasNextLine()) {
            String line = in.nextLine();

            if (line.charAt(0) == '#')
                continue; // skip comments

            String[] words = line.split("\\s+");

            String cmd  = words[0];
            String disk = words[1];
            String time = words[2];
            String file = words[3];

            int diskno = new Integer(disk);

            long   mylong = timeStringToLong(time);
            String mytime = timeLongToString(mylong);

            if (cmd.equals("save")) {
                String text = words[4];
                Event.add(new SaveEvent(mylong, file, text));
            }

            Debug.printf(
                "time=%s disk=%01d cmd=%-6s text=%s\n",
                //"time=%s\nTIME=%s\n",
                mytime, diskno, cmd, file
            );
        }
    }

    public static long timeStringToLong(String timeStr) {
        String[] timeChunks = timeStr.split(":");

        int hours = new Integer(timeChunks[0]);
        int mins  = new Integer(timeChunks[1]);
        int secs  = new Integer(timeChunks[2]);
        int msecs = new Integer(timeChunks[3]);

        long time = 0;
        time += hours; time *=  60;
        time += mins;  time *=  60;
        time += secs;  time *=  60;
        time += msecs;

        return time;
    }

    public static String timeLongToString(long time) {
        long hours;
        long mins;
        long secs;
        long msecs;

        hours = time / (60 * 60 * 60);
        time  = time % (60 * 60 * 60);
        mins  = time / (     60 * 60);
        time  = time % (     60 * 60);
        secs  = time / (          60);
        time  = time % (          60);
        msecs = time;

        return String.format("%02d:%02d:%02d:%03d", hours, mins, secs, msecs);
    }

    public static void main(String... args) {
        new Loader().load("test.txt");
    }
}
