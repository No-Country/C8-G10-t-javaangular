package NoCountry.YouTech.repository;

import NoCountry.YouTech.model.BroadcastType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadcastTypeRepository extends JpaRepository <BroadcastType, Integer> {
}
