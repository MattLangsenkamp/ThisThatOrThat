package src;
public class GameRunner {
	
	public static void main(String[] args) {
		
		
		new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(InfoFormView.class);
            }
        }.start();
        
        Model model = new Model();
		MainGameView game = new MainGameView();
		WinnerView win = new WinnerView();
		
		
        Controller cont = new Controller(model,game,win);
		
		game.registerController(cont);
		win.registerController(cont);
		model.registerController(cont);
        
        InfoFormView info = InfoFormView.waitForStartUpTest(cont);
                      				     
        
	}

}
