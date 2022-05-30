package com.panilya.letspdfserver.service;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageToPdfConversionService {

    public void convert(MultipartFile[] files) throws IOException {

        List<ImageData> imagesData = Arrays.stream(files)
                .map(file -> {
                    try {
                        return ImageDataFactory.create(file.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());

//        PdfDocument pdfDocument = new PdfDocument(new PdfWriter("ImageToPdf.pdf"));
        FileOutputStream fileOutputStream = new FileOutputStream("letspdf-server/src/main/resources/documents/file.pdf");
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(fileOutputStream));

        Document document = new Document(pdfDocument);

        for (ImageData image : imagesData) {
            Image img = new Image(image);
            img.setWidth(pdfDocument.getDefaultPageSize().getWidth() - 50);
            img.setAutoScaleHeight(true);
            document.add(img);
            pdfDocument.addNewPage();
        }
        pdfDocument.close();
    }
}
