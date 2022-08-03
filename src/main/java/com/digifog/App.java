package com.digifog;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
   static List<Double> numList= new ArrayList<Double>();
    public static void main( String[] args ) {
        System.out.println("******** Java11 Concurrent Collection ********");
        Counter count = new Counter();
        count.incrementi();
        count.incrementi();
        count.incrementi();
        count.geti();
        Map<Character, LongAdder> occurance = new Hashtable<>();
        String str = "ABCD ABCD ABCD";
        /*withoutConcurrent();
        ConcurrentMap();
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
        bookList.add(new Book("The Two Towers", 1954, "0345339711"));
        bookList.add(new Book("The Return of the King", 1955, "0618129111"));
        Map<String,String> bookMap=listToMap(bookList);
        System.out.println("Boook MAP : : "+bookMap);*/

        Runnable runNum=new NumIncrement();
        Runnable derunNum=new Numdecrement();
        Thread numTh1=new Thread(runNum,"Thread1");
        numTh1.start();
        Thread numTh2=new Thread(derunNum,"Thread2");
        numTh2.start();
    }

    public void addNum(double dub){
      numList.add(dub);
    }
    public void remNum(int i){
        numList.remove(i);
    }

    public static void withoutConcurrent(){
        System.out.println("$$$$$$$$$$$$$ withoutConcurrent Method $$$$$$$$$$$$$");
        Map<Character, LongAdder> occurance =new Hashtable<>();
        String str ="ABCD ABCD ABCD";
        for (char character:str.toCharArray()){
            LongAdder longAdder = occurance.get(character);
            if(longAdder==null){
                longAdder = new LongAdder();
            }
            longAdder.increment();
            occurance.put(character,longAdder);
        }
        System.out.println(occurance);
    }

        public static Map<String, String> listToMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
    }
    public static void ConcurrentMap(){

        System.out.println("$$$$$$$$$$$$$ ConcurrentMap Method $$$$$$$$$$$$$");
        ConcurrentMap <Character, LongAdder> occurance =new ConcurrentHashMap<>();
        String str ="ABCD ABCD AABCD";
        for (char character:str.toCharArray()){
            occurance.computeIfAbsent(character,ch->new LongAdder()).increment();
            /*LongAdder longAdder = occurance.get(character);
            if(longAdder==null){
                longAdder = new LongAdder();
            }
            longAdder.increment();*/
           // occurance.put(character,longAdder);
        }
        System.out.println(occurance);
    }

    public List<Double> getNumList() {
        return numList;
    }

    public void setNumList(List<Double> numList) {
        this.numList = numList;
    }
}
