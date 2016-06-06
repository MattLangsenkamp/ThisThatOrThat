package src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainGameView extends Application{
	WinnerView screenNew = new WinnerView();
	Controller controll;
	@Override
	public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {
    	VBox container = new VBox();
        FlowPane scorePane = new FlowPane();
        FlowPane roundsPane = new FlowPane();
        FlowPane imagePane = new FlowPane();
        FlowPane entryPane = new FlowPane();
        FlowPane endGame = new FlowPane();
        
        scorePane.setPadding(new Insets(5,5,5,5));
        roundsPane.setPadding(new Insets(5,5,5,5)); 
        imagePane.setPadding(new Insets(5,5,5,5)); 
        entryPane.setPadding(new Insets(5,5,5,5)); 
        endGame.setPadding(new Insets(5,5,5,5)); 
        
        
        scorePane.setHgap(5);
        roundsPane.setHgap(5);
        imagePane.setHgap(5);
        entryPane.setHgap(5);
        endGame.setHgap(5);
        
        container.setAlignment(Pos.TOP_CENTER);
        scorePane.setAlignment(Pos.TOP_CENTER);
        roundsPane.setAlignment(Pos.TOP_CENTER);
        imagePane.setAlignment(Pos.TOP_CENTER);
        entryPane.setAlignment(Pos.TOP_CENTER);
        endGame.setAlignment(Pos.TOP_CENTER);
        //
        VBox teamOne = new VBox();
        FlowPane teamTextOne = new FlowPane();
        FlowPane teamChoiceOne = new FlowPane();
        FlowPane readyOne = new FlowPane();
        
        teamTextOne.setAlignment(Pos.CENTER);
        teamChoiceOne.setHgap(5);
        teamChoiceOne.setAlignment(Pos.CENTER);
        teamChoiceOne.setPadding(new Insets(10,0,10,0));
        readyOne.setAlignment(Pos.CENTER);
        
        
        VBox teamTwo = new VBox();
        FlowPane teamTextTwo = new FlowPane();
        FlowPane teamChoiceTwo = new FlowPane();
        FlowPane readyTwo = new FlowPane();
        
        teamTextTwo.setAlignment(Pos.CENTER);
        teamChoiceTwo.setHgap(5);
        teamChoiceTwo.setAlignment(Pos.CENTER);
        teamChoiceTwo.setPadding(new Insets(10,0,10,0));
        readyTwo.setAlignment(Pos.CENTER);
        
        VBox teamThree = new VBox();
        FlowPane teamTextThree = new FlowPane();
        FlowPane teamChoiceThree = new FlowPane();
        FlowPane readyThree = new FlowPane();
        
        teamTextThree.setAlignment(Pos.CENTER);
        teamChoiceThree.setHgap(5);
        teamChoiceThree.setAlignment(Pos.CENTER);
        teamChoiceThree.setPadding(new Insets(10,0,10,0));
        readyThree.setAlignment(Pos.CENTER);
        
        //
        
        
        Text scoreOne = new Text(Controller.getName(0)+"'s Score: 0");
        Text scoreTwo = new Text(Controller.getName(1)+"'s Score: 0");
        Text scoreThree = new Text(Controller.getName(2)+"'s Score: 0");
        //
        Text roundsLeft = new Text(Controller.getRounds()+" rounds left");
        //
        imagePane.setPrefSize(300, 300);
        imagePane.setStyle("-fx-background: #FFFFFF;");
        
        //
        
        Text team1 = new Text("Team 1");
        CheckBox t1ch1 = new CheckBox(Controller.getSearch(0));
        CheckBox t1ch2 = new CheckBox(Controller.getSearch(1));
        CheckBox t1ch3 = new CheckBox(Controller.getSearch(2));
        CheckBox ready1 = new CheckBox("Ready");
        t1ch1.setOnAction((ActionEvent actionEvent) -> {           
            t1ch2.setSelected(false);
            t1ch3.setSelected(false);
        });
        t1ch2.setOnAction((ActionEvent actionEvent) -> {           
        	t1ch1.setSelected(false);
            t1ch3.setSelected(false);
        });
        t1ch3.setOnAction((ActionEvent actionEvent) -> {           
        	t1ch2.setSelected(false);
            t1ch1.setSelected(false);
        });
        
        
        //
        Text team2 = new Text("Team 2");
        CheckBox t2ch1 = new CheckBox(Controller.getSearch(0));
        CheckBox t2ch2 = new CheckBox(Controller.getSearch(1));
        CheckBox t2ch3 = new CheckBox(Controller.getSearch(2));
        CheckBox ready2 = new CheckBox("Ready");
        t2ch1.setOnAction((ActionEvent actionEvent) -> {           
            t2ch2.setSelected(false);
            t2ch3.setSelected(false);
        });
        t2ch2.setOnAction((ActionEvent actionEvent) -> {           
        	t2ch1.setSelected(false);
            t2ch3.setSelected(false);
        });
        t2ch3.setOnAction((ActionEvent actionEvent) -> {           
        	t2ch2.setSelected(false);
            t2ch1.setSelected(false);
        });
        //
        
        Text team3 = new Text("Team 3");
        CheckBox t3ch1 = new CheckBox(Controller.getSearch(0));
        CheckBox t3ch2 = new CheckBox(Controller.getSearch(1));
        CheckBox t3ch3 = new CheckBox(Controller.getSearch(2));
        CheckBox ready3 = new CheckBox("Ready");
        t3ch1.setOnAction((ActionEvent actionEvent) -> {           
            t3ch2.setSelected(false);
            t3ch3.setSelected(false);
        });
        t3ch2.setOnAction((ActionEvent actionEvent) -> {           
        	t3ch1.setSelected(false);
            t3ch3.setSelected(false);
        });
        t3ch3.setOnAction((ActionEvent actionEvent) -> {           
        	t3ch2.setSelected(false);
            t3ch1.setSelected(false);
        });
        //
        Button endBtn = new Button("End Game");
        endBtn.setOnAction((ActionEvent actionEvent) -> {           
	            screenNew.start(stage);
	            screenNew.registerController(controll);
	        });
        endBtn.setAlignment(Pos.CENTER);
        //
        if(Controller.getNamesNumb()==2)
        {
        	scorePane.getChildren().add(scoreOne);
        	scorePane.getChildren().add(scoreTwo);
        }
        else if(Controller.getNamesNumb()==3)
        {
        	scorePane.getChildren().add(scoreOne);
        	scorePane.getChildren().add(scoreTwo);
        	scorePane.getChildren().add(scoreThree);
        }
        //
        roundsPane.getChildren().add(roundsLeft);
        //
        teamTextOne.getChildren().add(team1);     
        readyOne.getChildren().add(ready1);    
        teamTextTwo.getChildren().add(team2);
        
        readyTwo.getChildren().add(ready2);         
        teamTextThree.getChildren().add(team3); 
        readyThree.getChildren().add(ready3);
        
        if(Controller.getFields()==2)
        {
        	teamChoiceOne.getChildren().addAll(t1ch1,t1ch2);
        	teamChoiceTwo.getChildren().addAll(t2ch1,t2ch2);
        	teamChoiceThree.getChildren().addAll(t3ch1,t3ch2);
        }
        else if(Controller.getFields()==3)
        {
        	teamChoiceOne.getChildren().addAll(t1ch1,t1ch2,t1ch3);
        	teamChoiceTwo.getChildren().addAll(t2ch1,t2ch2,t2ch3);
        	teamChoiceThree.getChildren().addAll(t3ch1,t3ch2,t3ch3);
        }
        
        
        
        //
        teamOne.getChildren().addAll(teamTextOne,teamChoiceOne,readyOne);
        teamTwo.getChildren().addAll(teamTextTwo,teamChoiceTwo,readyTwo);
        teamThree.getChildren().addAll(teamTextThree,teamChoiceThree,readyThree);
        
        
        
        if(Controller.getNamesNumb()==2)
        {
        	entryPane.getChildren().addAll(teamOne,teamTwo);
        }
        else if(Controller.getNamesNumb()==3)
        {
        	entryPane.getChildren().addAll(teamOne,teamTwo,teamThree);
        }
             
        endGame.getChildren().add(endBtn);
        
        //
        container.getChildren().add(scorePane);
        container.getChildren().add(roundsPane);
        container.getChildren().add(imagePane);
        container.getChildren().add(entryPane);
        container.getChildren().add(endGame);
        
        //
        Scene scene = new Scene(container, 1250, 600);
        
        stage.setTitle("Main Game");
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
    public void registerController(Controller cont)
    {
    	this.controll = cont;
    }
  
}
