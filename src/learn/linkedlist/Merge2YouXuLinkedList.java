package learn.linkedlist;

public class Merge2YouXuLinkedList {
    //合并两条有序链表为一条有序链表
    /**
     * 1->3->6->10->11->12->18
     * 1->2->8
     */
    public static Node merge2List(Node head1,Node head2){
        Node head = null;
        if (null==head1&&null==head2)
            return null;
        else if (null==head1)
            return head2;
        else if (null==head2)
            return head1;
        else {
            head = new Node("");//作为哨兵节点存在
            Node cur = head;
            while (null!=head1&&null!=head2){
                Node tmp;
                if (Integer.parseInt(head1.getValue())<=Integer.parseInt(head2.getValue())){
                    tmp = new Node(head1.getValue());
                    head1 = head1.getNext();
                }else {
                    tmp = new Node(head2.getValue());
                    head2 = head2.getNext();
                }
                cur.setNext(tmp);
                cur = tmp;
            }//当一条链表走完后，之后就没有新生成Node了，直接挂在没有走完的链表节点上就结束了
            if (null!=head1){
                cur.setNext(head1);
            }
            if (null!=head2){
                cur.setNext(head2);
            }
        }
        return head.getNext();
    }

    public static void main(String[] args){
        Node node1 = new Node("1");
        node1.setNext(new Node("3"));
//        node1 = null;
        node1.getNext().setNext(new Node("6"));
        node1.getNext().getNext().setNext(new Node("10"));
        node1.getNext().getNext().getNext().setNext(new Node("11"));

        Node node2 = new Node("1");
        node2.setNext(new Node("3"));
        node2.getNext().setNext(new Node("6"));
        node2.getNext().getNext().setNext(new Node("10"));
        node2.getNext().getNext().getNext().setNext(new Node("11"));
//        node2 = null;
        Node.print(merge2List(node1, node2));
    }

}
