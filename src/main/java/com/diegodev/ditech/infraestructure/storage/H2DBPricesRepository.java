package com.diegodev.ditech.infraestructure.storage;

import com.diegodev.ditech.domain.models.Prices;
import com.diegodev.ditech.domain.repositories.PricesRepository;
import com.diegodev.ditech.infraestructure.storage.mappers.PricesMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class H2DBPricesRepository implements PricesRepository {

    private final PricesEntityRepository pricesEntityRepository;

    private final PricesMapper pricesMapper;

    @Override
    public List<Prices> getPrices(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        log.info("H2DbPricesRepository - Get Prices by {} - {} - {}", applicationDate, productId, brandId);
        return pricesMapper.toPrices(
                pricesEntityRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(applicationDate, applicationDate, productId, brandId));
    }
}