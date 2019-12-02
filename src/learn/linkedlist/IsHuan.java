package learn.linkedlist;

public class IsHuan {

    public static boolean ishuan(Node head){
        if (null==head||null==head.getNext()||null==head.getNext().getNext())
            return false;
        Node fast = head;
        Node slow = head;
        while (null!=fast.getNext()&&null!=fast.getNext().getNext()){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow==fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Node node = new Node("1");
        node.setNext(new Node("2"));
        node.getNext().setNext(new Node("3"));
        node.getNext().getNext().setNext(new Node("4"));
        node.getNext().getNext().getNext().setNext(new Node("5"));
        node.getNext().getNext().getNext().getNext().setNext(node.getNext().getNext());
        System.out.print(ishuan(node));
    }
}
