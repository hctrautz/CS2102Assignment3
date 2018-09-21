import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples 
{  
  LinkedList<Show> shows = new LinkedList<Show>();
  LinkedList<Double> showResults = new LinkedList<Double>();
  LinkedList<Double> noShowResults = new LinkedList<Double>();
  LinkedList<Double> oneShowResult = new LinkedList<Double>();
  LinkedList<Double> twoShowResult = new LinkedList<Double>();
  LinkedList<Show> oneShow = new LinkedList<Show>();
  LinkedList<Show> twoShow = new LinkedList<Show>();
  LinkedList<Show> noShow = new LinkedList<Show>();
  DataSmooth1 D1 = new DataSmooth1();
  DataSmooth2 D2 = new DataSmooth2();
  
  public DataSmoothExamples() 
  {
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		shows.add(new Show("Star Trek", 1800, eps1));
		oneShow.add(new Show("Star Trek", 1800, eps1));
		twoShow.add(new Show("Star Trek", 1800, eps1));
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		shows.add(new Show("Futurama", 1900, eps2));

		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3));
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4));
		twoShow.add(new Show("Sesame Street", 900, eps4));
		
	    showResults.add(60.0);
	    showResults.add(29.75);
	    showResults.add(29.08333);
	    showResults.add(58.0);
	    
	    oneShowResult.add(60.0);
	    
	    twoShowResult.add(60.0);
	    twoShowResult.add(58.0);
  }
  
  @Test
  public void instructorTestDS() 
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults.get(i), .01);
	  }
  }
  //checks to see if the method produces 0 when there are no episodes
  @Test
  public void noEpisodes() {
	  for(int i = 0; i < noShowResults.size(); i++) {
		  assertEquals(noShowResults.get(i), 0, 0.5);
	  }
  }
  //checks there is no data smoothing
  @Test
  public void oneEpisode() {
	  LinkedList<Double> runtimes = D1.dataSmooth(oneShow);
	  
	  for(int i = 0; i < runtimes.size(); i++) {
		  assertEquals(oneShowResult.get(i), runtimes.get(i), 0.05);
	  }
  }
//checks there is no data smoothing
  @Test
  public void twoEpisodes() {
	  LinkedList<Double> runtimes = D1.dataSmooth(twoShow);
	  
	  for(int i = 0; i < runtimes.size(); i++) {
		  assertEquals(twoShowResult.get(i), runtimes.get(i), 0.05);
	  }
  }
  
}
//subtasks
//calculate the average runtime of each show by taking the sum of the runtime of every episode in a show, 
//and dividing it by the number of episodes there are in total
//add the average runtime of each show to a new list
//smoothing the list of average run times by adding the current number, the previous number, and the next number and dividing the sum by 3
//adding the smoothed value to a new list
//if the average runtime is either first or last in the list, the number cannot be smoothed and is just added to the list of smoothed values 