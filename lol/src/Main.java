import awkward.hero.Diana;
import test.A;
import test.B;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String name = Main.getPlayerInput();
        if(name.equals("Diana")){
            Diana diana = new Diana();
            diana.r();
        }
    }
    private static String getPlayerInput(){
        System.out.println("Enter a Hero's Name");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
