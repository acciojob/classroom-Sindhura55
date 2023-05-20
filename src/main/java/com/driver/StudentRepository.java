package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {
    static HashMap<String,Student> studentMap=new HashMap<>();
    static HashMap<String,Teacher> teacherMap=new HashMap<>();
    static HashMap<String,List<String>> studentTeacherMap=new HashMap<>();

    public void addStudentData(Student student){
        studentMap.put(student.getName(),student);
    }
    public void addTeacherData(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }
    public static void addStudentTeacherPair(String student, String teacher){
        List<String> studentList=new ArrayList<>();
        if(studentMap.containsKey(student)&&studentMap.containsKey(teacher)){
            if(studentTeacherMap.containsKey(teacher))
                studentList=studentTeacherMap.get(teacher);
            studentList.add(student);
            studentTeacherMap.put(teacher,studentList);
        }

    }
    public static Student getStudentDetails(String name){
        return studentMap.get(name);
    }
    public static Teacher getTeacher(String name){
        return teacherMap.get(name);
    }
    public static List<String> getStudentsByTeacherName(String teacher){
        return studentTeacherMap.get(teacher);
    }
    public static List<String> getAllStudents(){
        List<String> students =new ArrayList<>();
        for(String ans:studentMap.keySet()){
            students.add(ans);
        }
        return students;
    }
    public static void deleteTeacherByName(String teacher){
        List<String> students=new ArrayList<>();
        if(studentTeacherMap.containsKey(teacher)){
            students=studentTeacherMap.get(teacher);
            for(String s:students){
                if(studentMap.containsKey(s)){
                    studentMap.remove(s);
                }
            }
            studentTeacherMap.remove(teacher);
        }
        if(teacherMap.containsKey(teacher))
            teacherMap.remove(teacher);
    }
    public static void deleteAllTeachers(){
        HashSet<String> students= new HashSet<>();
        for(String teachers:studentTeacherMap.keySet()){
            for(String s:studentTeacherMap.get(teachers)){
                students.add(s);
            }
        }
        for(String ans:students){
            if(studentMap.containsKey(ans)){
                students.remove(ans);
            }
        }
    }

}
