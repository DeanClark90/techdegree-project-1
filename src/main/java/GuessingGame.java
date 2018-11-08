public class GuessingGame {
    public static void main(String[] args) {
      //Declare Main Method variables
      String item;
      int maxNumberOfItem;
      Jar jar; 
      
      //Declare and initialize no-args constructer for the prompter class
      Prompter prompter = new Prompter(); 
      
      //Display admin menu and retrieve input
      prompter.displayAdminBanner();
      item = prompter.initalizeItem();
      maxNumberOfItem = prompter.initalizeMaxNumberOfItem(item);
      jar = new Jar(item, maxNumberOfItem);
      prompter = new Prompter(jar);
      
      //Displaye user game banner, and prompt user for guesses
      prompter.displayUserBanner();
      do {
        prompter.promptForGuess();
        prompter.displayAttempts();
        
      } while(!jar.isWon());
        
    }
}
