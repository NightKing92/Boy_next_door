package learn.linkedlist;

public class DeleteReverseNNode {
    //删除倒数的第n个链表节点
    public static Node delReverseNNode(Node head,int n) throws Exception {
        if (n<=0)
            throw new Exception("倒数第"+n+"含义不正确！");
        if (null==head)
            return null;
        int count = 0;
        Node tmp = head;
        while (null!=tmp){
            tmp = tmp.getNext();
            count++;
        }
        if (count<n)
            return new Node("这怎么可能发生，输错了吧老铁！");
        if (count==1&&n==1)
            return null;
        if (count==n)
            return head.getNext();
        Node cur = head;
        if (count>n){
            if (n==1){
                for (int i=0;i<count-2;i++){
                    cur = cur.getNext();
                }
                cur.setNext(null);
            }else{
                for (int i=0;i<count-n-1;i++){
                    cur = cur.getNext();
                }
                cur.setNext(cur.getNext().getNext());
            }
        }
        return head;
    }

    public static void main(String[] args){
        Node node = new Node("1");
        node.setNext(new Node("2"));
//        node.getNext().setNext(new Node("3"));
//        node.getNext().getNext().setNext(new Node("4"));
//        node.getNext().getNext().getNext().setNext(new Node("5"));
        try {
            Node.print(delReverseNNode(node, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
