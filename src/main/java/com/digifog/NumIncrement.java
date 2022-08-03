package com.digifog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class NumIncrement implements Runnable{
    List<Double> numList= new ArrayList<Double>();

    @Override
    public void run() {
        for(int i=1; i<=10;i++) {
            try {
                incrementNum();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized void incrementNum() throws InterruptedException {
        Random r =new Random();
        int low =10;
        int high=100;
        double result=r.nextInt(high-low)+low;
        double no= result;
        App a1= new App();
        App.numList.add(result);
        //numList.add(no);
        sleep(500);
        System.out.println("numList :: "+a1.getNumList()+" Thread Name :: "+ "\n" +Thread.currentThread().getName());
    }

}
