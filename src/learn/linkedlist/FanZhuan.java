package learn.linkedlist;

public class FanZhuan {
//单链表反转
    public static Node reverse(Node head){
        if (null==head||null==head.getNext())
            return head;
        Node cur = head;
        Node pre = null;
        Node aft = null;
        while(null!=cur){
            aft = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = aft;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node("1");
        node.setNext(new Node("2"));
        node.getNext().setNext(new Node("3"));
        node.getNext().getNext().setNext(new Node("4"));
        node.getNext().getNext().getNext().setNext(new Node("5"));
        Node.print(reverse(node));

    }
}
