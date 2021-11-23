package main;

public class tempRun {

    public static void main(String[] args) {
        ArrayIntList list = new ArrayIntList(3);
        list.add(1);
        list.add(56);
        list.add(35);
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.size());
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());
        list.clear();
        System.out.println(list);
        list.add(45);
        list.add(560);
        list.add(29);
        System.out.println(list);
        list.add(0,345);
        list.add(4,100);
        System.out.println(list);
        SortedIntList list2 = new SortedIntList(5);
        list2.add(12);
        list2.add(35);
        list2.add(2);
        list2.add(2);
        list2.add(12);
        list2.add(2);
        list2.add(36);
        list2.add(30);
        list2.add(1);
        list2.add(100);
        System.out.println(list2);
        list2.setUnique(true);
        System.out.println(list2);
        list2.setUnique(false);
        System.out.println(list2);
        System.out.println(list2.max());
        System.out.println(list2.min());
        System.out.println(list2.indexOf(31));
    }
}
