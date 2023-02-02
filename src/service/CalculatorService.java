package service;

import entity.Operation;

import java.util.Optional;

public class CalculatorService {
    public Optional<Operation> calculate(Operation operation) {
        switch (operation.getType()) {
            case "sum":
                operation.setResult(sum(operation.getNum1(), operation.getNum2()));
                return Optional.of(operation);
            case "sub":
                operation.setResult(sub(operation.getNum1(), operation.getNum2()));
                return Optional.of(operation);
            case "mul":
                operation.setResult(mul(operation.getNum1(), operation.getNum2()));
                return Optional.of(operation);
            case "div":
                operation.setResult(div(operation.getNum1(), operation.getNum2()));
                return Optional.of(operation);


        }
        return Optional.empty();

    }

    public static Double sum(double a,double b){
        return a+b;
    }
    public static Double sub(double a,double b){
        return a-b;
    }
    public static Double mul(double a,double b){
        return a*b;
    }
    public static Double div(double a,double b){
        return a/b;
    }
}
