import java.sql.*;
public class student {
    private Connection con;
    public student() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/std_management",
                    "root",
                    "titli@2006"
            );
            System.out.println("Database connected successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertStudent(int id, String name, int age, String course) {
        try {
            String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, course);
            ps.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showAllStudents() {
        try {
            String sql = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nID\tName\tAge\tCourse");
            System.out.println("--------------------------------");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getInt("age") + "\t" +
                                rs.getString("course")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateStudent(int id, String name, int age, String course) {
        try {
            String sql = "UPDATE student SET name=?, age=?, course=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Student updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id) {
        try {
            String sql = "DELETE FROM student WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Database connection closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
