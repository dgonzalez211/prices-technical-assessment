package com.diegodev.ditech.infraestructure.controller;

import com.diegodev.ditech.infraestructure.dto.PricesDto;
import com.diegodev.ditech.application.mappers.PricesDtoMapper;
import com.diegodev.ditech.domain.usecase.PricesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@Slf4j
public class PricesController {

    private final PricesService pricesService;

    private final PricesDtoMapper pricesDtoMapper;

    @GetMapping(value = "/prices")
    public ResponseEntity<PricesDto> getPrices(@RequestParam(name = "applicationDate") LocalDateTime applicationDate,
                                                     @RequestParam(name = "productId") Integer productId,
                                                     @RequestParam(name = "brandId") Integer brandId) {
        log.info("PricesController - Get Prices by {} - {} - {}", applicationDate, productId, brandId);

        return ResponseEntity.ok(pricesDtoMapper.toPricesDto(
                pricesService.getPrices(applicationDate, productId, brandId))
        );
    }

}