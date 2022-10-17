package Controllers.Treman;
import Model.Player.Player;
import Model.Player.Players;
import com.example.hydrohomies.UIController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.*;
import java.io.File;
import java.util.Random;


public class TremanController {
    Random random = new Random();
    private UIController parentController;


    public TremanController(UIController parentController ) {
        this.parentController = parentController;


    }
    @FXML public AnchorPane tremanGameAnchorPane;
    @FXML public ImageView diceTremanMenuButtonImageView;
    @FXML public ListView<Players> playerListView;
    @FXML public  Label challengeLabel;
    @FXML private ImageView diceRightTremanImageView;
    @FXML private ImageView diceLeftTremanImageView;
    @FXML public Button tremanRollButton;


    //action performed saker

    //denna ska ske när knappen trycks så kommer skiten att ha en animation
    public void roll (ActionEvent event){
        tremanRollButton.setDisable(true);

        Thread thread = new Thread(){
            {
                System.out.println("Thread Running");
                try{
                    for(int i = 0;  i < 15; i++){
                        File file = new File("src/main/resources/resources_img/diceImg/die" + (random.nextInt(6)+1)+".png");
                        //diceRightTremanImageView.setImage(new Image(file.toURI().toString()));
                        //diceLeftTremanImageView.setImage(new Image((file.toURI().toString())));
                        Thread.sleep(50);
                    }
                    tremanRollButton.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        /* när det kommer en etta eller en utmaning (två av varje tal) så kör denna*/
        //model för när utmaning körs någon jävla om två av samma displayas kör den här koden
        //basically en observer som signaliserar
        //playerListView(); to front eller något samt labelen to front
        //sen ska man initiera att det går att trycka på knapparna osv osv genom en actionevent




    }

}
