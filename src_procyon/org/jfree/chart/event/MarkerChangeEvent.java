package org.jfree.chart.event;

import org.jfree.chart.plot.*;

public class MarkerChangeEvent extends ChartChangeEvent
{
    private Marker marker;
    
    public MarkerChangeEvent(final Marker marker) {
        super(marker);
        this.marker = marker;
    }
    
    public Marker getMarker() {
        return this.marker;
    }
}
