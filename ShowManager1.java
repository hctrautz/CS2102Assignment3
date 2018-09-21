import java.util.LinkedList;

class ShowManager1 {
	
	ShowManager1() {}
//consumes a list of shows and produces a ShowSummary (a report) which contains a list of primetime and daytime shows
//from the original list
	public ShowSummary organizeShows(LinkedList<Show> shows){
			ShowSummary report = new ShowSummary ();
			
			for(Show s : shows) {
				if(s.broadcastTime >= 600 && s.broadcastTime < 1700) {
					report.daytime.add(s);
				} else if (s.broadcastTime >= 1700 && s.broadcastTime < 2300) {
					report.primetime.add(s);
				}
			}
			return report;
		}
	}