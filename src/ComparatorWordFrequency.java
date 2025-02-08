public class ComparatorWordFrequency implements  Comparator<WordFrequency>{

    public int compare(WordFrequency wf1,WordFrequency wf2){
        return wf1.getFrequency() - wf2.getFrequency();
    }

    
}