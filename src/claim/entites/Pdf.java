/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claim.entites;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import claim.service.ServiceReclamation;

/**
 *
 * @author EMNA
 */
public class Pdf {

 

   
  
    public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document() {};
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
      
        ServiceReclamation su = new ServiceReclamation();        
        List<claim.entites.Reclamation> list=su.affcher();    
        document.add(new Paragraph("La liste des reclamations :"));
        document.add(new Paragraph("     "));
         for(Reclamation u:list)
        {
            
        document.add(new Paragraph("id :"+u.getId()));
        document.add(new Paragraph("nom :"+u.getNom()));
        document.add(new Paragraph("prenom :"+u.getPrenom()));
        document.add(new Paragraph("description :"+u.getDescription()));
       

        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        }
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }    
}

    

