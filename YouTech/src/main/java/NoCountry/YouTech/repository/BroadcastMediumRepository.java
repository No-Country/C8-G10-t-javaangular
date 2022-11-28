package NoCountry.YouTech.repository;

import NoCountry.YouTech.model.BroadcastMedium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadcastMediumRepository extends JpaRepository<BroadcastMedium, Integer> {
}
