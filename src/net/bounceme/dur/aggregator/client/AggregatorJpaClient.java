package net.bounceme.dur.aggregator.client;

import java.util.List;
import java.util.logging.Logger;
import net.bounceme.dur.selenium.jpa.Link;
import net.bounceme.dur.selenium.jpa.LinkFacade;

public class AggregatorJpaClient {

    private final static Logger log = Logger.getLogger(AggregatorJpaClient.class.getName());

    public static void main(String[] args) {
        new AggregatorJpaClient().hello();
    }

    private void hello() {
        log.info("hello world");
        LinkFacade linkFacade = new LinkFacade();
        List<Link> links = linkFacade.findAll();
        for (Link l : links) {
            log.info(l.getLink());
        }
    }

}
