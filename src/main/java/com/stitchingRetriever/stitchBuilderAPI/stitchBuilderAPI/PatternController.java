package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI;

import com.fasterxml.jackson.databind.util.JSONPObject;
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
import java.util.Optional;

@RestController
public class PatternController {
    private static final String staticFilePath = "/Users/alyssawadley/Documents/stitchBuilderAPI/src/main/resources/static/";

    @Autowired
    private PatternService patternService;

    public PatternController(){
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/protoImages")
    public long saveImage(@RequestParam("file") MultipartFile file, @RequestParam("projectTitle") String title) {
        try {
            byte[] picture = file.getBytes();
            ByteArrayInputStream byteSteam = new ByteArrayInputStream(picture);
            BufferedImage bufferedPicture = ImageIO.read(byteSteam);
            String imagePath = staticFilePath + file.getOriginalFilename();
            ImageIO.write(bufferedPicture, "jpg", new File(imagePath));
            Pattern newPattern = new Pattern();
            newPattern.setPrototypeImage(imagePath);
            newPattern.setTitle(title);
            newPattern = patternService.addNewPattern(newPattern);
            long id = newPattern.getId();
            return id;
        } catch (Exception e) {
            return -1;
        }
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

    @CrossOrigin(origins="*")
    @PostMapping("/patternData")
    public  ResponseEntity savePatternData(@RequestParam String currentId, @RequestParam MultipartFile canvasImage, String keyData) {
        try {
            byte[] picture = canvasImage.getBytes();
            ByteArrayInputStream byteSteam = new ByteArrayInputStream(picture);
            BufferedImage bufferedPicture = ImageIO.read(byteSteam);
            String imagePath = staticFilePath + currentId + ".png";
            ImageIO.write(bufferedPicture, "png", new File(imagePath));
            long id = Long.parseLong(currentId);
            Optional<Pattern> pattern= this.patternService.getPatternById(id);

                Pattern currentPattern = pattern.get();

                String title = currentPattern.getTitle();
                long patternId = currentPattern.getId();

                pdfCreatorService pdfCreate = new pdfCreatorService(imagePath, keyData, title, patternId);
                String pdfRUL = pdfCreate.createPdf();
                System.out.println(pdfRUL);

                currentPattern.setPatternPdfFinal(pdfRUL);
                currentPattern.setKeyData(keyData);
                currentPattern.setPatternImage(imagePath);
                patternService.addNewPattern(currentPattern);
                return new ResponseEntity(HttpStatus.ACCEPTED);

        } catch(Exception e){
            System.out.println(e);
            String error = "unable to save data";
            return new ResponseEntity((HttpStatus.BAD_REQUEST));
        }
    }
}
