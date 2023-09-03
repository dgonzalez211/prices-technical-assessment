package com.diegodev.ditech.domain.repositories;

import com.diegodev.ditech.domain.models.Prices;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepository {

    List<Prices> getPrices(LocalDateTime applicationDate, Integer productId, Integer brandId);

}