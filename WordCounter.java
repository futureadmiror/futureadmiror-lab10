import java.io.BufferedReader;  
import java.io.FileReader; 
import java.io.InputStreamReader;
import java.io.FileInputStream;   
import java.io.IOException; 
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public class WordCounter {
    public static int processText(StringBuffer input, String stopword) throws InvalidStopwordException, TooSmallText{
             
            int count = 0;
            int total = 0;
            boolean found = false;
            Pattern regex = Pattern.compile("[a-zA-Z0-9']+");
            if (input != null){
            Matcher regexMatcher = regex.matcher(input);
            Matcher regexMatcher1 = regex.matcher(input);
            
            while (regexMatcher1.find()) {
                total++;
            }
             if (stopword != null){
                while (regexMatcher.find()) {
                    count++;
                    if (regexMatcher.group().equals(stopword) && total > 5){
                        found = true;
                        break;
                    }
                } 
               
            }
            else{
                count = total;
            }
            }
              if (total < 5){
                throw new TooSmallText("Only found " + total + " words.");
            }

            if (found == false && stopword != null){
                throw new InvalidStopwordException("Couldn't find stopword: " + stopword);
            }
            
        return count;
    }

    public static StringBuffer processFile(String file) throws IOException, EmptyFileException {
        boolean found = false;
        BufferedReader reader = null;
        while (!found){
            try{
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                 
                found = true;
            }
            catch(Exception e){
            System.out.println("File Path");
            Scanner scan = new Scanner(System.in);
            file = scan.nextLine();
            }
        }
        String line = reader.readLine();
        String call = "";
        while( line != null ) {
            call = call + line;
            line = reader.readLine();  
        }
        reader.close();
       if (call.equals("")) {
            throw new EmptyFileException(file + " was empty");
        }
    
        return new StringBuffer(call);
    }

    public static void main(String[] args) {
        System.out.println("Choose a process 1. file, 2. text");
        Scanner scan = new Scanner(System.in);
        int chioce = scan.nextInt();
         
        while(chioce != 1 && chioce != 2){
            System.out.println("Choose a process 1. file, 2. text");
            chioce = scan.nextInt();
        }
        
        if(chioce == 2){
            try{
                int found = processText(new StringBuffer(args[0]),args[1]);
                System.out.println("Found" + found + "words.");  

            }
            catch (Exception e){
                try{
                System.out.println("Enter a new stopword:");
                String  stopword = scan.nextLine();
                int found = processText(new StringBuffer(args[0]),stopword);
                System.out.println("Found " + found + " words.");  
                }
                catch (Exception r){
                    System.out.println(e);
                }
            }
        }
         if(chioce == 1){
            StringBuffer call = null;
            try{
            call = processFile(args[0]);
            String word = null;
            if(args.length > 1){
                    word = args[1];
                }
            int found = processText(call, word);
            System.out.println("Found " + found + " words.");
            }
            catch (Exception e){  
                try{ 
                    String word = null;
                    if(args.length > 1){
                        word = args[1];
                    }
                    System.out.println(call);
                    int found = processText(call, word);
                }
                catch (Exception r){
                     System.out.println(r);
                }
            }
            
        }
    }
}

