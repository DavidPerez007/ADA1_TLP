import java.util.ArrayList;

public class InfixToPostfixApp {
    public static void main(String[] args) {
        String infixPath = args[0];
        DAO dao = new DAO(infixPath);
        ArrayList infixExpressions = dao.readFile();
        ArrayList postfixExpressions = transformToPostfix(infixExpressions);
        dao.writeFile(postfixExpressions);
    }

    public static ArrayList transformToPostfix(ArrayList infixExpressions){
        ArrayList resultList;
        ArrayList postfixExpressions = new ArrayList<>();
        for(int i = 0; i < infixExpressions.size(); i++){
            resultList = new ArrayList<>();
            String postfix = Conversor.infixToPostfix(infixExpressions.get(i).toString());
            Float result = Calculator.evaluate(postfix);
            resultList.add(postfix);
            resultList.add(result);
            postfixExpressions.add(resultList);
            System.out.println(postfixExpressions.get(i).toString() + " result: " + result);
        }
        return postfixExpressions;
    }
}
