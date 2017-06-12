import java.io.IOException;

public class JavaPDFTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PDFManager pdfManager = new PDFManager();
		/* pdfManager.setFilePath("D:\\test.pdf");
	       
	       try {
			System.out.println(pdfManager.ToText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		pdfManager.createPDFText();
	}

}
