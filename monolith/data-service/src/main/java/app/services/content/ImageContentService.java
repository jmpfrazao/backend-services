package app.services.content;

public class ImageContentService extends ContentServiceImpl  implements ContentService {
    public String getContentType(){
        return "Image";
    }
}