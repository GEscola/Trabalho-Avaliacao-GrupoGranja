public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Joe MAMA!");
        //Utils.criarRelatorio("SELECT * FROM employees");
        Utils.verificarExistencia("SELECT * FROM departments", "department_id", "20");
        //Utils.menuPrint();

    }
}
