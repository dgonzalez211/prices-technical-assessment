package com.diegodev.ditech.domain.services;

import com.diegodev.ditech.domain.models.Prices;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesService {

    List<Prices> getPrices(LocalDateTime applicationDate, Integer productId, Integer brandId);

}