import java.util.LinkedList;

class Earthquake1 {
	Earthquake1(){}

	// checks whether a datum is a date
	boolean isDate(double anum) {
		return (int) anum > 10000000; 
	}
	// extracts the month from an 8-digit date
	int extractMonth(double dateNum) { 
		return ((int) dateNum % 10000) / 100; 
	}
//consumes a list of doubles and the number of a month, and produces a list of the max readings for each day in the entered month
	public LinkedList <MaxHzReport> dailyMaxForMonth (LinkedList<Double> data,int month) {
		LinkedList <MaxHzReport> reports = new LinkedList <MaxHzReport> ();
		MaxHzReport maxReport = null;
		
		for(int i = 0; i < data.size(); i++) {
			double first = data.get(i);
			
			if(isDate(first) && extractMonth(first) == month) {
				 maxReport = new MaxHzReport(first, 0);
			} 
			
			if(!(isDate(first)) && maxReport != null && first > maxReport.maxReading) {
				maxReport.maxReading = data.get(i);
			}
			
			if (maxReport != null && (i == data.size()-1 || isDate(data.get(i+1)))) {
				reports.add(maxReport);
				maxReport = null;
			}
			
	}
	return reports;	
}
}


