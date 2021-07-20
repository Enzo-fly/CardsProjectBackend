package com.CardsProjectBackend.service;

import com.CardsProjectBackend.dao.CardOperationDAO;
import com.CardsProjectBackend.entity.CardOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        theCardOperation.setSenderFee(theCardOperation.getSenderAmount()/100);
        theCardOperation.setReceiverFee(theCardOperation.getSenderAmount()+10);
        cardOperationDAO.addCardOperation(theCardOperation);
    }

    @Override
    @Transactional
    public void deleteCardOperationById(int theId) {
        cardOperationDAO.deleteCardOperationById(theId);
    }
}
