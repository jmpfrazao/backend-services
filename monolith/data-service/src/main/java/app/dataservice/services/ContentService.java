package app.dataservice.services;

import java.util.Set;

import app.dataservice.model.Content;

public interface ContentService {
    Content findById(Long id);
    Content save(Content content);

    Set<Content> findAll();
}
