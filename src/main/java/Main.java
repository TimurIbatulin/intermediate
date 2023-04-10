import Unit.*;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class Main {

    public static ArrayList<Toy> draw = new ArrayList<>();
    public static ArrayList<Toy> wind = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        int id = 0;
        int winCounter = 0;
        int st = 0;
        int rc = 0;
        int robo = 0;
        Scanner in = new Scanner(System.in);
        while (true) {
            in.nextLine();
            System.out.println("Выберете пункт меню: \n 1 - Создание нового лотта для розыгрыша; \n 2 - Проведение розыгрыша; \n 3 - Выдача приза победителю");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите количество добавляемых игрушек по категориям: \n Мягкие инрушки - ");
                    int ST = in.nextInt();
                    System.out.println("Определите вероятность выигрыша данной категории игрушек в % - ");
                    int FST = in.nextInt();
                    System.out.println("Радиоуправляемые игрушки - ");
                    int RC = in.nextInt();
                    System.out.println("Определите вероятность выигрыша данной категории игрушек в % - ");
                    int FRC = in.nextInt();
                    System.out.println("Роботы - ");
                    int Robo = in.nextInt();
                    System.out.println("Определите вероятность выигрыша данной категории игрушек в % - ");
                    int FRobo = in.nextInt();
                    for (int i = 0; i < ST; i++) {
                        id++;
                        draw.add(new SoftToy(getNameST(), 1, id, FST));
                    }
                    for (int i = 0; i < RC; i++) {
                        id++;
                        draw.add(new RCToy(getNameRC(), 1, id, FRC));
                    }
                    for (int i = 0; i < Robo; i++) {
                        id++;
                        draw.add(new robots(getNameRobo(), 1, id, FRobo));
                    }
                    break;
                case 2:
                    int wd = (int) (Math.random() * draw.size());
                    if (winCounter < 3) {
                        wind.add(draw.get(wd));
                        switch (draw.get(wd).getType()) {
                            case "Мягкая игрушка":
                                st++;
                                break;
                            case "Радиоуправляемая игрушка":
                                rc++;
                                break;
                            case "Робот":
                                robo++;
                                break;

                        }
                        winCounter++;
                        draw.remove(wd);
                        System.out.println("Первый цикл");

                    }
                    else {
                        int z = draw.size();
                        for(Toy prize: draw) {
                            if ((prize.getType() == "Мягкая игрушка") && ((100 / (st + rc + robo) * st) <= prize.getFortune())) {
                                st++;
                                wind.add(prize);
                                System.out.println(prize.getPrint());
                                draw.remove(prize);
                                break;
                            } else if ((prize.getType() == "Радиоуправляемая игрушка") && ((100 / (st + rc + robo) * rc) <= prize.getFortune())) {
                                rc++;
                                wind.add(prize);
                                System.out.println(prize.getPrint());
                                draw.remove(prize);
                                break;
                            } else if ((prize.getType() == "Робот") && ((100 / (st + rc + robo) * robo) <= prize.getFortune())) {
                                robo++;
                                wind.add(prize);
                                System.out.println(prize.getPrint());
                                draw.remove(prize);
                                break;
                            }
                        }
                        if (z == draw.size()) {
                            wind.add(draw.get(0));
                            switch (draw.get(0).getType()) {
                                case "Мягкая игрушка":
                                    st++;
                                    break;
                                case "Радиоуправляемая игрушка":
                                    rc++;
                                    break;
                                case "Робот":
                                    robo++;
                                    break;
                            }
                            System.out.println("Второй цикл");
                            draw.remove(draw.get(0));
                            }
                    }
                    break;
                case 3:
                    PrintWriter windMan = new PrintWriter((new FileWriter("windMan.txt", true)));
                    windMan.println(wind.get(0).getPrint());
                    windMan.close();
                    wind.remove(0);
            }
        }
    }



private static String getNameST(){
    String name = String.valueOf(NameST.values()[new Random().nextInt(NameST.values().length-1)]);
    return name;
}
    private static String getNameRC(){
        String name = String.valueOf(NameRC.values()[new Random().nextInt(NameRC.values().length-1)]);
        return name;
    }
    private static String getNameRobo(){
        String name = String.valueOf(NameRobo.values()[new Random().nextInt(NameRobo.values().length-1)]);
        return name;
    }
}
