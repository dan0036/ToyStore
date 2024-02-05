package controller;

import model.store;
import java.util.ArrayList;
import java.util.Random;

public class controller {

    static ArrayList freqRange = new ArrayList();
    public static ArrayList prizeList = new ArrayList<>();



    public static void setFreqRange(){
        ArrayList<Integer> storeFreqList = new ArrayList<>(store.getStoreFreqs());
        int sumAllFreqs = store.getAllStoreFreqs();
        for (int freq: storeFreqList) {
            int weight = (freq*10) / sumAllFreqs;
            while (weight > 0) {
                freqRange.add(store.getToyIdByFreq(freq));
                weight--;
            }
        }
    }

    static public void setPrizeList(int prizeQuant){
        int i = 0;
        while (i < prizeQuant) {
            Random random = new Random();
            prizeList.add(freqRange.get(random.nextInt(0, freqRange.size())));
            i++;
        }
    }

}
