package cz.kct.repository;

import cz.kct.data.entity.ExcelEntity;
import cz.kct.data.entity.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcelRepository extends JpaRepository<ExcelEntity, Integer> {
}
