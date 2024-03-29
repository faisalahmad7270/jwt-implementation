package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Course;
import com.course.entity.JwtAuthResponse;
import com.course.entity.LoginDto;
import com.course.service.ServiceImpl;
import com.course.serviceAndImpl.AuthService;

@RestController
@RequestMapping("/api/auth")
public class Controller {
	@Autowired
    private ServiceImpl courseService;
	
	@Autowired
	private AuthService authService;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(course);
        return ResponseEntity.ok(updatedCourse);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        Course course = courseService.getCourse(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/welcome")
    public String welCome() {
    	return "Welcome to My Page";
    }
}
