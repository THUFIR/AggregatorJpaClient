package net.bounceme.dur.aggregator.client;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import net.bounceme.dur.jpa.entities.Link;
import net.bounceme.dur.jpa.entities.Page;
import net.bounceme.dur.jpa.facades.LinkFacade;
import net.bounceme.dur.jpa.facades.PageFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumWebPageIterator {

    private final static Logger log = Logger.getLogger(SeleniumWebPageIterator.class.getName());
    private final PageFacade pageFacade = new PageFacade();
    private final LinkFacade linkFacade = new LinkFacade();

    public SeleniumWebPageIterator() {
    }

    public void processLinks() {
        List<Link> links = linkFacade.findEntities();
        for (Link l : links) {
            processLink(l);
        }
    }

    private void processLink(Link l) {
        log.fine(l.toString());
        WebDriver driver = new FirefoxDriver();
        driver.get(l.getLink());
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        String s = driver.getPageSource();
        createPage(l, s);
        driver.close();
    }

    private void createPage(Link l, String s) {
        Page p = new Page();
        p.setCreated(new Date());
        p.setLinkId(l.getId());
        p.setPage(s);
        pageFacade.create(p);
    }
}
