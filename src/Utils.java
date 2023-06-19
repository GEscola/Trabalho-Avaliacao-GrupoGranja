import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.sql.rowset.serial.SerialDatalink;
import java.sql.SQLException;

public class Utils {

    // Metodo para fechar recursos ao sair
    public static void sair() throws ClassNotFoundException, SQLException {
        MySQLJDBC instance = MySQLJDBC.getInstance();
        instance.closeConnection();
    }

    // Metodo para imprimir Menu
    public static void menuPrint() throws ClassNotFoundException, SQLException {
        System.out.println("+---------------------MENU INICIAL----------------------+");
        System.out.println("| 0 - Sair da aplicação                                 |");
        System.out.println("| 1 - Funcionarios                                      |");
        System.out.println("| 2 - Departamentos                                     |");
        System.out.println("| 3 - Relatórios                                        |");
        System.out.println("+-------------------------------------------------------+");
        System.out.print("Digite opcao: ");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 0:
                sair();
                break;
            case 1:
                submenuPrint();
                break;
            case 2:
                submenuPrint1();
                break;
            case 3:
                submenuPrint2();
                break;

        }

    }

    // Metodo para imprimir submenu
    public static void submenuPrint() throws ClassNotFoundException, SQLException {
        System.out.println("\n+-----------------SUBMENU FUNCIONARIOS------------------+");
        System.out.println("| 0 - Sair da aplicação                                 |");
        System.out.println("| 1 - Voltar ao menu incial                             |");
        System.out.println("| 2 - Pesquisar funcionários por ID                     |");
        System.out.println("| 3 - Pesquisar funcionários por nome                   |");
        System.out.println("| 4 - Listar funcionários                               |");
        System.out.println("| 5 - Listar contactos de funcionários                  |");
        System.out.println("+-------------------------------------------------------+");
        System.out.print("Digite opcao: ");

        Scanner scanner = new Scanner(System.in);
        int opcao1 = scanner.nextInt();
        switch (opcao1) {
            case 0:
                sair();
                break;
            case 1:
                menuPrint();
                break;
            case 2:
                System.out.println("Funcionários por ID: ");
                int idFuncionarios = scanner.nextInt();
                try {
                    getFuncionarios(null, "employee_id = " + String.valueOf(idFuncionarios));
                } catch (Exception e) {
                    System.out.println("ERRO: Falha a obter os funcionários! ");
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("Funcionários por nome: ");
                String nomefuncionarios = scanner.next();
                try {
                    getFuncionarios(null, "first_name LIKE '" + String.valueOf(nomefuncionarios) + "'");
                } catch (Exception e) {
                    System.out.println("ERRO: Falha a obter os funcionários! ");
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    getFuncionarios("*", null);
                } catch (Exception e) {
                    System.out.println("ERRO: Falha a obter os funcionários! ");
                    e.printStackTrace();
                }
                break;
            case 5:
                System.out.println("Contactos dos funcionários: ");
                break;
        }
    }

    public static void submenuPrint1() throws ClassNotFoundException, SQLException {
        System.out.println("\n+-----------------SUBMENU DEPARTAMENTOS-----------------+");
        System.out.println("| 0 - Sair da aplicação                                 |");
        System.out.println("| 1 - Voltar ao menu incial                             |");
        System.out.println("| 2 - Pesquisar departamento por ID                     |");
        System.out.println("| 3 - Pesquisar departamento por nome                   |");
        System.out.println("| 4 - Alterar localização do departamento               |");
        System.out.println("| 5 - Listar departamentos                              |");
        System.out.println("+-------------------------------------------------------+");
        System.out.print("Digite opcao: ");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 0:
                sair();
                break;
            case 1:
                menuPrint();
                break;
            case 2:
                System.out.print("Digite id: ");
                int iddepartamento = scanner.nextInt();
                try {
                    getDepartamentos(null, "department_id = " + String.valueOf(iddepartamento));
                } catch (Exception e) {
                    System.out.println("ERRO: Falha a obter os departamentos! ");
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.print("Digite o nome: ");
                String nomedepartamento = scanner.next();
                try {
                    getDepartamentos(null, "department_name LIKE '" + String.valueOf(nomedepartamento) + "'");
                } catch (Exception e) {
                    System.out.println("ERRO: Falha a obter os departamentos! ");
                    e.printStackTrace();
                }
                break;
            case 4:
                System.out.print("Digite o id da localização: ");
                int idlocalizacao = scanner.nextInt();
                try {
                    getDepartamentos(null, "location_id = " + String.valueOf(idlocalizacao));
                } catch (Exception e) {
                    System.out.println("ERRO: Falha a obter os departamentos! ");
                    e.printStackTrace();
                }
                break;

            case 5:
                try {
                    getDepartamentos("*", null);
                } catch (Exception e) {
                    System.out.println("ERRO: Falha a obter os funcionários! ");
                    e.printStackTrace();
                }
                break;
        }
    }

    public static void submenuPrint2() throws ClassNotFoundException, SQLException {
        System.out.println("\n+----------------SUBMENU RELATORIOS-------------------------+");
        System.out.println("| 0 - Sair da aplicação                                      |");
        System.out.println("| 1 - Voltar ao menu inicial                                 |");
        System.out.println("| 2 - Relatório: Gerentes e funcionários por departamento    |");
        System.out.println("| 3 - Relatório: Contrato e salário de funcionários          |");
        System.out.println("| 4 - Relatório: Funcionários contratados por ano            |");
        System.out.println("| 5 - Relatório: Funcionários com salário MIN e MAX          |");
        System.out.println("+------------------------------------------------------------+");
        System.out.print("Digite opcao: ");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 0:
                sair();
                break;
            case 1:
                menuPrint();
                break;
            case 2:
                System.out.print("Digite id: ");
                int idRelatorio = scanner.nextInt();
                try {
                    getRelatorio(null, "department_id = " + String.valueOf(idRelatorio));
                } catch (Exception e) {
                    System.out.println("ERRO: Falha ao obter os departamentos! ");
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.print("Digite o nome: ");
                String nomeRelatorio = scanner.next();
                try {
                    getRelatorio(null, "nome_departamento = '" + nomeRelatorio + "'");
                } catch (Exception e) {
                    System.out.println("ERRO: Falha ao obter os funcionários! ");
                    e.printStackTrace();
                }
                break;
            case 4:
                System.out.print("Digite o ano: ");
                int anoContratacao = scanner.nextInt();
                try {
                    getRelatorio(null, String.valueOf(anoContratacao));
                } catch (Exception e) {
                    System.out.println("ERRO: Falha ao obter os funcionários! ");
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    getRelatorio(null, null);
                } catch (Exception e) {
                    System.out.println("ERRO: Falha ao obter os funcionários! ");
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void getRelatorio(Object object, String string) {
    }

    public static void getFuncionarios(String seccoes, String filtrar) throws SQLException, Exception {
        MySQLJDBC instance = MySQLJDBC.getInstance();
        Connection connection = instance.getConnection();
        // System.out.println(connection);

        if (seccoes == null) {
            seccoes = "*";
        }

        if (filtrar != null) {
            filtrar = "WHERE " + filtrar;
        } else {
            filtrar = "";
        }

        String query = "SELECT " + seccoes + " FROM employees " + filtrar;
        // Create Statement
        Statement stmt = connection.createStatement();
        // Get Result Set
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("+----------------------------+-----------------+");
        System.out.println("|  ID | FUNCIONARIOS         | PHONE_NUMBER    |");
        System.out.println("+----------------------------+-----------------+");
        // Extract data from Result Set
        while (rs.next()) {
            // Retrieve by column name
            String id = rs.getString("employee_id");
            String d = rs.getString("first_name") + " " + rs.getString("last_name");
            String number = rs.getString("phone_number");
            // Display values
            System.out.printf("| %-2s | %-20s | %-19s | %n", id, d, number );
        }
        System.out.println("+-----+--------------------+----------------+\n");
        rs.close();
        stmt.close();
    }

    public static void criarRelatorio(String query) throws SQLException, Exception {
        MySQLJDBC instance = MySQLJDBC.getInstance();
        Connection connection = instance.getConnection();
        // System.out.println(connection);

        // Create Statement
        Statement stmt = connection.createStatement();
        // Get Result Set
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("+-----+-----------------------+-----------+-----------------+--------------+------------+-----------+-----------------+");
        System.out.println("| ID  |         NAME          |  EMAIL    | PHONE_NUMBER    | HIRE_DATE    | JOB_ID     | SALARY    | COMMISSION_PCT  |");
        System.out.println("+-----+-----------------------+-----------+-----------------+--------------+------------+-----------+-----------------+");
        // Extract data from Result Set
        while (rs.next()) {
            // Retrieve by column name
            String id = rs.getString("employee_id");
            String d = rs.getString("first_name") + " " + rs.getString("last_name");
            String email = rs.getString("email");
            String number = rs.getString("phone_number");
            String date = rs.getString("hire_date");
            String job = rs.getString("job_id");
            String salary = rs.getString("salary");
            String pct = rs.getString("commission_pct");
            // Display values
            System.out.printf("| %-2s | %-21s | %-12s | %-19s | %16s | %-14s | %-12s | %-20s | %n", id, d, email, number, date, job, salary, pct);
        }
        System.out.println(
                "+-----------------------------+-----------+-----------------+--------------+------------+-----------+-----------------+\n");
        rs.close();
        stmt.close();

    }

    public static void verificarExistencia(String query, String atributo, String valor) throws SQLException, Exception {
        MySQLJDBC instance = MySQLJDBC.getInstance();
        Connection connection = instance.getConnection();
        // System.out.println(connection);

        // Create Statement
        Statement stmt = connection.createStatement();
        // Get Result Set
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            if (rs.getString(atributo) == "20") {
                System.out.println("1");
            }
            ;
        }
        rs.close();
        stmt.close();
    }

    public static void getDepartamentos(String seccoes, String filtrar) throws SQLException, Exception {
        MySQLJDBC instance = MySQLJDBC.getInstance();
        Connection connection = instance.getConnection();
        // System.out.println(connection);

        if (seccoes == null) {
            seccoes = "*";
        }

        if (filtrar != null) {
            filtrar = "WHERE " + filtrar;
        } else {
            filtrar = "";
        }

        String query = "SELECT " + seccoes + " FROM departments " + filtrar;
        // Create Statement
        Statement stmt = connection.createStatement();
        // Get Result Set
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("+------------------------------+----------------------+");
        System.out.println("| ID |         NAME            |       LOCATION       |");
        System.out.println("+------------------------------+----------------------+");
        // Extract data from Result Set
        while (rs.next()) {
            // Retrieve by column name
            String id = rs.getString("department_id");
            String d = rs.getString("department_name");
            String location_id = rs.getString("location_id");
             
            // Display values
            System.out.printf("| %-2s | %-23s | %-20s | %n", id, d, location_id);
        }
        System.out.println("+----+--------------------------+----------------------+\n");
        rs.close();
        stmt.close();

    }
}