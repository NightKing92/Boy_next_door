package learn.list;

public class MyarraylistImpl implements Iarraylist {

    private int head = 0;//首部指针
    private int tail = 0;//尾部指针
    private int i = -1;//游走指针
    Object[] array;

    public MyarraylistImpl(){
        array = new Object[10];
        tail = 9;
    }

    public MyarraylistImpl(int size){
        array = new Object[size];
        tail = size - 1;
    }

//做为debug方法存在，开发完成后删除
    public int getI() {
        return i;
    }
    public int getTail() { return tail; }

    @Override
    public void add(Object o) {
        if (i<tail){
            array[++i] = o;
        }else {
            while (i>=tail){
                array = autoIncrease();
                tail = array.length-1;
            }
            array[++i] = o;
        }
    }

    private Object[] autoIncrease() {
        Object[] bigger = new Object[(int) ((tail + 1) * 1.5)];
        for (int p=0;p<array.length;p++){
            bigger[p] = array[p];
        }
        return bigger;
    }

    @Override
    public boolean insert(int index, Object o) {
        if (i<tail&&index<=i){
            int tmp = i;
            while (tmp>=index){
                array[tmp+1] = array[tmp];
                tmp--;
            }
            array[index] = o;
            i++;
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return array[i];
    }

    @Override
    public void remove(Object o) {
        for (int p = 0;p<=i;p++){
            if (o==array[p]||o.equals(array[p])){
                int tmp = p;
                while (tmp<i){
                    array[tmp] = array[tmp+1];
                    tmp++;
                }
                i--;
                break;
            }
        }
    }

    @Override
    public void removeAll() {
        i = -1;
    }

    @Override
    public int size() {
        return i+1;
    }

    @Override
    public void print() {
        for (int p=0;p<=i;p++)
            System.out.print(array[p]+"  ");
    }
}
