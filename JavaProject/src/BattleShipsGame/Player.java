package BattleShipsGame;

import java.util.Scanner;

public class Player {
    Boards bds=new Boards();
    Scanner input=new Scanner(System.in);

    public Player() {
        bds.getBoardA();
        bds.getBoardB();
    }
    public void PlayerSetUp(){
        System.out.println("Now it is time to set up your ships.");
        bds.printBoardA();
        System.out.println("The first ship is an carrier of size 5.");
        System.out.println("What direction you like to place it in? Enter 'u' for up,'d' for down,'r' for right and 'l for left'");
        char dir=input.next().charAt(0);
        System.out.println("Now enter the X-Coordinate: ");
        int Xcord=input.nextInt();
        System.out.println("Now enter the Y-Coordinate: ");
        int Ycord=input.nextInt();
        Coordinate crd=new Coordinate(Xcord,Ycord);
        Ship carrier=new Ship('A',dir,crd);
        while(!bds.validLocation(crd, carrier)){
            System.out.println("That is an invalid location.Please enter again");
            System.out.println("Now enter the X-Coordinate: ");
            int NewXcord=input.nextInt();
            System.out.println("Now enter the Y-Coordinate: ");
            int NewYcord=input.nextInt();
            crd=new Coordinate(NewXcord,NewYcord);
            carrier=new Ship('A',dir,crd);
        }
        bds.placeShips(crd, carrier);
        bds.printBoardA();

        System.out.println("The second ship is an battleship of size 4.");
        System.out.println("What direction you like to place it in? Enter 'u' for up,'d' for down,'r' for right and 'l for left'");
        dir=input.next().charAt(0);
        System.out.println("Now enter the X-Coordinate: ");
        Xcord=input.nextInt();
        System.out.println("Now enter the Y-Coordinate: ");
        Ycord=input.nextInt();
        crd=new Coordinate(Xcord,Ycord);
        Ship battleship=new Ship('B',dir,crd);
        while(!bds.validLocation(crd, carrier)){
            System.out.println("That is an invalid location.Please enter again");
            System.out.println("Now enter the X-Coordinate: ");
            int NewXcord=input.nextInt();
            System.out.println("Now enter the Y-Coordinate: ");
            int NewYcord=input.nextInt();
            crd=new Coordinate(NewXcord,NewYcord);
            battleship=new Ship('B',dir,crd);
        }
        bds.placeShips(crd, battleship);
        bds.printBoardA();

        System.out.println("The third ship is an cruiser of size 3.");
        System.out.println("What direction you like to place it in? Enter 'u' for up,'d' for down,'r' for right and 'l for left'");
        dir=input.next().charAt(0);
        System.out.println("Now enter the X-Coordinate: ");
        Xcord=input.nextInt();
        System.out.println("Now enter the Y-Coordinate: ");
        Ycord=input.nextInt();
        crd=new Coordinate(Xcord,Ycord);
        Ship cruiser=new Ship('C',dir,crd);
        while(!bds.validLocation(crd, carrier)){
            System.out.println("That is an invalid location.Please enter again");
            System.out.println("Now enter the X-Coordinate: ");
            int NewXcord=input.nextInt();
            System.out.println("Now enter the Y-Coordinate: ");
            int NewYcord=input.nextInt();
            crd=new Coordinate(NewXcord,NewYcord);
            cruiser=new Ship('C',dir,crd);
        }
        bds.placeShips(crd, cruiser);
        bds.printBoardA();

        System.out.println("The forth ship is an submarine of size 3.");
        System.out.println("What direction you like to place it in? Enter 'u' for up,'d' for down,'r' for right and 'l for left'");
        dir=input.next().charAt(0);
        System.out.println("Now enter the X-Coordinate: ");
        Xcord=input.nextInt();
        System.out.println("Now enter the Y-Coordinate: ");
        Ycord=input.nextInt();
        crd=new Coordinate(Xcord,Ycord);
        Ship submarine=new Ship('S',dir,crd);
        while(!bds.validLocation(crd, submarine)){
            System.out.println("That is an invalid location.Please enter again");
            System.out.println("Now enter the X-Coordinate: ");
            int NewXcord=input.nextInt();
            System.out.println("Now enter the Y-Coordinate: ");
            int NewYcord=input.nextInt();
            crd=new Coordinate(NewXcord,NewYcord);
            submarine=new Ship('S',dir,crd);
        }
        bds.placeShips(crd, submarine);
        bds.printBoardA();

        System.out.println("The fifth and final ship is an destroyer of size 2.");
        System.out.println("What direction you like to place it in? Enter 'u' for up,'d' for down,'r' for right and 'l for left'");
        dir=input.next().charAt(0);
        System.out.println("Now enter the X-Coordinate: ");
        Xcord=input.nextInt();
        System.out.println("Now enter the Y-Coordinate: ");
        Ycord=input.nextInt();
        crd=new Coordinate(Xcord,Ycord);
        Ship destroyer=new Ship('D',dir,crd);
        while(!bds.validLocation(crd, submarine)){
            System.out.println("That is an invalid location.Please enter again");
            System.out.println("Now enter the X-Coordinate: ");
            int NewXcord=input.nextInt();
            System.out.println("Now enter the Y-Coordinate: ");
            int NewYcord=input.nextInt();
            crd=new Coordinate(NewXcord,NewYcord);
            destroyer=new Ship('D',dir,crd);
        }
        bds.placeShips(crd, destroyer);
        bds.printBoardA();

        System.out.println("You have finished setting up your board!");
    }
    public Coordinate playerGuessAttack(){
        System.out.println("Enter the X-Coordinate of where to attack the computer's board: ");
        int attackX= input.nextInt();
        System.out.println("Enter the Y-Coordinate of where to attack the computer's board: ");
        int attackY= input.nextInt();
        Coordinate attack=new Coordinate(attackX,attackY);
        while(!bds.validAttack(attack)){
            System.out.println("Invalid input.Please try again");
            System.out.println("Enter the X-Coordinate of where to attack the computer's board: ");
            int NewAttackX= input.nextInt();
            System.out.println("Enter the Y-Coordinate of where to attack the computer's board: ");
            int NewAttackY= input.nextInt();
            attack=new Coordinate(NewAttackX,NewAttackY);
        }
        return attack;
    }
    public void attackComputer(Computer computer,Coordinate attack){
        bds.printResult(bds.resultComputer(attack,computer));
    }
    public void printBoard(char[][] board){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++)
                System.out.print(board[i][j]+"     ");
            System.out.println();
        }
    }
    public boolean playerWin(Computer computer){
        for(int i=1;i<computer.getBoardA().length;i++){
            for (int j=1;j<computer.getBoardA()[0].length;j++){
                if(computer.getBoardA()[i][j]!='~'&&bds.getBoardB()[i][j]!='H')
                    return false;
            }
        }
        return true;
    }
    public char[][] getBoardA(){
        return bds.getBoardA();
    }
    public char[][]getBoardB(){
        return bds.getBoardB();
    }
}
