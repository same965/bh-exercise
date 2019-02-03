package hu.oparin.bhexercise.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.oparin.bhexercise.models.ErrorMessage;
import hu.oparin.bhexercise.models.FareFilterRequest;
import hu.oparin.bhexercise.services.CategoryService;
import hu.oparin.bhexercise.services.FareService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class FareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    FareService fareService;

    @MockBean
    CategoryService categoryService;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private ObjectMapper objectMapper = new ObjectMapper();

    public FareControllerTest() throws JsonProcessingException {
    }

    @Test
    public void fareFilterEmptyList() throws Exception {
        FareFilterRequest testFareFilter = new FareFilterRequest("cdg", "lis");
        String testFareJson = objectMapper.writeValueAsString(testFareFilter);

        ErrorMessage message = new ErrorMessage("No such fare");
        when(fareService.filteredListIsEmpty(any())).thenReturn(true);

        mockMvc.perform(post("/fare/filter")
                .contentType(contentType)
                .content(testFareJson))
                .andExpect(status().isNoContent())
                .andExpect(content().contentType(contentType));
    }
}