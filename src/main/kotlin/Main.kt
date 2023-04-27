import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

fun main(args: Array<String>) {
    try {
        val connection: Connection =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/pinodb", "developer", "developer")
        val statement: Statement = connection.createStatement()

        statement.executeUpdate("UPDATE students SET country = 'Italy' WHERE student_id = 18")
        statement.executeUpdate("UPDATE students SET country = 'Italy' WHERE student_id = 19")
        statement.executeUpdate("UPDATE students SET country = 'Germany' WHERE student_id = 20")
        statement.executeUpdate("UPDATE students SET country = 'Germany' WHERE student_id = 21")
        val resultSet: ResultSet = statement.executeQuery("select * from students")

        while (resultSet.next()) {
            println(resultSet.getString("country"))
        }
    }catch (e: Exception){
        e.printStackTrace()
    }
}