package org.lunatech.assessment.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RunwayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRunwaysByAirportId() {
        try {
            this.mockMvc.perform(get("/api/runway/query/{airportId}", 45437))
                    .andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRunwayTypesByCountry() {
        try {
            this.mockMvc.perform(get("/api/runway/report/runwayTypesByCountry"))
                    .andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRunwayIdentCounts() {
        try {
            this.mockMvc.perform(get("/api/runway/report/runwayIdentCounts"))
                    .andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}