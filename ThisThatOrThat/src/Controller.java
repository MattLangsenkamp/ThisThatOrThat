package src;

public class Controller {
	
	private static Model model;
	private static InfoFormView infoView;
	private static MainGameView mainView;
	
	public static void setFields(int f)
	{
		model.fields = f;
	}
	public static void setRounds(int r)
	{
		model.rounds = r;
	}
	
	public static void setNames(String teamName, int team)
	{
		model.teamNames[team] = teamName;	
	}
	public static void setSearches(String searchName, int n)
	{
		model.searchs[n] = searchName;	
	}
	
	//------------- main view methods------//
	
	public static int getRounds()
	{
		return model.rounds;
	}
	
	public static String getName(int team)
	{
		return model.name(team);
	}
	
	public static String getSearch(int n)
	{
		return model.search(n);
	}
	public static int getScore(int n)
	{
		return model.score(n);
	}
	
	public static void incrementScore(int n)
	{
		model.scores[n]++;
	}
	
	public static void decrementRound()
	{
		model.rounds--;
	}
}
