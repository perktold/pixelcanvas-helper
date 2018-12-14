package Interface;

import Lesezeichen.*;

import javax.swing.*;
import java.io.IOException;

public class UI {

    public static void start(){
        while(true){

            String command = JOptionPane.showInputDialog(null ,"Menu", "", JOptionPane.QUESTION_MESSAGE);
            if(command.contains("goto")){
                go();
            } else if (command.contains("exit")){
                LesezeichenManager.save();
                System.exit(0);
            } else if (command.contains("new")){
                Lesezeichen l = new Lesezeichen(JOptionPane.showInputDialog("name"), Integer.parseInt(JOptionPane.showInputDialog("x")), Integer.parseInt(JOptionPane.showInputDialog("y")));
                LesezeichenManager.add(l);
            } else if (command.contains("del")){
                LesezeichenManager.delete(LesezeichenManager.get().getName());
            }
        }

    }

    public static void go() {

        Lesezeichen lesezeichen = LesezeichenManager.get();

        try {
            new ProcessBuilder(new String[] { "cmd", "/c", "start",
                    "http://pixelcanvas.io/@" + lesezeichen.getX() + "," + lesezeichen.getY()}).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
