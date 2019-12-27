package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI;


import com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model.Stitch;
import com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model.StitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StitchController {
    @Autowired
    private StitchService stitchService;

    @CrossOrigin(origins="*")
    @GetMapping("/stitches")
    public List<Stitch> getAllStitches(){
        return stitchService.findAll();
    }

}
