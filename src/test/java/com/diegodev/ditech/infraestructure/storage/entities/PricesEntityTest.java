package com.diegodev.ditech.infraestructure.storage.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PricesEntityTest {

    @Test
    void testEqualsAndHashCode() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        PricesEntity pricesEntity1 = new PricesEntity();
        pricesEntity1.setId(id1);

        PricesEntity pricesEntity2 = new PricesEntity();
        pricesEntity2.setId(id1);

        PricesEntity pricesEntity3 = new PricesEntity();
        pricesEntity3.setId(id2);

        // Equals should compare by id
        assertEquals(pricesEntity1, pricesEntity2);
        assertNotEquals(pricesEntity1, pricesEntity3);

        // Hash code should be based on id
        assertEquals(pricesEntity1.hashCode(), pricesEntity2.hashCode());
        assertNotEquals(pricesEntity1.hashCode(), pricesEntity3.hashCode());
    }

    @Test
    void testToString() {
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setId(UUID.fromString("c0acbd79-10bd-4e73-bf9b-82251e74dd4d"));
        pricesEntity.setBrandId(1);
        pricesEntity.setStartDate(LocalDateTime.parse("2022-01-01T00:00:00"));
        pricesEntity.setEndDate(LocalDateTime.parse("2022-12-31T23:59:59"));
        pricesEntity.setPriceList(1);
        pricesEntity.setProductId(35455);
        pricesEntity.setPriority(0);
        pricesEntity.setPrice(35.5F);
        pricesEntity.setCurr("EUR");

        String expectedToString = "PricesEntity(id=c0acbd79-10bd-4e73-bf9b-82251e74dd4d, brandId=1, " +
                "startDate=2022-01-01T00:00, endDate=2022-12-31T23:59:59, priceList=1, " +
                "productId=35455, priority=0, price=35.5, curr=EUR)";
        assertEquals(expectedToString, pricesEntity.toString());
    }

    @Test
    void testGettersAndSetters() {
        PricesEntity pricesEntity = new PricesEntity();
        UUID id = UUID.fromString("c0acbd79-10bd-4e73-bf9b-82251e74dd4d");
        pricesEntity.setId(id);
        pricesEntity.setBrandId(1);
        pricesEntity.setStartDate(LocalDateTime.parse("2022-01-01T00:00:00"));
        pricesEntity.setEndDate(LocalDateTime.parse("2022-12-31T23:59:59"));
        pricesEntity.setPriceList(1);
        pricesEntity.setProductId(35455);
        pricesEntity.setPriority(0);
        pricesEntity.setPrice(35.5F);
        pricesEntity.setCurr("EUR");

        assertEquals(id, pricesEntity.getId());
        assertEquals(1, pricesEntity.getBrandId());
        assertEquals(LocalDateTime.parse("2022-01-01T00:00:00"), pricesEntity.getStartDate());
        assertEquals(LocalDateTime.parse("2022-12-31T23:59:59"), pricesEntity.getEndDate());
        assertEquals(1, pricesEntity.getPriceList());
        assertEquals(35455, pricesEntity.getProductId());
        assertEquals(0, pricesEntity.getPriority());
        assertEquals(35.5F, pricesEntity.getPrice());
        assertEquals("EUR", pricesEntity.getCurr());
    }

    @Test
    void testConstructor() {
        UUID id = UUID.randomUUID();
        Integer brandId = 1;
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = LocalDateTime.now();
        Integer priceList = 1;
        Integer productId = 35455;
        Integer priority = 0;
        Float price = 35.5F;
        String curr = "EUR";

        PricesEntity pricesEntity = new PricesEntity(id, brandId, startDate, endDate, priceList, productId, priority, price, curr);

        assertEquals(id, pricesEntity.getId());
        assertEquals(brandId, pricesEntity.getBrandId());
        assertEquals(startDate, pricesEntity.getStartDate());
        assertEquals(endDate, pricesEntity.getEndDate());
        assertEquals(priceList, pricesEntity.getPriceList());
        assertEquals(productId, pricesEntity.getProductId());
        assertEquals(priority, pricesEntity.getPriority());
        assertEquals(price, pricesEntity.getPrice());
        assertEquals(curr, pricesEntity.getCurr());
    }

    @Test
    void testEqualsAndHashCodeWithNullId() {
        PricesEntity pricesEntity1 = new PricesEntity();
        PricesEntity pricesEntity2 = new PricesEntity();

        // Equals and hashCode should not throw exceptions when id is null
        assertDoesNotThrow(() -> pricesEntity1.equals(pricesEntity2));
        assertDoesNotThrow(pricesEntity1::hashCode);
    }
}
