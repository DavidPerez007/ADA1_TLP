import java.util.ArrayList;

public class InfixToPostfixApp {
    public static void main(String[] args) {
        String infixPath = "files\\infix_exp.txt";
        DAO dao = new DAO(infixPath);
        ArrayList postfixExpressions = dao.readFile();
        dao.writeFile(postfixExpressions);
        


    }
}
