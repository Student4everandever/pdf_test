package pdf_text_extraction;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Oleksandr_Kalinin\\IdeaProjects\\pdf_test\\src\\files\\sample.pdf");
        PDDocument doc = PDDocument.load(file);
        PDFTextStripper stripper = new PDFTextStripper();
        String result = stripper.getText(doc);
        System.out.println(result);
    }
}
