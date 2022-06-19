import java.util.Random;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"number","player","soccer", "music", "beach","beach","information","people","midnight","love","personality"};
        Scanner sc = new Scanner(System.in);

        List<Character> PlayerGuesses = new ArrayList<>();

        Random rand = new Random();
        int upperbound = 25;
        int randomnumber = rand.nextInt(upperbound - 1);

        String word = words[randomnumber];

        System.out.println("Hello! \n" +
                "Welcome to the hangman game! \n" +
                "A random word will be selected and you have to guess it before the drawing is complete. Good luck! \n" +
                "Here are the instructions: \n" +
                "You will be given the first and last letter of the word \n" +
                "You will be given a chance to guess the full word after each time you giess a letter, if you do not know it simply type a letter. \n" +
                "Each time you guess a letter it will be added to the word \n" +
                "If you type a word when you are supposed to guess a letter, only the first letter will be taken. \n" +
                "if you type a number, it will not count. \n" +
                "Each time you miss a word guess the drawing will progress.\n Have fun! :)");

        System.out.println();
        System.out.println("The firs letter of the word is: " + word.charAt(0) + ". The last letter of the word is: " + word.charAt(word.length()- 1));

        int wrongCount = 0;

        while(true){

            printState(word, playerGuesses);
            PlayerGuesses(sc, word, PlayerGuesses);

            if(printState(word, PlayerGuesses)){
                System.out.println("You win!");
                break;
            }

            System.out.println("\n Enter your guess for the word: \n");

            String guess = sc.nextLine();
            if(guess.equals(word)){

                System.out.println("\n You Win! \n");
                break;
            }
            else {
                System.out.println("\n Incorrect, try again!\n");
                wrongCount++;
            }
            if(wrongCount == 1){
                System.out.println("      |");

            }
            else if(wrongCount == 2){
                System.out.println(" ------\n     |");
            }
            else if(wrongCount == 3){
                System.out.println(" ------\n |     |");
            }
            else if(wrongCount==4){
                System.out.println(" ------\n |     |\n O");
            }
            else if(wrongCount==5){
                System.out.println(" ------\n |     |\n O\n\\");
            }
            else if(wrongCount==6){
                System.out.println(" ------\n |     |\n O\n\\ /");
            }
            else if(wrongCount==7){
                System.out.println(" ------\n |     |\n O\n\\ /\n |");
            }
            else if(wrongCount==8){
                System.out.println(" ------\n |     |\n O\n\\ /\n |\n/");
            }
            else if(wrongCount==9){
                System.out.println(" ------\n |     |\n O\n\\ /\n |\n/ \\");
            }
            if(wrongCount==9){
                System.out.println("\nYou lose!");
                break;
            }
        }

        static void PlayerGuess(Scanner sc, String word, List<Character>PlayerGuesses){
            System.out.println("\nPlease enter a letter:\n");
            String letter = sc.nextLine();

            PlayerGuesses.add(letter.charAt(0));
        }

        static boolean printState(String word, List<Character>PlayerGuesses){

            int correctCount = 0;

            for(int i = 0; i<word.length(); i++){
                if(PlayerGuesses.contains(word.charAt(i))){
                    System.out.println(word.charAt(i));
                    correctCount++;
                }
                else {
                    System.out.println("_");
                }
            }
            System.out.println();

            return (word.length()==correctCount);
        }
    }
}
