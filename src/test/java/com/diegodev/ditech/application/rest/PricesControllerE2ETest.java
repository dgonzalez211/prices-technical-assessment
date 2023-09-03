package com.diegodev.ditech.application.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AssertionErrors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PricesControllerE2ETest {

    @Autowired
    private MockMvc mvc;

    @Test
    void givenARequestToGetPrices_whenApplicationDateIs2020_06_14_10_00_00AndProductIdIs_35455AndBrandIdIs_1_thenReturn200OkAndAListOfPricesWithWithSize1() throws Exception {

        // Arrange

        // Act
        mvc.perform(MockMvcRequestBuilders.get("/prices?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON))

                // Assert
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value("c0acbd79-10bd-4e73-bf9b-82251e74dd4d"))
                .andExpect(jsonPath("$[0].brand_id").value("1"))
                .andExpect(jsonPath("$[0].start_date").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].end_date").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].price_list").value("1"))
                .andExpect(jsonPath("$[0].product_id").value("35455"))
                .andExpect(jsonPath("$[0].priority").value("0"))
                .andExpect(jsonPath("$[0].price").value("35.5"))
                .andExpect(jsonPath("$[0].curr").value("EUR"));

    }


    @Test
    void givenARequestToGetPrices_whenApplicationDateIs2020_06_14_16_00_00AndProductIdIs_35455AndBrandIdIs_1_thenReturn200OkAndAListOfPricesWithWithSize2() throws Exception {

        // Arrange

        // Act
        mvc.perform(MockMvcRequestBuilders.get("/prices?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON))

                // Assert
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value("475bdb8a-b42e-4790-b9c9-7bf3a2f9cd21"))
                .andExpect(jsonPath("$[0].brand_id").value("1"))
                .andExpect(jsonPath("$[0].start_date").value("2020-06-14T15:00:00"))
                .andExpect(jsonPath("$[0].end_date").value("2020-06-14T18:30:00"))
                .andExpect(jsonPath("$[0].price_list").value("2"))
                .andExpect(jsonPath("$[0].product_id").value("35455"))
                .andExpect(jsonPath("$[0].priority").value("1"))
                .andExpect(jsonPath("$[0].price").value("25.45"))
                .andExpect(jsonPath("$[0].curr").value("EUR"))
                .andExpect(jsonPath("$[1].id").value("c0acbd79-10bd-4e73-bf9b-82251e74dd4d"))
                .andExpect(jsonPath("$[1].brand_id").value("1"))
                .andExpect(jsonPath("$[1].start_date").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[1].end_date").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[1].price_list").value("1"))
                .andExpect(jsonPath("$[1].product_id").value("35455"))
                .andExpect(jsonPath("$[1].priority").value("0"))
                .andExpect(jsonPath("$[1].price").value("35.5"))
                .andExpect(jsonPath("$[1].curr").value("EUR"));

    }

    @Test
    void givenARequestToGetPrices_whenApplicationDateIs2020_06_14_21_00_00AndProductIdIs_35455AndBrandIdIs_1_thenReturn200OkAndAListOfPricesWithWithSize1() throws Exception {

        // Arrange

        // Act
        mvc.perform(MockMvcRequestBuilders.get("/prices?applicationDate=2020-06-14T21:00:00&productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON))

                // Assert
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value("c0acbd79-10bd-4e73-bf9b-82251e74dd4d"))
                .andExpect(jsonPath("$[0].brand_id").value("1"))
                .andExpect(jsonPath("$[0].start_date").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].end_date").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].price_list").value("1"))
                .andExpect(jsonPath("$[0].product_id").value("35455"))
                .andExpect(jsonPath("$[0].priority").value("0"))
                .andExpect(jsonPath("$[0].price").value("35.5"))
                .andExpect(jsonPath("$[0].curr").value("EUR"));

    }

    @Test
    void givenARequestToGetPrices_whenApplicationDateIs2020_06_15_10_00_00AndProductIdIs_35455AndBrandIdIs_1_thenReturn200OkAndAListOfPricesWithWithSize2() throws Exception {

        // Arrange

        // Act
        mvc.perform(MockMvcRequestBuilders.get("/prices?applicationDate=2020-06-15T10:00:00&productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON))

                // Assert
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value("568f29a8-f0c6-4899-862b-e659ec320897"))
                .andExpect(jsonPath("$[0].brand_id").value("1"))
                .andExpect(jsonPath("$[0].start_date").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$[0].end_date").value("2020-06-15T11:00:00"))
                .andExpect(jsonPath("$[0].price_list").value("3"))
                .andExpect(jsonPath("$[0].product_id").value("35455"))
                .andExpect(jsonPath("$[0].priority").value("1"))
                .andExpect(jsonPath("$[0].price").value("30.5"))
                .andExpect(jsonPath("$[0].curr").value("EUR"))
                .andExpect(jsonPath("$[1].id").value("c0acbd79-10bd-4e73-bf9b-82251e74dd4d"))
                .andExpect(jsonPath("$[1].brand_id").value("1"))
                .andExpect(jsonPath("$[1].start_date").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[1].end_date").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[1].price_list").value("1"))
                .andExpect(jsonPath("$[1].product_id").value("35455"))
                .andExpect(jsonPath("$[1].priority").value("0"))
                .andExpect(jsonPath("$[1].price").value("35.5"))
                .andExpect(jsonPath("$[1].curr").value("EUR"));

    }


    @Test
    void givenARequestToGetPrices_whenApplicationDateIs2020_06_16_21_00_00AndProductIdIs_35455AndBrandIdIs_1_thenReturn200OkAndAListOfPricesWithWithSize2() throws Exception {

        // Arrange

        // Act
        mvc.perform(MockMvcRequestBuilders.get("/prices?applicationDate=2020-06-16T21:00:00&productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON))

                // Assert
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value("5bfe6227-456b-4722-ad18-f811c00803bf"))
                .andExpect(jsonPath("$[0].brand_id").value("1"))
                .andExpect(jsonPath("$[0].start_date").value("2020-06-15T16:00:00"))
                .andExpect(jsonPath("$[0].end_date").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].price_list").value("4"))
                .andExpect(jsonPath("$[0].product_id").value("35455"))
                .andExpect(jsonPath("$[0].priority").value("1"))
                .andExpect(jsonPath("$[0].price").value("38.95"))
                .andExpect(jsonPath("$[0].curr").value("EUR"))
                .andExpect(jsonPath("$[1].id").value("c0acbd79-10bd-4e73-bf9b-82251e74dd4d"))
                .andExpect(jsonPath("$[1].brand_id").value("1"))
                .andExpect(jsonPath("$[1].start_date").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[1].end_date").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[1].price_list").value("1"))
                .andExpect(jsonPath("$[1].product_id").value("35455"))
                .andExpect(jsonPath("$[1].priority").value("0"))
                .andExpect(jsonPath("$[1].price").value("35.5"))
                .andExpect(jsonPath("$[1].curr").value("EUR"));

    }

    @Test
    void givenARequestToGetPrices_whenApplicationDateIsNullAndProductIdIs_35455AndBrandIdIs_1_thenReturn400BadRequestAndErrorDetails() throws Exception {

        // Arrange

        // Act
        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/prices?productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON));

        // Assert
        AssertionErrors.assertEquals("Status", 400, result.andReturn().getResponse().getStatus());
        AssertionErrors.assertEquals("Message", "Required parameter 'applicationDate' is not present.", result.andReturn().getResponse().getErrorMessage());
    }

}