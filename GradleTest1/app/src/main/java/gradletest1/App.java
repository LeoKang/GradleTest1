/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradletest1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static class DBInfo {
        public static String driver = "oracle.jdbc.driver.OracleDriver";
        public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
        public static String user = "c##green";
        public static String password = "green1234";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        try {
            Class.forName(DBInfo.driver);
            Connection conn = DriverManager.getConnection(DBInfo.url, DBInfo.user, DBInfo.password);
            Statement stmt = conn.createStatement();

            String sql = "SELECT deptno, dname, loc FROM dept";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("- START ---------------------------");
            while (rs.next()) {
                System.out.print(rs.getString("deptno") + " ");
                System.out.print(rs.getString("dname") + " ");
                System.out.println(rs.getString("loc") + " ");
            }
            System.out.println("- END ---------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Frame f = new Frame("AWT Test");
        f.setSize(300, 200);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);     // program exit
            }
        });
        f.setVisible(true);
    }
}
