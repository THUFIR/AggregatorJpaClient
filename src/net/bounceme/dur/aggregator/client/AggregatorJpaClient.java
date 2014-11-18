package net.bounceme.dur.aggregator.client;

import java.util.logging.Logger;

public class AggregatorJpaClient {

    private final static Logger log = Logger.getLogger(AggregatorJpaClient.class.getName());

    public static void main(String[] args) {
        new AggregatorJpaClient().hello();
    }

    private void hello() {
        SeleniumWebPageIterator iterator = new SeleniumWebPageIterator();
        iterator.processLinks();
    }

}
