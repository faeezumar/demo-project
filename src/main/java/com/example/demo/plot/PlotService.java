package com.example.demo.plot;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlotService {
    private PlotRepository plotRepository;

    @Autowired
    public PlotService(PlotRepository plotRepository) {
        this.plotRepository = plotRepository;
    }

    public List<Plot> getPlots() {
        return plotRepository.findAll();
    }

    public void addNewPlot(Plot plot) {
        plotRepository.save(plot);
    }

    @Transactional
    public void updatePlot(
            Long plotId,
            Integer width,
            Integer height,
            String name,
            String description) {
        Plot p = plotRepository.findById(plotId)
                .orElseThrow(() -> new IllegalStateException(
                        "Plot with id " + plotId + " does not exist"
                ));

        if(width != null && width > 0) {
            p.setWidth(width);
        }

        if(height != null && height > 0) {
            p.setHeight(height);
        }

        if(name != null && name.length() > 0) {
            p.setName(name);
        }

        if(description != null && description.length() > 0) {
            p.setDescription(description);
        }
    }

    public void deletePlot(Long plotId) {
        boolean exists = plotRepository.existsById(plotId);
        if(!exists) {
            throw new IllegalStateException("Plot with id " + plotId + " does not exist");
        }
        plotRepository.deleteById(plotId);
    }
}
