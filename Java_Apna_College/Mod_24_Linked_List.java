public class Mod_24_Linked_List {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head;
    public static Node Tail;



    // methods in linkedlist
    public static int size ; // bydefault 0
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

    // Add Last in a linkedlist
    public void Add_Last(int data) {
        Node newNode = new Node(data);
        size++;
        if(Head == null ){ //by convention
            Head = Tail = newNode;
            return;
        }
        Tail.next = newNode;
        Tail = newNode;
        
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

    // Add in middle
    public void Add_in_Middle (int index , int data) { // O(n)
        if( index == 0 ){ //if index ==0 Time- O(1)
            AddFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        //traversing LL // O(n)
        int i = 0;
        Node temp = Head;
        while(i < index-1){ 
            temp = temp.next;
            i++;
        }
        // i = index-1 ; temp -> next
        newNode.next = temp.next;
        temp.next = newNode; 
    }

    //Remove First
    public int Remove_First() {
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = Head.data;
            Head = Tail = null;
            size = 0;
            return val;
        }

        int val = Head.data;
        Head = Head.next;
        size--;
        return val;
        
    }
    //remove last
    public int Remove_Last(){
        if(size == 0){
            System.out.println("LL is empty");
        }
        else if(size == 1){
            int val = Head.data;
            Head = Tail = null;
            size = 0;
            return val;
        }


        int val = Tail.data;
        Node prev = Head ;
        // prev : i = size - 2
        int i = 0; 
        while(i != size - 2){
            prev = prev.next;
            i++;
        }
        prev.next = null;
        Tail = prev;
        size --;
        return val;
        
    }

    // Search in LL iteratively
    public int Search_Iterative(int key) {
        Node temp = Head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i ;
            }

            temp = temp.next;
            i++;
            
        }
        
        return -1;            
    }


    // Search in LL Recursively
    public int Helper_Function(Node Head , int key ) {
        if(Head == null){
            return -1;
        }
        if(Head.data == key){
            return 0;
        }
        int index = Helper_Function(Head.next , key );
        if(index == -1){
            return -1;
        }
        return index + 1;
    }
    public int Recursive_Search(int key) {
        return Helper_Function(Head, key);
    }

    // Reverse a linked list
    public void Reverse_LL() { // O(N) 
        // 3 variables & 4 Steps
        Node prev = null;
        Node curr = Tail =  Head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Head = prev;

    }

    // Find and Remove Nth node from end
    public void Remove_Nth_from_last(int N) {
        //Node temp = Head;
        if(N == size){
            Head = Head.next;
            return;
        }
        int i = 1;
        Node prev = Head;
        while(i < size-N){
            prev = prev.next;
            i++;
        }

        prev.next = (prev.next).next;
        return;

    }

    // Palindrome or not!
    // slow-fast approach to find mid
    public Node Find_Mid(Node Head) {
        Node Slow = Head;
        Node Fast = Head;
        while( Fast != null && Fast.next != null ){
            Slow = Slow.next;//+1
            Fast = (Fast.next).next;//+2
        }
        return Slow;  // mid
    }
    public boolean Is_Palindrome() {
        if(Head == null || Head.next == null){
            return true;
        }
        // find mid
        Node midNode = Find_Mid(Head);

        // reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node Right = prev;
        Node left = Head;

        //check with 1st half
        while(Right!=null){
            if(Right.data != left.data){
                return false;

            }
            Right = Right.next;
            left = left.next;
        }
        return true;

    }

    
    public static void main(String[] args) {
        Mod_24_Linked_List ll = new Mod_24_Linked_List();
        ll.Print_Linked_List();
        System.out.println("Size of the linkedlist : "+ll.size);
        ll.AddFirst(1);
        ll.Print_Linked_List();
        System.out.println("Size of the linkedlist : "+ll.size);
        ll.AddFirst(2);
        ll.Print_Linked_List();
        System.out.println("Size of the linkedlist : "+ll.size);
        ll.Add_Last(3);
        ll.Print_Linked_List();
        System.out.println("Size of the linkedlist : "+ll.size);
        ll.Add_Last(4);
        ll.Print_Linked_List();
        System.out.println("Size of the linkedlist : "+ll.size);
        ll.Add_in_Middle(1, 2);
        ll.Print_Linked_List();
        System.out.println("Size of the linkedlist : "+ll.size);
        
        ll.Remove_First();
        ll.Print_Linked_List();
        System.out.println("Size of the linkedlist : " + ll.size);
        ll.Remove_Last();
        ll.Print_Linked_List();
        System.out.println("Size of the linkedlist : "+ll.size);

        System.out.println("Index is : "+ll.Search_Iterative(7)); 
        System.out.println(ll.Recursive_Search( 3));      
        
        ll.Reverse_LL();
        ll.Print_Linked_List();

        //ll.Remove_Nth_from_last(3);
        ll.Print_Linked_List();
        System.out.println(ll.Is_Palindrome()); 

    }
}
