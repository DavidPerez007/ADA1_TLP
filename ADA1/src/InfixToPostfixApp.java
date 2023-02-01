import java.util.ArrayList;

public class InfixToPostfixApp {
    public static void main(String[] args) {
        String infixPath = "ADA1\\files\\infix_exp.txt";
        DAO dao = new DAO(infixPath);
        ArrayList infixExpressions = dao.readFile();
        ArrayList postfixExpressions = new ArrayList<>();
        ArrayList resultList;
        for(int i = 0; i < infixExpressions.size(); i++){
            resultList = new ArrayList<>();
            String postfix = Conversor.infixToPostfix(infixExpressions.get(i).toString());
            resultList.add(postfix);
            Float result = Calculator.evaluate(postfix);
            resultList.add(result);
            postfixExpressions.add(resultList);
            System.out.println(postfixExpressions.get(i).toString() + " result: " + result);
        }
        
        dao.writeFile(postfixExpressions);


    }
}
