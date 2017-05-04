package com.loraneo.test.javaee;

import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.SystemException;

@Stateless
public class TimerTest {

    private static final Logger LOG = Logger.getLogger(Ejb1.class.getName());

    @Inject
    Ejb1 ejb1;

    @Schedule(minute = "*", hour = "*", second = "*/5", persistent = false)
    private void onTimeout() throws SystemException {
        LOG.info("Timer execured ");
        try {
            LOG.info("Calling ejb1");
            ejb1.callMe();
        } catch (final Exception e) {
            LOG.info("Exception after ejb1 call");
        }
        LOG.info("After ejb1 call");

    }
}
