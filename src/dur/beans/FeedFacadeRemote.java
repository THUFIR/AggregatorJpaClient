package dur.beans;

import java.util.List;
import javax.ejb.Remote;
import net.bounceme.dur.jpa.entities.Feed;

@Remote
public interface FeedFacadeRemote {

    void create(Feed feed);

    void edit(Feed feed);

    void remove(Feed feed);

    Feed find(Object id);

    List<Feed> findAll();

    List<Feed> findRange(int[] range);

    int count();
    
}
