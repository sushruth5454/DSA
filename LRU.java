import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DLLNode{
    int key,value;
    DLLNode prev;
    DLLNode next;
    DLLNode(int k,int v) {
        this.key = k;
        this.value = v;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    Map<Integer,DLLNode> cache=new HashMap<>();
    DLLNode head=new DLLNode(-1,-1);
    DLLNode tail=new DLLNode(-1,-1);
    int size;
    int capacity;
    void addNodeToHead(DLLNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        return;
    }
    void removeNode(DLLNode node){
        DLLNode prev=node.prev;
        DLLNode next=node.next;
        prev.next=next;
        next.prev=prev;
    }
    void moveToHead(DLLNode node){
        System.out.println("accessed the key :"+node.key);
        removeNode(node);
        addNodeToHead(node);
    }
    int removeFromTail(){
        DLLNode temp=tail.prev;
        cache.remove(temp.key);
        removeNode(temp);
        return  temp.key;
    }
    int get(int k){
        if(!cache.containsKey(k))
            return -1;
        DLLNode node=cache.get(k);
        moveToHead(node);
        return node.value;
    }
    void put(int k,int v){
        if(capacity>=size){
            removeFromTail();
            capacity--;
        }
        if(!cache.containsKey(k)) {
            DLLNode node = new DLLNode(k, v);
            cache.put(k, node);
            addNodeToHead(node);
            capacity++;
        }
        else {
            DLLNode node=cache.get(k);
            node.value=v;
            moveToHead(node);
        }

    }
    public void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size iof Cache");
        size = sc.nextInt();
        head.next=tail;
        tail.prev=head;
        while (true) {
            try {
                char ch;
                ch = sc.next().charAt(0);
                int k, v;
                if (ch == 'p') {
                    System.out.println("Inserting");
                    k = sc.nextInt();
                    v = sc.nextInt();
                    put(k, v);
                } else {
                    k = sc.nextInt();
                    System.out.println("Value at key " + k + " is" + get(k));
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

}
public class LRU  {
    public static void main(String []args){
        LRUCache l=new LRUCache();
        l.main();
    }
}
