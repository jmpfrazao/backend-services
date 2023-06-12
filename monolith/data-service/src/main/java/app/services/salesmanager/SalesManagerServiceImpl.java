package app.services.salesmanager;

import java.util.Set;

import org.springframework.stereotype.Service;

import app.model.SalesManager;
import app.services.common.BaseServiceImpl;

@Service
public class SalesManagerServiceImpl extends BaseServiceImpl<SalesManager, Long> implements SalesManagerService{

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
