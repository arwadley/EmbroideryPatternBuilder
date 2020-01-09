package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.io.IOException;
import java.util.ArrayList;

public class pdfCreatorService {
    private static final String staticFilePath = "/Users/alyssawadley/Documents/stitchBuilderAPI/src/main/resources/static/";

    private String imagePath;
    private String keyData;
    private String projectTitle;
    private long id;

    public pdfCreatorService(String imagePath, String keyData, String projectTitle, long id){
        this.imagePath = imagePath;
        this.keyData = keyData;
        this.projectTitle = projectTitle;
        this.id = id;
    }

    public String createPdf(){
        try{
            PDDocument pdf = new PDDocument();
            PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
            PDPageContentStream stream = new PDPageContentStream(pdf, page);
            PDImageXObject pdImage = PDImageXObject.createFromFile(this.imagePath, pdf);

            int fontSize = 20;
            PDFont font = PDType1Font.COURIER_BOLD;
            float titleWidth = font.getStringWidth(this.projectTitle) / 1000 * fontSize;
            float titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;

            stream.beginText();
            stream.setFont(font, fontSize);
            stream.newLineAtOffset((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - 10 - titleHeight);
            stream.showText(this.projectTitle);
            stream.endText();
            int width = 600;
            int height = 450;
            int margin = 36;

            stream.drawImage(pdImage, margin, margin, width, height);

            stream.moveTo(margin, margin);
            stream.lineTo(width + margin, margin);
            stream.stroke();

            stream.moveTo(width + margin, margin);
            stream.lineTo(width + margin, height + margin);
            stream.stroke();

            stream.moveTo(width + margin, height + margin);
            stream.lineTo(margin, height + margin);
            stream.stroke();

            stream.moveTo(margin, height + margin);
            stream.lineTo(margin, margin);
            stream.stroke();

            stream.beginText();
            stream.newLineAtOffset(width + margin + 65, height + margin - 5);
            stream.setFont(font, 18);
            stream.showText("KEY");
            stream.endText();


            String[] formattedData = formatKeyData();
            int newHeight = height;
            for(int i = 0; i < formattedData.length; i++) {
                stream.beginText();
                System.out.println(formattedData[i]);
                stream.newLineAtOffset(width + margin + 20, newHeight + margin - 50);
                stream.setFont(font, 12);
                stream.showText(formattedData[i]);
                stream.endText();
                newHeight -= 25;
            }

            stream.close();

            pdf.addPage(page);
            pdf.save(staticFilePath + this.projectTitle + this.id +  ".pdf");
            pdf.close();
            return staticFilePath + this.projectTitle + this.id +  ".pdf";
        } catch(IOException e) {
            System.out.println(e);
            return "error";
        }
    }

    public String[] formatKeyData() {
        String[] formattedData = this.keyData.split("\n");
        return formattedData;
    }



}
