package app.services.content;

public class ContentServiceFactory{
    public ContentService getContentService(String contentType) {
        switch (contentType) {
            case "IMAGE":
                return new ImageContentService();
            case "PDF":
                return new PdfContentService();
            default:
            return new TextContentService();
        }
    }

}
