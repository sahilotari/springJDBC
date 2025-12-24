package com.sahil.springjdbcdemo.repo;

// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sahil.springjdbcdemo.model.Student;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;
    

    public void save(Student s) {
        System.out.println("DAO: Saving Student: "+ s.toString());  
        String sql = """
                INSERT INTO student (rollno, name, marks)
                VALUES (?, ?, ?)
                """;
        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());  
        System.out.println(rows + " effected...");    
    }

    public List<Student> findAll() {
        System.out.println("DAO: Finding all students...");
        String sql = """
                SELECT * FROM student
                """;

        RowMapper<Student> mapper = (rs, rowNum) ->{
                Student s = new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
        };
        return jdbc.query(sql, mapper);
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    // Setter injection
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

}
