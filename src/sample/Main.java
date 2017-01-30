package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Please enter the number of N\'s to use: ");
        int n = reader.nextInt();

        System.out.print("Please enter the number of steps: ");
        int steps = reader.nextInt();

        Controller controller = new Controller(n, steps);
        controller.Run();
    }
}
