package src;

public class Model {

	public String[] teamNames = new String[3];
	public String[] searchs = new String[3];
	public int[] scores = new int[3];
	public int fields = 0;
	public int names = 0;
	public int rounds = 0;
	
	public Controller controll;
			
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
	public int nameNumb()
	{
		return names;
	}
}
