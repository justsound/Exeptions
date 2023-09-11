public class DataExeption  extends Exception{

    private String text;

    public DataExeption (String message, String text){
        super(message);
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
