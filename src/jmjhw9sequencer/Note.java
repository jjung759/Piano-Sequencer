/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmjhw9sequencer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.AudioStream;


/**
 *
 * @author Jim
 */
public class Note {
    
    private URL soundFile;
    private Clip clip;
    
    
    
    
    public Note() throws LineUnavailableException, IOException, UnsupportedAudioFileException 
    {  // System.out.println(soundPath);
       /* try {
         // Use URL (instead of File) to read from disk and JAR.
         URL url = this.getClass().getClassLoader().getResource(soundPath);
         if (url == null)
         {  System.out.println("Errror: Null URL"); }
         // Set up an audio input stream piped from the sound file.
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
         if (audioInputStream == null)
         {  System.out.println("No audioInputStream"); }
         // Get a clip resource.
         clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioInputStream);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
      */
      /* File file = new File("A.wav");
      if (file == null)
       {    System.out.println("Null File"); }
       else {
           System.out.println("File created"); 
       } */
      InputStream stream = this.getClass().getResourceAsStream("A.mp3");
      if (stream == null)
      { System.out.println("Cannot load file for some reason."); }
      AudioInputStream audioIS = AudioSystem.getAudioInputStream(stream);
      
     // clip = AudioSystem.getClip();
     // clip.open(audioIS);
       
       
       
    }

    public void play() {
      
         if (clip.isRunning())
         {   clip.stop(); } 
         clip.setFramePosition(0); 
         clip.start();   
      
   }
}
