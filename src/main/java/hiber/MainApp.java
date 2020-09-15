package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("ERT564QW", 3645)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("BLM532PY", 9321)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("LTK108RE", 1319)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("QSV093ZX", 8254)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car Name = "+user.getCar().getName());
         System.out.println("Car Series = "+user.getCar().getSeries());
         System.out.println();
      }
      User u = userService.getUserByCar("QSV093ZX", 8254);
      System.out.println("Id = " + u.getId());
      System.out.println("First Name = " + u.getFirstName());
      System.out.println("Last Name = " + u.getLastName());
      System.out.println("Email = " + u.getEmail());
      System.out.println();
      context.close();
   }
}
