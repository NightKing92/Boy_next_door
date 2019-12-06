package learn.queue;

import learn.linkedlist.Node;

/**
 * 使用链表实现一个无限长的队列
 * 出队的链表节点被丢弃，在jvm中被自动回收
 * 队列一直在向后生长...
 */

public class InfiniteLinkedQueue {
    private Node head;
    private Node tail;
    /**
     *队列初始化为一个值为“nothing”的哨兵节点
     *当有第一个元素入队时，“nothing”被覆盖
     * 当最后一个元素出队时，“nothing”又被写回
     */
    public InfiniteLinkedQueue(){
        head = new Node("nothing");
        tail = head;
    }
    //无限队列没有容量限制,可以一直入队
    public boolean inQueue(String s){
        if (head==tail&&"nothing".equals(head.getValue())){
            head.setValue(s);
            return true;
        }
        tail.setNext(new Node(s));
        tail = tail.getNext();
        return true;
    }

    public boolean outQueue() throws Exception {
        if (head==tail&&"nothing".equals(head.getValue())){
            throw new Exception("对列已空，不能再出队！");
        }
        if (head==tail&&!"nothing".equals(head.getValue())){
            head.setValue("nothing");
            return true;
        }
        head = head.getNext();
        return true;
    }

//    public int size(){
//        int count = 0;
//        Node p = head;
//        while (p!=null){
//            p = p.getNext();
//            count++;
//        }
//        return count;
//    }

    public void printQueue(){
        for (Node p = head;p!=null;p = p.getNext()){
//            if (!"nothing".equals(p.getValue()))
            System.out.print(p.getValue()+" ");
        }
    }

    public static void main(String[] args) throws Exception{
        InfiniteLinkedQueue queue = new InfiniteLinkedQueue();
        queue.inQueue("1");
        queue.inQueue("2");
        queue.inQueue("3");
        queue.inQueue("4");
        queue.inQueue("5");
        queue.inQueue("6");
        queue.outQueue();
        queue.outQueue();
        queue.outQueue();
        queue.outQueue();
        queue.outQueue();
//        queue.outQueue();
        System.out.println(queue.outQueue());
        queue.inQueue("1");
        queue.inQueue("2");
        queue.inQueue("2");
        queue.inQueue("2");
        queue.inQueue("2");

        queue.printQueue();

    }

}
