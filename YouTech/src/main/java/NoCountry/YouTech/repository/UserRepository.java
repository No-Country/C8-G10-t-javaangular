package NoCountry.YouTech.repository;

import NoCountry.YouTech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findByEmail(String email);
}
