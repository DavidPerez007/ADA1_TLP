import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DAO {

    private String infixPath;
    private String postfixPath;

    public DAO(String infixPath) {
        this.infixPath = infixPath;
        this.postfixPath = "files\\postfix.txt";
    }

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.infixPath))) {
            String expression;
            ArrayList postfixArray = new ArrayList<>();

            while ((expression = reader.readLine()) != null) {
                InfixToPostfix conversor = new InfixToPostfix();
                String postfixExpression = conversor.infixToPostfix(expression);
                postfixArray.add(postfixExpression);
            }

            writeFile(postfixArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(ArrayList postfixEpression) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.postfixPath, false))) {
            for(int i = 0; i < postfixEpression.size(); i++){
                writer.write(postfixEpression.get(i).toString());
                writer.newLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
