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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Jim
 */
public class GuitarController implements Initializable {
    @FXML
    private Ellipse C0;
    @FXML
    private Ellipse Db;
    @FXML
    private Ellipse D;
    @FXML
    private Ellipse Eb;
    @FXML
    private Ellipse E;
    @FXML
    private Ellipse F;
    @FXML
    private Ellipse Gb;
    @FXML
    private Ellipse G;
    @FXML
    private Ellipse Ab;
    @FXML
    private Ellipse A;
    @FXML
    private Ellipse Bb;
    @FXML
    private Ellipse B;
    @FXML
    private Ellipse C1;
    
    private GuitarSong song1;
    
    @FXML 
    private TextArea compositionContent;
    
    @FXML
    private Button recordBtn;
    @FXML
    private Button playBtn;
    @FXML
    private Button clearBtn;
    
    private Stage stage;
    
     private boolean recording=FALSE;
     private int numClickedRecord=0;
     
    public Scene pianoScene;
    private Scene guitarScene;
    public PianoController pianoController;
    
    @FXML 
    private Circle recordEnabled;
    
    public Boolean guitarSceneActive = TRUE;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }
    
    public void ready(Stage stage) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        this.stage = stage;
        
        Guitar guitar = new Guitar();
        compositionContent.setEditable(FALSE);
        
        if (recording == FALSE)
        {   recordEnabled.setVisible(FALSE); }
        
        
        stage.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> { 
        if (null != event.getCode().toString() && guitarSceneActive == TRUE) switch (event.getCode().toString()) {
            case "A":
                C0.setStrokeWidth(1);
                guitar.playNotes(0);
                if (recording)
                {
                    compositionContent.appendText("CMaj7 ");
                }
                    
                break;
            case "W":
                Db.setStrokeWidth(1);
                guitar.playNotes(1);
                if (recording)
                {
                    compositionContent.appendText("DbMaj7 ");
                }
                break;
            case "S":
                D.setStrokeWidth(1);
                guitar.playNotes(2);
                if (recording)
                {
                    compositionContent.appendText("DMaj7 ");
                }
                break;
            case "E":
                Eb.setStrokeWidth(1);
                guitar.playNotes(3);
                if (recording)
                {
                    compositionContent.appendText("EbMaj7 ");
                }
                break;
            case "D":
                E.setStrokeWidth(1);
                guitar.playNotes(4);
                if (recording)
                {
                    compositionContent.appendText("EMaj7 ");
                }
                break;
            case "F":
                F.setStrokeWidth(1);
                guitar.playNotes(5);
                if (recording)
                {
                    compositionContent.appendText("FMaj7 ");
                }
                break;
                
            case "T":
                Gb.setStrokeWidth(1);
                guitar.playNotes(6);
                if (recording)
                {
                    compositionContent.appendText("GbMaj7 ");
                }
                break;
            case "G":
                G.setStrokeWidth(1);
                guitar.playNotes(7);
                if (recording)
                {
                    compositionContent.appendText("GMaj7 ");
                }
                break;
            case "Y":
                Ab.setStrokeWidth(1);
                guitar.playNotes(8);
                if (recording)
                {
                    compositionContent.appendText("AbMaj7 ");
                }
                break;
            case "H":
                A.setStrokeWidth(1);
                guitar.playNotes(9);
                if (recording)
                {
                    compositionContent.appendText("AMaj7 ");
                }
                break;
            case "U":
                Bb.setStrokeWidth(1);
                guitar.playNotes(10);
                if (recording)
                {
                    compositionContent.appendText("BbMaj7 ");
                }
                break;
            case "J":
                B.setStrokeWidth(1);
                guitar.playNotes(11);
                if (recording)
                {
                    compositionContent.appendText("BMaj7 ");
                }
                break;
            case "K":
                C1.setStrokeWidth(1);
                guitar.playNotes(12);
                if (recording)
                {
                    compositionContent.appendText("C1Maj7 ");
                }
                break;
            default:
                break;
                
            
            
        }
        });
        
         stage.addEventFilter(KeyEvent.KEY_RELEASED,(KeyEvent event) -> {
        if (null != event.getCode().toString() && guitarSceneActive==TRUE) switch (event.getCode().toString()) {
            case "A":
                    C0.setStrokeWidth(0);
                    break;
            
                case "W":
                    Db.setStrokeWidth(0);
                    break;
            
                case "S":
                    D.setStrokeWidth(0);
                    break;
           
                case "E":
                    Eb.setStrokeWidth(0);
                    break;
                    
                case "D":
                    E.setStrokeWidth(0);
                    break;
                    
                case "F":
                    F.setStrokeWidth(0);
                    break;
                    
                case "T":
                    Gb.setStrokeWidth(0);
                    break;
                    
                case "G":
                    G.setStrokeWidth(0);
                    break;
                    
                case "Y":
                    Ab.setStrokeWidth(0);
                    break;
                    
                case "H":
                    A.setStrokeWidth(0);
                    break;
                    
                case "U":
                    Bb.setStrokeWidth(0);
                    break;
                case "J":
                    B.setStrokeWidth(0);
                    break;
                case "K":
                    C1.setStrokeWidth(0);
                    break;
                    
                default:
                    break;
            
            
            
        }
        });
        
        
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
    public void handleAboutMe()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About James Jung");
        alert.setHeaderText("About the developer: ");
        alert.setContentText("James Jung is a second year student studying Computer Science, he's ok presumably, and has yet to commmit an extreme moral failure.\n" +
"He is heavily involved with the student Radio station KCOU, serving as Production Director, as well as hosting the experimental program \"???\", which provides\n" +
"valuable moaning sounds and afrobeat to the Columbia area every Wednesday Night at 10pm. He also plays guitar in a band that doesn't yet have a name.\n" +
"\n" +
"He's interested in the intersection of CS and sound, as well as the design and implementation of Music oriented applications.");
        
        alert.showAndWait();
        
        
    }
    @FXML void handleAboutGuitar()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("How to Use the Guitar Sequencer");
        alert.setHeaderText("Instructions: ");
        alert.setContentText("The Guitar Sequencer Allows for one to both play guitar chords through the utilization of the keyboard, as well as Record, Load, and Save note sequences that the application can utilize for playback.\n" +
"\n" +
"To Play Guitar: Press the keys A,W,S,E,D,F,T,G,Y,H,U,J and K in order to major 7th chords which span the octave C0-C1.\n" +
"\n" +
"To Record a sequence: Press the record button, then play chords on the piano, The text Area will update with notes as they are entered.\n" +
"\n" +
"To Play A Sequence: Press the Play button the hear back the notes which are currently populating the sequence.\n" +
"\n" +
"To Load A Sequence: Select \"Load Sequence\" under the file menu, then select a priorly created TXT File.\n" +
"\n" +
"To Save A Sequence: Select \"Save Sequence\" under the file menu, in order to create and save a TXT file containing the sequence's content.");
        
        alert.showAndWait();
        
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
            System.out.println("Loading error");
            
        }
        
    }
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
    public void handleChangeInstrument()
    {   
        guitarSceneActive = FALSE;
        stage.setScene(pianoScene);
        pianoController.activeScenePiano = TRUE;
    }
    
    @FXML
    public void handlePlay()
    {
        if ("".equals(compositionContent.getText()))
        { return; }
        
        
        song1 = new GuitarSong(compositionContent.getText());
        song1.playSequence();
    }
    
        
        
    }
    

