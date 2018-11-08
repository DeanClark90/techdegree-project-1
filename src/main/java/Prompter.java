import java.util.Scanner;

public class Prompter {
  
  //Declare class variable
  private Jar jar;
  
  //Declare and initialize Scanner for user input
  private Scanner input = new Scanner(System.in);
  
  //No-args constructor
  public Prompter(){}
  
  //Game Prompter constructor
  public Prompter(Jar jar){
    this.jar = jar; 
  }
  
  //Display Admin Banner
  public void displayAdminBanner(){
    System.out.println("###########ADMINISTRATOR SETUP###########"); 
  }
  
  //Display Admin Banner
  public void displayUserBanner(){
    System.out.printf("###########GUESS HOW MANY %sS ARE IN THE JAR###########%n", jar.getItem().toUpperCase()); 
  }
  
  //Initalize item to be stored in the jar
  public String initalizeItem(){
    String item;
    boolean isItem = false;  
    do{
      System.out.print("What type of item?  ");
      item = input.nextLine();
      try {
        isItem = Jar.isItem(item);
      } catch(IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
      }   
    } while(!isItem); 
    return item;
  }
  
  //Initalize the maximum ammount of an item that can be stored in a jar
  public int initalizeMaxNumberOfItem(String item){
    int maxNumberOfItem = 0;
    boolean isInteger = false;
    do {
      System.out.printf("What is the maximum amount of %s:  ", item);     
      if(input.hasNextInt()){
        isInteger = true;
        maxNumberOfItem = input.nextInt();   
      } else {
        System.out.println("Your input was invalid");
        input.next();
      } 
    } while(!isInteger);
    
    return maxNumberOfItem;
  }
  
  //Prompt for user guess and validate input
  public void promptForGuess(){
    boolean isGuess = false;
    int guess = 0;
    do {
      System.out.printf("How many %s are in the jar? Pick a number between 1 and %d  ", 
                        jar.getItem(), jar.getMaxNumberOfItem());
      
      if(input.hasNextInt()){
        guess = input.nextInt();
        try {
          jar.applyGuess(guess);
          isGuess = true;
        } catch(IllegalArgumentException iae){
          System.out.println(iae.getMessage());
        }
      } else {
        System.out.println("Your input was invalid");
        input.next();
      }
    } while(!isGuess);
  }
  
  //Display the a hint if the game isn't won else display the number of attempts the game was beatten in
  public void displayAttempts(){
    if(!jar.isWon()){
      System.out.println(jar.getHint());
    } else {
      System.out.printf("%nCongatulation you got it in %d attempts%n", jar.getNumberOfGuesses());
    }
  }
  
}