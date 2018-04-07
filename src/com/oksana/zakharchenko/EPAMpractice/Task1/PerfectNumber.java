package com.oksana.zakharchenko.EPAMpractice.Task1;

import java.util.ArrayList;

public class PerfectNumber {

    public void findNumbers(int num){
        ArrayList<Integer> perfectNumbers=findAllPerfectNumbers(num);
        printNumbers(perfectNumbers);

    }

    public  int  findSumOfAllDividers(int num){
        int sum=0;
        ArrayList<Integer> dividers=new ArrayList<>();
        for (int i=1; i<num; i++){
            if (num%i==0){
                dividers.add(i);
            }

        }

        for (int k=0; k<dividers.size(); k++){
            sum+=dividers.get(k);
        }
        return sum;
    }

    public  ArrayList<Integer> findAllPerfectNumbers(int num){
        ArrayList<Integer> perfectNumbers=new ArrayList<>();
        for (int i=1; i<=num; i++){
            if (findSumOfAllDividers(i)==i){
                perfectNumbers.add(i);
            }
        }

        return perfectNumbers;
    }

    public  void printNumbers(ArrayList<Integer> numbers){
        for (int i=0; i<numbers.size(); i++){
            System.out.println(numbers.get(i));
        }
    }
}
