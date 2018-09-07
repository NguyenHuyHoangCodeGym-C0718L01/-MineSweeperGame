import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the size of row: ");
        int row = scanner.nextInt();
        System.out.println();
        System.out.print("Input the size of column: ");
        int column = scanner.nextInt();
        String[][] array = inputSizeArray(row, column);

        System.out.println("Input the element");
        array = inputElement(array);

        System.out.println("Display the array");
        outputArray(array);

        System.out.println("Start playing");
        playRule(array);
    }
    public static String[][] inputSizeArray(int a, int b){
        return new String[a][b];
    }

    public static String[][] inputElement(String[][] array){
        int countRow = 0;
        for(int row = 0; row <array.length; row++){
            for(int column = 0; column < array[row].length; column++){
                array[row][column] = ".";
            }
            countRow++;
        }
        int numberOfMines = (countRow * array[countRow-1].length)/2;
        Random random = new Random();
        int countMines = 0;
        while(countMines <= numberOfMines){
            int positionRow = random.nextInt(countRow-1);
            int positionColumn = random.nextInt(array[countRow-1].length);
            array[positionRow][positionColumn] = "*";
            countMines++;
        }
        return array;
    }

    public static boolean outputArray(String[][] array){
        if(array != null) {
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    System.out.print("Element at row: " + row + " column: " + column + " : " + array[row][column]+" ");
                }
                System.out.println();
            }
            return true;
        }else {
            System.out.println("Array is null");
            return false;
        }
    }

    public static void playRule(String[][] array){
        int numberOfPlay = (array.length * array[array.length-1].length);
        int countNumberPlay = 0;
        Scanner scanner = new Scanner(System.in);
        while(countNumberPlay < numberOfPlay){
            System.out.println("Input the position where you want to play: ");
            System.out.print("Input the row: ");
            int rowPlay = scanner.nextInt();
            System.out.println();
            System.out.print("Input the column: ");
            int columnPlay = scanner.nextInt();
            if(array[rowPlay][columnPlay].equals(".!")){
                System.out.println("You have just moved that position");
            }
            if(array[rowPlay][columnPlay].equals(".")){
                array[rowPlay][columnPlay] = ".!";
                System.out.println("You haven't died yet! Keep Playing");
                countNumberPlay++;
            }else if(array[rowPlay][columnPlay].equals("*")){
                System.out.println("Lose");
                break;
            }
            int count = 0;
            for(int row = 0; row < array.length; row++){
                for(int column = 0; column < array[row].length; column++){
                    if(array[row][column].equals(".!")){
                        count++;
                    }
                }
            }
            if(count == (array.length * array[array.length-1].length)/2){
                System.out.println("You won!");
                break;
            }
        }
    }
}
