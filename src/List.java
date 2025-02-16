

import java.io.PrintStream;
import java.util.*;

public class List{
    private Node head=null;
    private Node tail=null;

    public boolean isEmpty() {
        return head==null;
    }

    public void insertAtFront(Node my_node ){
        if(isEmpty()){
            head=my_node;
            tail=my_node;

        }

        else{
                my_node.setNext(head);
                head=my_node;

        }
    }

    public String removeFromFront() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        else{
            String removed_data=head.getData();
            if(head==tail){
                head=null;
                tail=null;
                return removed_data;


            }
            else {
                head=head.getNext();
                return removed_data;
            }

        }
    }


    public void insertAtEnd(Node my_node){
        if(isEmpty()){
            head=my_node;
            tail=my_node;
        }

        else{
            tail.setNext(my_node);
            tail=my_node;
        }
    }


    public String removeFromEnd() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            String removed_data=tail.getData();
            if(head==tail) {
                head = null;
                tail = null;

            }

            else{
                Node current =head;
                while(current.getNext()!=tail){
                    current=current.getNext();
                }
                current.setNext(null);
                tail=current;



            }

            return removed_data;
        }
    }

    public String returnFromEnd() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException();

        }
        else{

            return tail.getData();
        }

    }

    public String returnFromFront() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return head.getData();
        }
    }

    public void print(PrintStream printStream){
        if(isEmpty()){
            System.out.println("It  is empty!");
        }

        else{
            Node current=head;
            StringBuilder sb=new StringBuilder();

            sb.append("HEAD -> ");

            while(current!=null){
                sb.append(current.getData().toString());
                if(current.getNext()!=null){
                    sb.append(" -> ");
                }
                current=current.getNext();
            }
            sb.append(" <- TAIL");

            printStream.println(sb);
        }
    }

}