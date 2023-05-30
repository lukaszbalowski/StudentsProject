package pl.coderslab.studentsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.studentsproject.model.Subject;
import pl.coderslab.studentsproject.model.Teacher;
import pl.coderslab.studentsproject.model.Class;
import pl.coderslab.studentsproject.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImplement implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImplement(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Autowired
    private SubjectService subjectService;


    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID: " + id));
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {

        return teacherRepository.save(teacher);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @Override
    public void deleteTeacher(long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID: " + id));

//        List<Class> classes = teacher.getClasses();
//        for (Class group : classes) {
//            group.getTeachers().remove(teacher);
//        }
//
//        List<Subject> subjects = teacher.getSubjects();
//        for (Subject subject : subjects) {
//            subject.getTeachers().remove(teacher);
//        }

        teacherRepository.delete(teacher);

    }

}