package ru.rra;
import org.json.JSONArray;
import org.json.JSONString;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        PriorityQueue<ToysShop> priorityQueue = new PriorityQueue<>(10); // компаратор в классе ToysShop
        PriorityQueue<ToysShop> priorityQueue = new PriorityQueue<>(10, new ToysComparator());


        priorityQueue.add(new ToysShop("1", "конструктор", 2));
        priorityQueue.add(new ToysShop("3", "кукла", 6));
        priorityQueue.add(new ToysShop("3", "кукла", 6));
        priorityQueue.add(new ToysShop("2", "робот", 2));
        priorityQueue.add(new ToysShop("3", "кукла", 6));
        priorityQueue.add(new ToysShop("3", "кукла", 6));
        priorityQueue.add(new ToysShop("2", "робот", 2));
        priorityQueue.add(new ToysShop("3", "кукла", 6));
        priorityQueue.add(new ToysShop("1", "конструктор", 2));
        priorityQueue.add(new ToysShop("3", "кукла", 6));

//        JSONArray js = new JSONArray();
//        for(ToysShop t: priorityQueue){
//            js.put(t);
//        }
//        System.out.println("-------------");
//        System.out.println(js);
//        System.out.println("-------------");



        get(priorityQueue);
    }

    public static void get(PriorityQueue<ToysShop> pQ){
        int pQSize = pQ.size();
        for (int i = 0; i < pQSize; i++) {
            System.out.println(pQ.poll().getId());
        }
    }
}





