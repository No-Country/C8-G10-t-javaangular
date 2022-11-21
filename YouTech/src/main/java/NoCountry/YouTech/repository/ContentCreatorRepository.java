package NoCountry.YouTech.repository;

import NoCountry.YouTech.entities.ContentCreator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentCreatorRepository extends JpaRepository <ContentCreator, Integer> {
}
