import java.util.ArrayList;

public class Utility {
	
	/**
	 * Takes a number and returns its factorial
	 * 
	 * @param a
	 * @return factorial of a
	 */
	public static int factorial(int a) {
		int r = 1;
		for(int i = a; i >= 1; i--) {
			r*=i;
		}
		return r;
	}
	
	
	/**
	 * 
	 * @param arr - The starting permutation to start from
	 * @param k - index value that aids in swapping different points in the permutation
	 * @param l - The Integer[] list that will store the different permutations
	 * 
	 * This was modified from a method found on Stackoverflow.
	 * Permute method just helps kick start the recursive algorithm.
	 */
	static void permute(Job[] arr, int k, ArrayList<JobConfiguration> l){
        for(int i = k; i < arr.length; i++){
            swap(arr, i, k);
            permute(arr, k+1, l);
            swap(arr, k, i);
        }
        if (k == arr.length -1){
            l.add(new JobConfiguration(arr.clone()));
        }
    }
    static void Permute(Job[] a, ArrayList<JobConfiguration> l){
        permute(a, 0, l);
    }
    
    
    public static void swap(Job[] a, int i, int k) {
    	Job temp = a[i];
    	a[i] = a[k];
    	a[k] = temp;
    }
	
}
