package NoCountry.YouTech.repository;

import NoCountry.YouTech.Projection.IPContentCreator;
import NoCountry.YouTech.model.ContentCreator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentCreatorRepository extends JpaRepository<ContentCreator, Integer> {
    @Query("SELECT c.idContentCreator as idContentCreator,user.email as email, c.name as name,c.lastName as lastName,c.imageProfile as imageProfile ,user.isAdmin as isAdmin FROM ContentCreator c JOIN c.idUser user WHERE user.email=:email")
    IPContentCreator findByEmail(String email);
}
