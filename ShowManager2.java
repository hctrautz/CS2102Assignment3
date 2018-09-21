import java.util.LinkedList;

class ShowManager2 {
	
	ShowManager2() {}
//consumes a list of shows and produces a ShowSummary (a report) which contains a list of primetime and daytime shows
//from the original list
	public ShowSummary organizeShows(LinkedList <Show> shows){
		LinkedList <Show> daytime = new LinkedList <Show> ();
		LinkedList <Show> prime = new LinkedList <Show> ();
		LinkedList <Show> both = new LinkedList <Show> ();
		
		for (Show s : shows) {
			if(s.broadcastTime >= 600 && s.broadcastTime < 1700) {
				both.add(s);
			} else if (s.broadcastTime >= 1700 && s.broadcastTime < 2300) {
				both.add(s);
			}
		}
		
		for (Show s : both) {
			if(s.broadcastTime >= 600 && s.broadcastTime < 1700) {
				 daytime.add(s);
			} else if (s.broadcastTime >= 1700 && s.broadcastTime < 2300) {
				 prime.add(s);
			}
		}
		
		ShowSummary report = new ShowSummary (daytime, prime);
		return report;
	}
}
