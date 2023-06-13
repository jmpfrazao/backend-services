package app.user.service;

import app.user.model.Application;

public interface ApplicationService {
    void addNewApplicationWTemplate(Application application);
    Application findByIdTemplate(String id);
    void deleteWTemplate(Application application);
    void updateApplicationWTemplate(Application application);
}


