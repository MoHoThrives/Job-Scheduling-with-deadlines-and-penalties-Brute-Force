
public class Job {
	public static int idCounter = 0;
	public int time;
	public int deadline;
	public int penalty;
	public int jobID;
	
	Job(int t, int d, int p) {
		time = t;
		deadline = d;
		penalty = p;
		idCounter++;
		jobID = idCounter;
	}
	
}
