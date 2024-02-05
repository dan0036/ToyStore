package view;

import controller.controller;
import model.lottery;
import model.store;
import model.toy;

import java.io.IOException;
import java.util.Scanner;

public class view {

    Scanner scan = new Scanner(System.in);

    public void run() throws IOException {
        boolean key = true;
        while (key){
            System.out.print(text.mainMenu);

            switch (scan.nextInt()){
                case 0: // Открыть магазин.
                    store.pullUpdateStore(store.storePath);
                    break;
                case 1 : // Добавить игрушку в магазин
                    store.store.add(new toy(askToyTitle(),askToyQuantity(),askToyFreq()));
                    break;
                case 2: // Удалить игрушку из магазина
                    store.deleteToyByTitle(askToyTitle());
                    break;
                case 3: // Провести розыгрыш
                    controller.setFreqRange();
                    controller.setPrizeList(askPrizeQuant());
                    lottery.pushUpdateIssueList(controller.prizeList);
                    break;
                case 4: // Выдать приз
                    announcePrize(lottery.extractPrizeOutList());
                    break;
                case 5: // Завершить работу
                    store.pushUpdateStore(store.storePath);
                    scan.close();
                    key = false;
                    break;
            }
        }
    }

    public String askToyTitle() {
        System.out.println(text.askInputTitle);
            return scan.next();
    }

    public int askToyQuantity() {
        System.out.println(text.askToyQuantity);
        return scan.nextInt();
    }

    public int askToyFreq() {
        System.out.println(text.askInputFreq);
        return scan.nextInt();
    }

    public int askPrizeQuant() {
        System.out.println(text.askPrizeQuant);
        return scan.nextInt();
    }


    public void announcePrize(Integer prizeId){
        System.out.println(text.announcePrize + store.getToyTitleById(prizeId));
    }

}