package com.diegodev.ditech.domain.usecase;

import com.diegodev.ditech.domain.models.Prices;

import java.time.LocalDateTime;

public interface PricesService {

    Prices getPrices(LocalDateTime applicationDate, Integer productId, Integer brandId);

}