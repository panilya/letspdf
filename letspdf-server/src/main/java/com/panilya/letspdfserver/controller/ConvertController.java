package com.panilya.letspdfserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class ConvertController {

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFiles(@RequestParam("file") MultipartFile[] files) {

    }

}
