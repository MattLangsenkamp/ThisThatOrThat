package src;


import java.util.concurrent.CountDownLatch;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class InfoFormView extends Application{
	MainGameView screenNew = new MainGameView();
	public static Controller controll;
	//-----
	public static final CountDownLatch latch = new CountDownLatch(1);
    public static InfoFormView startUpTest = null;

    public static InfoFormView waitForStartUpTest(Controller cont) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controll = cont;
        return startUpTest;
    }

    public static void setStartUpTest(InfoFormView startUpTest0) {
        startUpTest = startUpTest0;
        latch.countDown();
    }

    public void StartUpTest() {
        setStartUpTest(this);
    }

    public void printSomething() {
        System.out.println("You called a method on the application");
    }
    //-----
	@Override
		public void start(Stage stage) {
	        initUI(stage);
	    }

	    private void initUI(Stage stage) {
	    	VBox container = new VBox();    	
	    	FlowPane descriptionText = new FlowPane();    	   	
	    	FlowPane teamNumber = new FlowPane();    	    	
	    	FlowPane teamNames = new FlowPane();	    	
	    	FlowPane searchNumber = new FlowPane();	    	
	    	FlowPane searchNames = new FlowPane();	    	
	    	FlowPane contButton = new FlowPane();	    	
	    	FlowPane progress = new FlowPane();	
	    	
	    	descriptionText.setHgap(5);	 
	    	teamNumber.setHgap(5);	
	    	teamNames.setHgap(5);
	    	searchNumber.setHgap(5);
	    	searchNames.setHgap(5);	
	    	contButton.setHgap(5);
	    	
	    	descriptionText.setPadding(new Insets(5,5,5,5));
	    	teamNumber.setPadding(new Insets(5,5,5,5));
	    	teamNames.setPadding(new Insets(5,5,5,5));
	    	searchNumber.setPadding(new Insets(5,5,5,5));
	    	searchNames.setPadding(new Insets(5,5,5,5));
	    	contButton.setPadding(new Insets(5,5,5,5));
	    	progress.setPadding(new Insets(5,5,5,5));
	    	
	    	container.setAlignment(Pos.TOP_CENTER);
	    	descriptionText.setAlignment(Pos.CENTER);
	    	teamNumber.setAlignment(Pos.CENTER);
	    	teamNames.setAlignment(Pos.CENTER);
	    	searchNumber.setAlignment(Pos.CENTER);
	    	searchNames.setAlignment(Pos.CENTER);
	    	contButton.setAlignment(Pos.CENTER);
	    	progress.setAlignment(Pos.CENTER);
	    	//-----
	    	Text introText = new Text("In this game you will "
	    			+ "pick two or three image searchs. These images will"
	    			+ " then be randomly picked and you will have to guess"
	    			+ " which picture is which");
	    	introText.setWrappingWidth(500);
	    	descriptionText.getChildren().add(introText);
	    	//-----  	
	        CheckBox twoTeams = new CheckBox("Two Teams");
	        CheckBox threeTeams = new CheckBox("Three Teams");
	        
	        teamNumber.getChildren().add(twoTeams);
	        teamNumber.getChildren().add(threeTeams);
	        //-----
	        Label lbl1 = new Label("Team 1");
	        Label lbl2 = new Label("Team 2");
	        Label lbl3 = new Label("Team 3");
	        
	        TextField field1 = new TextField("Team 1");
	        TextField field2 = new TextField("Team 2");
	        TextField field3 = new TextField("Team 3");
	        
	        lbl1.setLabelFor(field1);
	        lbl2.setLabelFor(field2);
	        lbl3.setLabelFor(field3);
	        twoTeams.setOnAction((ActionEvent actionEvent)-> {
	        	field3.setVisible(false);
	        	threeTeams.setSelected(false);
	        });
	        threeTeams.setOnAction((ActionEvent actionEvent)-> {
	        	field3.setVisible(true);
	        	twoTeams.setSelected(false);
	        });
	        
	        teamNames.getChildren().add(field1);
	        teamNames.getChildren().add(field2);
	        teamNames.getChildren().add(field3);
	        //-----
	        CheckBox twoSearches = new CheckBox("Two Searches");     
	        CheckBox threeSearches = new CheckBox("Three Searches");
	        
	        searchNumber.getChildren().add(twoSearches);
	        searchNumber.getChildren().add(threeSearches);
	        //-----
	        Label lbl4 = new Label("Search 1");
	        Label lbl5 = new Label("Search 2");
	        Label lbl6 = new Label("Search 3");
	        
	        TextField field4 = new TextField("Search 1");
	        TextField field5 = new TextField("Search 2");
	        TextField field6 = new TextField("Search 3");
	        
	        lbl4.setLabelFor(field4);
	        lbl5.setLabelFor(field5);
	        lbl6.setLabelFor(field6);
	        twoSearches.setOnAction((ActionEvent actionEvent)-> {
	        	field6.setVisible(false);
	        	threeSearches.setSelected(false);
	        });
	        threeSearches.setOnAction((ActionEvent actionEvent)-> {
	        	field6.setVisible(true);
	        	twoSearches.setSelected(false);
	        });
	        searchNames.getChildren().add(field4);
	        searchNames.getChildren().add(field5);
	        searchNames.getChildren().add(field6);
	        //-----
	        Button contBtn = new Button("Continue");
	        contButton.getChildren().add(contBtn);
	        
	        //-----
	        ProgressBar pbar = new ProgressBar(0);
	        pbar.setPrefWidth(150);
	        
	        KeyFrame frame1 = new KeyFrame(Duration.ZERO, 
	                new KeyValue(pbar.progressProperty(), 0));
	        
	        KeyFrame frame2 = new KeyFrame(Duration.seconds(3), 
	                new KeyValue(pbar.progressProperty(), 1));        

	        Timeline task = new Timeline(frame1, frame2);

	       
	        contBtn.setOnAction((ActionEvent actionEvent) -> {
	            task.playFromStart();
	            
	            
	            
	           
	            if(twoTeams.isSelected()||threeTeams.isSelected())
	            {
	            	if(twoTeams.isSelected())
	            	{
	            		Controller.setNameNumb(2);
	            		Controller.setNames(field1.getText(), 0);
	            		Controller.setNames(field2.getText(), 1);	            		       		
	            	}
	            	else
	            	{
	            		Controller.setNameNumb(3);
	            		Controller.setNames(field1.getText(), 0);
	    	            Controller.setNames(field2.getText(), 1);
	    	            Controller.setNames(field3.getText(), 2);	    	            
	            	}
	        	}
	            else
	            {
	            	//
	            	
	            }

	            if(twoSearches.isSelected()||threeSearches.isSelected())
	            {
	            	if(twoSearches.isSelected())
	            	{
	            		Controller.setFields(2);
	            		Controller.setSearches(field4.getText(), 0);
	            		Controller.setSearches(field5.getText(), 1);        		
	            	}
	            	else
	            	{
	            		Controller.setFields(3);	            
	    	            Controller.setSearches(field4.getText(), 0);
	            		Controller.setSearches(field5.getText(), 1); 
	            		Controller.setSearches(field6.getText(), 2); 
	            	}
	        	}
	            else
	            {
	            	//popup
	            	
	            }
	            
	            screenNew.start(stage);
	            screenNew.registerController(controll);
	            
	        });
	        
	        progress.getChildren().add(pbar);
	        //-----
	        container.getChildren().add(descriptionText);
	        container.getChildren().add(teamNumber);
	        container.getChildren().add(teamNames);
	        container.getChildren().add(searchNumber);
	        container.getChildren().add(searchNames);
	        container.getChildren().add(contButton);
	        container.getChildren().add(progress);
	        
	        
	        //-----
	        Scene scene = new Scene(container, 600, 350);
	        
	        stage.setTitle("Info Form");
	        stage.setOnCloseRequest(new EventHandler<WindowEvent>() 
            {
                public void handle(WindowEvent e){
                    System.out.println("test");  
                    try {
                        System.exit(0);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
	        stage.setScene(scene);
	        stage.show();
	    }
	
	   
	    public static void main(String[] args) {
	       launch(args);
	    }
}
