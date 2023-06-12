package app.services.content;

public class PdfContentService extends ContentServiceImpl  implements ContentService {
    public String getContentType(){
        return "Pdf";
    }
}
