package app.dataservice.services.salesmanager;

import java.util.Set;

import app.dataservice.model.SalesManager;
import app.dataservice.services.base.*;

public class SalesManagerServiceImpl extends BaseServiceImpl<SalesManager, Long> implements BaseService<SalesManager, Long>{

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<SalesManager> findAll() {
        return super.findAll();
    }

    @Override
    public SalesManager findById(Long id) {
        return super.findById(id);
    }

    @Override
    public SalesManager save(SalesManager object) {
        return super.save(object.getId(), object);
    }
        
}
