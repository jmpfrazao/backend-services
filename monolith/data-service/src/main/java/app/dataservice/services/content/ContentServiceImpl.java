package app.dataservice.services.content;

import java.util.Set;

import app.dataservice.model.Content;
import app.dataservice.services.base.BaseService;
import app.dataservice.services.base.BaseServiceImpl;

public class ContentServiceImpl extends BaseServiceImpl<Content, Long> implements BaseService<Content, Long>{

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Content> findAll() {
        return super.findAll();
    }

    @Override
    public Content findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Content save(Content object) {
        return super.save(object.getId(), object);
    }
    
}
