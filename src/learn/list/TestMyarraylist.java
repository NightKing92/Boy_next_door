package learn.list;

public class TestMyarraylist {
    public static void main(String[] args){
        MyarraylistImpl myarraylist = new MyarraylistImpl();
        for (int i =0;i<800;i++){
            myarraylist.add(i);
        }
//        System.out.println(myarraylist.getI());
//        System.out.println("目前有"+myarraylist.size()+"个元素");
//        myarraylist.removeAll();
//        myarraylist.add("888");
        myarraylist.print();
        System.out.println();
//        System.out.println(myarraylist.get(5));
        myarraylist.insert(1, "插入");
//        System.out.println("目前有"+myarraylist.size()+"个元素");
//        System.out.println(myarraylist.getI());
        myarraylist.remove("插入");
        myarraylist.print();
        System.out.println();
        System.out.println(myarraylist.getTail());
        System.out.println(myarraylist.size());
    }
}
