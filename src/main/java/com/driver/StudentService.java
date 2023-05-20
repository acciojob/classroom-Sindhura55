package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

     StudentRepository studentRepository=new StudentRepository();
     public void addStudentDetails(Student student){
          studentRepository.addStudentData(student);
     }
     public void addTeacherDetails(Teacher teacher){
          studentRepository.addTeacherData(teacher);
     }
     public void addStudentTeacherPair(String student,String teacher)
     {
          StudentRepository.addStudentTeacherPair(student,teacher);
     }
     public static Student getStudent(String name){
         return StudentRepository.getStudentDetails(name);
     }
     public static Teacher getTeacher(String name){
          return StudentRepository.getTeacher(name);
     }
     public static List<String> getStudentsByTeacherName(String teacher){
          return StudentRepository.getStudentsByTeacherName(teacher);
     }
     public static List<String> getAllStudents(){
          return StudentRepository.getAllStudents();
     }
     public static void deleteTeacherByName(String teacher) {
          StudentRepository.deleteTeacherByName(teacher);
     }
     public static void deleteAllTeachers(){
          StudentRepository.deleteAllTeachers();
     }




}
