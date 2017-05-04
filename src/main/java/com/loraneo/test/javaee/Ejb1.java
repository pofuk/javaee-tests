package com.loraneo.test.javaee;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Ejb1 {

    private static final Logger LOG = Logger.getLogger(Ejb1.class.getName());

    @Inject
    Ejb2 ejb2;

    public void callMe() throws Exception {
        LOG.info("Entered " + this.getClass()
                .getName() + " tx:");
        try {
            LOG.info("Calling ejb2");
            ejb2.callMe();
        } catch (final Exception e) {
            LOG.info("Exception after ejb2 call");
        }
    }
}
