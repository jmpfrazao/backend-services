package app.user.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Content{
    @Id
    private String id;
    private String contentType;
    private String storage_url;

    public Content() {
    }

    public Content(String contentType, String storage_url) {
        this.contentType = contentType;
        this.storage_url = storage_url;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getStorage_url() {
        return storage_url;
    }

    public void setStorage_url(String storage_url) {
        this.storage_url = storage_url;
    }

    @Override
    public String toString() {
        return "Content [id=" + id + ", contentType=" + contentType + ", storage_url=" + storage_url + "]";
    }


}
