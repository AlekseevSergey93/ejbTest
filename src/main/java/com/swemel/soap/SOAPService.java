package com.swemel.soap;

import com.swemel.entity.Bid;
import com.swemel.entity.Item;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "BidManager")
public class SOAPService {

    @Resource
    private SessionContext sc;

    /**
     * Initializes the BidManager
     */
    @PostConstruct
    public void initialize() {

    }

    public Long addBid(Bid bid) {
        return null;
    }

    private Long getBidId() {
        // Add Code for generating a unique key
        return Long.valueOf(1002);
    }

    public void cancelBid(Bid bid) {
    }

    public List<Bid> getBids(Item item) {
        return item.getBids();
    }

    @PreDestroy
    public void cleanup() {

    }

    public String getBid(long bidId) {
        Bid bid = new Bid();
        return "Hello World";
    }
}
