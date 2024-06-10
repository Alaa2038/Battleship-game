package BattleShipsGame;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Computer {
    FileOutputStream file =null;
    Boards bds=new Boards();
    ArrayList<Coordinate> crds=new ArrayList<Coordinate>();
    ArrayList<Coordinate> chooseFrom=new ArrayList<Coordinate>();

    public Computer() {
        bds.initializeBoardA();
        bds.initializeBoardB();
    }
    public void ComputerSetUp() throws IOException {
        file=new FileOutputStream("C:\\Users\\NTC\\Desktop\\JavaProject\\Computer.txt",true);
        file.write(("\n***************\nNew Game.\n***************").getBytes());
        file.write("\nComputer SetUp\n".getBytes());
        char direction=randomDirection();
        Coordinate crd=randomCoordinate();
        Ship carrier=new Ship('A',direction,crd);
        while (!bds.validLocation(crd, carrier))
            crd=randomCoordinate();
        bds.placeShips(crd, carrier);
        file.write("1)Carrier: ".getBytes());
        file.write((crd.getxCor()+","+ crd.getyCor()+"/("+direction+")").getBytes());

        direction=randomDirection();
        crd=randomCoordinate();
        Ship battleship=new Ship('B',direction,crd);
        while (!bds.validLocation(crd, battleship))
            crd=randomCoordinate();
        bds.placeShips(crd, battleship);
        file.write("\n2)Battleship: ".getBytes());
        file.write((crd.getxCor()+","+ crd.getyCor()+"/("+direction+")").getBytes());


        direction=randomDirection();
        crd=randomCoordinate();
        Ship cruiser=new Ship('C',direction,crd);
        while (!bds.validLocation(crd, cruiser))
            crd=randomCoordinate();
        bds.placeShips(crd, cruiser);
        file.write("\n3)Cruiser: ".getBytes());
        file.write((crd.getxCor()+","+ crd.getyCor()+"/("+direction+")").getBytes());

        direction=randomDirection();
        crd=randomCoordinate();
        Ship submarine=new Ship('S',direction,crd);
        while (!bds.validLocation(crd, submarine))
            crd=randomCoordinate();
        bds.placeShips(crd, submarine);
        file.write("\n4)Submarine: ".getBytes());
        file.write((crd.getxCor()+","+ crd.getyCor()+"/("+direction+")").getBytes());

        direction=randomDirection();
        crd=randomCoordinate();
        Ship destroyer=new Ship('D',direction,crd);
        while (!bds.validLocation(crd, destroyer))
            crd=randomCoordinate();
        bds.placeShips(crd, destroyer);
        file.write("\n5)Destroyer: ".getBytes());
        file.write((crd.getxCor()+","+ crd.getyCor()+"/("+direction+")").getBytes());
        file.flush();

        System.out.println("The computer has finished setting up its board.");
        System.out.println("'X' represent where the computer has attacked your board.");
    }
    public void attackPlayer(Player p,Coordinate attack){
        printResult(bds.resultPlayer(attack, p));
    }
    public void printResult(char result){
        if(result=='H')
            System.out.println("The computer has successfully HIT your ships!");
        else
            System.out.println("The computer has MISSED your ship.");
    }
    public Coordinate predictedCoordinate(Player p)throws IOException{
        file=new FileOutputStream("C:\\Users\\NTC\\Desktop\\JavaProject\\Computer.txt",true);
        Coordinate c;
        if(crds.size()>=1){
            c=crds.get(crds.size()-1);
            if (bds.resultPlayer(c, p)=='H'){
                chooseFrom=chooseLocations(c);
                int randNum=(int)(Math.random()*chooseFrom.size())+1;
                while(!bds.validAttack(chooseFrom.get(randNum-1))||bds.getBoardB()[chooseFrom.get(randNum-1).getyCor()+1][chooseFrom.get(randNum-1).getxCor()+1]!='~')
                    randNum=(int)(Math.random()*chooseFrom.size())+1;
                crds.add(chooseFrom.get(randNum-1));
                file.write(("("+chooseFrom.get(randNum-1).getxCor()+","+chooseFrom.get(randNum-1).getyCor()+"),").getBytes());
                file.flush();
                return chooseFrom.get(randNum-1);
            }
        }
        c=randomCoordinate();
        while (!bds.validAttack(c)||bds.getBoardB()[c.getyCor()+1][c.getxCor()+1]!='~')
            c=randomCoordinate();
        crds.add(c);
        file.write(("("+c.getxCor()+","+c.getxCor()+"),").getBytes());
        file.flush();
        return c;
    }
    public ArrayList<Coordinate> chooseLocations(Coordinate crd){
        ArrayList<Coordinate> adjacentCoords=new ArrayList<Coordinate>();
        if(crd.getxCor()==0&&crd.getyCor()==0){
            adjacentCoords.add(new Coordinate(crd.getxCor()+1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()+1));
        } else if (crd.getxCor()==0&&crd.getyCor()==9) {
            adjacentCoords.add(new Coordinate(crd.getxCor()+1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()-1));
        } else if(crd.getxCor()==0){
            adjacentCoords.add(new Coordinate(crd.getxCor()+1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()+1));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()-1));
        } else if (crd.getxCor()==9&&crd.getyCor()==0) {
            adjacentCoords.add(new Coordinate(crd.getxCor()-1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()+1));
        }else if(crd.getxCor()==9&&crd.getyCor()==9){
            adjacentCoords.add(new Coordinate(crd.getxCor()-1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()-1));
        }else if(crd.getxCor()==9){
            adjacentCoords.add(new Coordinate(crd.getxCor()-1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()+1));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()-1));
        }else if(crd.getyCor()==0){
            adjacentCoords.add(new Coordinate(crd.getxCor()-1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor()+1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()+1));
        }else if(crd.getyCor()==9){
            adjacentCoords.add(new Coordinate(crd.getxCor()-1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor()+1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()-1));
        }
        else {
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()-1));
            adjacentCoords.add(new Coordinate(crd.getxCor(),crd.getyCor()+1));
            adjacentCoords.add(new Coordinate(crd.getxCor()-1,crd.getyCor()));
            adjacentCoords.add(new Coordinate(crd.getxCor()+1,crd.getyCor()));
        }

        return adjacentCoords;
    }
    public boolean verifyComputerWin(Player p){
        for (int i=1;i<p.getBoardA().length;i++){
            for (int j=1;j<p.getBoardA()[0].length;j++){
                if (p.getBoardA()[i][j]!='~'&&bds.getBoardB()[i][j]!='H')
                    return false;
            }
        }
        return true;
    }
    public char randomDirection() {
        int dirNum=(int)(Math.random()*4)+1;
        switch(dirNum){
        case 1:
            return 'u';
            case 2:
            return 'd';
        case 3:
            return 'r';
        default:
            return 'l';
        }
    }
    public Coordinate randomCoordinate(){
        int randNum1=(int)(Math.random()*10);
        int randNum2=(int)(Math.random()*10);
        return new Coordinate(randNum1,randNum2);
    }
    public char[][] getBoardA(){
        return bds.getBoardA();
    }
    public char[][]getBoardB(){
        return bds.getBoardB();
    }
}
