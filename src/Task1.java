public class Task1 extends Task {
    public Task1(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }

    /**
     * Priority is deadline
     * @param t2 the task to be compared to self/this
     * @return an integer marking if self/this or t2 is due earlier
     */
    @Override
    public int compareTo(Task t2) {
        return deadline - t2.deadline;
    }
}
