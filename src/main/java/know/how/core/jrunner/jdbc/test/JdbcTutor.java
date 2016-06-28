package know.how.core.jrunner.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class JdbcTutor {
    /**
     * Please rename DB_NAME to your name, for example 
     * static final String DB_NAME="JohnDoe";
     */
    static final String DB_NAME="skurski";
    
    Connection conn;
    
    public static void main(String[] a) {
        JdbcTutor t = null;
        try {
            t = new JdbcTutor();                
    
            /**
             * Create table and Insert can be executed only once!
             */
            t.dropTables();
            t.createTableStudents();
            t.createTableMarks();
            t.addStudent(1, "Andrew", "andrew@mail.ua");
            t.addStudent(2, "John", "john@mail.ua");
            t.addMark(5,1); // add mark 5 to Andrew
            t.addMark(4,1); // and mark 4
            t.addMark(5,2); // add mark 5 to John
            
            Student[] students = {
            		new Student("Kennedy", "kennedy@one.pl"),
            		new Student("Samson", "samson@one.pl"),
            		new Student("Polsat", "polsat@one.pl"),
            };
            t.addStudents(Arrays.asList(students));
            
            /**
             * Print all students and average marks
             */
            t.printStudents();
            
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            t.closeConnection();
        }
        
    }
    
    public JdbcTutor() {
        openConnection();
    }
    
    public Connection openConnection() {
        try {
            Class.forName("org.h2.Driver"); // this is driver for H2
            conn = DriverManager.getConnection("jdbc:h2:~/"+DB_NAME, 
                "sa", // login
                "" // password
                );
            return conn;
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void closeConnection() {
        try {
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void dropTables() throws SQLException {
    	String drop = "DROP TABLE IF EXISTS MARKS; DROP TABLE IF EXISTS STUDENTS;";
    	Statement stmt = conn.createStatement();
    	stmt.executeUpdate(drop);
    	stmt.close();
    }

    /**
     * Should create table Students
     */
    public void createTableStudents() throws SQLException {
    	String sql = "Create Table if not exists students (" +
    				"id int auto_increment primary key," +
    				"name varchar(255)," +
    				"email varchar(255))";

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
    }

    /**
     * Should create table Marks
     */
    public void createTableMarks() throws SQLException {
    	String sql = "Create Table if not exists marks (" +
				"id int auto_increment primary key," +
				"student_id int," +
				"mark int," +
				"comments varchar(255)," +
				"foreign key (student_id) " +
				"references students (id))";

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
    }
    
    /**
     * Should add student to the Students table
     */
    public void addStudent(int id, String name, String email) throws SQLException {
    	String insert = "insert into students (id,name,email) values (?,?,?);";
    	PreparedStatement prepStmt = conn.prepareStatement(insert);
    	prepStmt.setInt(1, id);
    	prepStmt.setString(2, name);
    	prepStmt.setString(3, email);
    	prepStmt.executeUpdate();
    	prepStmt.close();
    }
    
    /**
     * Should add mark to the Student
     */
    public void addMark(int mark, int student) throws SQLException {
    	String insert = "insert into marks (student_id,mark) values (?,?);";
    	PreparedStatement prepStmt = conn.prepareStatement(insert);
    	prepStmt.setInt(1, student);
    	prepStmt.setInt(2, mark);
    	prepStmt.executeUpdate();
    	prepStmt.close();
    }

    /**
     * Should print all students and their marks
     */
    public void printStudents() throws SQLException {
    	Statement stmt = conn.createStatement();
    	String select = "select s.name, avg(m.mark) as average_mark from students s " +
    					"join marks m on m.student_id = s.id group by s.name;";
    	ResultSet result = stmt.executeQuery(select);
    	while (result.next()) {
    		System.out.println(result.getString(1) + " => " + result.getString(2));
    	}
    	
    	result.close();
    	stmt.close();
    }
    
    private static class Student {
    	String name;
    	String email;
    	Student(String name, String email) {
    		this.name = name;
    		this.email = email;
    	}
    }
    
    /**
     * Add list of students using Batch
     * @throws java.sql.SQLException
     */
    public void addStudents(List<Student> students) throws SQLException {
    	final String insert = "insert into students (name,email) values (?,?);";
    	final PreparedStatement prepStmt = conn.prepareStatement(insert);
    	
    	try {
    		for (Student stud: students) {
    			prepStmt.setString(1, stud.name);
    			prepStmt.setString(2, stud.email);
    			prepStmt.addBatch();
    		}
    		
    		final int[] results = prepStmt.executeBatch();
    		for (int i=0; i<results.length; i++) {
                if (results[i] == Statement.EXECUTE_FAILED) {
                    System.out.println("Batch #" + i + " - Failed.");
                } else if (results[i] == Statement.SUCCESS_NO_INFO) {
                    System.out.println("Batch #" + i + " - Succeded with no results.");
                } else {
                    System.out.println("Batch #" + i + " - Affected " + results[i] + " rows.");
                }
    		}
    	} finally {
    		prepStmt.close();
    	}
    }
}


