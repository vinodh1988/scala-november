import java.sql.{Connection, DriverManager, ResultSet, Statement}

object DatabaseExample {
  def main(args: Array[String]): Unit = {
    // Load the JDBC driver
    Class.forName("com.mysql.cj.jdbc.Driver")

    // Establish a connection
    val url = "jdbc:mysql://scaladb.mysql.database.azure.com:3306/scala"
    val username = "mysqladmin"
    val password = "XXXXXXXXXXX"
    val connection: Connection = DriverManager.getConnection(url, username, password)

    try {
      // Create a statement
      val statement: Statement = connection.createStatement()

      // Create a table
      val createTableSQL =
        """
          CREATE TABLE IF NOT EXISTS employees (
           id INT AUTO_INCREMENT PRIMARY KEY,
           name VARCHAR(100),
           age INT
          )
          """

      statement.execute(createTableSQL)
      println("Table created successfully.")

      // Insert some data
      val insertSQL =
        """
          INSERT INTO employees (name, age)
           VALUES ('John Doe', 30),
               ('Jane Smith', 25)
          """

      statement.executeUpdate(insertSQL)
      println("Data inserted successfully.")

      // Query the data
      val query = "SELECT * FROM employees"
      val resultSet: ResultSet = statement.executeQuery(query)

      // Process the ResultSet
      println("Employees:")
      while (resultSet.next()) {
        val id = resultSet.getInt("id")
        val name = resultSet.getString("name")
        val age = resultSet.getInt("age")
        println(s"ID: $id, Name: $name, Age: $age")
      }
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      // Close Statement and Connection
      connection.close()
    }
  }
}
