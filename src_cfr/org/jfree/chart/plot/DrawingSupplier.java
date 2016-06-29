/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;

public interface DrawingSupplier {
    public Paint getNextPaint();

    public Paint getNextOutlinePaint();

    public Stroke getNextStroke();

    public Stroke getNextOutlineStroke();

    public Shape getNextShape();
}

