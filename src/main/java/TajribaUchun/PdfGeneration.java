package TajribaUchun;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.FileNotFoundException;


public class PdfGeneration {
    public static void main(String[] args) throws FileNotFoundException {
        PdfWriter writer=new PdfWriter("text.pdf");
        PdfDocument pdfDocument=new PdfDocument(writer);
        Document document=new Document(pdfDocument);
        Paragraph paragraph=new Paragraph("Jonnyhhhh");
        paragraph.setBold();
//        paragraph.setTextAlignment(TextAlignment.CENTER);
        paragraph.setVerticalAlignment(VerticalAlignment.MIDDLE);
        document.add(paragraph);
        System.out.println(document);
        document.close();
    }
}
