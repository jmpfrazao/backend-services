package app.dataservice.services;

import java.util.Set;

import app.dataservice.model.SalesManager;

public interface SalesManagerService {
    SalesManager findById(Long id);
    SalesManager save(SalesManager salesManager);

    Set<SalesManager> findAll();
}
