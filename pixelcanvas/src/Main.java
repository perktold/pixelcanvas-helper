import Interface.UI;
import Lesezeichen.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        setup();

    }

    private  static void setup(){
        LesezeichenManager.read();
        UI.start();

    }
}
