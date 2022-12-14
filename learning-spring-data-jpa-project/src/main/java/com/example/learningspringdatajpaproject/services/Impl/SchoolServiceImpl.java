package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.entities.*;
import com.example.learningspringdatajpaproject.exceptions.*;
import com.example.learningspringdatajpaproject.repositories.*;
import com.example.learningspringdatajpaproject.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final CourseMaterialRepository courseMaterialRepository;
    private final CourseClassRepository courseClassRepository;
    private final CourseClassStudentGradeRepository courseClassStudentGradeRepository;

    @Override
    public Guardian saveGuardian(Guardian guardian) { return guardianRepository.save(guardian); }

    @Override
    public Course saveCourse(Course course) { return courseRepository.save(course); }

    @Override
    public CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial)
    {
        return courseMaterialRepository.save(courseMaterial);
    }

    @Override
    public CourseClass saveCourseClass(CourseClass courseClass) { return courseClassRepository.save(courseClass); }

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
    public Course assignCourseMaterialToCourse(Long courseId, Long courseMaterialId) {
        var course = findCourseByIdOrElseThrowException(courseId);
        var courseMaterial = findCourseMaterialByIdOrElseThrowException(courseMaterialId);

        verifyCourseAlreadyHasMaterial(course);

        course.setMaterial(courseMaterial);
        return courseRepository.save(course);
    }

    @Override
    public CourseClass assignCourseClassToCourse(Long courseId, Long courseClassId) {
        var course = findCourseByIdOrElseThrowException(courseId);
        var courseClass = findCourseClassByIdOrElseThrowException(courseClassId);

        courseClass.getCourses().add(course);
        return courseClassRepository.save(courseClass);
    }

    @Override
    public CourseClass assignStudentToCourseClass(Long studentId, Long courseClassId) {
        var student = findStudentByIdOrElseThrowException(studentId);
        var courseClass = findCourseClassByIdOrElseThrowException(courseClassId);

        verifyIfCanAssignClassToStudent(student, courseClass);

        courseClass.getStudents().add(student);

        return courseClassRepository.save(courseClass);
    }

    @Override
    public CourseClass assignTeacherToCourseClass(Long teacherId, Long courseClassId) {
        var teacher = getTeacherById(teacherId);
        var courseClass = getCourseClassById(courseClassId);

        verifyCourseClassAlreadyHasATeacher(courseClass);

        courseClass.setTeacher(teacher);
        courseClassRepository.save(courseClass);
        return courseClass;
    }

    @Override
    public Student assignGradeToClass(Long studentId, Long courseClassId, CourseClassStudentGrade grade) {
        var student = findStudentByIdOrElseThrowException(studentId);
        var courseClass = findCourseClassByIdOrElseThrowException(courseClassId);

        verifyIfIsValidClass(student, courseClass);

        grade.getStudentsGrade().add(student);
        grade.getClasses().add(courseClass);
        courseClassStudentGradeRepository.save(grade);

        return student;
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
    public CourseMaterial getCourseMaterialById(Long courseMaterialId)
    {
        return findCourseMaterialByIdOrElseThrowException(courseMaterialId);
    }

    @Override
    public CourseClass getCourseClassById(Long courseClassId)
    {
        return findCourseClassByIdOrElseThrowException(courseClassId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<CourseClass> getAllCourseClassesInACourseByTitle(String courseTitle) {
        var course = findCourseByTitleOrElseThrowException(courseTitle);
        return course.getClasses();
    }

    @Override
    public List<CourseClass> getAllCourseClassesOfAStudent(Long studentId) {
        var student = findStudentByIdOrElseThrowException(studentId);
        if(!student.getClasses().isEmpty()) return student.getClasses();
        return null;
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

    private CourseClass findCourseClassByIdOrElseThrowException(Long courseClassId)
    {
        return courseClassRepository.findById(courseClassId).orElseThrow(
                () -> new ObjectNotFoundException("Class not found not found!")
        );
    }

    private Student findStudentByEmailOrElseThrowException(String studentEmail)
    {
        return studentRepository.findByEmail(studentEmail).orElseThrow(
                () -> new WrongEmailOrPasswordException("Wrong e-mail or password!")
        );
    }

    private Course findCourseByTitleOrElseThrowException(String courseTitle)
    {
        return courseRepository.findByTitle(courseTitle).orElseThrow(
                () -> new ObjectNotFoundException("Course not Found!")
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

    private void verifyCourseClassAlreadyHasATeacher(CourseClass courseClass) {
        if(courseClass.getTeacher() != null)
            throw new CourseAlreadyHasTeacherException("This class already has a teacher! ");
    }

    private void verifyCourseAlreadyHasMaterial(Course course) {
        if(course.getMaterial() != null)
            throw new CourseAlreadyHasTeacherException("This course already has material for it! ");
    }

    private void verifyIfCanAssignClassToStudent(Student student, CourseClass courseClass)
    {
        AtomicBoolean bol = new AtomicBoolean(false);

        if(student.getClasses().contains(courseClass))
            throw new InvalidClassException("student Already registered in this class");

        courseClass.getCourses().forEach((x) -> {
            if(x.getCourseId() == student.getCourse().getCourseId()) bol.set(true);
        });

        if(!bol.get()) throw new InvalidClassException("This class does not belong to this student's grade!");
    }

    private void verifyIfIsValidClass(Student student, CourseClass courseClass)
    {
        if(!student.getClasses().contains(courseClass))
            throw new InvalidClassException("This student is not registered in this class");
    }
}
