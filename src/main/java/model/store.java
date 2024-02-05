package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.random.RandomGenerator;

public class store {

    public static ArrayList<toy> store;
    String storePath = "store.txt";

    public static RandomGenerator getStoreIds() {
        ArrayList result = new ArrayList<>();
        for (toy toy : store) {
            result.add(toy.id);
        }
        return result;
    }

    public void pullUpdateStore(String storePath){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(storePath))){
            ArrayList filler = new ArrayList(Arrays.asList(bufferedReader.readLine().split(";")));
            store.add(new toy((int) filler.get(0), filler.get(1), (int) filler.get(2), (int) filler.get(3)));
        } catch (FileNotFoundException e) {
            try {
                Files.createFile(Path.of(storePath));
            } catch (IOException ex) {
                System.out.println("Проблемы с созданием файла ассортимента.");
                throw new RuntimeException("Проблемы с созданием файла ассортимента.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Нечитаемый файл ассортимента.");
        }
    }

    public void pushUpdateStore(String storePath){
        try (FileWriter fileWriter = new FileWriter(storePath)){
            for (toy toy: store) {
                fileWriter.write(String.join(";",
                        String.valueOf(toy.id),
                        toy.title,
                        String.valueOf(toy.quantity),
                        String.valueOf(toy.frequency)));
            }
        } catch (IOException e) {
            throw new RuntimeException("Проблема сохранения файла ассортимента.");
        }
    }



}
