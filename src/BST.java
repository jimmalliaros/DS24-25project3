import java.util.List;
import java.util.LinkedList;
import  java.util.Stack;
import  java.io.PrintStream;
import  java.util.Scanner;
import  java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;


public class BST /*implements WordCounter*/{
    private class TreeNode{
        WordFrequency item;
        TreeNode left;
        TreeNode right;
        int subtreeSize=0;

        TreeNode(WordFrequency item){
            this.item=item;
        }

        public void setRight(TreeNode right){this.right=right;}
        public void setLeft(TreeNode left){this.left=left;}

        TreeNode getRight(){return right;}

        TreeNode getLeft(){return left;}

        WordFrequency getItem(){return item;}
        public String toString(){
            return "Item: " + item.toString() + " size of subtree: " + Integer.toString(subtreeSize);

        }


    }

    private TreeNode head;
    private List<String> stopWords =new LinkedList<String>();
    private int NumDistinctWords=0;

    private ComparatorWordFrequency comparator;




    public void insert(String w){
        if(head==null)
            head=new TreeNode(new WordFrequency(w,1));
            NumDistinctWords++;

        TreeNode current=head;

        while(true){
            if(current.getItem().key()==w){
                current.getItem().incrementFrequency();
                return;
            }


            if(current.getItem().key().compareTo(w)<0){
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


        TreeNode current=head;
        while(true){
            if(current==null)
                return new WordFrequency(w,0);
            if(current.getItem().key().equals(w))
                return current.getItem();
            if(current.getItem().key().compareTo(w)<0)
                current.getRight();
            else
                current=current.getLeft();
        }

    }

    public void remove(String w){
        TreeNode current =head;
        TreeNode parent=null;

        while(true){
            if(current==null)
                return;
            if(current.getItem().key().equals(w))
                break;
            parent=current;

            if(current.getItem().key().compareTo(w)<0)
                current=current.getRight();
            else
                current=current.getLeft();

        }

        TreeNode replace = null;

        if(current.getLeft()==null)
            replace=current.getRight();

        else if(current.getRight()==null){
            replace=current.getLeft();
        }

        else{
            TreeNode findCurrent = current.getRight();


        }

    }

    public void load(String filename) throws FileNotFoundException{
        File my_file=new File(filename);
        Scanner file_scanner=new Scanner(my_file);
        StringBuilder sb=new StringBuilder("");

        for(String s:stopWords){
            sb.append(s+"|");
        }



        while(file_scanner.hasNextLine()){
            String my_line=file_scanner.nextLine();
            Scanner linescanner = new Scanner(my_line);


            while(linescanner.hasNext()){
                String s=linescanner.next();
                if(s.matches(sb.toString())){
                    continue;
                }

                else{
                    insert(s);
                }
            }
        }



    }
    public int getNumDistinctWords() {

        int result = 0;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = head;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();

            }
            current = stack.pop();
            result += current.getItem().getFrequency();
            current = current.getRight();
        }


        return result;


    }


    public int getNumTotalWords(){
        return 0;
    }
    public int getFrequency(String w){

        TreeNode current=head;

        while(true){
            if(current==null)
                return 0;
            if(current.getItem().key().equals(w))
                return current.getItem().getFrequency();

            if(current.getItem().key().compareTo(w)<0)
                current=current.getRight();
            else
                current=current.getLeft();
        }

    }

    public WordFrequency getMaxFrequency() {

        Stack<TreeNode> stack =new Stack<>();
        TreeNode current=head;
        WordFrequency max=new WordFrequency(null,-1);

        while(current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current=current.getLeft();
            }

            current=stack.pop();
            if(current.getItem().getFrequency()>max.getFrequency()){
                max=current.getItem();
            }
            current=current.getRight();
        }

        return max;

    }

    public double getMeanFrequency(){

        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=head;
        int sum=0;

        while(current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current=current.getLeft();
            }

            current=stack.pop();
            sum+=current.getItem().getFrequency();
            current.getRight();
        }

        double result= sum * 1.0 /getNumDistinctWords();

        return result;
    }








    public void printTreeByWord(PrintStream stream){
            Stack<TreeNode> stack=new Stack<TreeNode>();
            TreeNode current=head;

            while(current!=null || !stack.isEmpty()){
                while(current!=null){
                    stack.push(current);
                    current=current.getLeft();
                }
                current=stack.pop();
                stream.println(current.getItem().toString());

                current=current.getRight();
            }

    }

    public void addStopWord(String w){
        stopWords.add(w);
    }

    public void removeStopWrod(String w){
        stopWords.remove(w);
    }








}