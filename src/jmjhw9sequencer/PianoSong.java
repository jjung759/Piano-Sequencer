/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmjhw9sequencer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jim
 */
public class PianoSong extends Piano {
    
  
  private String[] noteSequence;
  private int[] indexSequence;
  private String contentFromComp;
  private int noteSequenceLength;
  private Thread pianoThread;
    
    
    
    public PianoSong(String content)
    {   
        this.contentFromComp = content;
        noteSequence = parseComposition(content);
        indexSequence = convertStringSequenceToIndex(noteSequence);
    }
    
    public String[] parseComposition(String content)
    {
        String compositionOriginal = content;
        String delims = "[ ]+";
        String[] noteSequence =  compositionOriginal.split(delims);
        noteSequenceLength = noteSequence.length;
        
        return noteSequence;
        
    }
    
    public void playSequence()
    {   initializeNotes();
        if (noteSequence == null)
        {   
           System.out.println("Null noteSequence");
        }
        
    else if (indexSequence == null)  {
            System.out.println("Null Sequence");
        }
        
    else {
         pianoThread = new Thread(new Runnable() {
            @Override
            public void run()
            {   for (int i = 0; i<noteSequenceLength; i++)
                {   playNotes(indexSequence[i]);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PianoSong.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    
                }
                
                
                
            }
        });
        pianoThread.start();
        
        
        
        }
        
    }
    
    public int[] convertStringSequenceToIndex(String[] stringSequence)
    {   int length = stringSequence.length;
        int[] intArray = new int[length];
        
        for (int i = 0; i<length; i++)
        {   switch(stringSequence[i]) {
            
            case "C0":
                intArray[i]=0;
                break;
            case "Db":
                intArray[i]=1;
                break;
            case "D":
                intArray[i]=2;
                break;
            case "Eb":
                intArray[i]=3;
                break;
            case "E":
                intArray[i]=4;
                break;
            case "F":
                intArray[i]=5;
                break;
            case "Gb":
                intArray[i]=6;
                break;
            case "G":
                intArray[i]=7;
                break;
            case "Ab":
                intArray[i]=8;
                break;
            case "A":
                intArray[i]=9;
                break;
            case "Bb":
                intArray[i]=10;
                break;
            case "B":
                intArray[i]=11;
                break;
            case "C1":
                intArray[i]=12;
                break;
            }
        }
        
        return intArray;
    }
    

}
    
    

