package cz.kct.repository;
import cz.kct.data.entity.PersonEntity;
import cz.kct.data.entity.SalaryEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Integer> {

    @Query("SELECT p FROM PersonEntity p JOIN p.salaryEntity s")
    List<PersonEntity> getJoinInformation();

    @Query("FROM SalaryEntity p1 WHERE p1.quantity = :quantity AND p1.id = :id") //SIMPLE REQ'S
    public List<SalaryEntity> findByQty(@Param("quantity") Double quantity, @Param("id") int id); //COMPL REQ'S

}
