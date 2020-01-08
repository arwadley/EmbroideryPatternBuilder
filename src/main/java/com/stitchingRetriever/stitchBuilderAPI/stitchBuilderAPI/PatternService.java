package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI;

import com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model.Pattern;
import com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model.PatternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatternService {

    @Autowired
    private PatternRepository patternRepository;

    public void addNewPattern(Pattern pattern) {
        try{
            this.patternRepository.save(pattern);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
