package dao;

import model.Student;

import java.sql.SQLException;


public interface StudentDao {

    public void addStudent(int id , String name,String lastName,int age) throws SQLException;

    public boolean deleteStudent(int id) throws SQLException;

    public void getInfoStudents() throws SQLException;

    public Student getStudentById(int id);


}
