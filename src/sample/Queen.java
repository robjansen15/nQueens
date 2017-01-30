package sample;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import java.util.ArrayList;

/**
 * Created by terrabyte on 1/29/2017.
 */
public class Queen {
    public Queen(int x, int y){
        x_pos = x;
        y_pos = y;
    }

    //setters
    public void setX(int x){
        x_pos = x;
    }
    public void setY(int y){
        y_pos = y;
    }


    //getters
    public int getX(){
        return x_pos;
    }
    public int getY(){
        return y_pos;
    }
    public int getConflicts(){
        return num_conflicts;
    }


    //CONFLICT COUNT*/
    public int getConflictCount(ArrayList<Queen> queens){
        int count = 0;

        for(Iterator<Queen> q = queens.iterator(); q.hasNext();){
            Queen tempQ = q.next();

            //if we are the same queen lets not do this!
            if(!(tempQ.getX() == this.getX() && tempQ.getY() == this.getY())){
                //if on the same col
                if(tempQ.getX() == this.getX()){
                    count++;
                }
                //if on the same row
                else if(tempQ.getY() == this.getY()){
                    count++;
                }//if on on diagnol
                else if(DiagonalConflict(tempQ)) {
                    count++;
                }
            }
        }

        return count;
    }


    public void updateConflictCount(ArrayList<Queen> queens, int qNumber){
        num_conflicts = getConflictCount(queens);
    }


    //helper method for conflict count
    public boolean DiagonalConflict(Queen temp){
        //NE or SW
        if((temp.getX() - this.getX()) == (temp.getY() - this.getY())){
            return true;
        }
        //NE or SE
        else if((temp.getX() - this.getX())*-1 == (temp.getY() - this.getY())){
            return true;
        }

        return false;
    }


    public void Move(ArrayList<Queen> queens, int qNumber){
        int oldX = this.getX();

        //min conflic
        int conflictCnt = qNumber;
        int tempX = oldX;

        for(int i = 0; i < qNumber; i++){
            this.setX(i);

            if(conflictCnt >= this.getConflicts()){
                conflictCnt = this.getConflictCount(queens);
                tempX = this.getX();
            }
        }

        //set the new value
        for(Iterator<Queen> q = queens.iterator(); q.hasNext();){
            Queen queen = q.next();

            if(queen.getX() == this.getX() && queen.getY() == this.getY()){
                queen.setX(tempX);
            }
        }
    }



    //variables
    private int num_conflicts;
    private int x_pos;
    private int y_pos;
}
