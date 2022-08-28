package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.entities.*;
import com.example.learningspringdatajpaproject.exceptions.CourseAlreadyHasTeacherException;
import com.example.learningspringdatajpaproject.exceptions.GuardianAlreadyHasStudentException;
import com.example.learningspringdatajpaproject.exceptions.ObjectNotFoundException;
import com.example.learningspringdatajpaproject.exceptions.StudentIsAlreadyTakingACourseException;
import com.example.learningspringdatajpaproject.repositories.*;
import com.example.learningspringdatajpaproject.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final CourseMaterialRepository courseMaterialRepository;

    @Override
    public Student saveStudent(Student student) { return studentRepository.save(student); }

    @Override
    public Guardian saveGuardian(Guardian guardian) { return guardianRepository.save(guardian); }

    @Override
    public Course saveCourse(Course course) { return courseRepository.save(course); }

    @Override
    public Teacher saveTeacher(Teacher teacher) { return teacherRepository.save(teacher); }

    @Override
    public CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial)
    {
        return courseMaterialRepository.save(courseMaterial);
    }

    @Override
    public Guardian assignGuardianToStudent(Long studentId, Long guardianId) {
        var student = findStudentByIdOrElseThrowException(studentId);
        var guardian = findGuardianByIdOrElseThrowException(guardianId);

        verifyIfGuardianAlreadyHasAStudent(guardian);

        guardian.setStudent(student);
        return guardianRepository.save(guardian);
    }

    @Override
    public Student assignStudentToACourse(Long studentId, Long courseId) {
        var student = findStudentByIdOrElseThrowException(studentId);
        var course = findCourseByIdOrElseThrowException(courseId);

        verifyIfStudentIsAlreadyTakingACourse(student);

        student.setCourse(course);
        return studentRepository.save(student);
    }

    @Override
    public Course assignTeacherToCourse(Long teacherId, Long courseId) {
        var teacher = findTeacherByIdOrElseThrowException(teacherId);
        var course = findCourseByIdOrElseThrowException(courseId);

        verifyCourseAlreadyHasATeacher(course);

        course.setTeacher(teacher);
        return courseRepository.save(course);
    }

    @Override
    public Course assignCourseMaterialToCourse(Long courseId, Long courseMaterialId) {
        var course = findCourseByIdOrElseThrowException(courseId);
        var courseMaterial = findCourseMaterialByIdOrElseThrowException(courseMaterialId);

        verifyCourseAlreadyHasMaterial(course);

        course.setMaterial(courseMaterial);
        return courseRepository.save(course);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return findStudentByIdOrElseThrowException(studentId);
    }

    @Override
    public Guardian getGuardianById(Long guardianId) {
        return findGuardianByIdOrElseThrowException(guardianId);
    }

    @Override
    public Course getCourseById(Long courseId) { return findCourseByIdOrElseThrowException(courseId); }

    @Override
    public Teacher getTeacherById(Long teacherId) { return findTeacherByIdOrElseThrowException(teacherId); }

    @Override
    public CourseMaterial getCourseMaterialById(Long courseMaterialId) {
        return findCourseMaterialByIdOrElseThrowException(courseMaterialId);
    }

    private Student findStudentByIdOrElseThrowException(Long studentId)
    {
        return studentRepository.findById(studentId).orElseThrow(
                () -> new ObjectNotFoundException("Student not found!")
        );
    }

    private Guardian findGuardianByIdOrElseThrowException(Long guardianId)
    {
        return guardianRepository.findById(guardianId).orElseThrow(
                () -> new ObjectNotFoundException("Guardian not found!")
        );
    }

    private Course findCourseByIdOrElseThrowException(Long courseId)
    {
        return courseRepository.findById(courseId).orElseThrow(
                () -> new ObjectNotFoundException("Course not found!")
        );
    }

    private Teacher findTeacherByIdOrElseThrowException(Long teacherId)
    {
        return teacherRepository.findById(teacherId).orElseThrow(
                () -> new ObjectNotFoundException("Teacher not found!")
        );
    }

    private CourseMaterial findCourseMaterialByIdOrElseThrowException(Long courseMaterialId)
    {
        return courseMaterialRepository.findById(courseMaterialId).orElseThrow(
                () -> new ObjectNotFoundException("Course material not found!")
        );
    }

    private void verifyIfGuardianAlreadyHasAStudent(Guardian guardian) {
        if(guardian.getStudent() != null)
            throw new GuardianAlreadyHasStudentException("This guardian already has a student assigned! ");
    }

    private void verifyIfStudentIsAlreadyTakingACourse(Student student) {
        if(student.getCourse() != null)
            throw new StudentIsAlreadyTakingACourseException("This student can't change course! ");
    }

    private void verifyCourseAlreadyHasATeacher(Course course) {
        if(course.getTeacher() != null)
            throw new CourseAlreadyHasTeacherException("This course already has a teacher! ");
    }

    private void verifyCourseAlreadyHasMaterial(Course course) {
        if(course.getMaterial() != null)
            throw new CourseAlreadyHasTeacherException("This course already has material for it! ");
    }
}
