package step.learning;
import java.io.IOException;

import step.learning.DZ.Dz_2_Files.Dz2;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            new Dz2().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
