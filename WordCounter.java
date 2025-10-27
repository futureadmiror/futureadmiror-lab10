import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public class WordCounter {

    public int processText(StringBuffer input, String stopword){

    }

    public StringBuffer processFile(String word){

    }

    public static void main(String[] args) {
    while(args[2] != 1 || args[2] != 2){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a process 1. text, 2. file");
        String input = scan.nextLine();
        if(input == 1){
            System.out.println(processText(input, word));
        }

         if(input == 2){
            processFile(word);
        }
    }



    }
}
