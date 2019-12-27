package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PatternController {

    @CrossOrigin(origins="*")
    @PostMapping("/protoImages")
    public ResponseEntity saveImage(@RequestParam("file") MultipartFile file){
        try {
            System.out.println(file);
        } catch(Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
