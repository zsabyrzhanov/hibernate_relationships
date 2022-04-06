package peaksoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.test.entity.Course;
import peaksoft.test.entity.Student;
import peaksoft.test.util.HibernateUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Course course = Course.builder()
                .name("Js-5")
                .build();

        Student student = Student.builder()
                .username("jon@gmail.com")
                .firstname("Усон")
                .lastname("Кейджи")
                .birthdate(LocalDate.of(2000, 01, 01))
                .age(22)
                .course(course)
                .build();
//        session.saveOrUpdate(student);
//        session.save(course);
//        session.save(student);
        Student student1 = session.get(Student.class,1l);
        session.delete(student1);
//        System.out.println(student1);
        session.getTransaction().commit();
    }
}
