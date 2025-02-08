import java.util.List;
import java.util.LinkedList;


public class BST implements WordCounter{
    private class TreeNode{
        WordFrequency item;
        TreeNode left;
        TreeNode right;
        int subtreeSize=0;

        TreeNode(WordFrequency item){
            this.item=item;
        }

        TreeNode getRight(){return right;}

        TreeNode getLeft(){return left;}

        WordFrequency getItem(){return item;}
        String toString(){
            return "Item: " + item.toString() + " size of subtree: " + Integer.toString(subtreeSize);

        }


    }

    private TreeNode head;
    private List stopWords ;
    private NumDistinctWords=0;

    private ComparatorWordFrequency comparator;

    stopWords=new LinkedList<String>();


    public void insert(String w){
        if(root=null)
            root=new TreeNode(new WordFrequency(w,1));
            NumDistinctWords++;

        TreeNode current=root;

        while(true){
            if(current.getItem().key()==w){
                current.getItem().incrementFrequency();
                return;
            }


            if(current.getItem().key().compare(w)<0){
                if(current.getRight()==null){
                    current.setRight(new TreeNode(new WordFrequency(w,1)));
                    NumDistinctWords++;
                    return;
                }
                else{
                    current=current.getRight();
                }
            }

            else{
                if(current.getLeft()==null){
                    current.setLeft(new TreeNode(new WordFrequency(w,1)));
                    NumDistinctWords++;
                    return;
                }
                else{
                    current=current.getLeft();
                }
            }


        }
    }

    public WordFrequency search(String w){

    }

    public void remove(String w){
        TreeNode current =root;
        TreeNode parent=null;

        while(true){
            if(current==null)
                return;
            if(current.getItem().key().equals(w))
                break;
            parent=current;

            if(current.getItem().key().compare(w)<0)
                current=current.getRight();
            else
                current=current.getLeft();

        }

        TreeNode replace = null;

        if(current.getLeft()==null)
            replace=current.getRight();

    }

    public int getNumDistinctWords(){
        return NumDistinctWords;
    }

    public void addStopWord(String w){
        stopWords.add(w);
    }

    public void removeStopWrod(String w){
        stopWords.remove(w);
    }




}