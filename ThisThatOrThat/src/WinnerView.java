package src;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class WinnerView extends Application{
	Controller controll;
	@Override
	public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {
    	VBox container = new VBox();
    	Text winner = new Text("The winner is team XX with a score of XX");
    	container.setAlignment(Pos.CENTER);
    	container.getChildren().add(winner);
    	Button btn = new Button("Ok");
    	btn.setOnAction((ActionEvent actionEvent) -> {           
            System.exit(0);
        });
    	btn.setPadding(new Insets(15,15,15,15));
    	container.getChildren().add(btn);
    	Scene scene = new Scene(container, 300, 200);
        
        stage.setTitle("Winner");
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

  public static void main(String[] args) {
       launch(args);
    }
}
