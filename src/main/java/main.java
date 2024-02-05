import view.view;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        view view = new view();
        try {
            view.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
