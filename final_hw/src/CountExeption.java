public class CountExeption extends DataExeption{
    public CountExeption(String message, String text, int count){
        super(message, text);
    }

    private int count;
    public int getCount(){
        return count;
    } 
}
