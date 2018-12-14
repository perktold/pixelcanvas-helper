package Lesezeichen;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class LesezeichenManager {
    private static final String PATH = "lesezeichen.txt";
    private static ArrayList<Lesezeichen> lesezeichen = new ArrayList<Lesezeichen>();

    public static Lesezeichen get(){

        String [] names = new String[lesezeichen.size()];
        for (int i = 0; i < lesezeichen.size(); i++) {
            names[i] = lesezeichen.get(i).getName();
        }

        Object temp =  JOptionPane.showInputDialog(null, "choose", "", -1, null, names, lesezeichen.get(0));

        for(int i = 0; i < lesezeichen.size(); i++){
            if(temp.equals(lesezeichen.get(i).getName())){
                return lesezeichen.get(i);
            }
        }
        return null;
    }

    public static void add(Lesezeichen e){
        lesezeichen.add(e);
    }

    public static void delete(String name){
        for(int i = 0; i < lesezeichen.size(); i++){
            if(lesezeichen.get(i).getName().equals(name)){
                lesezeichen.remove(i);
            }
        }
    }

    public static void read(){
        try{
            BufferedReader counter = new BufferedReader(new FileReader(PATH));
            int numberOfLines = (int) counter.lines().count();
            counter.close();

            BufferedReader reader = new BufferedReader(new FileReader(PATH));

            if (numberOfLines > 0) {
                for(int i = 0; i < numberOfLines; i++) {
                    //ließt eine Zeile text
                    String temp = reader.readLine();

                    //teilt die Zeile text in x, y und Name der koordinate (bzw lesezeichen)
                    String [] subs = temp.split(" ");
                    int x = Integer.parseInt(subs[1]);
                    int y = Integer.parseInt(subs[2]);

                    lesezeichen.add(new Lesezeichen(subs[0], x, y));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save(){
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(PATH)));

            //schreibt alle lesezeichen in lesezeichen.txt, am ende ein leerer String als zeichen, dass die Datei aufhört
            //name x y (mit abständen als zeichen)
            if (lesezeichen != null) {
                for (int i = 0; i < lesezeichen.size(); i++) {
                    writer.println(lesezeichen.get(i).name + " " + lesezeichen.get(i).x + " " + lesezeichen.get(i).y);
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
