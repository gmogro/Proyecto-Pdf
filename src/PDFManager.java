import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.util.StringTokenizer;;

public class PDFManager {
	
	   private PDFParser parser;
	   private PDFTextStripper pdfStripper;
	   private PDDocument pdDoc ;
	   private COSDocument cosDoc ;
	   
	   private String Text ;
	   private String filePath;
	   private File file;

	    public PDFManager() {
	        
	    }
	   public String ToText() throws IOException
	   {
	       this.pdfStripper = null;
	       this.pdDoc = null;
	       this.cosDoc = null;
	       
	       file = new File(filePath);
	       parser = new PDFParser(new RandomAccessFile(file,"r")); // update for PDFBox V 2.0
	       
	       parser.parse();
	       cosDoc = parser.getDocument();
	       pdfStripper = new PDFTextStripper();
	       pdDoc = new PDDocument(cosDoc);
	       pdDoc.getNumberOfPages();
	       pdfStripper.setStartPage(1);
	       pdfStripper.setEndPage(10);
	       
	       // reading text from page 1 to 10
	       // if you want to get text from full pdf file use this code
	       // pdfStripper.setEndPage(pdDoc.getNumberOfPages());
	       
	       Text = pdfStripper.getText(pdDoc);
	       return Text;
	   }

	    public void setFilePath(String filePath) {
	        this.filePath = filePath;
	    }
	    
	    public void countString (){
	    	StringTokenizer st = new StringTokenizer(Text);
	    	System.out.println("La Cantidada de palabras de su texto es " + st.countTokens());
	    }
	    public void createPDFEmpty (){
	    	System.out.println("Create Simple PDF file with blank Page");
	        
	        String fileName = "EmptyPdf.pdf"; // name of our file
	        
	        try{
	        
	        PDDocument doc = new PDDocument(); // creating instance of pdfDoc
	        
	        doc.addPage(new PDPage()); // adding page in pdf doc file
	        
	        doc.save(fileName); // saving as pdf file with name perm 
	        
	        doc.close(); // cleaning memory 
	        
	        System.out.println("your file created in : "+ System.getProperty("user.dir"));
	        
	        
	        }
	        catch(Exception e){
	        System.out.println(e.getMessage());
	        }
	    }
	    
	    public void createPDFText(){
	    	 try{
	    	        
	    	        System.out.println("Create Simple PDF file with Text");
	    	        String fileName = "PdfWithtext.pdf"; // name of our file
	    	        
	    	        PDDocument doc = new PDDocument();
	    	        PDPage page = new PDPage();

	    	        doc.addPage(page);

	    	        PDPageContentStream content = new PDPageContentStream(doc, page);
	    	        
	    	        content.beginText();
	    	        content.setFont(PDType1Font.HELVETICA, 26);
	    	        content.moveTextPositionByAmount(220, 750);
	    	        content.drawString("Registration Form");
	    	        content.endText();
	    	        
	    	        
	    	        content.beginText();
	    	        content.setFont(PDType1Font.HELVETICA, 16);
	    	        content.moveTextPositionByAmount(80, 700);
	    	        content.drawString("Name : ");
	    	        content.endText();
	    	        
	    	        
	    	        content.beginText();
	    	        content.setFont(PDType1Font.HELVETICA, 16);
	    	        content.moveTextPositionByAmount(80,650);
	    	        content.drawString("Father Name : ");
	    	        content.endText();
	    	        
	    	        content.beginText();
	    	        content.moveTextPositionByAmount(80,600);
	    	        content.drawString("DOB : ");
	    	        content.endText();
	    	        
	    	        
	    	        content.close();
	    	        doc.save(fileName);
	    	        doc.close();
	    	        
	    	        System.out.println("your file created in : "+ System.getProperty("user.dir"));

	    	        }
	    	        catch(Exception e){
	    	        
	    	        System.out.println(e.getMessage());
	    	        
	    	        }
	    }
}
