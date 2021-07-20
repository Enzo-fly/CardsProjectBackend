package com.CardsProjectBackend.rest;



import com.CardsProjectBackend.entity.CardOperation;
import com.CardsProjectBackend.service.CardOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class CardOperationRestController {

    private CardOperationService cardOperationService;

    @Autowired
    public CardOperationRestController (CardOperationService theCardOperationService) {
        cardOperationService=theCardOperationService;
    }
    @GetMapping("/test")
    public String getTest(){
        return "Test is working";
    }
    @GetMapping("/testOperation")
    public CardOperation getTestOperation(){
        CardOperation MyTestOperation=new CardOperation("111222333", 122021, 1212, 999111, "111222334", 999, 1, 1, 7776655, false, true);
        return MyTestOperation;
    }

    @GetMapping("/CardOperations")
    public List<CardOperation> getAllCardOperations(){
        return cardOperationService.getAllCardOperations();
    }

    @GetMapping("/CardOperations/{cardOperationId}")
    public CardOperation getCardOperationById(@PathVariable int cardOperationId){
        CardOperation cardOperation = cardOperationService.getCardOperationById(cardOperationId);
        if (cardOperation == null){
            throw new RuntimeException("Card Operation with id: "+cardOperationId+" wasn't founded");
        }
        return cardOperation;
    }

    @PostMapping("/CardOperations")
    public CardOperation addCardOperation(@RequestBody CardOperation theCardOperation){
        theCardOperation.setId(0);
        cardOperationService.addCardOperation(theCardOperation);
        return theCardOperation;
        
    }

    @PutMapping("/CardOperations")
    public CardOperation updateCardOperation(@RequestBody CardOperation theCardOperation){
        cardOperationService.addCardOperation(theCardOperation);
        return theCardOperation;
    }

    @DeleteMapping("/CardOperations/{cardOperationId}")
    public String deleteCardOperationById(@PathVariable int cardOperationId){
        CardOperation cardOperation = cardOperationService.getCardOperationById(cardOperationId);
        if (cardOperation == null){
            throw new RuntimeException("Card Operation with id: "+cardOperationId+" wasn't founded");
        }
        cardOperationService.deleteCardOperationById(cardOperationId);

        return "Card Operation with id: "+cardOperationId+" was deleted";

    }
}
