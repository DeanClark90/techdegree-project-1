import java.util.Random;
import java.util.ArrayList;

public class Jar {
  
  //Declare class variables
  private final String item;
  private final int maxNumberOfItem;
  private int numberOfItem;
  private ArrayList<Integer> guesses;
  
  //Declare Class constructor
  public Jar(String item, int maxNumberOfItem){
    this.item = item;
    this.maxNumberOfItem = maxNumberOfItem;
    fill(maxNumberOfItem);
    guesses = new ArrayList<>();
  }
  
  //Method to return item stored in the jar
  public String getItem(){
    return item;
  }
  
  //Method to validate item is a not empty
  public static boolean isItem(String item){
    boolean isItem = false;
    if(item.isEmpty()){
      throw new IllegalArgumentException("Item cannot be empty");
    } else {
      isItem = true; 
    }
    return isItem;
  }
  
  //Method to return the max number of an item that can be stored in a jar
  public int getMaxNumberOfItem(){
    return maxNumberOfItem; 
  }
   
  //Method to fill the jar
  public void fill(int maxNumberOfItem){
    numberOfItem = new Random().nextInt(maxNumberOfItem) + 1;
  }
  
  //Method to apply a guess
  public void applyGuess(int guess){
    if(guess > maxNumberOfItem){
        throw new IllegalArgumentException("Your guess must be less than " + getMaxNumberOfItem());
    } else {
        guesses.add(guess);
    }
  }
  
  //Method to get hint
  public String getHint(){
    if(guesses.get(guesses.size() - 1) > numberOfItem){
      return "Your guess is too high";
    } else {
      return "Your guess is too low";
    }
  }
  
  //Method to get the number of guesses
  public int getNumberOfGuesses(){
    return guesses.size();
  }
  
  //Method to determine if the game was won
  public boolean isWon(){
    return numberOfItem == guesses.get(guesses.size() - 1); 
  }
  
  
}