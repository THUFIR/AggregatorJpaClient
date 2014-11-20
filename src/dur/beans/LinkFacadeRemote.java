package dur.beans;

import java.util.List;
import javax.ejb.Remote;
import net.bounceme.dur.jpa.entities.Link;

@Remote
public interface LinkFacadeRemote {

    void create(Link link);

    void edit(Link link);

    void remove(Link link);

    Link find(Object id);

    List<Link> findAll();

    List<Link> findRange(int[] range);

    int count();
    
}
