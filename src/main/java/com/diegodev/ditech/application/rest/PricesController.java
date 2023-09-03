package com.diegodev.ditech.application.rest;

import com.diegodev.ditech.application.rest.converters.LocalDateTimeConverter;
import com.diegodev.ditech.application.rest.dto.PricesDto;
import com.diegodev.ditech.application.rest.mappers.PricesDtoMapper;
import com.diegodev.ditech.domain.services.PricesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class PricesController {

    private final PricesService pricesService;

    private final PricesDtoMapper pricesDtoMapper;

    @GetMapping(value = "/prices")
    public ResponseEntity<List<PricesDto>> getPrices(@RequestParam(name = "applicationDate") String applicationDate,
                                                     @RequestParam(name = "productId") Integer productId,
                                                     @RequestParam(name = "brandId") Integer brandId) {
        log.info("PricesController - Get Prices by {} - {} - {}", applicationDate, productId, brandId);

        return ResponseEntity.ok(pricesDtoMapper.toPricesDto(
                pricesService.getPrices(LocalDateTimeConverter.parseDateTime(applicationDate), productId, brandId)));
    }

}