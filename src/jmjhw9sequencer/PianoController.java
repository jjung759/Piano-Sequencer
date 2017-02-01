/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmjhw9sequencer;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 *
 * @author Jim
 */
public class PianoController implements Initializable {
    @FXML
    private Rectangle keyC0;
    @FXML 
    private Rectangle keyDb;
    @FXML
    private Rectangle keyD;
    @FXML
    private Rectangle keyEb;
    @FXML 
    private Rectangle keyE;
    @FXML
    private Rectangle keyF;
    @FXML
    private Rectangle keyGb;
    @FXML 
    private Rectangle keyG;
    @FXML
    private Rectangle keyAb;
    @FXML
    private Rectangle keyA;
    @FXML 
    private Rectangle keyBb;
    @FXML
    private Rectangle keyB;
    @FXML 
    private Rectangle keyC1;
    
    private Scene pianoScene;
    private Scene guitarScene;
    private GuitarController guitarController;
    
    public Boolean activeScenePiano = TRUE;
    
    @FXML 
    private TextArea compositionContent;
    
    @FXML
    private Button recordBtn;
    @FXML
    private Button playBtn;
    @FXML
    private Button clearBtn;
    
    private Stage stage;
    
    @FXML 
    private AnchorPane background;
    
    @FXML 
    private MenuBar menu;
    
    @FXML 
    private HBox hbox;
    
    @FXML
    private AnchorPane org;
    
    @FXML 
    private Circle recordEnabled;
    
    private boolean recording=FALSE;//When the record button is clicked, this will be set to true, enabling recording.
    private int numClickedRecord=0;//
    
    private Piano piano;
    private PianoSong song;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    public void ready(Stage stage) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        
        this.stage=stage;
        pianoScene = stage.getScene();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Insturctions");
        alert.setHeaderText("How to use the Sequencer: ");
        alert.setContentText("To play the instrument, just press the keys A,W,S,E,D,F,T,G,Y,H,U,J,K. Click Record to log your sequence, then"
                + " click play to hear the sequence again.");
        alert.showAndWait();
        
        compositionContent.setEditable(FALSE);
        
        Piano piano = new Piano();
        
        if (recording==FALSE)
            {   recordEnabled.setVisible(FALSE); }
        
        //This Lambda expression functions to detect the key pressed, then output the correct sound
        //And Notate within the composition TextArea if "recording" is enabled.
        
        stage.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> { 
        if (null != event.getCode().toString() && activeScenePiano == TRUE) switch (event.getCode().toString()) {
                case "A":
                    keyC0.setStrokeWidth(1);
                    piano.playNotes(0);
                    if (recording==TRUE)
                        compositionContent.appendText("C ");
                    break;
            
                case "W":
                    keyDb.setStrokeWidth(1);
                    piano.playNotes(1);
                    if (recording==TRUE)
                        compositionContent.appendText("Db ");
                    break;
            
                case "S":
                    keyD.setStrokeWidth(1);
                    piano.playNotes(2);
                    if (recording==TRUE)
                        compositionContent.appendText("D ");
                    break;
           
                case "E":
                    keyEb.setStrokeWidth(1);
                    piano.playNotes(3);
                    if (recording==TRUE)
                        compositionContent.appendText("Eb ");
                    break;
                    
                case "D":
                    keyE.setStrokeWidth(1);
                    piano.playNotes(4);
                    if (recording==TRUE)
                        compositionContent.appendText("E ");
                    break;
                    
                case "F":
                    keyF.setStrokeWidth(1);
                    piano.playNotes(5);
                    if (recording==TRUE)
                        compositionContent.appendText("F ");
                    break;
                    
                case "T":
                    keyGb.setStrokeWidth(1);
                    piano.playNotes(6);
                    if (recording==TRUE)
                        compositionContent.appendText("Gb ");
                    break;
                    
                case "G":
                    keyG.setStrokeWidth(1);
                    piano.playNotes(7);
                    if (recording==TRUE)
                        compositionContent.appendText("G ");
                    break;
                    
                case "Y":
                    keyAb.setStrokeWidth(1);
                    piano.playNotes(8);
                    if (recording==TRUE)
                        compositionContent.appendText("Ab ");
                    break;
                    
                case "H":
                    keyA.setStrokeWidth(1);
                    piano.playNotes(9);
                  //  A.play();
                    if (recording==TRUE)
                        compositionContent.appendText("A ");
                    break;
                    
                case "U":
                    keyBb.setStrokeWidth(1);
                    piano.playNotes(10);
                    if (recording==TRUE)
                        compositionContent.appendText("Bb ");
                    break;
                case "J":
                    keyB.setStrokeWidth(1);
                    piano.playNotes(11);
                    if (recording==TRUE)
                        compositionContent.appendText("B ");
                    break;
                    
                case "K":
                    keyC1.setStrokeWidth(1);
                    piano.playNotes(12);
                    if (recording==TRUE)
                        compositionContent.appendText("C1 ");
                    break;
                    
                default:
                    break;
            }
        });
        
        
        stage.addEventFilter(KeyEvent.KEY_RELEASED,(KeyEvent event) -> {
        if (null != event.getCode().toString() && activeScenePiano == TRUE) switch (event.getCode().toString()) {
            case "A":
                    keyC0.setStrokeWidth(0);
                    break;
            
                case "W":
                    keyDb.setStrokeWidth(0);
                    break;
            
                case "S":
                    keyD.setStrokeWidth(0);
                    break;
           
                case "E":
                    keyEb.setStrokeWidth(0);
                    break;
                    
                case "D":
                    keyE.setStrokeWidth(0);
                    break;
                    
                case "F":
                    keyF.setStrokeWidth(0);
                    break;
                    
                case "T":
                    keyGb.setStrokeWidth(0);
                    break;
                    
                case "G":
                    keyG.setStrokeWidth(0);
                    break;
                    
                case "Y":
                    keyAb.setStrokeWidth(0);
                    break;
                    
                case "H":
                    keyA.setStrokeWidth(0);
                    break;
                    
                case "U":
                    keyBb.setStrokeWidth(0);
                    break;
                case "J":
                    keyB.setStrokeWidth(0);
                    break;
                case "K":
                    keyC1.setStrokeWidth(0);
                    break;
                    
                default:
                    break;
            
            
            
        }
        });
    }
    @FXML
    public void handleRecord (ActionEvent event)
    {   if ( (numClickedRecord % 2) == 0 )
        {   recording = TRUE;
            recordEnabled.setVisible(TRUE);
            numClickedRecord++;
        }
        
        else
            {   recording = FALSE;
                recordEnabled.setVisible(FALSE);
                numClickedRecord++;
            
            }
    }
    @FXML
    public void handleClear (ActionEvent event)
    {   if (compositionContent.getText() == null) {
        } else {
          compositionContent.setText("");
    
        }
    }
    
    
    @FXML 
    public void handleLoad (ActionEvent event) throws IOException
    {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files(*.txt)", "*.txt"));
        File file = fileChooser.showOpenDialog(stage);
        
        
        if (file != null)
        {   try{ 
                    FileReader reader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    
                    String line;
                    
                    while ( (line = bufferedReader.readLine()) != null) {
                        compositionContent.setText(line);
                
            }
                    
                    
                    
        }
        catch (Exception e)
        {
            System.out.println("Error: File Not Found");
            
        }
        
    }
    }
    
    @FXML
    public void handleSaveSequence(ActionEvent event) throws IOException
    {   FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files(*.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(stage);
        
        FileWriter writer = null;
        if (file != null)
        {
            try{
                writer =  new FileWriter(file);
                writer.write(compositionContent.getText());
            }
            catch (IOException ioex)
            {
                System.out.println("\nSaving Error");
            } catch (Exception ex)
            {
                System.out.println("\nSaving Error");
            } finally {
                if (writer != null){
                    try { 
                            writer.close();
                    }
                    catch (Exception e)
                    {
                        
                    }
                }
            }
        }
    }
    
    @FXML
    public void handlePlay() 
    {   if ("".equals(compositionContent.getText()))
        { return; }
        if (activeScenePiano == FALSE)
        {   return; }
        
        
        song = new PianoSong(compositionContent.getText());
        song.playSequence();
    }
    
    @FXML
    public void handleAboutPiano()
    {   
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("How To Use the Piano Sequencer");
        alert.setHeaderText("Instructions: ");
        alert.setContentText("The Piano Sequencer allows one to both play a piano by utilizing the keyboard, as well as Record, Load, and Save note sequences that the application can utilize for playback.\n" +
"To Play Piano: Press the keys A,W,S,E,D,F,T,G,Y,H,U,J, and K to play the notes spanning the octave C0-C1.\n" +
"\n" +
"To Record a sequence: Press The record button, then play notes on the piano. The text Area will update with notes as they are struck\n" +
"\n" +
"To Play a sequence: Press the play button to listen back to the notes recorded in the sequence.\n" +
"\n" +
"To Load A Sequence: Under the File menu, select \"Load Sequence\", then select a prior created TXT File.\n" +
"\n" +
"To Save A Sequence: Under the File menu, select \"Save Sequence\" To Create and Save a TXT file containing the sequence's content. ");
        
        alert.showAndWait();
        
        
        
    }
    
    @FXML 
    public void handleAboutMe()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About James Jung");
        alert.setHeaderText("About the developer: ");
        alert.setContentText("James Jung is a second year student studying Computer Science, he's ok presumably, and has yet to commmit an extreme moral failure.\n" +
"He is heavily involved with the student Radio station KCOU, serving as Production Director, as well as hosting the experimental program \"???\", which provides\n" +
"valuable moaning sounds and afrobeat to the Columbia area every Wednesday Night at 10pm. He also plays guitar in a band that doesn't yet have a name.\n" +
"\n" +
"He's interested in the intersection of CS and sound, as well as the design and implementation of Music oriented applications.");
        
        alert.showAndWait();
        
        
    }
    
    @FXML
    public void handleChangeInstrument() throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {   
        activeScenePiano = FALSE;
        
        if (guitarScene == null)
        {   FXMLLoader loader = new FXMLLoader(getClass().getResource("Guitar.FXML.fxml"));
                    
                   
                    
                    Parent guitarRoot = (Parent) loader.load();
                     guitarController = loader.getController();
                    guitarController.pianoScene = pianoScene;
                    guitarController.pianoController = this;
                    guitarScene = new Scene(guitarRoot);
                
        }
        stage.setScene(guitarScene);
        guitarController.guitarSceneActive = TRUE;
      
        guitarController.ready(stage);
        
    }
    
    
    
    
}
