package ru.rra;


import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<ToysShop> priorityQueue = new PriorityQueue<>(10, new ToysComparator());

        Gson gson = new Gson();
        ToysShop[] toysShops = gson.fromJson(readToysFormJsonFile(), ToysShop[].class);

        for (int i = 0; i < toysShops.length; i++) {
            priorityQueue.add(toysShops[i]);
        }

        getToysFromPriorityQueue(priorityQueue);
    }


    private static String readToysFormJsonFile() {
        String data = "";
        try {
            File myObj = new File("ToysShop.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = data.concat(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }

    public static void getToysFromPriorityQueue(PriorityQueue<ToysShop> pQ){
        String result;
        int pQSize = pQ.size();
        try {
            FileWriter fw = new FileWriter("result.txt");
            for (int i = 0; i < pQSize; i++) {
                result = pQ.poll().getId();
                System.out.println(result);
                fw.write(result);
            }
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}





