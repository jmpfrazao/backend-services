package app.services.content;

import java.util.Set;

import app.model.Content;
import app.services.common.BaseService;
import app.services.common.BaseServiceImpl;

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
