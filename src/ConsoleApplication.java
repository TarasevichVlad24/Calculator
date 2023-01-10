import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleApplication implements Application{
    private final Reader reader = new ConsoleReader();
    private FileWriter fileWriter;
    {
        try{
            fileWriter = new FileWriter ("history.txt",true);
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    private final Writer writer = new ConsoleWriter();
    private final Calculator calculator = new Calculator();

    @Override
    public void run() {
        checkFile();
        while (true) {
            writer.write("Введите операцию");
            String type = reader.readString();
            if(type.equals("check")) {
                calculator.checkHistory();
            }else if(){
                System.out.println("Операции не существует");
            }else {
                writer.write("Введите число ");
                double num1 = reader.readDouble();
                writer.write("Введите еще одно число");
                double num2 = reader.readDouble();
                Operation operation = new Operation(num1, num2, type);
                Operation result = calculator.calculate(operation);
                try {
                    fileWriter.write(result.toString());
                    fileWriter.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                writer.write("Результа = " + result);
            }

        }
    }
        private void checkFile(){
            File file = new File("history.txt");
            if(!file.exists()){
                try{
                    file.createNewFile();
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        }

    }


