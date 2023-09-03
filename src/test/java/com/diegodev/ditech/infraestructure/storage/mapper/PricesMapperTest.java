package com.diegodev.ditech.infraestructure.storage.mapper;

import com.diegodev.ditech.domain.models.Prices;
import com.diegodev.ditech.infraestructure.storage.entities.PricesEntity;
import com.diegodev.ditech.infraestructure.storage.mappers.PricesMapper;
import com.diegodev.ditech.infraestructure.storage.mappers.PricesMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.util.AssertionErrors.*;

@ExtendWith(SpringExtension.class)
class PricesMapperTest {

    private PricesMapper pricesMapper;

    @BeforeEach
    void setup() {
        pricesMapper = new PricesMapperImpl();
    }

    @Test
    void givenAPriceEntity_whenTryToMapToPrices_thenReturnAPricesModelEntity() {

        // arrange
        PricesEntity pricesEntity =
                PricesEntity.builder()
                        .id(UUID.fromString("c0acbd79-10bd-4e73-bf9b-82251e74dd4d"))
                        .brandId(1)
                        .startDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-14T00:00:00", LocalDateTime::from))
                        .endDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-12-31T23:59:59", LocalDateTime::from))
                        .priceList(1)
                        .productId(35455)
                        .priority(0)
                        .price(35.5F)
                        .curr("EUR")
                        .build();

        // act
        Prices prices = pricesMapper.toPrices(pricesEntity);

        // assert
        assertNotNull("Prices should be not null", prices);
        assertEquals("Id should be c0acbd79-10bd-4e73-bf9b-82251e74dd4d", "c0acbd79-10bd-4e73-bf9b-82251e74dd4d", prices.getId().toString());
        assertEquals("BrandId should be 1", 1, prices.getBrandId());
        assertEquals("StartDate should be 2020-06-14T00:00:00", "2020-06-14T00:00:00", prices.getStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        assertEquals("EndDate should be 2020-12-31T23:59:59", "2020-12-31T23:59:59", prices.getEndDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        assertEquals("PriceList should be 1", 1, prices.getPriceList());
        assertEquals("ProductId should be 35455", 35455, prices.getProductId());
        assertEquals("Priority should be 0", 0, prices.getPriority());
        assertEquals("Price should be 35.5", 35.5F, prices.getPrice());
        assertEquals("Curr should be EUR", "EUR", prices.getCurr());

    }

    @Test
    void givenANullPriceEntity_whenTryToMapToPrices_thenReturnANullPricesModelEntity() {

        // arrange
        PricesEntity pricesEntity = null;
        PricesEntity.builder()
                .id(UUID.fromString("c0acbd79-10bd-4e73-bf9b-82251e74dd4d"))
                .brandId(1)
                .startDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-14T00:00:00", LocalDateTime::from))
                .endDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-12-31T23:59:59", LocalDateTime::from))
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.5F)
                .curr("EUR")
                .build();

        // act
        Prices prices = pricesMapper.toPrices(pricesEntity);

        // assert
        assertNull("Prices should be null", prices);

    }

    @Test
    void givenAPriceEntityList_whenTryToMapToPricesList_thenReturnAPricesModelEntityList() {

        // arrange
        PricesEntity pricesEntity1 =
                PricesEntity.builder()
                        .id(UUID.fromString("c0acbd79-10bd-4e73-bf9b-82251e74dd4d"))
                        .brandId(1)
                        .startDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-14T00:00:00", LocalDateTime::from))
                        .endDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-12-31T23:59:59", LocalDateTime::from))
                        .priceList(1)
                        .productId(35455)
                        .priority(0)
                        .price(35.5F)
                        .curr("EUR")
                        .build();

        PricesEntity pricesEntity2 =
                PricesEntity.builder()
                        .id(UUID.fromString("5bfe6227-456b-4722-ad18-f811c00803bf"))
                        .brandId(1)
                        .startDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-06-15T16:00:00", LocalDateTime::from))
                        .endDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2020-12-31T23:59:59", LocalDateTime::from))
                        .priceList(4)
                        .productId(35455)
                        .priority(1)
                        .price(38.95F)
                        .curr("EUR")
                        .build();

        List<PricesEntity> pricesEntityList = Arrays.asList(pricesEntity1, pricesEntity2);

        // act
        List<Prices> pricesList = pricesMapper.toPrices(pricesEntityList);

        // assert
        assertFalse("PricesList should be not empty", CollectionUtils.isEmpty(pricesList));
        assertEquals("PricesList size should be 2", 2, pricesList.size());
        assertEquals("Should contain an item with id c0acbd79-10bd-4e73-bf9b-82251e74dd4d", "c0acbd79-10bd-4e73-bf9b-82251e74dd4d", pricesList.stream().filter(prices -> prices.getId().compareTo(UUID.fromString("c0acbd79-10bd-4e73-bf9b-82251e74dd4d")) == 0).findFirst().orElseThrow().getId().toString());
    }

    @Test
    void givenAnEmptyPriceEntityList_whenTryToMapToPricesList_thenReturnAnEmptyPricesModelEntityList() {

        // arrange
        List<PricesEntity> pricesEntityList = new ArrayList<>();

        // act
        List<Prices> pricesList = pricesMapper.toPrices(pricesEntityList);

        // assert
        assertTrue("PricesList should be empty", CollectionUtils.isEmpty(pricesList));
        assertEquals("PricesList size should be 0", 0, pricesList.size());
    }

    @Test
    void givenANullPriceEntityList_whenTryToMapToPricesList_thenReturnAnEmptyPricesModelEntityList() {

        // arrange
        List<PricesEntity> pricesEntityList = null;

        // act
        List<Prices> pricesList = pricesMapper.toPrices(pricesEntityList);

        // assert
        assertTrue("PricesList should be empty", CollectionUtils.isEmpty(pricesList));
        assertEquals("PricesList size should be 0", 0, pricesList.size());
    }
}