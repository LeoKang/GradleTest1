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

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "c##green";
        String password = "green1234";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String sql = "SELECT deptno, dname, loc FROM dept";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("----------------------------");
            while (rs.next()) {
                System.out.print(rs.getString("deptno") + " ");
                System.out.print(rs.getString("dname") + " ");
                System.out.println(rs.getString("loc") + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Frame f = new Frame("AWT Test");
        f.setSize(300, 200);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }
}
