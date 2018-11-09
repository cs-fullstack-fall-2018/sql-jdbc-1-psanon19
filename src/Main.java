import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here

        Connection connection = DriverManager.getConnection("jdbc:sqlite:Set_up");
        Statement stmt=connection.createStatement();
        Statement stmt2=connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM Teachers left join Classes on Teachers.ClassID = Classes.ClassID");
        ResultSet resultSet2 = stmt2.executeQuery("SELECT * FROM Classes left join Teachers on Classes.ClassID = Teachers.ClassID");


        while(resultSet.next())
        {
            Integer order = resultSet.getInt("TeacherID");
            String name = resultSet.getString("FirstName");
            String cname = resultSet.getString("ClassName");
            Integer order2 = resultSet.getInt("ClassID");

            System.out.println(name + " " + cname);
        }

        while(resultSet2.next()){

            String name = resultSet2.getString("ClassName");
            String cname = resultSet2.getString("FirstName");

            System.out.println(name + " " + cname);

        }

        stmt.close();
        stmt2.close();
        connection.close();
    }
}
