package BattleShipsGame;

public class Boards {
    private char[][] boardA=new char[11][11];
    private char[][] boardB=new char[11][11];
    private int numCarrierPlayer=0;
    private int numBattleshipPlayer=0;
    private int numCruiserPlayer=0;
    private int numSubmarinePlayer=0;
    private int numDestroyerPlayer=0;

    private int numCarrierComputer=0;
    private int numBattleshipComputer=0;
    private int numCruiserComputer=0;
    private int numSubmarineComputer=0;
    private int numDestroyerComputer=0;

    public Boards() {
        initializeBoardA();
        initializeBoardB();
    }
    public void initializeBoardA(){
        boardA[0][0]=' ';
        int num=1;
        //first column
        for(int i=48;i<=57;i++){
            boardA[num][0]=(char) i;
            num++;
        }
        //first row
        num=1;
        for(int i=48;i<=57;i++){
            boardA[0][num]=(char) i;
            num++;
        }
        //rest
        for(int i=1;i<boardA.length;i++){
            for(int j=1;j<boardA[0].length;j++)
                boardA[i][j]='~';
        }
    }
    public void initializeBoardB(){
        boardB[0][0]=' ';
        int num=1;
        //first column
        for(int i=48;i<=57;i++){
            boardB[num][0]=(char) i;
            num++;
        }
        //first row
        num=1;
        for(int i=48;i<=57;i++){
            boardB[0][num]=(char) i;
            num++;
        }
        //rest
        for(int i=1;i<boardB.length;i++){
            for(int j=1;j<boardB[0].length;j++)
                boardB[i][j]='~';
        }
    }
    public boolean validLocation(Coordinate crd, Ship s){
        int yCrd = crd.getyCor()+1;
        int xCrd = crd.getxCor()+1;
        if(xCrd<1||xCrd>= boardA[0].length)
            return false;
        if(yCrd<1||yCrd>= boardA.length)
            return false;
        if (s.getDirection()=='u'){
            if (yCrd-s.getSize()<1)
                return false;
            for(int i=yCrd;i>yCrd-s.getSize();i--){
                if (boardA[i][xCrd]!='~')
                    return false;
            }
        } else if (s.getDirection()=='d'){
            if (yCrd+(s.getSize()+1)>=boardA.length)
                return false;
            for(int i=yCrd;i<=yCrd+(s.getSize()-1);i++){
                if (boardA[i][xCrd]!='~')
                    return false;
            }
        }else if (s.getDirection()=='r'){
            if (xCrd+(s.getSize()-1)>=boardA[0].length)
                return false;
            for(int i=xCrd;i<=xCrd+(s.getSize()-1);i++){
                if (boardA[yCrd][i]!='~')
                    return false;
            }
        }else if (s.getDirection()=='l'){
            if (xCrd-(s.getSize()+1)<1)
                return false;
            for(int i=xCrd;i>xCrd-s.getSize();i--){
                if (boardA[yCrd][i]!='~')
                    return false;
            }
        }
        return true;
    }
    public boolean validAttack(Coordinate crd){
        int yCrd= crd.getyCor()+1;
        int xCrd= crd.getxCor()+1;
        if(xCrd<1||xCrd>=boardA[0].length)
            return false;
        if(yCrd<1||yCrd>=boardA.length)
            return false;
        return true;
    }
    public char resultComputer(Coordinate crd,Computer opposition){
        int yCrd= crd.getyCor()+1;
        int xCrd= crd.getxCor()+1;
        if (opposition.getBoardA()[yCrd][xCrd]=='A'){
            numCarrierComputer++;
            if(numCarrierComputer==5)
                System.out.println("You sunk your opponent's carrier");
        }
        else if (opposition.getBoardA()[yCrd][xCrd]=='B'){
            numBattleshipComputer++;
            if(numBattleshipComputer==4)
                System.out.println("You sunk your opponent's battleship");
        }
        else if (opposition.getBoardA()[yCrd][xCrd]=='C'){
            numCarrierComputer++;
            if(numCruiserComputer==3)
                System.out.println("You sunk your opponent's cruiser");
        }
        else if (opposition.getBoardA()[yCrd][xCrd]=='S'){
            numSubmarineComputer++;
            if(numSubmarineComputer==3)
                System.out.println("You sunk your opponent's submarine");
        }
        else if (opposition.getBoardA()[yCrd][xCrd]=='B'){
            numDestroyerComputer++;
            if(numDestroyerComputer==2)
                System.out.println("You sunk your opponent's destroyer");
        }
        if (opposition.getBoardA()[yCrd][xCrd]!='~'){
            this.getBoardB()[yCrd][xCrd]='H';
            opposition.getBoardA()[yCrd][xCrd]='X';
            return 'H';}
        this.getBoardB()[yCrd][xCrd]='M';
        return 'M';
    }
    public char resultPlayer(Coordinate crd,Player opposition){
        {
            int yCrd= crd.getyCor()+1;
            int xCrd= crd.getxCor()+1;
            if (opposition.getBoardA()[yCrd][xCrd]=='A'){
                numCarrierPlayer++;
                if(numCarrierPlayer==5)
                    System.out.println("Your opponent sunk your own carrier");
            }
            else if (opposition.getBoardA()[yCrd][xCrd]=='B'){
                numBattleshipPlayer++;
                if(numBattleshipPlayer==4)
                    System.out.println("Your opponent sunk your own battleship");
            }
            else if (opposition.getBoardA()[yCrd][xCrd]=='C'){
                numCruiserPlayer++;
                if(numCruiserPlayer==3)
                    System.out.println("Your opponent sunk your own cruiser");
            }
            else if (opposition.getBoardA()[yCrd][xCrd]=='S'){
                numSubmarinePlayer++;
                if(numSubmarinePlayer==3)
                    System.out.println("Your opponent sunk your own submarine");
            }
            else if (opposition.getBoardA()[yCrd][xCrd]=='B'){
                numDestroyerPlayer++;
                if(numDestroyerPlayer==2)
                    System.out.println("Your opponent sunk your own destroyer");
            }
            if (opposition.getBoardA()[yCrd][xCrd]!='~'){
                this.getBoardB()[yCrd][xCrd]='H';
                opposition.getBoardA()[yCrd][xCrd]='X';
                return 'H';
            }
            this.getBoardB()[yCrd][xCrd]='M';
            return 'M';
        }
    }
    public void printResult(char result){
        if(result=='M')
            System.out.println("Hard luck.you MISSED!");
        else
            System.out.println("Great strike!you successfully HIT the enemy ship!");
    }
    public void placeShips(Coordinate crd,Ship s){
        int yCrd=crd.getyCor()+1;
        int xCrd=crd.getxCor()+1;
        boardA[yCrd][xCrd]=s.getLetter();
        if(s.getDirection()=='u'){
            for (int i=yCrd;i>=yCrd-(s.getSize()-1);i--){
                boardA[i][xCrd]=s.getLetter();
            }
        }
        else if(s.getDirection()=='d'){
            for (int i=yCrd;i<=yCrd+(s.getSize()-1);i++){
                boardA[i][xCrd]=s.getLetter();
            }
        }
        else if(s.getDirection()=='r'){
            for (int i=xCrd;i<=xCrd+(s.getSize()-1);i++){
                boardA[yCrd][i]=s.getLetter();
            }
        }
        else if(s.getDirection()=='l'){
            for (int i=xCrd;i>=xCrd-(s.getSize()-1);i--){
                boardA[yCrd][i]=s.getLetter();
            }
        }
    }

    public char[][] getBoardA() {
        return boardA;
    }

    public char[][] getBoardB() {
        return boardB;
    }
    public void printBoardA(){
        for (int i=0;i<boardA.length;i++){
            for (int j=0;j<boardA[0].length;j++)
                System.out.print(boardA[i][j]+"     ");
            System.out.println();
        }
    }
    public void printBoardB(){
        for (int i=0;i<boardB.length;i++){
            for (int j=0;j<boardB[0].length;j++)
                System.out.print(boardB[i][j]+"     ");
            System.out.println();
        }
    }
}
