package utils;

import com.github.javafaker.Faker;

import java.sql.*;
import java.time.LocalDate;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateSql {
    
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/datingApp";
        String dbUser = "root";
        String dbPassword = "";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String createTableSql;
            
            createTableSql = "CREATE TABLE IF NOT EXISTS users ("
                  + "id INT AUTO_INCREMENT PRIMARY KEY, "
                  + "name VARCHAR(255), "
                  + "email VARCHAR(255), "
                  + "birth_date DATE, "
                  + "gender CHAR(1), "
                  + "displayName VARCHAR(255))";
            executeSql(createTableSql, connection);
            
            createTableSql = "CREATE TABLE IF NOT EXISTS profile ("
                  + "id INT AUTO_INCREMENT PRIMARY KEY, "
                  + "user_id INT, "
                  + "display_name VARCHAR(255), "
                  + "birth_date DATE, "
                  + "gender CHAR(1), "
                  + "bio TEXT, "
                  + "profile_image VARCHAR(255), "
                  + "FOREIGN KEY (user_id) REFERENCES users(id))";
            executeSql(createTableSql, connection);
            
            
            createTableSql = "CREATE TABLE IF NOT EXISTS images ("
                  + "id INT AUTO_INCREMENT PRIMARY KEY, "
                  + "user_id INT, "
                  + "image_url VARCHAR(255), "
                  + "is_public BOOLEAN, "
                  + "display_order INT, "
                  + "bio TEXT, "
                  + "display_name VARCHAR(255),"
                  + "birth_date DATE, "
                  + "profile_image VARCHAR(255), "
                  + "FOREIGN KEY (user_id) REFERENCES users(id))";
            executeSql(createTableSql, connection);
            
            Faker faker = new Faker(new Locale("en-US"));
            String birthDatePattern = "yyyy-MM-dd";
            String insertStatement =
                  "INSERT INTO users (id, name, email, birth_date, gender, displayName) VALUES " +
                        "(?, ?, ?, ?, ?, ?)";
            
            for (int i = 0; i < 25; i++) {
                long id = faker.number().randomNumber();
                String name = faker.name().firstName();
                String email = faker.internet().emailAddress();
                String username = faker.name().username();
                String displayName = username.substring(0, Math.min(255, username.length()));
                String gender = faker.options().option("M", "F");
                
                LocalDate startDate = LocalDate.of(1950, 1, 1);
                long start = startDate.toEpochDay();
                LocalDate endDate = LocalDate.now().minusYears(18);
                long end = endDate.toEpochDay();
                long randomEpochDay = ThreadLocalRandom
                      .current()
                      .longs(start, end)
                      .findAny()
                      .orElseThrow(() -> new RuntimeException("No random value could be generated"));
                
                try (PreparedStatement pstmt = connection.prepareStatement(insertStatement)) {
                    pstmt.setLong(1, id);
                    pstmt.setString(2, name);
                    pstmt.setString(3, email);
                    pstmt.setDate(4, Date.valueOf(LocalDate.ofEpochDay(randomEpochDay)));
                    pstmt.setString(5, gender);
                    pstmt.setString(6, displayName);
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void executeSql(String createTableSql, Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}