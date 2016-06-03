package src;

public class Model {

	public static String[] teamNames = new String[3];
	public static String[] searchs = new String[3];
	public static int[] scores = new int[3];
	public static int fields = 0;
	public static int rounds = 0;
	
	private Controller controll;
			
	public int score(int team)
	{
		return scores[team];
	}
	
	public String search(int searchNumb)
	{
		return searchs[searchNumb];
	}
	
	public String name(int team)
	{
		return teamNames[team];
	}
	
	public void registerController(Controller controllSet)
	{
		this.controll = controllSet;
	}
}
