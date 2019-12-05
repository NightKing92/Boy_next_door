package learn.queue;

/**
 * 数组方式实现循环队列
 * 核心在于判断队列空和队列满时的判断条件
 */
public class CircleQueue {
    private int head;
    private int tail;
    private int[] queue = null;
    private int size = 6;//初始化的数组长度为6，实际队列队列最多只能存5个元素，以此类推...

    public CircleQueue(){
        queue = new int[size];
        head = 0;
        tail = 0;
    }

    public CircleQueue(int size){
        queue = new int[size];
        head = 0;
        tail = 0;
        this.size = size;
    }

    public boolean inQueue(int num){
        if ((tail+1)%size == head)
            return false;
        else {
            queue[tail] = num;
            tail = tail+1==size?0:tail+1;
            return true;
        }
    }

    public boolean outQueue(){
        if (head==tail)
            return false;
        else {
            head = head+1==size?0:head+1;
            return true;
        }
    }

    public void print(){
        if ((tail+1)%size == head){
            System.out.println("队列已满！");
        }
        if (head==tail){
            System.out.println("队列为空！");
            return;
        }
        if (head<tail){
            for (int i = head;i < tail;i++)
                System.out.print(queue[i]+" ");
        }
        if (head>tail){
            for (int i = head;i < queue.length;i++)
                System.out.print(queue[i]+" ");
            for (int i = 0;i < tail;i++)
                System.out.print(queue[i]+" ");
        }
    }

    public static void main(String[] args){
        CircleQueue c = new CircleQueue();
        System.out.println(c.inQueue(1));
        System.out.println(c.inQueue(2));
        System.out.println(c.inQueue(3));
        System.out.println(c.inQueue(4));
        System.out.println(c.inQueue(5));
        System.out.println(c.outQueue());
        System.out.println(c.inQueue(6));
        System.out.println(c.outQueue());
        System.out.println(c.inQueue(7));
        System.out.println(c.outQueue());
        System.out.println(c.outQueue());
        System.out.println(c.outQueue());
        System.out.println(c.outQueue());
        System.out.println(c.inQueue(8));
        System.out.println(c.inQueue(9));
        System.out.println(c.inQueue(10));
//        System.out.println(c.inQueue(11));

        c.print();
    }
}
