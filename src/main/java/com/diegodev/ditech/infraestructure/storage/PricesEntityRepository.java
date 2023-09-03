package com.diegodev.ditech.infraestructure.storage;

import com.diegodev.ditech.infraestructure.storage.entities.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface PricesEntityRepository extends JpaRepository<PricesEntity, UUID> {
    List<PricesEntity> findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime applicationDateStart, LocalDateTime applicationDateEnd, Integer productId, Integer brandId);
}