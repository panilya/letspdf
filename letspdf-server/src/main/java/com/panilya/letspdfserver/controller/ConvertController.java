package com.panilya.letspdfserver.controller;

import com.panilya.letspdfserver.service.ImageToPdfConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ConvertController {

    private final ImageToPdfConversionService imageToPdfConversionService;

    @Autowired
    public ConvertController(ImageToPdfConversionService imageToPdfConversionService) {
        this.imageToPdfConversionService = imageToPdfConversionService;
    }

    @PostMapping(path = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte[]> uploadFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        byte[] pdfFile = imageToPdfConversionService.convert(files);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition");
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "file.pdf" + "\"");

        return ResponseEntity.ok().contentType(MediaType.valueOf(MediaType.APPLICATION_PDF_VALUE))
                .headers(httpHeaders)
                .body(pdfFile);
    }
}
