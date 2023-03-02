package ru.rra;


import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//        PriorityQueue<ToysShop> priorityQueue = new PriorityQueue<>(10); // компаратор в классе ToysShop
        PriorityQueue<ToysShop> priorityQueue = new PriorityQueue<>(10, new ToysComparator());

        //jsonFileRead();

//        priorityQueue.add(new ToysShop("1", "конструктор", 2));
//        priorityQueue.add(new ToysShop("3", "кукла", 6));
//        priorityQueue.add(new ToysShop("3", "кукла", 6));
//        priorityQueue.add(new ToysShop("2", "робот", 2));
//        priorityQueue.add(new ToysShop("3", "кукла", 6));
//        priorityQueue.add(new ToysShop("3", "кукла", 6));
//        priorityQueue.add(new ToysShop("2", "робот", 2));
//        priorityQueue.add(new ToysShop("3", "кукла", 6));
//        priorityQueue.add(new ToysShop("1", "конструктор", 2));
//        priorityQueue.add(new ToysShop("3", "кукла", 6));

        Gson gson = new Gson();
//        String userJson = gson.toJson(priorityQueue);
//        jsonFileCreate(userJson);
//        System.out.println(userJson);
        String s = jsonFileRead();
        System.out.println(s);
        ToysShop[] ts1 = gson.fromJson(s, ToysShop[].class);
        for (int i = 0; i < ts1.length; i++) {
            priorityQueue.add(ts1[i]);
        }
        System.out.println(priorityQueue);

        get(priorityQueue);
    }

    private static void jsonFileCreate(String userJson) {
        try{
            FileWriter fw = new FileWriter("ToysShop.json");
            fw.write(userJson);
            fw.flush();
        }
        catch (IOException e){e.printStackTrace();}
    }

    private static String jsonFileRead() {
        String data = "";
        try {
            File myObj = new File("ToysShop.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = data.concat(myReader.nextLine());
//                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }

    public static void get(PriorityQueue<ToysShop> pQ){
        int pQSize = pQ.size();
        for (int i = 0; i < pQSize; i++) {
            System.out.println(pQ.poll().getId());
        }
    }
}





