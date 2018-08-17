package org.lunatech.assessment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AirportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAirportsByCode() {
        Pageable pageable = PageRequest.of(0,10);
        try {
            this.mockMvc.perform(post("/api/airport/query/byCode/{countryCode}", "US")
                    .content((new ObjectMapper()).writeValueAsString(pageable))
                    .contentType(APPLICATION_JSON)).andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAirportsByName() {
        Pageable pageable = PageRequest.of(0,10);
        try {
            this.mockMvc.perform(post("/api/airport/query/byName/{countryName}", "Iran")
                    .content((new ObjectMapper()).writeValueAsString(pageable))
                    .contentType(APPLICATION_JSON)).andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}