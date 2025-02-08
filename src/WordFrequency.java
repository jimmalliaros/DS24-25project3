public class WordFrequency{
    private  String word;
    private int counter;

    WordFrequency(String word,int counter){
        this.word=word;
        this.counter=counter;
    }

    public void setWord(String word){this.word=word;}

    public void setCounter(int counter){this.counter=counter;}

    public String key(){return word;}

    public int getCounter(){return counter;}

    public String toString(){
        return "word: " + word + " counter: " + Integer.toString(counter);
    }



}