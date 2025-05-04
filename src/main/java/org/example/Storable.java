package org.example;

import java.io.FileNotFoundException;

public interface Storable {


   default void save(String fileName) {
      System.out.println("Data is saved : ");
      //ToDO ADD THE LOGIC CODE
   }

   /**
    * Static method to test track the progress
    */
     default void trackProgress() {
     System.out.println("Tracking progress... ");
      //TODO  add the logic to track progress
   }

    /**
     * method to load info from a file
     */
    void load(String fileName) throws FileNotFoundException;

}
