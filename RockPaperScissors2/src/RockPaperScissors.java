
/**
 * A simple rock paper scissors game
 * keep a running score
 * only accepts valid inputs
 * uses a loop to play several times
 * @author Stephen Wong
 * @version 8/10/16
 */
import java.util.*;
public class RockPaperScissors
{
    static Scanner scanner = new Scanner(System.in);
    Random ai = new Random();
    static String[] rps = {"Rock", "Paper", "Scissors"};
    public static void main(String[] args){
        System.out.print('\f');
        int wins = 0;
        int draws = 0;
        int losses = 0;
        boolean running = true;
        System.out.println("Started.");
        System.out.println("Press Enter to start");
        scanner.nextLine();

        while(running == true){
            
            System.out.println("Choose your weapon. 'Rock', 'Paper' or 'Scissors'?");
            String aiChoice = rps[(int)(Math.random()*(rps.length))]; //generate a random number and lookup in the rps array
            String plChoice = scanner.nextLine();
            boolean goodChoice = false;
            while(goodChoice == false){
                if(plChoice.equalsIgnoreCase("rock") || plChoice.equalsIgnoreCase("paper")||plChoice.equalsIgnoreCase("scissors")){
                    goodChoice = true;
                }
                else{
                    goodChoice = false;
                }
            
                if(goodChoice == false){
                    System.out.println("You must enter 'Rock', 'Paper' or 'Scissors'.");
                    plChoice = scanner.nextLine();
                }
            }
            System.out.println("The computer chose " + aiChoice);
            System.out.println("You chose " + plChoice);
            
            if(rpsGame(plChoice.toLowerCase(),aiChoice.toLowerCase()).equals("draw")){
                    System.out.println("It is a draw!");
                    draws++;
            }
            if(rpsGame(plChoice.toLowerCase(),aiChoice.toLowerCase()).equals("lose")){
                    System.out.println("You lose!");
                    losses++;
            }
            if(rpsGame(plChoice.toLowerCase(),aiChoice.toLowerCase()).equals("win")){
                    System.out.println("You win!");
                    wins++;
            }
            System.out.println("Your Score is: "+ wins + " - " + draws+" - "+ losses);
            System.out.println("Do you want to play again y/n?");
            String answer = scanner.nextLine();
            boolean nextChoice = false;
            while (nextChoice == false){
            if(answer.equalsIgnoreCase("y")){
                nextChoice = true;
                System.out.print('\f');
                continue;}
            else{
                if(answer.equalsIgnoreCase("n")){
                    running = false;
                    System.out.println("Finished");
                    break;
                }
                if(!answer.equalsIgnoreCase("n")){
                    System.out.println("Type 'y' or 'n' to continue");
                    answer = scanner.nextLine();
                }
            }
            }
    }
}
public static String rpsGame(String x, String y){
            int xIndex = -1;
            int yIndex = -1;
            String result;
            for(int i=0;i<rps.length;i++){
                if(rps[i].equalsIgnoreCase(x)){
                    xIndex = i;
                    
                } 
                if(rps[i].equalsIgnoreCase(y)){
                    yIndex = i;
                }
            }
            //String rpsGame(String x, String y){//String rpsGame(String plChoice, String aiChoice)
            //ensure x, y are not case sensitive 
            int diffIndex = xIndex - yIndex;
            if(diffIndex >0){
                if(diffIndex < 2){
                    result = "win";
                }else{
                    result = "lose";
                }
            }else
            if (diffIndex<0){
                    if(diffIndex> -2){
                        result = "lose";
                    }else{
                        result = "win";
                    }
            }else
            if (diffIndex == 0){
                result = "draw";
                }else{
                    result = "error";
                }
            return result;
        }      
    }
