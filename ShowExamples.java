import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class ShowExamples 
{
	ShowManager1 sm1 = new ShowManager1();
	ShowManager2 sm2 = new ShowManager2();
	LinkedList<Show> shows = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();
	
	public ShowExamples(){}
	
	//instructor test, basic 
	@Test
	public void instructorTestOrganizeShows() 
	{
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		Show s1 = new Show("Star Trek", 1800, eps1);
		shows.add(s1);
		report1.primetime.add(s1);
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		Show s2 = new Show("Futurama", 1900, eps2);
		shows.add(s2);
		report1.primetime.add(s2);
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		Show s3 = new Show("Animaniacs", 1630, eps3);
		shows.add(s3);
		report1.daytime.add(s3);
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		Show s4 = new Show("Sesame Street", 900, eps4);
		shows.add(s4);
		report1.daytime.add(s4);
		
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}
	//tests to make sure that primetime list is empty
	@Test
	public void daytime() 
	{
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		Show s3 = new Show("Animaniacs", 1630, eps3);
		shows.add(s3);
		report1.daytime.add(s3);
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		Show s4 = new Show("Sesame Street", 900, eps4);
		shows.add(s4);
		report1.daytime.add(s4);
		
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}
	
	//tests to make sure that daytime list is empty
	@Test
	public void primetime() 
	{
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		Show s1 = new Show("Star Trek", 1800, eps1);
		shows.add(s1);
		report1.primetime.add(s1);
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		Show s2 = new Show("Futurama", 1900, eps2);
		shows.add(s2);
		report1.primetime.add(s2);
		
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}
	
	//tests shows that are neither primetime or daytime
		@Test
		public void empty() {
		
			LinkedList<Episode> eps1 = new LinkedList<Episode>();
			eps1.add(new Episode("Best of Both Worlds", 88));
			eps1.add(new Episode("The Ultimate Computer", 49));
			eps1.add(new Episode("Trials and Tribble-ations", 43));		
			Show s1 = new Show("Star Trek", 1800, eps1);
			shows.add(s1);
			report1.primetime.add(s1);
			
			LinkedList<Episode> eps2 = new LinkedList<Episode>();
			eps2.add(new Episode("Fear of a Bot Planet", 23));
			eps2.add(new Episode("The Why of Fry", 21));
			eps2.add(new Episode("Roswell that Ends Well", 23));
			eps2.add(new Episode("Meanwhile", 22));
			Show s2 = new Show("Futurama", 1900, eps2);
			shows.add(s2);
			report1.primetime.add(s2);
			
			LinkedList<Episode> eps3 = new LinkedList<Episode>();
			eps3.add(new Episode("Yakko's World", 4));
			eps3.add(new Episode("Hello Nice Warners", 8));
			eps3.add(new Episode("Where Rodents Dare", 9));
			Show s3 = new Show("Animaniacs", 1630, eps3);
			shows.add(s3);
			report1.daytime.add(s3);
			
			LinkedList<Episode> eps4 = new LinkedList<Episode>();
			eps4.add(new Episode("The Letter W", 59));
			eps4.add(new Episode("The Letter P", 57));
			eps4.add(new Episode("The Letter I", 58));
			Show s4 = new Show("Sesame Street", 900, eps4);
			shows.add(s4);
			report1.daytime.add(s4);
			
			LinkedList<Episode> eps5 = new LinkedList<Episode>();
			eps5.add(new Episode("The Letter W", 59));
			eps5.add(new Episode("The Letter P", 57));
			eps5.add(new Episode("The Letter I", 58));
			Show s5 = new Show("Oh joy", 599, eps4);
			shows.add(s5);
			
			ShowSummary report2 = sm1.organizeShows(shows);
			assertEquals(report1, report2);
		}

}

//subtasks
//sort the list of shows into shows that are daytime shows and shows that are prime time shows
//create a new ShowSummary which contains the 2 lists we sorted
