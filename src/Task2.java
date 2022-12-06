public class Task2 extends Task {
    public Task2(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }

    /**
     * Priority is start time
     * @param t2 the task to be compared to self/this
     * @return an integer marking if self/this or t2 starts sooner
     */
    @Override
    public int compareTo(Task t2) {
        if(start - t2.start == 0){
            return deadline - t2.deadline;
        }
        return start - t2.start;
    }
}
