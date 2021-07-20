package com.CardsProjectBackend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.CardsProjectBackend.dao.CardOperationDAO;
import com.CardsProjectBackend.entity.CardOperation;

@ExtendWith(MockitoExtension.class)
class CardOperationServiceImplTest {

    @InjectMocks
    private CardOperationService cardOperationService;
	@Mock 
	private CardOperationDAO cardOperationDAO;
	
	
	
//	  @Test void testGetAllCardOperations() {
//	  when(cardOperationDAO.getAllCardOperations()).thenReturn(Arrays.asList(new
//	  CardOperation(111222333, 122021, 1212, 999111, 111222334, 999, 1, 1, 7776655,
//	  false,true ))); assertEquals(6, cardOperationService.getAllCardOperations());
//	  }
//	 
	 
}
