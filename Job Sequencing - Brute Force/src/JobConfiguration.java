

public class JobConfiguration implements Comparable<JobConfiguration> {
	public Job[] orderOfJobs;
	int totalPenalty = 0;
	
	JobConfiguration(){
		
	}
	
	JobConfiguration(Job[] o) {
		orderOfJobs = o;
		computePenalty();
	}
	
	int computePenalty() {
		int time = 0;
		for(Job j : orderOfJobs) {
			time += j.time;
			if(j.deadline < time) {
				totalPenalty += j.penalty;
			}
		}
		return totalPenalty;
		
	}

	@Override
	public int compareTo(JobConfiguration o) {
		// TODO Auto-generated method stub
		if(this.totalPenalty > o.totalPenalty) {
			return -1;
		}
			return 1;
	}
	
	public String toString() {
		String result = "Job ordering: ";
		for(Job j: orderOfJobs) {
			result += j.jobID;
		}
		result += "\nPenalty:" + totalPenalty;
		return result;
	}
}
