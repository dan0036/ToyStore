package view;

import java.util.Scanner;

import static java.lang.System.*;

public class view {

    public int askToyFreq() {
        out.println(text.askInputFreq);
        while (true) {
            try (Scanner scan = new Scanner(System.in)) {
                int freq = scan.nextInt();
                return freq;
            }
        }
    }
}