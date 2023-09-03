package com.diegodev.ditech.application.rest.mapper;

import com.diegodev.ditech.application.rest.dto.PricesDto;
import com.diegodev.ditech.application.rest.mappers.PricesDtoMapper;
import com.diegodev.ditech.application.rest.mappers.PricesDtoMapperImpl;
import com.diegodev.ditech.domain.models.Prices;
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
class PricesDtoMapperTest {

    private PricesDtoMapper pricesDtoMapper;

    @BeforeEach
    void setup() {
        pricesDtoMapper = new PricesDtoMapperImpl();
    }

    @Test
    void givenAPrices_whenTryToMapToPricesDto_thenReturnAPricesDto() {

        // arrange
        Prices prices =
                Prices.builder()
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
        PricesDto pricesDto = pricesDtoMapper.toPricesDto(prices);

        // assert
        assertNotNull("Prices should be not null", pricesDto);
        assertEquals("Id should be c0acbd79-10bd-4e73-bf9b-82251e74dd4d", "c0acbd79-10bd-4e73-bf9b-82251e74dd4d", pricesDto.getId().toString());
        assertEquals("BrandId should be 1", 1, prices.getBrandId());
        assertEquals("StartDate should be 2020-06-14T00:00:00", "2020-06-14T00:00:00", pricesDto.getStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        assertEquals("EndDate should be 2020-12-31T23:59:59", "2020-12-31T23:59:59", pricesDto.getEndDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        assertEquals("PriceList should be 1", 1, pricesDto.getPriceList());
        assertEquals("ProductId should be 35455", 35455, pricesDto.getProductId());
        assertEquals("Priority should be 0", 0, pricesDto.getPriority());
        assertEquals("Price should be 35.5", 35.5F, pricesDto.getPrice());
        assertEquals("Curr should be EUR", "EUR", pricesDto.getCurr());

    }

    @Test
    void givenANullPrices_whenTryToMapToPrices_thenReturnANullPricesDto() {

        // arrange
        Prices prices = null;
        Prices.builder()
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
        PricesDto pricesDto = pricesDtoMapper.toPricesDto(prices);

        // assert
        assertNull("Prices should be null", pricesDto);

    }

    @Test
    void givenAPricesList_whenTryToMapToPricesDtoList_thenReturnAPricesDtoList() {

        // arrange
        Prices prices1 =
                Prices.builder()
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

        Prices prices2 =
                Prices.builder()
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

        List<Prices> pricesList = Arrays.asList(prices1, prices2);

        // act
        List<PricesDto> pricesDtoList = pricesDtoMapper.toPricesDto(pricesList);

        // assert
        assertFalse("PricesList should be not empty", CollectionUtils.isEmpty(pricesDtoList));
        assertEquals("PricesList size should be 2", 2, pricesDtoList.size());
        assertEquals("Should contain an item with id c0acbd79-10bd-4e73-bf9b-82251e74dd4d", "c0acbd79-10bd-4e73-bf9b-82251e74dd4d", pricesDtoList.stream().filter(prices -> prices.getId().compareTo(UUID.fromString("c0acbd79-10bd-4e73-bf9b-82251e74dd4d")) == 0).findFirst().orElseThrow().getId().toString());
    }

    @Test
    void givenAnEmptyPricesList_whenTryToMapToPricesDtoList_thenReturnAnEmptyPricesDtoList() {

        // arrange
        List<Prices> pricesList = new ArrayList<>();

        // act
        List<PricesDto> pricesDtoList = pricesDtoMapper.toPricesDto(pricesList);

        // assert
        assertTrue("PricesList should be empty", CollectionUtils.isEmpty(pricesList));
        assertEquals("PricesList size should be 0", 0, pricesDtoList.size());
    }

    @Test
    void givenANullPriceList_whenTryToMapToPricesDtoList_thenReturnAnEmptyPricesDtoList() {

        // arrange
        List<Prices> pricesList = null;

        // act
        List<PricesDto> pricesDtoList = pricesDtoMapper.toPricesDto(pricesList);

        // assert
        assertTrue("PricesList should be empty", CollectionUtils.isEmpty(pricesDtoList));
        assertEquals("PricesList size should be 0", 0, pricesDtoList.size());
    }
}