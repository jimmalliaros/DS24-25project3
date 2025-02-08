import java.util.List;
import java.util.ArrayList;


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
    private List stopWords;

    private ComparatorWordFrequency comparator;


    public void insert(String w){
        if(root=null)
            root=new TreeNode(new WordFrequency(w,1));

        TreeNode current=root;

        while(true){
            if(current.getItem().key()==w){
                current.getItem().incrementFrequency();
                return;
            }


            if(current.getItem().key().compare(w)<0){
                if(current.getRight()==null){
                    current.setRight(new TreeNode(new WordFrequency(w,1)));
                    return;
                }
                else{
                    current=current.getRight();
                }
            }

            else{
                if(current.getLeft()==null){
                    current.setLeft(new TreeNode(new WordFrequency(w,1)));
                    return;
                }
                else{
                    current=current.getLeft();
                }
            }


        }
    }



}