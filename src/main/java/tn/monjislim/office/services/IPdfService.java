package tn.monjislim.office.services;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.FileNotFoundException;

public interface IPdfService {

    void generatePdf() throws FileNotFoundException, DocumentException;

    void addTableHeader(PdfPTable table);

    void addRows(PdfPTable table);

    void addCustomRows(PdfPTable table);
}
