package com.CardsProjectBackend.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.CardsProjectBackend.entity.CardOperation;
import com.CardsProjectBackend.service.CardOperationService;


@WebMvcTest(CardOperationRestController.class)
class CardOperationRestControllerTest {

	@Autowired
    private MockMvc mockMvc;
	@MockBean
    private CardOperationService cardOperationService;
	@Test
	public void testGetAllCardOperations_basic() throws Exception {
        when(cardOperationService.getAllCardOperations())
        	.thenReturn(Arrays.asList(new CardOperation("111222333", 122021, 1212, 999111, "111222334", 999,
        								1, 1, 7776655, false,true ),
        								new CardOperation("111222333", 122021, 1212, 999111, "111222334", 999,
                								1, 1, 7776655, false,true )));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/CardOperations")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("[{senderNumber:111222333,senderDate:122021,senderCvc2:1212,senderAmount:999111.0,receiverNumber:111222334,receiverAmount:999.0,senderFee:1.0,receiverFee:1.0,phone:7776655,receiverNotification:false,email:true},"
                						+ "{senderNumber:111222333,senderDate:122021,senderCvc2:1212,senderAmount:999111.0,receiverNumber:111222334,receiverAmount:999.0,senderFee:1.0,receiverFee:1.0,phone:7776655,receiverNotification:false,email:true}]"))
                .andReturn();
	}
	@Test
	public void testPostCardOperations_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/CardOperations")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"senderNumber\":1234567890123433,\"senderDate\":122021,\"senderCvc2\":121,\"senderAmount\":999111.0,\"receiverNumber\":1234567890123477,\"receiverAmount\":999.0,\"senderFee\":1.0,\"receiverFee\":1.0,\"phone\":380501111111,\"receiverNotification\":false,\"email\":true}")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
	}
}
