package com.example.demo.boot.controller;

import com.example.demo.boot.bean.Student;
import com.example.demo.boot.response.ResponseHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController//@Contoller + @ResponseBody //@Component + @Controller rest :: for rest apis
@RequestMapping("students")
public class StudentController {

    static List<Student> studentList = new ArrayList<>();

    static{
        Student student1 = new Student(1, "Bob", "Billy");
        Student student2 = new Student(2, "Ana", "Potter");

        studentList.add(student1); // 0th element
        studentList.add(student2); // 1st element
    }
    @GetMapping("welcome-note")
    public String firstAPI(){
        return "Hello! Welcome to the Spring boot API";
    }

    @GetMapping("next-steps")
    public String nextSteps(){
        return "Next Steps are : click here";
    }

    @Operation(
            summary = "Get End point",
            description = "To get a single default student"
    )
    @ApiResponse(
            responseCode = "200",
            description = "200 OK, successfully retrieved"

    )
    @GetMapping("getStudent")
    public ResponseEntity<Object> getStudent(){
        Student student = new Student(3, "John", "Doe");
        return ResponseHandler.generateResponse("Successfully Retrieved Student", HttpStatus.OK, student);
    }


    @GetMapping("listStudents")
    public ResponseEntity<List<Student>> getStudentList(){
        //select * from students
        return  ResponseEntity.ok().body(studentList);
    }


    @GetMapping("getStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer studentId){
        //select * from students where studentid=1
        Student student = studentList.get(studentId-1);
        return  ResponseEntity.ok().body(student);
    }

    @PostMapping("createStudent")
    public ResponseEntity<List<Student>> createStudent(@RequestBody Student student){
        // {"id":4,"firstName":"Peter","lastName":"Parker"}
        //insert into students(firstName,lastName) values()

        student.setId(studentList.size()+1);
        studentList.add(student);
        return new ResponseEntity<>(studentList, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student
            , @PathVariable("id") Integer studentId){
        //update student set() values () where id =1

        studentList.set(studentId-1, student);

        return ResponseEntity.ok(student);
    }

    @DeleteMapping("delete/{id}/{firstName}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId,
                                                @PathVariable("firstName") String firstName) {
        //delete * from students where id = 1

        studentList.remove(studentId-1);


        return new ResponseEntity<>
                ("Student  deleted successfully",
                        HttpStatus.NO_CONTENT);
    }


    @GetMapping("query")
    public ResponseEntity<Object> getStudentByQuery(@RequestParam int id, @RequestParam String firstName){
        //select * from student where id = 1 and firstName = "John"
        Student student = new Student(id, firstName, "Doe"); //pass params here
        return ResponseEntity.ok().body(student);

    }

}
