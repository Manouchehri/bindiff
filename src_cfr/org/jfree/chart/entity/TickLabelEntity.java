/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;

public class TickLabelEntity
extends ChartEntity
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 681583956588092095L;

    public TickLabelEntity(Shape shape, String string, String string2) {
        super(shape, string, string2);
    }
}

