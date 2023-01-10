import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public Operation calculate(Operation operation){
        switch(operation.getType()){
            case "sum":
                operation.setResult(sum(operation.getNum1(),operation.getNum2()));
                return operation;
            case "sub":
                operation.setResult(sub(operation.getNum1(),operation.getNum2()));
                return operation;
            case "mult":
                operation.setResult(mult(operation.getNum1(),operation.getNum2()));
                return operation;
            case "div":
                operation.setResult(div(operation.getNum1(),operation.getNum2()));
                return operation;
            case"check":
                 checkHistory();
        }
        return null;
    }
    private static double sum(double a, double b){
        return a+b;
    }
    private static double sub(double a, double b){
        return a-b;
    }
    private static double mult(double a, double b){
        return a*b;
    }
    private static double div(double a, double b){
        return a/b;
    }
    private static void checkHistory(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("history.txt"));
            String line;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
