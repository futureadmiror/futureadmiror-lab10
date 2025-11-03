public class TooSmallText extends Exception{

  public TooSmallText(String word){ 
    super(word);
}  

public String toString() {
        return "TooSmallText: " + getMessage();
    }
}

