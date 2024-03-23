import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            
            Session session = factory.getCurrentSession();
            Employee employee = new Employee();
            employee.setName("John Doe");
            employee.setSalary(50000);

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }
}