public class Task3 extends Task {
    public Task3(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }

    /**
     * Priority is time allowed
     * @param t2 the task to be compared to self/this
     * @return an integer marking if self/this or t2 has less time to finish
     */
    @Override
    public int compareTo(Task t2) {
        int leeway1 = deadline - start;
        int leeway2 = t2.deadline - t2.start;
        if(leeway1 - leeway2 == 0){
            return deadline - t2.deadline;
        }
        return leeway1 - leeway2;
    }
}
