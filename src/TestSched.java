import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestSched {
    /**
     * Read task files into array lists of task objects
     * @param filename where the information comes from
     * @param task1 priority: deadline
     * @param task2 priority: start time
     * @param task3 priority: time allowed
     */
    public static void readTasks(String filename, ArrayList<Task> task1, ArrayList<Task> task2, ArrayList<Task> task3){
        // Create lists where base type is different
        try {
            Scanner reader = new Scanner(new File(filename));

            // (start time, deadline, duration) on each line in files
            int ID = 0;
            while (reader.hasNext()) {
                ID += 1;
                int start = Integer.parseInt(reader.next());
                int deadline = Integer.parseInt(reader.next());
                int duration = Integer.parseInt(reader.next());

                task1.add(new Task1(ID, start, deadline, duration));
                task2.add(new Task2(ID, start, deadline, duration));
                task3.add(new Task3(ID, start, deadline, duration));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String args[]) {
        Scheduler s = new Scheduler();
        String [] files = {"taskset1.txt", "taskset2.txt", "taskset3.txt", "taskset4.txt", "taskset5.txt" };

        // for each file, make 3 kinds of task lists
        for (String f : files) {
            ArrayList<Task> t1 = new ArrayList();    // elements are Task1
            ArrayList<Task> t2 = new ArrayList();    // elements are Task2
            ArrayList<Task> t3 = new ArrayList();    // elements are Task3
            readTasks(f, t1, t2, t3);

            s.makeSchedule("Deadline Priority ( " + f + " )", t1);
            s.makeSchedule("Starttime Priority ( " + f + " )", t2);
            s.makeSchedule("Wild and Crazy Priority ( " + f + " )", t3);
        }
    }
}