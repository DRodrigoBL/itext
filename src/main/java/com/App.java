package com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Document document = new Document();
        document.setPageSize(new Rectangle(PageSize.LETTER.rotate()));
        
        try {
        	PdfWriter.getInstance(document, new FileOutputStream("/home/karla/Documents/rfiles/pdfDocs/file.pdf"));
        	document.open();
        	
        	document.addTitle("Un reporte de evaluacion");
        	
        	document.add(new Paragraph("Reporte de evaluacion "+new Date(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 20,Font.BOLD, BaseColor.BLACK )));
        	
        	document.add( Chunk.NEWLINE );
        	
        	//Create the table which will be 2 Columns wide and make it 100% of the page
        	PdfPTable myTable = new PdfPTable(5);
        	//myTable.setWidthPercentage(100.0f);

        	Image img  = Image.getInstance("/home/karla/Documents/rfiles/itext/src/main/resources/checked.jpg");
        	img.scalePercent(10);
        	
        	Image img2  = Image.getInstance("/home/karla/Documents/rfiles/itext/src/main/resources/unchecked.png");
        	img2.scalePercent(10);
        	
        	
        	//create a 3 cells and add them to the table
        	PdfPCell cellOne = new PdfPCell(new Paragraph("Tabla de checkbox", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.BOLD, BaseColor.WHITE )));
        	PdfPCell cellTwo = new PdfPCell(new Paragraph("First col"));
        	PdfPCell cellThree = new PdfPCell(img);
        	PdfPCell cellFour = new PdfPCell(new Paragraph("Third col"));
        	PdfPCell cellFive = new PdfPCell(img2);
        	PdfPCell cellSix = new PdfPCell(new Paragraph("Fifth col"));

        	cellOne.setColspan(5);
        	cellOne.setHorizontalAlignment(Element.ALIGN_CENTER);
        	cellOne.setBackgroundColor(BaseColor.BLACK);
        	
        	
        	cellTwo.setHorizontalAlignment(Element.ALIGN_CENTER);
        	cellThree.setHorizontalAlignment(Element.ALIGN_CENTER);
        	cellThree.setVerticalAlignment(Element.ALIGN_MIDDLE);
        	cellFour.setHorizontalAlignment(Element.ALIGN_CENTER);
        	cellFive.setHorizontalAlignment(Element.ALIGN_CENTER);
        	cellFive.setVerticalAlignment(Element.ALIGN_MIDDLE);
        	cellSix.setHorizontalAlignment(Element.ALIGN_CENTER);

        	//Add the three cells to the table
        	myTable.addCell(cellOne);
        	myTable.addCell(cellTwo);
        	myTable.addCell(cellThree);
        	myTable.addCell(cellFour);
        	myTable.addCell(cellFive);
        	myTable.addCell(cellSix);
        	
        	document.add(myTable);

        	document.newPage();
        	//PORTADA
        	Paragraph paragraph = new Paragraph("Reporte de evaluacion del Sistema Operativo", FontFactory.getFont(FontFactory.TIMES_ROMAN, 24,Font.BOLD, new BaseColor(25,118,210) ));
        	paragraph.setAlignment(Element.ALIGN_CENTER);
        	document.add(paragraph);
        	
        	Image sistemaLogo  = Image.getInstance("/home/karla/Documents/rfiles/itext/src/main/resources/centos_logo.png");
        	sistemaLogo.scalePercent(20);
        	
        	
        	document.close();
        	
        }catch(DocumentException  ex) {
        	ex.printStackTrace();
        }catch(FileNotFoundException ex) {
        	ex.printStackTrace();
        }catch(IOException ex) {
        	ex.printStackTrace();
        }
        
        
        
    }
}
