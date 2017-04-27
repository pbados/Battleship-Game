import java.util.Scanner;


public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("===BATTLESHIP GAME===");
        System.out.println("Do you want to set ships on board by yourself (press 0) oraz load random board from file (press 1).");
        int choice = sc.nextInt();
        while(choice != 0 && choice !=1){
            System.out.println("There's no option that you have chosen.");
            System.out.println("Do you want to set ships on board by yourself (press 0) oraz load random board from file (press 1).");
            choice = sc.nextInt();
        }
        if(choice==0){
            System.out.println("Player 1 is setting ships on board:");
            Ships shipsPlayer1 = new Ships();
            System.out.println("Ships Player 1: "+shipsPlayer1.toString());
            System.out.println("Player 2 is setting ships on board:");
            Ships shipsPlayer2 = new Ships();
            System.out.println("Ships Player 2: "+shipsPlayer2.toString());
            Ships.startGame(shipsPlayer1.getArray(), shipsPlayer2.getArray());
        }else{
            Ships shipsPlayer1 = new Ships("shipsPlayer1.txt");
            Ships shipsPlayer2 = new Ships("shipsPlayer2.txt");

            int[][] arr1 = shipsPlayer1.getArray();
            int[][] arr2 = shipsPlayer2.getArray();

            Ships.startGame(arr1, arr2);
        }

    }

}
