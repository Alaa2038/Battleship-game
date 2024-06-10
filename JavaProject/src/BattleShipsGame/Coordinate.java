package BattleShipsGame;

public class Coordinate {
    private int xCor;
    private int yCor;

    public Coordinate() {
        xCor = 1;
        yCor = 1;
    }

    public Coordinate(int xCor, int yCor) {
        this.xCor = xCor;
        this.yCor = yCor;
    }

    public int getxCor() {
        return xCor;
    }

    public int getyCor() {
        return yCor;
    }

    @Override
    public String toString() {
        return "("+xCor+", "+yCor+")";
    }
}
