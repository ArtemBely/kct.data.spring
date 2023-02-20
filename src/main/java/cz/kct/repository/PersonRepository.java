package cz.kct.repository;

import cz.kct.data.entity.PersonEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    public PersonEntity findByFirstNameAndLastName(String firstName, String lastName);

    @Modifying
    @Query("FROM PersonEntity p1 WHERE p1.firstName = :firstName AND p1.lastName = :lastName")
    public List<PersonEntity> findByAlternative(@Param("firstName") String firstName, @Param("lastName") String lastName);


}
