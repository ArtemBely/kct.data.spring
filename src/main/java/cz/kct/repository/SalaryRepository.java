package cz.kct.repository;
import cz.kct.data.entity.PersonEntity;
import cz.kct.data.entity.SalaryEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Integer> {

    @Query("FROM SalaryEntity s JOIN s.personEntities p")
    Optional<SalaryEntity> getJoinInformation();

//    @Query("SELECT new cz.kct.data.dto.SalaryDto(d.position) FROM SalaryEntity d INNER JOIN d.personEntities e")
//    Optional<SalaryEntity> getJoinInformation();

//    @Query("SELECT p.quantity, n.id FROM SalaryEntity p JOIN PersonEntity n ON p.position = n.position")
//    Optional<SalaryEntity> getJoinInformation();


    @Query("FROM SalaryEntity p1 WHERE p1.quantity = :quantity AND p1.id = :id") //SIMPLE REQ'S
    public List<SalaryEntity> findByQty(@Param("quantity") Double quantity, @Param("id") int id); //COMPL REQ'S

}
