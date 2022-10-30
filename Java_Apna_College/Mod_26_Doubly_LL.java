public class Mod_26_Doubly_LL {
    public class Node{
        int data ;
        Node next;
        Node prev;
        
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void Print_Doubly_LL(){
        System.out.print("null <- ");
        Node temp = head;
        while (temp!= null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    //Add 
    // Add First
    public  void add_First(int data ) {
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    } 
    // Add Last
    public void addLast(int data) {
        Node newNode = new Node (data);
        size++;
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        
    }
    //Remove 
    //Remove First
    public int RemoveFirst(){
        if(size == 0){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }
    //Remove Last

    public int RemoveLast(){
        if(size == 0){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size --;
        return val;
    }

    // Reverse a DLL
    public void ReverseDLL() {
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        head = prev;

    }
    public static void main(String[] args) {
        Mod_26_Doubly_LL dll =new Mod_26_Doubly_LL();
        dll.add_First(3);
        dll.Print_Doubly_LL();
        System.out.println("Size is : "+dll.size);
        dll.add_First(2);
        dll.Print_Doubly_LL();
        System.out.println("Size is : "+dll.size);
        dll.add_First(1);
        dll.Print_Doubly_LL();
        System.out.println("Size is : "+dll.size);
        dll.add_First(4);
        dll.Print_Doubly_LL();
        dll.RemoveFirst();
        dll.Print_Doubly_LL();
        System.out.println(dll.size);
        dll.RemoveLast();
        dll.Print_Doubly_LL();
        System.out.println(dll.size);
        dll.addLast(6);
        dll.Print_Doubly_LL();
        dll.ReverseDLL();
        dll.Print_Doubly_LL();
    }
}
