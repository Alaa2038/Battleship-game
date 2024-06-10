package BattleShipsGame;

public class Ship {
    /*
    Carrier, which has five holes,letter="A"
    Battleship, which has four holes,letter="B"
    Cruiser, which has three holes,letter="C"
    Submarine, which has three holes,letter="S"
    Destroyer, which has two holes,letter="D"
    */
    private int size;
    private char letter;
    private char direction;
    private Coordinate coordinate;

    public Ship(char let, char dir, Coordinate crd) {
        if(let=='A') size=5;
        else if(let=='B') size=4;
        else if(let=='C'||let=='S') size=3;
        else size=2;
        letter=let;
        direction=dir;
        coordinate=crd;
    }

    public int getSize() {
        return size;
    }

    public char getLetter() {
        return letter;
    }

    public char getDirection() {
        return direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
