package com.CardsProjectBackend.service;

import com.CardsProjectBackend.entity.CardOperation;
import java.util.List;

public interface CardOperationService {

    public List<CardOperation> getAllCardOperations();
    public CardOperation getCardOperationById(int theId);
    public void addCardOperation(CardOperation theCardOperation);
    public void deleteCardOperationById(int theId);

}
