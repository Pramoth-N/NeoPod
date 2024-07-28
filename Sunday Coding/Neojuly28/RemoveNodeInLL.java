import java.util.*;

class Node {
    int key;
    Node next;
    
    Node(int key) {
        this.key = key;
        this.next = null;
    }
}

class RemoveNodeInLL {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        Node head = null;
        
        int n = sc.nextInt();
        
        for(int i=0;i<n;i++) {
            head = insert(head , sc.nextInt());
        }
        
        head = removeNode(head);
        
        print(head);
    }
    
    private static Node insert(Node head , int key) {
        Node temp = new Node(key);
        
        if(head == null){
            head = temp;
            return head;
        }
        Node ptr = head;
        
        while(ptr != null) {
            ptr = ptr.next;
        }
        
        ptr.next = temp;
        
        return head;
    }
    
    private static Node removeNode(Node head) {
        if(head == null) {
            return null;
        }
        
        Node temp = new Node(0);
        temp.next = head;
        Node prev = head , cur = head.next;
        
        while(cur != null) {
            Node Next = cur.next;
            boolean remove = false;
            
            while(Next != null) {
                if(Next.key > cur.key) {
                    remove = true;
                    break;
                }
            }
            
            if(remove) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            
            cur = cur.next;
        }
        
        return head.next;
    }
    
    private static void print(Node head) {
        while(head != null) {
            System.out.print(head.key);
            head = head.next;
        }
    }
}