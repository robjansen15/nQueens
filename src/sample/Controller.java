package sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Controller {
    public Controller(int numQueens){
        qNumber = numQueens;

        queens = new ArrayList<Queen>();
        random = new Random(System.currentTimeMillis());
    }


    public void Run(){
        //INITIALIZATION
        queens = new Initialization().Initialize(qNumber);
        System.out.println("Init:");
        Print();

        int count = 0;
        while(true){
            //SEARCH AND CONFLICT COUNT
            UpdateAQueen();
            //CONFLICT COUNT
            UpdateConflicts();
            //LETS SEE HOW MANY TRIES WE HAVE TO MAKE
            count++;

            //FINAL STATE
            if(IsFinalState()){
                break;
            }
        }

        System.out.println("Final:");
        Print();

        //PRINT PAIRS AND CONFLICTS
        System.out.println("Steps: " + count);
        for(Iterator<Queen> q = queens.iterator(); q.hasNext();){
            Queen queen = q.next();
            System.out.println("Pair: (" + queen.getY() + "," + queen.getX() + ") Conflicts: " + queen.getConflicts());
        }
    }


    //UPDATING EVERYTHING ON BOARD
    public void UpdateConflicts(){
        for(Iterator<Queen> q = queens.iterator(); q.hasNext();){
            Queen queen = q.next();
            queen.updateConflictCount(queens,qNumber);
        }
    }


    //UPDATE A QUEEN
    public void UpdateAQueen(){
        int randNumber = random.nextInt(qNumber);
        queens.get(randNumber).Move(queens,qNumber);
    }


    //FINAL STATE CHECK
    public boolean IsFinalState(){
        for(Iterator<Queen> q = queens.iterator(); q.hasNext();){
            Queen queen = q.next();

            if(queen.getConflicts() > 0)
                return false;
        }

        return true;
    }

    /*for printing*/
    public void Print(){
        for(int i = 0; i < qNumber; i++){
            for(int j = 0; j < qNumber; j++){
                if(QueenHere(i,j)){
                    System.out.print("1  ");
                }
                else{
                    System.out.print("0  ");
                }
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
    }
    public boolean QueenHere(int x, int y){
        for (Iterator<Queen> q = queens.iterator(); q.hasNext(); ) {
            Queen tempQ = q.next();

            if (tempQ.getX() == x && tempQ.getY() == y) {
                return true;
            }
        }

        return false;
    }

    private ArrayList<Queen> queens;
    private int qNumber;
    private int steps;
    private Random random;
}
