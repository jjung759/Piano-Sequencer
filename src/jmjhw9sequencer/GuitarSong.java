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
public class GuitarSong extends Guitar{
    private String[] noteSequence;
    private int[] indexSequence;
    private Thread guitarThread;
    private String contentFromComp;
    private int noteSequenceLength;
    
    public GuitarSong(String content)
    {   this.contentFromComp = content;
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
    
    
    public int[] convertStringSequenceToIndex(String[] stringSequence){
        int length = stringSequence.length;
        int[] intArray = new int[length];
        
        for (int i = 0; i<length; i++)
        {   switch(stringSequence[i]) {
            
            case "CMaj7":
                intArray[i]=0;
                break;
            case "DbMaj7":
                intArray[i]=1;
                break;
            case "DMaj7":
                intArray[i]=2;
                break;
            case "EbMaj7":
                intArray[i]=3;
                break;
            case "EMaj7":
                intArray[i]=4;
                break;
            case "FMaj7":
                intArray[i]=5;
                break;
            case "GbMaj7":
                intArray[i]=6;
                break;
            case "GMaj7":
                intArray[i]=7;
                break;
            case "AbMaj7":
                intArray[i]=8;
                break;
            case "AMaj7":
                intArray[i]=9;
                break;
            case "BbMaj7":
                intArray[i]=10;
                break;
            case "BMaj7":
                intArray[i]=11;
                break;
            case "C1Maj7":
                intArray[i]=12;
                break;
            }
        }
        
        return intArray;
    }
    
    public void playSequence()
    {   initializeNotes();
        
        
        if (noteSequence == null)
        {   
            System.out.println("Null note sequence");
        }
        
         else if (indexSequence == null)  {
            System.out.println("Null index sequence");
        }
         else { 
             guitarThread = new Thread(new Runnable() {
                 @Override 
                 public void run(){
                      for (int i = 0; i<noteSequenceLength; i++)
                {   playNotes(indexSequence[i]);
                try {
                    Thread.sleep(525);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GuitarSong.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    
                }
                
                
                
            }
        });
        
            guitarThread.start();
        }
                 
                 
                 
    }
         
        
}
    
    
    
    

