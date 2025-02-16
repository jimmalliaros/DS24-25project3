import  java.util.Comparator;

public class ComparatorWordFrequency implements  Comparator<WordFrequency>{

    public int compare(WordFrequency wf1,WordFrequency wf2){
        String s1=wf1.key();
        String s2=wf2.key();
        return s1.compareTo(s2);
    }


}