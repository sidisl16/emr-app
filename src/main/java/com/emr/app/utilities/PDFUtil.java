package com.emr.app.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PDFUtil {

	public static OutputStream convertHtmlToPDF(String html, File location) {
		PdfWriter pdfWriter = null;
		Document document = new Document();
		FileOutputStream fs = null;
		try {
			document = new Document();
			document.addAuthor("Siddharth");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("Siddharth");
			document.addTitle("Prescription");
			document.setPageSize(PageSize.A4);
			fs = new FileOutputStream(location);
			PdfWriter.getInstance(document, fs);
			document.open();
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(html));
			document.close();
		} catch (Exception e) {
		}
		return fs;
	}
}
