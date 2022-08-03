package com.digifog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Numdecrement implements Runnable{
    List<Double> numList= new ArrayList<Double>();

    @Override
    public void run() {
        try {

        for(int i=1; i<=10;i++) {
            sleep(3000);
                decrementNum(i);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    synchronized void decrementNum(int i) throws InterruptedException {
        Random r =new Random();
        App a1= new App();
        App.numList.remove(i);
        //    numList.remove(i);

        System.out.println("numList :: "+a1.getNumList()+" Thread Name :: "+ Thread.currentThread().getName());
    }

}
