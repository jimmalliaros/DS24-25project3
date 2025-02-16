

public class Node{
    protected  String data;
    protected  Node next=null;


    Node(String data){
        this.data=data;
    }

    public void setNext(Node my_node){
        this.next=my_node;
    }

    public Node getNext(){
        return this.next;
    }

    public void setData(String data){
        this.data=data;
    }

    public String getData(){
        return data;
    }






}