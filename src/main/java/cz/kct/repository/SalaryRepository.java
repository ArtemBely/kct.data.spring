package cz.kct.repository;

import cz.kct.data.entity.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Integer> {
    @Query("SELECT s.quantity FROM SalaryEntity s JOIN s.personEntities p")
    public String getJoinInformation();
}
