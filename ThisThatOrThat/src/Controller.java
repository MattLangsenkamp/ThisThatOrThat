package src;

public class Controller {
	
	public static Model model;
	public static InfoFormView infoView;
	public static MainGameView mainView;
	public static WinnerView winView;
	
	public Controller(Model modelINIT,MainGameView mainViewINIT, WinnerView winINIT)
	{
		model = modelINIT;
		
		mainView = mainViewINIT;
		winView = winINIT;
	}
	public static void setFields(int f)
	{
		model.fields = f;
	}
	public static void setNameNumb(int n)
	{
		model.names = n;
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
	public static int getFields()
	{
		return model.fields;
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
	public static int getNamesNumb()
	{
		return model.names;
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
