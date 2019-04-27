import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static int numJobs;
	
	
	public static void main(String[] args) throws IOException {
		
		//Getting input file of the jobs from the run arguments
		Scanner in = new Scanner(new FileReader(args[0]));
		
		//Storing number of jobs
		numJobs = Integer.parseInt(in.next());

		
		
		//Creating the jobs array
		Job[] jobs = new Job[numJobs];
		
		//Instantiating The Jobs
		for(int i = 0; i < numJobs; i++) {
			int t, d, p;
			t = Integer.parseInt(in.next());
			d = Integer.parseInt(in.next());
			p = Integer.parseInt(in.next());
			jobs[i] = new Job(t,d,p);
		}
		in.close();
		
		//Number of Permutations
		int numConfigs = Utility.factorial(numJobs);
		
		//This will be used for storing the permutations.
		ArrayList<JobConfiguration> theConfigs = new ArrayList<JobConfiguration>();
		
		//Generating the Permutations
		Job[] startingPoint = new Job[jobs.length];
		for(int i = 0; i < jobs.length; i++) {
			startingPoint[i] = jobs[i];
		}
		Utility.Permute(startingPoint, theConfigs);
		
		JobConfiguration theLeast = new JobConfiguration();
		theLeast.totalPenalty = 9999;
		for(JobConfiguration e : theConfigs) {
			int comparison = e.compareTo(theLeast);
			if(comparison == 1) {
				theLeast = e;
			}
		}
		
		PrintWriter outFile = new PrintWriter(new FileWriter(args[1]));
		outFile.print(theLeast.toString());
		outFile.close();
		
	}
}
