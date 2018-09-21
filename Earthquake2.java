import java.util.LinkedList;

class Earthquake2 {
  Earthquake2(){}
      
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
  
//consumes a list of doubles and the number of a month, and produces a list of the max readings for each day in the entered month
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,int month) {
	  LinkedList<MaxHzReport> listMaxReport = new LinkedList <MaxHzReport> ();
	  double maxF = 0;
	  
	  for(int i = 0; i < data.size(); i++) {
		  double first = data.get(i);
		  
		  if(isDate(first)) {
			  if(extractMonth(first) == month) {
				  for(int j = i+1; j < data.size() && !isDate(data.get(j)); j++) {
					  if(data.get(j) > maxF) {
						  maxF = data.get(j);
					  }
				  }
				  MaxHzReport maxReport = new MaxHzReport (first, maxF);
				  maxF = 0;
				  listMaxReport.add(maxReport);
			  }
		  }
	  }
	  return listMaxReport;
  }
}