package com.panilya.letspdfserver.controller;

import com.panilya.letspdfserver.service.ImageToPdfConversionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void uploadFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        imageToPdfConversionService.convert(files);
    }
}
