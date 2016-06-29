package org.jfree.chart.entity;

import java.io.*;
import java.awt.*;

public class XYAnnotationEntity extends ChartEntity implements Serializable
{
    private static final long serialVersionUID = 2340334068383660799L;
    private int rendererIndex;
    
    public XYAnnotationEntity(final Shape shape, final int rendererIndex, final String s, final String s2) {
        super(shape, s, s2);
        this.rendererIndex = rendererIndex;
    }
    
    public int getRendererIndex() {
        return this.rendererIndex;
    }
    
    public void setRendererIndex(final int rendererIndex) {
        this.rendererIndex = rendererIndex;
    }
    
    public boolean equals(final Object o) {
        return o == this || (super.equals(o) && o instanceof XYAnnotationEntity && this.rendererIndex == ((XYAnnotationEntity)o).rendererIndex);
    }
}
