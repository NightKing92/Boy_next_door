package learn.linkedlist;


public class Node {
    private Node next;
    private String value;

    public Node(String value) {
        this.value = value;
    }

    public static void main(String[] args){
        Node node1 = new Node("1");
        Node head = node1;
        node1.next = new Node("2");
        node1.next.next = new Node("8");
        node1.next.next.next = new Node("10");
        node1.next.next.next.next = new Node("82");
        node1.next.next.next.next.next = new Node("2");
        node1.next.next.next.next.next.next = new Node("1");
        print(head);
//        System.out.println(node1.value);
//        print(reverse(head));
        System.out.println(isHuiWen(head));
    }

    public static void print(Node node1){
        for (;node1!=null;node1=node1.next){
            if (node1.next==null) {
                System.out.println(node1.value);
            }
            else
                System.out.print(node1.value+"->");
        }
    }

    public static Node reverse(Node head){
        if (null==head||null==head.next)
        return head;
        Node pre = null;
        Node cur = head;
        Node tmp = null;
        while (null!=cur){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    //空间复杂度O(1) 时间复杂度O(n)
    public static boolean isHuiWen(Node node) {
        Node head = node;
        Node tail;
        Node step1 = node;
        Node step2 = node;
        Node mid = null;

        //find mid 快慢指针
        while(step2!=null){
            if (step2.next==null||step2.next.next==null){
                mid = step1;
                break;
            }else{
                step1 = step1.next;
                step2 = step2.next.next;
            }
        }
        //System.out.println(mid.value);
        //反转后段链表指针
        tail = reverse(mid);
        print(head);
        print(tail);
        //两端同时遍历比较
        if (head.value!=tail.value)
            return false;
        while (head!=mid&&tail!=mid){
            if (head.value!=tail.value)
                return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
}