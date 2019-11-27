package learn.list;

//有简单的自动扩容功能
//插入和删除的操作复杂度很高，还没有做优化
public interface Iarraylist {

    public void add(Object o);

    public boolean insert(int index, Object o);

    public Object get(int index);

    public void remove(Object o);

    public void removeAll();

    public int size();

    public void print();

}
