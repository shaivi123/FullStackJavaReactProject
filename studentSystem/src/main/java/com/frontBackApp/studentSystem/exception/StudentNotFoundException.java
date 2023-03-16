package com.frontBackApp.studentSystem.exception;

public class StudentNotFoundException extends RuntimeException{

           public StudentNotFoundException(Integer id){
               super("Could not found the user with id "+ id);
           }
}
