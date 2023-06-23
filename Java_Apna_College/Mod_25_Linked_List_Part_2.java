import java.util.LinkedList;
import java.util.*;
public class Mod_25_Linked_List_Part_2 {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next  = null;
        }
    }
    public static Node Head;
    public static Node Tail;
    public static int size;

    
    // Add Last in a linkedlist

    //  public void Add_Last(int data) {
    //     Node newNode = new Node(data);
    //     size++;
    //     if(Head == null ){ //by convention
    //         Head = Tail = newNode;
    //         return;
    //     }
    //     Tail.next = newNode;
    //     Tail = newNode;
        
    // } 

    //Detect Cycle
    //Floyd Slow Fast Approach // Floyd Cycle Finding Algorithm
    public static boolean Detect_Cycle() {  
        Node Slow = Head;
        Node Fast = Head;

        while( Fast!=null && Fast.next != null ){
            Slow = Slow.next;
            Fast = Fast.next.next;
            if(Fast == Slow){
                return true;
            }
        }
        return false;
    }

    // Remove Cycle
    public static void RemoveCycle() {
        //detect cycle
        Node Slow = Head;
        Node Fast = Head;
        boolean IsCycle = false;
        while(Fast!= null && Fast.next != null){
            Slow = Slow.next;
            Fast = Fast.next.next;
            if(Fast == Slow){
                IsCycle = true;
                break;
            }
        }
        if(IsCycle == false){
            System.out.println(" No Cycle exists , No Removal Required ! ");
            return;
        }
        // find meeting point
        Slow = Head;
        Node prev = null;  // for tracking the last which will be previous of fast
        while (Slow != Fast) {
            Slow = Slow.next;
            prev = Fast;
            Fast = Fast.next;
        }

        //remove cycle -> last.next = null
        prev.next = null;
    }
    //add First in a linkedlist
    public void AddFirst(int data) {

        // step-1 = create new Node
       Node newNode = new Node(data);
       size++;
       // if linkedlist is empty
       if(Head == null){
           Head = Tail = newNode;
           return;
       }
       
       //step-2 ->   newNode = create new node
       newNode.next = Head;  

       //step-3 head = newNode
       Head = newNode;

    }
    // Print linkedlist
    public void Print_Linked_List() {
        // if(Head == null){
        //     System.out.println("LinkedList is empty");
        //     return;
        // }

        Node temp = Head;
        while (temp!= null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

    }

    // MergeSort 
    public Node merge(Node head1 , Node head2) {

        Node mergedLL = new Node (-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;

            }
        }   
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }
    public Node getMid(Node Head) {
        Node slow = Head;
        Node Fast = Head;
        while(Fast.next != null && Fast.next.next != null){
            slow = slow.next;
            Fast = Fast.next.next;
        }
        return slow; // mid node
    }
    public Node mergeSort(Node Head) {

        if(Head == null || Head.next == null){
            return Head;
        }

        // find mid
        Node mid = getMid(Head);

        // left & right mergeSort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(Head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);

    }



    // Zig_Zag Linked_List
    
   public void Zig_Zag_LL() {

        // find mid
        Node Slow = Head;
        Node Fast = Head;
        while(Fast.next != null && Fast.next.next != null){
            Slow = Slow.next;
            Fast = Fast.next.next;
        }
        Node mid = Slow; // middle --> last node of 1st half
        
        // Reverse 2nd half

        
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = Head;
        Node right = prev;

        // Alternate merging
        Node nextL , nextR;
        
        while(left != null && right != null){
            // zigzag merge
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextR;

            // update
            left = nextL;
            right = nextR;

        }
    }
    
    public static void main(String[] args) {
        //Mod_25_Linked_List_Part_2  ll = new Mod_25_Linked_List_Part_2();
        // Head = new Node(1);
        // Head.next = new Node(2);
        // Head.next.next = new Node(3);
        // Head.next.next.next = new Node(4);
        // Head.next.next.next.next = Head.next;

        // System.out.println( Detect_Cycle());
        // RemoveCycle();
        // System.out.println( Detect_Cycle());

        // Use classes instead of objects // Integer, Float , Character class instead of int , float , boolean object 
        LinkedList <Integer> ll = new LinkedList<>();

        // Add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(3);
        System.out.println(ll);

        // Remove
        ll.removeLast();
        System.out.println(ll);
        ll.removeFirst();
        System.out.println(ll);
        ll.addLast(6);
        ll.addLast(9);
        ll.addFirst(3);

        System.out.println(ll);

        Mod_25_Linked_List_Part_2 ll1 = new Mod_25_Linked_List_Part_2();
        ll1.AddFirst(1);
        ll1.AddFirst(2);
        ll1.AddFirst(3);
        ll1.AddFirst(4);
        ll1.AddFirst(5); 
        ll1.Print_Linked_List();
        ll1.Zig_Zag_LL();
        ll1.Print_Linked_List();
        ll1.Head = ll1.mergeSort(ll1.Head);
        ll1.Print_Linked_List();

        
     }
}
