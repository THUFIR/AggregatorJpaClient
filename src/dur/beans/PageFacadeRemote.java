package dur.beans;

import java.util.List;
import javax.ejb.Remote;
import net.bounceme.dur.jpa.entities.Page;

@Remote
public interface PageFacadeRemote {

    void create(Page page);

    void edit(Page page);

    void remove(Page page);

    Page find(Object id);

    List<Page> findAll();

    List<Page> findRange(int[] range);

    int count();
    
}
