package learn.queue;

import learn.linkedlist.Node;

/**
 * 使用链表实现了一个循环队列
 * 提供了两种构造方法
 * 难点在于构造函数初始化一个size+1大小的循环链表
 * 其中利用了“watchman”的初始哨兵节点
 */
public class CircleLinkedQueue {
    private Node head = new Node("watchman");
    private Node tail = head;

    private final int INITSIZE = 6;

    public CircleLinkedQueue(){
        Node p = head;
        Node tmp = null;
        for (int i = 0;i < INITSIZE;i++){
            tmp = new Node(String.valueOf(i));
            p.setNext(tmp);
            p = tmp;
        }
        p.setNext(head);
    }

    public CircleLinkedQueue(int size){
        Node p = head;
        Node tmp = null;
        for (int i = 0;i < size;i++){
            tmp = new Node(String.valueOf(i));
            p.setNext(tmp);
            p = tmp;
        }
        p.setNext(head);
    }

    public void inQueue(String s) throws Exception {
        if (tail.getNext()==head)
            throw new Exception("队列已满");
        tail.setValue(s);
        tail = tail.getNext();
    }

    public void outQueue() throws Exception {
        if (head==tail)
            throw new Exception("队列已空");
        head = head.getNext();
    }

    public void print(){
        Node p = head;
        while (p!=tail){
            System.out.print(p.getValue()+" ");
            p = p.getNext();
        }
    }

    public static void main(String[] args) throws Exception{
        CircleLinkedQueue queue = new CircleLinkedQueue();
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
        queue.outQueue();
        queue.inQueue("1");
        queue.inQueue("2");
        queue.inQueue("3");
        queue.outQueue();
        queue.print();
    }
}
