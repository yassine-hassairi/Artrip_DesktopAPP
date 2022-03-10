/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.model;
import com.itextpdf.text.Document;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import event.Service.ServiceEvenements;

/**
 *
 * @author Asus
 */
public class Pdf {

   
  
    public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document() {};
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
      
        ServiceEvenements su = new ServiceEvenements();        
        List<event.model.Evenements> list=su.afficher();    
        document.add(new Paragraph("La liste des Evenements :"));
        document.add(new Paragraph("     "));
         for(Evenements u:list)
        {
            
        document.add(new Paragraph("id :"+u.getId()));
        document.add(new Paragraph("Titre :"+u.getTitre()));
        document.add(new Paragraph("Lieu :"+u.getLieu()));
        document.add(new Paragraph("Description :"+u.getDescription()));
       

        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        }
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }    
}

