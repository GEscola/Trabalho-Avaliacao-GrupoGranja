import java.sql.Connection;
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
                // menuPrint();
                break;
            case 2:
                System.out.println("Funcionários por ID: ");
                try {
                    getFuncionarios(null, null);
                } catch (Exception e) {
                    System.out.println("ERRO: Falha a obter os funcionarios! ");
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("Funcionários por nome: ");
                break;
            case 4:
                System.out.println("Funcionários: ");
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

                break;

        }

    }

    public static void submenuPrint2() {
        System.out.println("\n+----------------SUBMENU RELATORIOS-------------------------+");
        System.out.println("| 0 - Sair da aplicação                                      |");
        System.out.println("| 1 - Voltar ao menu incial                                  |");
        System.out.println("| 2 - Relatório: Gerentes e funcionários por departamento    |");
        System.out.println("| 3 - Relatório: Contrato e salário de funcionários          |");
        System.out.println("| 4 - Relatório: Funcionários contratados por ano            |");
        System.out.println("| 5 - Relatório: Funcionários com salário MIN e MAX          |");
        System.out.println("+------------------------------------------------------------+");
        System.out.print("Digite opcao: ");
    }

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
                int idDepartamento = scanner.nextInt();
                try {
                    getDepartamentos(null, "department_id = " + String.valueOf(idDepartamento));
                } catch (Exception e) {
                    System.out.println("ERRO: Falha ao obter os departamentos! ");
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.print("Digite o nome: ");
                String nomeDepartamento = scanner.next();
                try {
                    getDepartamentos(null, "nome_departamento = '" + nomeDepartamento + "'");
                } catch (Exception e) {
                    System.out.println("ERRO: Falha ao obter os funcionários! ");
                    e.printStackTrace();
                }
                break;
            case 4:
                System.out.print("Digite o ano: ");
                int anoContratacao = scanner.nextInt();
                try {
                    getDepartamentos(null, String.valueOf(anoContratacao));
                } catch (Exception e) {
                    System.out.println("ERRO: Falha ao obter os funcionários! ");
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    getDepartamentos(null, null);
                } catch (Exception e) {
                    System.out.println("ERRO: Falha ao obter os funcionários! ");
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        System.out.println("-----------------------------\n");
        rs.close();
        stmt.close();

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
        System.out.println("\n------------------------------");
        System.out.println("| ID |    FUNCIONARIOS          |");
        System.out.println("--------------------------------");
        // Extract data from Result Set
        while (rs.next()) {
            // Retrieve by column name
            int id = rs.getInt("employee_id");
            String d = rs.getString("first_name");
            // Display values
            System.out.printf("| %-2d | %-20s | %n", id, d);
        }
        System.out.println("-----------------------------\n");
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
        System.out.println("\n+--------------------------+----------------------+");
        System.out.println("| ID |         NAME        |       LOCATION       |");
        System.out.println("+--------------------------+----------------------+");
        // Extract data from Result Set
        while (rs.next()) {
            // Retrieve by column name
            int id = rs.getInt("department_id");
            String d = rs.getString("department_name");
            int location_id = rs.getInt("location_id");
            // Display values
            System.out.printf("| %-2d | %-19s | %n", id, d);
        }
        System.out.println("---------------------------+-----------------------\n");
        rs.close();
        stmt.close();

    }

    // Metodo Listar concelhos de um Distrito
    // @param - id do distrito (int)
    // @return - sem retorno
    public static void getConcelhos(int distrito) throws SQLException, Exception {
        MySQLJDBC instance = MySQLJDBC.getInstance();
        Connection connection = instance.getConnection();
        // System.out.println(connection);
        String query = "SELECT id_concelho, nome FROM concelho WHERE id_distrito = " + distrito;
        // Create Statement
        Statement stmt = connection.createStatement();
        // Get Result Set
        ResultSet rs = stmt.executeQuery(query);
        // Extract data from Result Set
        System.out.println("\n-----------------------------");
        System.out.println("| ID  |    CONCELHOS        |");
        System.out.println("-----------------------------");
        while (rs.next()) {
            // Retrieve by column name
            int id = rs.getInt("id_concelho");
            String c = rs.getString("nome");
            // Display values
            System.out.printf("| %-2d | %-20s | %n", id, c);
        }
        System.out.println("-----------------------------\n");
        rs.close();
        stmt.close();

    }

    // Metodo Listar Freguesias de determinado Concelho
    // @param - id do concelho (int)
    // @return - sem retorno
    public static void getFreguesias(int concelho) throws SQLException, Exception {
        MySQLJDBC instance = MySQLJDBC.getInstance();
        Connection connection = instance.getConnection();
        String query = "SELECT f.nome AS freguesia, f.url AS url" +
                " FROM freguesia AS f WHERE f.id_concelho = " + concelho;

        // Create Statement
        Statement stmt = connection.createStatement();
        // Get Result Set
        ResultSet rs = stmt.executeQuery(query);
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|                             FREGUESIA                            |                                  URL                              |");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------");
        // Extract data from Result Set
        while (rs.next()) {
            // Retrieve by column name
            String f = rs.getString("FREGUESIA");
            String url = rs.getString("URL");
            // Display values
            System.out.printf("|%-65s | %-65s | %n", f, url);
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------\n");
        rs.close();
        stmt.close();

    }
}
