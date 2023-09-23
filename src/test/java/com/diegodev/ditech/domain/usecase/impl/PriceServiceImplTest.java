package com.diegodev.ditech.domain.usecase.impl;

import com.diegodev.ditech.domain.usecase.PricesService;
import com.diegodev.ditech.application.usecase.impl.PricesServiceImpl;
import com.diegodev.ditech.domain.models.Prices;
import com.diegodev.ditech.domain.repositories.PricesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.*;

@ExtendWith(SpringExtension.class)
class PriceServiceImplTest {

    private PricesService pricesService;

    private PricesRepository pricesRepository;

    @BeforeEach
    void setup() {
        pricesRepository = mock(PricesRepository.class);
        pricesService = new PricesServiceImpl(pricesRepository);
    }

    @Test
    void givenApplicationDateAndProductIdAndBrandId_whenFindByThoseFields_ThenReturnAListOfPrices() {
        // arrange
        when(pricesRepository.getPrices(any(), any(), any())).thenReturn(Collections.singletonList(Prices.builder()
                .id(UUID.fromString("c0acbd79-10bd-4e73-bf9b-82251e74dd4d"))
                .brandId(1)
                .startDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-14T00:00:00", LocalDateTime::from))
                .endDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-12-31T23:59:59", LocalDateTime::from))
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.5F)
                .curr("EUR")
                .build()));

        // act
        List<Prices> pricesList = Collections.singletonList(
                pricesService.getPrices(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-14T00:00:00", LocalDateTime::from), 35455, 1)
        );

        // assert
        verify(pricesRepository).getPrices(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-14T00:00:00", LocalDateTime::from), 35455, 1);
        assertFalse("PricesList should not be empty", CollectionUtils.isEmpty(pricesList));
        assertEquals("PricesList size should be 1", 1, pricesList.size());

    }

    @Test
    void givenApplicationDateAndProductIdAndBrandId_whenNoPricesFound_ThenReturnNull() {
        // arrange
        when(pricesRepository.getPrices(any(), any(), any())).thenReturn(Collections.emptyList());

        // act
        Prices prices = pricesService.getPrices(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-14T00:00:00", LocalDateTime::from), 35455, 1);

        // assert
        verify(pricesRepository).getPrices(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-14T00:00:00", LocalDateTime::from), 35455, 1);
        assertNull("Prices should be null when no prices found", prices);
    }

    @Test
    void givenMultiplePricesForSameProductAndDate_whenFindByThoseFields_ThenReturnHighestPriorityPrice() {
        // arrange
        List<Prices> multiplePrices = List.of(
                Prices.builder().priority(1).price(10.0F).build(),
                Prices.builder().priority(2).price(20.0F).build(),
                Prices.builder().priority(3).price(30.0F).build()
        );

        when(pricesRepository.getPrices(any(), any(), any())).thenReturn(multiplePrices);

        // act
        Prices prices = pricesService.getPrices(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-14T00:00:00", LocalDateTime::from), 35455, 1);

        // assert
        verify(pricesRepository).getPrices(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-14T00:00:00", LocalDateTime::from), 35455, 1);
        assertEquals("Prices should have highest priority", 3, prices.getPriority());
    }

    @Test
    void givenNullParameters_whenFindByThoseFields_ThenReturnNull() {
        // act
        Prices prices = pricesService.getPrices(null, null, null);

        // assert
        assertNull("Prices should be null when parameters are null", prices);
    }


}