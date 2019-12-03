package learn.linkedlist;

public class FindMidNode {
    //求单链表的中间节点
    public static Node find_mid(Node head){
        if (null==head)
            return null;
        if (null==head.getNext())
            return head;
        Node fast = head;
        Node slow = head;
        while (null!=fast.getNext()&&null!=fast.getNext().getNext()){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast==slow)
                return new Node("这他娘的是带环的链表！求个毛毛中间节点");
        }
        return slow;
    }

    public static void main(String[] args){
        Node node = new Node("1");
        node.setNext(new Node("2"));
        node.getNext().setNext(new Node("3"));
        node.getNext().getNext().setNext(new Node("4"));
        node.getNext().getNext().getNext().setNext(new Node("5"));
//        node.getNext().getNext().getNext().getNext().setNext(node.getNext().getNext());
        System.out.print(find_mid(node).getValue());
    }
}
