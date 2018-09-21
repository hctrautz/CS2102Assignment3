import java.util.LinkedList;

class DataSmooth2 {
  DataSmooth2(){}
//consumes a list of shows and produces a smoothed list of the shows' average runtimes
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) {
	  LinkedList<Double> smoothed = new LinkedList<Double> ();

		//adds up the runtimes of the all the episodes of all the shows, and then divides the sum of all the runtimes
		//by the amount of episodes there are, then setting the average length of the show to the avgRuntime
		for (Show s : shows) {
			double avgRuntime = 0;
			for (Episode e : s.episodes) {
				avgRuntime = avgRuntime + e.runTime;
			}
			
			avgRuntime = avgRuntime/s.episodes.size();
			s.setAvgLength(avgRuntime);
		}
		//takes the list of all the average run times and adds the smoothed data to another list
		for (int i = 0; i < shows.size(); i++) {
			if (i== 0 || i == shows.size()-1) {
				smoothed.add(shows.get(i).avgLength);
			} else {
				smoothed.add((shows.get(i-1).avgLength + shows.get(i).avgLength + shows.get(i+1).avgLength)/3);    
			}	
		}
		
		return smoothed;
  }
}
//summing the runtimes of each episode in a show
//finding the average run time of a show by dividing the sum of all the runtimes by the number of episodes, and then setting the show's average length field to the result
//looping through and doing the above steps with every show in the list
//smoothing the average run times by adding the current show's avgLength, the previous show's avgLength, and the next show's avgLength and dividing the sum by 3
//adding the smoothed value to a new list
//if the show is either first or last in the list, the show's avgLength cannot be smoothed and it's avgLength value is simply added to the list of smoothed values 
