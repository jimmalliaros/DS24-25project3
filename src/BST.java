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

        String toString(){
            return "Item: " + item.toString() + " size of subtree: " + Integer.toString(subtreeSize);

        }



    }
}