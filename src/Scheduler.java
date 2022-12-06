import java.util.ArrayList;

public class Scheduler {
    /**
     * Creates the leftist heap queue with the array list of tasks
     * Prints the final data
     * @param title priority type and file name
     * @param tasks all tasks from a certain file
     */
    public void makeSchedule(String title, ArrayList<Task> tasks){
        // build priority queue using task list
        LeftistPriorityQueue<Task> priorityQueue = new LeftistPriorityQueue<>();
        for (Task task : tasks) {
            priorityQueue.insert(task);
        }
        System.out.println(runTasks(priorityQueue, title));
    }

    /**
     * Builds the informational string that will be printed later
     * @param queue all the tasks that still have to run
     * @param title priority type and file name
     * @return informational string
     */
    private StringBuilder runTasks(LeftistPriorityQueue<Task> queue, String title){
        StringBuilder schedule = new StringBuilder();
        schedule.append(title + "\n");

        int time = 0;
        int totalLateness = 0;
        int lateTaskCount = 0;

        while(!queue.isEmpty()){
            Task currentTask = queue.dequeue();

            time += 1;
            currentTask.duration -= 1;
            schedule.append("Time: " + time);
            schedule.append("  Task " + currentTask.ID);

            int currentLateness = time - currentTask.deadline;
            if(currentLateness > 0 && currentTask.duration == 0){
                schedule.append("  ** Late " + currentLateness);
                totalLateness += currentLateness;
                lateTaskCount += 1;
            } else if(currentTask.duration == 0){
                schedule.append("  **");
            }
            schedule.append("\n");

            if(currentTask.duration != 0){
                queue.insert(currentTask);
            }
        }

        schedule.append("Tasks late: " + lateTaskCount);
        schedule.append("  Total late: " + totalLateness + "\n");

        return schedule;
    }
}
