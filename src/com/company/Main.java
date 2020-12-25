package com.company;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<Integer> myList = new MyLinkedList<>();


        myList.add(32);
        myList.add(322);
        myList.add(321);
        myList.add(32111);

        myList.add(4,3);
        myList.add(2,3);

        myList.add(666);
        myList.remove(4);
        myList.set(1,1);


        System.out.println();


        for (Integer integer : myList) {
            System.out.println(integer);
        }

        System.out.println();

        Iterator<Integer> iterRev = myList.iteratorReverse();
        while (iterRev.hasNext()) {
            System.out.println(iterRev.next());
        }


        System.out.println(myList.toString());






    }
}
