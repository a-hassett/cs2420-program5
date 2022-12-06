public class Task implements Comparable<Task> {
    public int ID;
    public int start;
    public int deadline;
    public int duration;

    public Task() {
        this.ID = 0;
        this.start = 0;
        this.deadline = 0;
        this.duration = 0;
    }

    public Task(int ID, int start, int deadline, int duration) {
        this.ID = ID;
        this.start = start;
        this.deadline = deadline;
        this.duration = duration;
    }

    public String toString() {
        return "Task " + ID;
    }

    public String toStringL() {
        return "Task " + ID + "[" + start + "-" + deadline + "] " + duration;
    }

    /**
     * Parent class to compare tasks and will be overridden later
     * @param t2 the task to be compared to self/this
     * @return an integer <0 if self/this is smaller
     * the integer 0 if self/this is equal to t2
     * an integer >0 if self/this is larger
     */
    public int compareTo(Task t2) {
        System.out.println("NO compareTo");
        return 0;
    }
}
