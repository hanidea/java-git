import reflect.ISkill;
import abstraction.hero.Camille;
import abstraction.hero.Diana;
import abstraction.hero.Irelia;
import reflect.HeroFactory;
import test.A;
import test.B;

import java.awt.*;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args){
//        String name = Main.getPlayerInput();
//        switch (name) {
//            case "Diana":
//                Diana diana = new Diana();
//                diana.r();
//                break;
//            case "Irelia":
//                Irelia irelia = new Irelia();
//                irelia.r();
//                break;
//            case "Camille":
//                Camille camille = new Camille();
//                camille.r();
//                break;
//
//        }
//    }
//    public static void main(String[] args) throws Exception {
//        String name = Main.getPlayerInput();
//        ISkill iSkill;
//        switch (name){
//            case "Diana":
//                iSkill = new Diana();
//                break;
//            case "Irelia":
//                iSkill = new Irelia();
//                break;
//            case "Camille":
//                iSkill = new Camille();
//                break;
//            default:
//                throw new Exception();
//        }
//        iSkill.r();
//    }
    public static void main(String[] args) throws Exception {
        String name = Main.getPlayerInput();
        ISkill iSkill = HeroFactory.getHero(name);
        iSkill.r();
    }
    private static String getPlayerInput(){
        System.out.println("Enter a Hero's Name");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
