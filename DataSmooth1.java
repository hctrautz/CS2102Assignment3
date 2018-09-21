import java.util.LinkedList;

class DataSmooth1 {
	DataSmooth1(){}
//consumes a list of shows and produces a smoothed list of the shows' average runtimes
	public LinkedList<Double> dataSmooth(LinkedList<Show> shows) {
		LinkedList<Double> smoothed = new LinkedList<Double> ();
		LinkedList<Double> avgtimes = new LinkedList<Double> ();

		//adds up the runtimes of the all the episodes of all the shows, and then divides the sum of all the runtimes
		//by the amount of episodes there are, then adding that value to a list 
		for (Show s : shows) {
			double avgRuntime = 0;
			for (Episode e : s.episodes) {
				avgRuntime = avgRuntime + e.runTime;
			}
			
			avgRuntime = avgRuntime/s.episodes.size();
			avgtimes.add(avgRuntime);
		}
		//takes the list of all the average run times and adds the smoothed data to another list
		for(int i = 0; i < avgtimes.size(); i++) {
			if (i== 0 || i == avgtimes.size()-1) {
				smoothed.add(avgtimes.get(i));
			} else {
				smoothed.add( (avgtimes.get(i-1) + avgtimes.get(i) + avgtimes.get(i+1))/3 );    
			}	
		}
		
		return smoothed;
		
	}
}
//summing the runtimes of each episode in a show
//finding the average run time of a show by dividing the sum of all the runtimes by the number of episodes, and then adding the result to a new list
//looping through and doing the above steps with every show in the list
//smoothing the list of average run times by adding the current number, the previous number, and the next number and dividing the sum by 3
//adding the smoothed value to a new list
//if the average runtime is either first or last in the list, the number cannot be smoothed and is just added to the list of smoothed values 
