package org.example;

public interface Storable {
   default void save() {
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

}
