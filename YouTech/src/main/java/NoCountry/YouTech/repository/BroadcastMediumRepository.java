package NoCountry.YouTech.repository;

import NoCountry.YouTech.entities.BroadcastMedium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadcastMediumRepository extends JpaRepository<BroadcastMedium, Integer> {
}
