package sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Please enter the number of N\'s to use: ");
        int n = reader.nextInt();

        ArrayList<ThreadObj> Threads = new ArrayList<ThreadObj>();

        for(int i = 0; i < 2; i++){
            Threads.add(new ThreadObj((n)));
        }

        for(Iterator<ThreadObj> t = Threads.iterator(); t.hasNext();) {
            ThreadObj threadObj = t.next();

            threadObj.start();
        }
    }
}
