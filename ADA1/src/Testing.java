public class Testing {
    public static void main(String[] args) {
        String infixPath = "files\\infix.txt";
        DAO dao = new DAO(infixPath);
        dao.readFile();


    }
}
