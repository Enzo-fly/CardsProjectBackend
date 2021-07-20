package com.CardsProjectBackend.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CardsProjectBackend.entity.CardOperation;

@SpringBootTest
class CardOperationDAOImplTest {

	@Autowired
	private CardOperationDAO cardOperationDAO;

	@Test
	void testGetAllCardOperations() {
		List <CardOperation> cardOperations = cardOperationDAO.getAllCardOperations();
		assertEquals(16,cardOperations.size());
	}

	@Test
	void testGetCardOperationById() {
		CardOperation cardOperation = cardOperationDAO.getCardOperationById(2);
		assertEquals(125.6,cardOperation.getSenderAmount());
	}
}
