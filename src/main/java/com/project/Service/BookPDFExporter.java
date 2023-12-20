package com.project.Service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.project.Entity.Book;

public class BookPDFExporter {
    private List<Book> listBook;

    // constructor 
    public BookPDFExporter(List<Book> listBook) {
        this.listBook = listBook;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Book ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Email", font)); // Adjust field name to match your Book entity
        table.addCell(cell);

        cell.setPhrase(new Phrase("Full Name", font)); // Adjust field name to match your Book entity
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("password", font)); // Adjust field name to match your Book entity
        table.addCell(cell);

       
        
    }

    private void writeTableData(PdfPTable table) {
        for (Book book : listBook) {
            table.addCell(String.valueOf(book.getBid()));
            table.addCell(book.getEmail()); // Assuming getEmail() returns a String
            table.addCell(book.getFullName()); // Assuming getFullName() returns a String
            table.addCell(book.getPassword()); // Assuming getPassword() returns a String
           // table.addCell(book.getRoles());
            
            
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Books", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f,  });
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
