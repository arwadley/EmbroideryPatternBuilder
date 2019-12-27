package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI;

import com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model.Stitch;
import com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model.StitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StitchService {
    @Autowired
    private StitchRepository stitchRepository;

    public List<Stitch> findAll(){
        Iterable<Stitch> data = stitchRepository.findAll();
        List stitches = new ArrayList<Stitch>();
        data.forEach(each -> stitches.add(each));

        return stitches;
    }
}
