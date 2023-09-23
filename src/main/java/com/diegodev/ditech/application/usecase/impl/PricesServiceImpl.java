package com.diegodev.ditech.application.usecase.impl;

import com.diegodev.ditech.domain.models.Prices;
import com.diegodev.ditech.domain.repositories.PricesRepository;
import com.diegodev.ditech.domain.usecase.PricesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PricesServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;

    public Prices getPrices(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        log.info("PricesServiceImpl - Get Prices by {} - {} - {}", applicationDate, productId, brandId);

        List<Prices> pricesList = pricesRepository.getPrices(applicationDate, productId, brandId);
        List<Prices> mutablePricesList = new ArrayList<>(pricesList);
        mutablePricesList.sort(Comparator.comparing(Prices::getPriority).reversed());

        return mutablePricesList.isEmpty() ? null : mutablePricesList.get(0);
    }

}