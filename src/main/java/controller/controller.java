package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

public class controller {

    ArrayList<int> freqRange = new ArrayList();
    ArrayList prizeList = new ArrayList<>();

    public void addFreqRange(int toyId, int freq){
        if (freqRange.size() < 100) {
            int i = 0;
            while (i < freq && (i + freq) <=100 ) {
                freqRange.add(toyId);
                i++;
            }
        }
    }

    public void finalizeFreqRange(){
        int i = freqRange.size();
        while (i < 101) {
            freqRange.add(Random.from(model.store.getStoreIds());
            i++;
        }
    }

    public void setPrizeList(int prizeQuant){
        int i = 0;
        while (i < prizeQuant) {
            prizeList.add(Random.from((RandomGenerator) freqRange));
            i++;
        }
    }

}
