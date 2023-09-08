package com.diegodev.ditech;

import com.diegodev.ditech.domain.service.PricesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PricesTechnicalAssessmentApplicationTests {

    @Autowired
    private PricesService pricesService;

    @Test
    void contextLoads() {
        // Simple test to avoid SonarLint rule "Add at least one assertion to this test case."
        assertNotNull(pricesService);
    }

}
