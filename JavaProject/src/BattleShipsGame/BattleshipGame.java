package BattleShipsGame;

import java.io.FileOutputStream;
import java.io.IOException;

public class BattleshipGame {
    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();
        FileOutputStream file = null;
        System.out.println("Welcome to the BattleShip Game!");
        player.PlayerSetUp();
        try {
            computer.ComputerSetUp();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            file = new FileOutputStream("C:\\Users\\NTC\\Desktop\\JavaProject\\Computer.txt", true);
            file.write("\nComputer predicted attack coordinate:\n".getBytes());
            file.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        while (!player.playerWin(computer) && !computer.verifyComputerWin(player)) {
            Coordinate attackOnComputer = player.playerGuessAttack();
            player.attackComputer(computer, attackOnComputer);
            try {
                Coordinate attackOnPlayer = computer.predictedCoordinate(player);
                computer.attackPlayer(player, attackOnPlayer);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Your board A: ");
            player.printBoard(player.getBoardA());
            System.out.println("Your board B: ");
            player.printBoard(player.getBoardB());
        }

        if (player.playerWin(computer))
            System.out.println("YOU WON!!!!!");
        else if (computer.verifyComputerWin(player))
            System.out.println("GAME OVER! Sorry you lost");
    }
}
