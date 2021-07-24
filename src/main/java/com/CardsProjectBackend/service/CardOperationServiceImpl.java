package com.CardsProjectBackend.service;

import com.CardsProjectBackend.dao.CardOperationDAO;
import com.CardsProjectBackend.entity.CardOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardOperationServiceImpl implements CardOperationService {
    private CardOperationDAO cardOperationDAO;
    @Autowired
    public CardOperationServiceImpl(CardOperationDAO theCardOperationDAO) {
        cardOperationDAO=theCardOperationDAO;
    }

    @Override
    @Transactional
    public List<CardOperation> getAllCardOperations() {
        return cardOperationDAO.getAllCardOperations();
    }

    @Override
    @Transactional
    public CardOperation getCardOperationById(int theId) {
        return cardOperationDAO.getCardOperationById(theId);
    }

    @Override
    @Transactional
    public void addCardOperation(CardOperation theCardOperation) {
    	double tempAmount=theCardOperation.getSenderAmount();
    	theCardOperation.setSenderAmount(Math.round(tempAmount*1.01));
        theCardOperation.setSenderFee(Math.round(tempAmount*0.01));
        theCardOperation.setReceiverAmount(Math.round(tempAmount)-1000);
        theCardOperation.setReceiverFee(1000);
        cardOperationDAO.addCardOperation(theCardOperation);
    }

    @Override
    @Transactional
    public void deleteCardOperationById(int theId) {
        cardOperationDAO.deleteCardOperationById(theId);
    }
}
