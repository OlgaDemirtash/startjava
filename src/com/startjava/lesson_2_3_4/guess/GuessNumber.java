package com.startjava.lesson_2_3_4.guess;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class GuessNumber {

    private final static int MAX_ROUNDS = 3;
    private final Player[] players;
    private final int min;
    private final int max;
    private final int maxAttempts;
    private int hiddenNumber;

    public GuessNumber(int maxAttempts, int min, int max, Player... players) {
        this.min = min;
        this.max = max;
        this.players = copyPlayers(players);
        this.maxAttempts = maxAttempts;
    }

    private void setHiddenNumber() {
        hiddenNumber = (int) (Math.random() * max + min);
    }

    private Player[] copyPlayers(Player[] players) {
        Player[] copyPlayers = new Player[players.length];
        for (int i = 0; i < players.length; i++) {
            copyPlayers[i] = new Player(players[i]);
        }
        return copyPlayers;
    }

    public void play() {
        for (int i = 1; i <= MAX_ROUNDS; i++) {
            setHiddenNumber();
            startGame();
            printPlayersNumbers();
            clearPlayersNumbers();
        }
        printWinner();
        clearPlayersWins();
    }

    private void startGame() {
        int countEliminatedPlayers = 0;
        shufflePlayers();
        while (true) {
            for (Player currentPlayer : players) {
                int nextNumber = inputNextNumber(currentPlayer);
                if (isGuessed(nextNumber, currentPlayer)) {
                    currentPlayer.incrementScore();
                    return;
                }
                if (!hasAttempt(currentPlayer)) {
                    countEliminatedPlayers++;
                }
                if (countEliminatedPlayers >= players.length) {
                    return;
                }
            }
        }
    }

    private void shufflePlayers() {
        System.out.println("Бросаю жребий для игроков...");
        for (int i = 0; i < players.length; i++) {
            int j = (int) (Math.random() * i);
            Player tmpPlayer = players[i];
            players[i] = players[j];
            players[j] = tmpPlayer;
        }
        System.out.println("Игроки будут ходить в следующем порядке:");
        printPlayersOrder();
    }

    private void printPlayersOrder() {
        for (int i = 0; i < players.length; i++) {
            System.out.println(i + 1 + ". " + players[i].getName());
        }
    }

    private int inputNextNumber(Player player) {
        Scanner console = new Scanner(System.in);
        System.out.println(player.getName() + " введите целое число в диапазоне ["
                + min + ", " + max + "]: ");
        try {
            int number = console.nextInt();
            if (player.addNumber(number, min, max)) {
                return number;
            }
            System.out.println("Число за пределами диапазона");
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Неправильный ввод");
        }
        return inputNextNumber(player);
    }

    private boolean isGuessed(int nextNumber, Player player) {
        if (nextNumber == hiddenNumber) {
            System.out.println("Игрок " + player.getName() + " угадал число " + nextNumber
                    + " с " + player.getCountAttempts() + " попытки!\n");
            return true;
        }
        System.out.printf("Число %d" + ((nextNumber > hiddenNumber) ? " больше " : " меньше ")
                + "того, что загадал компьютер\n\n", nextNumber);
        return false;
    }

    private boolean hasAttempt(Player player) {
        if (player.getCountAttempts() == maxAttempts) {
            System.out.println("У " + player.getName() + " закончились попытки");
            return false;
        }
        return true;
    }

    private void printPlayersNumbers() {
        for (Player player : players) {
            System.out.println("Игрок " + player.getName() + " ввёл следующие числа: ");
            int[] inputNumbers = player.getInputNumbers();
            int len = inputNumbers.length;
            for (int i = 0; i < len; i++) {
                System.out.print(inputNumbers[i] + ((i == len / 2 - 1) && len > 5 ? "\n" : " "));
            }
            System.out.println();
        }
    }

    private void clearPlayersNumbers() {
        for (Player player : players) {
            player.clear();
        }
    }

    private void printWinner() {
        int maxScoreIndex = 0;
        int maxScore = 0;
        boolean isDraw = false;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getScore() > maxScore) {
                maxScoreIndex = i;
                maxScore = players[i].getScore();
            }
        }
        if (maxScore == 1) {
            isDraw = true;
        }
        if (isDraw) {
            System.out.println("Ничья!");
            return;
        }
        System.out.println("Победил игрок " + players[maxScoreIndex].getName() + ", выиграв "
                + players[maxScoreIndex].getScore() + " раза!");
    }

    private void clearPlayersWins() {
        for (Player player : players) {
            player.clearScore();
        }
    }
}