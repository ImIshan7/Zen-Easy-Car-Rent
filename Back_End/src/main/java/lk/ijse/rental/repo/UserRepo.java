package lk.ijse.rental.repo;

import lk.ijse.rental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String> {

    @Query(value = "select * from User where user_Name=? AND password=? limit 1",nativeQuery = true)
    User findUserByUser_NameAndPassword(String username, String password) throws RuntimeException;
}
