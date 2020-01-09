package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI;

import com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model.Pattern;
import com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model.PatternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatternService {

    @Autowired
    private PatternRepository patternRepository;

    public Pattern addNewPattern(Pattern pattern) {
        try{
            Pattern updatedPattern = this.patternRepository.save(pattern);
            return updatedPattern;
        } catch(Exception e) {
            System.out.println(e);
            return pattern;
        }
    }

    public Optional<Pattern> getPatternById(long id){
        Optional<Pattern> currentPattern = this.patternRepository.findById(id);
        return currentPattern;
    }
}
