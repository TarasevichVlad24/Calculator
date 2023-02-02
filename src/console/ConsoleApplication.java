package console;

import entity.Operation;
import service.CalculatorService;

import java.util.Optional;

import static console.ConsoleReader.readDouble;
import static console.ConsoleReader.readString;
import static console.ConsoleWriter.write;

public class ConsoleApplication {
    private final CalculatorService calculatorService = new CalculatorService();
    public void run(){
        while(true){
            write("Enter num1");
            double num1 = readDouble();
            write("Enter num2");
            double num2 = readDouble();
            write("Enter type");
            String type = readString();
            Operation operation = new Operation(num1,num2,type);
            Optional<Operation> result = calculatorService.calculate(operation);
            write("Result = " + result.toString());


        }

    }
}
