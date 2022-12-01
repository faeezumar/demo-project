package com.example.demo.plot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/plot")
public class PlotController {
    private final PlotService plotService;

    @Autowired
    public PlotController(PlotService plotService) {
        this.plotService = plotService;
    }

    @PostMapping
    public void addPlot(@RequestBody Plot plot) {
        plotService.addNewPlot(plot);
    }

    @GetMapping
    public List<Plot> getPlots() {
        return plotService.getPlots();
    }

    @PutMapping(path = "{plotId}")
    public  void updatePlot(
            @PathVariable("plotId") Long plotId,
            @RequestParam(required = false) int width,
            @RequestParam(required = false) int height,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description
    ) {
        plotService.updatePlot(plotId, width, height, name, description);
    }

    @DeleteMapping(path = "{plotId}")
    public void deletePlot(@PathVariable("plotId") Long plotId) {
        plotService.deletePlot(plotId);
    }

}
