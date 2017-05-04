package com.loraneo.test.javaee;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class Ejb2 {

    private static final Logger LOG = Logger.getLogger(Ejb1.class.getName());

    public void callMe() throws Exception {
        LOG.info("Entered " + this.getClass()
                .getName());
        throw new RuntimeException("Exception from " + this.getClass()
                .getName());
    }
}
