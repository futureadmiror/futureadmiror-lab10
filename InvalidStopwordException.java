public class InvalidStopwordException extends Exception{

    public InvalidStopwordException(String word){
    super(word);
}

public String toString() {
        return "InvalidStopwordException: " + getMessage();
    }
}
