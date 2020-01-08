package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI;

import com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

@RestController
public class PatternController {
    private static final String staticFilePath = "/Users/alyssawadley/Documents/stitchBuilderAPI/src/main/resources/static/";

    @Autowired
    private PatternService patternService;


    @CrossOrigin(origins = "*")
    @PostMapping("/protoImages")
    public ResponseEntity saveImage(@RequestParam("file") MultipartFile file) {
        try {
            byte[] picture = file.getBytes();
            ByteArrayInputStream byteSteam = new ByteArrayInputStream(picture);
            BufferedImage bufferedPicture = ImageIO.read(byteSteam);
            String imagePath = staticFilePath + file.getOriginalFilename();
            ImageIO.write(bufferedPicture, "jpg", new File(imagePath));
            Pattern newPattern = new Pattern();
            newPattern.setPrototypeImage(imagePath);
            patternService.addNewPattern(newPattern);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/protoImages")
    public String retrieveImage(@RequestParam String filePath) {
        try {
            String imagePath = staticFilePath + filePath;
            File file = new File(imagePath);
            InputStream targetStream = new FileInputStream(file);
            byte[] bytes = targetStream.readAllBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            return encoded;
        } catch (Error | FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "File not found";
    }
}
