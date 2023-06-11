package app.monolith.model;

public class Content {
    private Long id;
    private ContentType contentType;
    private User user;
    private String storage_url;

    public Content() {
    }

    public Content(ContentType contentType, User user, String storage_url) {
        this.contentType = contentType;
        this.user = user;
        this.storage_url = storage_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStorage_url() {
        return storage_url;
    }

    public void setStorage_url(String storage_url) {
        this.storage_url = storage_url;
    }

}
