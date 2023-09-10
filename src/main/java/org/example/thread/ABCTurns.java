package org.example.thread;

public class ABCTurns {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread threadA = new Thread(new PrintTask(printer, 'A', 10));
        Thread threadB = new Thread(new PrintTask(printer, 'B', 10));
        Thread threadC = new Thread(new PrintTask(printer, 'C', 10));

        threadA.start();

        threadC.start();
        threadB.start();
    }
}

class Printer {
    private char currentChar = 'A';

    public synchronized void printChar(char c) {
        while (c != currentChar) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print(c);
        currentChar = (char) (currentChar % 3 + 'A');
        notifyAll();
    }
}

class PrintTask implements Runnable {
    private Printer printer;
    private char charToPrint;
    private int printCount;

    public PrintTask(Printer printer, char charToPrint, int printCount) {
        this.printer = printer;
        this.charToPrint = charToPrint;
        this.printCount = printCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < printCount; i++) {
            printer.printChar(charToPrint);
        }
    }
}
