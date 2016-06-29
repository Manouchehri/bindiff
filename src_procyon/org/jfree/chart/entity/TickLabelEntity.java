package org.jfree.chart.entity;

import java.io.*;
import java.awt.*;

public class TickLabelEntity extends ChartEntity implements Serializable, Cloneable
{
    private static final long serialVersionUID = 681583956588092095L;
    
    public TickLabelEntity(final Shape shape, final String s, final String s2) {
        super(shape, s, s2);
    }
}
