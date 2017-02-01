/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmjhw9sequencer;

import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Jim
 */
public class Guitar implements Instrument{

    private ArrayList<Media> sounds;
    private MediaPlayer guitarPlayer;
    
    public Guitar()
    {initializeNotes();}
    
    @Override
    public void initializeNotes() { //The method initializes the array list of media, loading in each MP3 to be accessed.
        sounds = new ArrayList<Media>(13);
        
        sounds.add(new Media(this.getClass().getResource("Cmaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Dbmaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Dmaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Ebmaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Emaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Fmaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Gbmaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Gmaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Abmaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Amaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Bbmaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("Bmaj.mp3").toExternalForm()) );
        sounds.add(new Media(this.getClass().getResource("C1maj.mp3").toExternalForm()) );
    
    
    }

    @Override
    public void playNotes(int i) {
            guitarPlayer = new MediaPlayer(sounds.get(i));
            guitarPlayer.play();

    }

    
}
