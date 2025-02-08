public class WordFrequency{
    private  String word;
    private int frequency;

    WordFrequency(String word,int frequency){
        this.word=word;
        this.frequency=frequency;
    }

    public void setWord(String word){this.word=word;}

    public void setFrequency(int frequency){this.frequency=frequency;}

    public String key(){return word;}

    public int getFrequency(){return frequency;}

    public String toString(){
        return "word: " + word + " frequency: " + Integer.toString(frequency);
    }



}