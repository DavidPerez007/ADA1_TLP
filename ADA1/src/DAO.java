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
        this.postfixPath = "files\\postfix_exp.txt";
    }

    public ArrayList readFile() {
        String expression;
        ArrayList postfixArray = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.infixPath))) {
            while ((expression = reader.readLine()) != null) {
                // Conversor conversor = new Conversor();
                // String postfixExpression = conversor.infixToPostfix(expression);
                postfixArray.add(expression);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return postfixArray;

    }

    public void writeFile(ArrayList postfixExpression) {
        ArrayList answer;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.postfixPath, false))) {
            for(int i = 0; i < postfixExpression.size(); i++){
                answer = (ArrayList) postfixExpression.get(i);
                writer.write(answer.get(0).toString() + " resultado: " + answer.get(1).toString());
                writer.newLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
