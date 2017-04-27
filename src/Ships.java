import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Ships {
    private int[][] array;
    private int w=3;
    private int k=3;

    public int[][] getArray() {
        return array;
    }

    //different value than 0, 1 oraz less then four 1 ->load array from file
    public void setArray(int[][] array) {
        int howManyOnes=0;
        int loadArray=0;

        for(int i=0; i<w;i++){
            for(int j=0; j<k;j++){
                if(array[i][j]==1){
                    howManyOnes++;
                }
                if(array[i][j]!=0 && array[i][j]!=1){
                    loadArray=1;
                    System.out.println("Warning! You have enterend character different than 0 or 1!");
                }
            }
        }

        if(howManyOnes<3){
            loadArray=1;
            System.out.println("Warning! Not enough number of 1.");
        }
        if(loadArray==1){
            System.out.println("You have entered incorrect data. Array will be load from file.");
            try{
                FileReader fr = new FileReader("randomships.txt");
                Scanner sc = new Scanner(fr);

                int[][] fileArray = new int[w][k];

                String[] firstLine = sc.nextLine().split("");

                for(int i=0;i<w;i++){
                    fileArray[0][i] = Integer.parseInt(firstLine[i]);
                }

                String[] secondLine = sc.nextLine().split("");

                for(int i=0;i<w;i++){
                    fileArray[1][i] = Integer.parseInt(secondLine[i]);
                }

                String[] thirdLine = sc.nextLine().split("");

                for(int i=0;i<w;i++){
                    fileArray[2][i] = Integer.parseInt(thirdLine[i]);
                }

                this.array = fileArray;

                sc.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
        else if(loadArray==0){
            this.array = array;
        }


    }

    public Ships() {

        int[][] array = new int[w][k];
        System.out.println("Please enter where do you want to set ships. (enter 1 if you want set ship, enter 0 if not)");
        for(int i=0; i<w; i++){
            for(int j=0; j<k;j++){
                System.out.println("Do you want to set ship in: verse "+i+", column "+j+"?");
                array[i][j] = Main.sc.nextInt();
            }
        }
        this.array = array;

        setArray(this.array);
    }


    public Ships(String fileName) {

        try{
            FileReader fr = new FileReader(fileName);
            Scanner sc = new Scanner(fr);

            int[][] fileArray = new int[w][k];

            String[] firstLine = sc.nextLine().split("");


            for(int i=0;i<w;i++){
                fileArray[0][i] = Integer.parseInt(firstLine[i]);
            }

            String[] secondLine = sc.nextLine().split("");

            for(int i=0;i<w;i++){
                fileArray[1][i] = Integer.parseInt(secondLine[i]);
            }

            String[] thirdLine = sc.nextLine().split("");

            for(int i=0;i<w;i++){
                fileArray[2][i] = Integer.parseInt(thirdLine[i]);
            }

            array = fileArray;

            sc.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }


        setArray(array);
    }

    public static void startGame(int[][] player1, int[][] player2){

        int ww = 3;
        int kk = 3;

        int[][] shotsPlayer1 = new int[ww][kk];
        int[][] shotsPlayer2 = new int[ww][kk];

        for(int i=0; i<ww;i++){
            for(int j=0; j<kk;j++){
                shotsPlayer1[i][j]=0;
                shotsPlayer2[i][j]=0;
            }
        }

        int howManyCorrectShootsNeedsToWinByPlayer1=0;
        int howManyCorrectShootsNeedsToWinByPlayer2=0;

        for(int i=0; i<ww;i++){
            for(int j=0; j<kk;j++){
                if(player2[i][j]==1){
                    howManyCorrectShootsNeedsToWinByPlayer1++;
                }
            }
        }

        for(int i=0; i<ww;i++){
            for(int j=0; j<kk;j++){
                if(player1[i][j]==1){
                    howManyCorrectShootsNeedsToWinByPlayer2++;
                }
            }
        }

        int gameContinous=0;

        int howManyCorrectShootsPlayer1=0;
        int howManyCorrectShootsPlayer2=0;

        while(gameContinous!=1){

            System.out.println("Player 1 is shooting");
            System.out.println("Enter value of verse:");
            int verse1 = Main.sc.nextInt();
            while(verse1>ww-1 || verse1<0){
                System.out.println("There isn't verse that you have chosen. Try again.");
                verse1 = Main.sc.nextInt();
            }
            System.out.println("Player 1 is shooting. Enter value of column.");
            int column1 = Main.sc.nextInt();
            while(column1>kk-1 || column1<0){
                System.out.println("There isn't column that you have chosen. Try again.");
                column1 = Main.sc.nextInt();
            }

            if(player2[verse1][column1]==1){
                System.out.println("You have hitted your enemy's ship!");
                shotsPlayer1[verse1][column1] = 1;
                howManyCorrectShootsPlayer1++;
            }
            else if(player2[verse1][column1]==0){
                System.out.println("Miss. You haven't hit enemy's ship.");
                shotsPlayer1[verse1][column1] = -1;
            }

            System.out.println("Player 2 is shooting");
            System.out.println("Enter value of verse:");
            int verse2 = Main.sc.nextInt();
            while(verse2>ww-1 || verse2<0){
                System.out.println("There isn't verse that you have chosen. Try again.");
                verse2 = Main.sc.nextInt();
            }
            System.out.println("Player 2 is shooting. Enter value of column.");
            int column2 = Main.sc.nextInt();
            while(column2>kk-1 || column2<0){
                System.out.println("There isn't column that you have chosen. Try again.");
                column2 = Main.sc.nextInt();
            }

            if(player1[verse2][column2]==1){
                System.out.println("You have hitted your enemy's ship!");
                howManyCorrectShootsPlayer2++;
                shotsPlayer2[verse2][column2] = 1;
            }
            else if(player1[verse2][column2]==0){
                System.out.println("Miss. You haven't hit enemy's ship.");
                shotsPlayer2[verse2][column2] = -1;
            }


            if(howManyCorrectShootsPlayer1==howManyCorrectShootsNeedsToWinByPlayer1){
                gameContinous=1;
                System.out.println("END OF THE GAME! PLAYER 1 IS A WINNER!!!");
            }
            if(howManyCorrectShootsPlayer2==howManyCorrectShootsNeedsToWinByPlayer2){
                gameContinous=1;
                System.out.println("KEND OF THE GAME! PLAYER 2 IS A WINNER!!!");
            }

        }

    }

    @Override
    public String toString() {
        return "Ships [array=" + Arrays.deepToString(array) + "]";
    }



}
