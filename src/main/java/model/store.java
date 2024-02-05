package model;

import view.text;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class store {

    public static ArrayList<toy> store;
    public static String storePath = "store.txt";

    public static String getToyTitleById(int id) throws RuntimeException{
         for (toy toy: store)
             if (toy.id == id) {
                return toy.title;
            }
        throw new RuntimeException("Игрушка закончилась в магазине?");
    }

    public static int getToyIdByFreq(int freq) throws RuntimeException{
         for (toy toy: store)
             if (toy.frequency == freq) {
                return toy.id;
            }
        throw new RuntimeException("Игрушка закончилась в магазине?");
    }

    public static ArrayList getStoreIds() {
        ArrayList result = new ArrayList<>();
        for (toy toy : store) {
            result.add(toy.id);
        }
        return result;
    }

    public static ArrayList getStoreFreqs() {
        ArrayList result = new ArrayList<>();
        for (toy toy : store) {
            result.add(toy.frequency);
        }
        return result;
    }

    public static int getAllStoreFreqs() {
        int result = 0;
        for (toy toy : store) {
            result += toy.frequency;
        }
        return result;
    }

    public static void deleteToyByTitle(String title) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).title.equals(title)) {
                store.remove(store.get(i));
                System.out.println(text.toyDelSuccess);
                return;
            }
            System.out.println(text.toyDelUnSuccess);
        }
    }

    static public void pullUpdateStore(String storePath){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(storePath))){
            ArrayList filler = new ArrayList(Arrays.asList(bufferedReader.readLine().split(";")));
            store.add(new toy(Integer.parseInt((String) filler.get(0)), (String) filler.get(1), Integer.parseInt((String) filler.get(2)), Integer.parseInt((String) filler.get(3))));
        } catch (FileNotFoundException | NullPointerException e) {
            File newFile = new File(storePath);
        } catch (IOException e) {
            throw new RuntimeException("Нечитаемый файл ассортимента.");
        }
    }

    static public void pushUpdateStore(String storePath){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(storePath))){
            for (toy toy: store) {
                bufferedWriter.append(String.join(";",
                        String.valueOf(toy.id),
                        toy.title,
                        String.valueOf(toy.quantity),
                        String.valueOf(toy.frequency)));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("Проблема сохранения файла ассортимента.");
        }
    }



}
