/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmjhw9sequencer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Jim
 */


public class Piano implements Instrument {

    private Media[] sounds;
    private MediaPlayer pianoPlayer;
    
    public Piano()
    {   initializeNotes(); }
    
    @Override
    public void initializeNotes() {
        sounds = new Media[13];
        sounds[0] = new Media(this.getClass().getResource("C0.mp3").toExternalForm());
        sounds[1] = new Media(this.getClass().getResource("Db.mp3").toExternalForm());
        sounds[2] = new Media(this.getClass().getResource("D.mp3").toExternalForm());
        sounds[3] = new Media(this.getClass().getResource("Eb.mp3").toExternalForm());
        sounds[4] = new Media(this.getClass().getResource("E.mp3").toExternalForm());
        sounds[5] = new Media(this.getClass().getResource("F.mp3").toExternalForm());
        sounds[6] = new Media(this.getClass().getResource("Gb.mp3").toExternalForm());
        sounds[7] = new Media(this.getClass().getResource("G.mp3").toExternalForm());
        sounds[8] = new Media(this.getClass().getResource("Ab.mp3").toExternalForm());
        sounds[9] = new Media(this.getClass().getResource("A.mp3").toExternalForm());
        sounds[10] = new Media(this.getClass().getResource("Bb.mp3").toExternalForm());
        sounds[11] = new Media(this.getClass().getResource("B.mp3").toExternalForm());
        sounds[12] = new Media(this.getClass().getResource("C1.mp3").toExternalForm());
        
    
    
    
    }

    @Override
    public void playNotes(int i) {
      pianoPlayer = new MediaPlayer(sounds[i]);
      pianoPlayer.play();
        
        
    }
        

}
