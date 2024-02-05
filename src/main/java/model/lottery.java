package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class lottery {

    private static final String lotteryPath = "issueList.txt";

    static public void pushUpdateIssueList(ArrayList<Integer> prizeList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(lotteryPath))){
            for (int id: prizeList) {
                bufferedWriter.append(String.valueOf(id));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Проблема сохранения файла результатов лотереи.");
        }
    }

    public static Integer extractPrizeOutList () throws IOException {
        Integer prizeIdOut;
        File oldFile = new File(lotteryPath);
        File tempFile = new File("tmp.new");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(lotteryPath))) {
            prizeIdOut = Integer.valueOf(bufferedReader.readLine());
            while (bufferedReader.readLine() != null) {
                bufferedWriter.append(bufferedReader.readLine());
            }
            oldFile.delete();
            tempFile.renameTo(oldFile);
        } catch (IOException e) {
            throw new RuntimeException("Проблема открытия временного файла перезаписи листа выигрышей.");
        }
        return prizeIdOut;
    }

}
