package NoCountry.YouTech.repository;

import NoCountry.YouTech.model.ContentCreator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentCreatorRepository extends JpaRepository <ContentCreator, Integer> {
    public String findByName(@Param("name") String name);

}
