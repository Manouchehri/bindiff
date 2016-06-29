/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;

public class XYAnnotationEntity
extends ChartEntity
implements Serializable {
    private static final long serialVersionUID = 2340334068383660799L;
    private int rendererIndex;

    public XYAnnotationEntity(Shape shape, int n2, String string, String string2) {
        super(shape, string, string2);
        this.rendererIndex = n2;
    }

    public int getRendererIndex() {
        return this.rendererIndex;
    }

    public void setRendererIndex(int n2) {
        this.rendererIndex = n2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof XYAnnotationEntity)) {
            return false;
        }
        XYAnnotationEntity xYAnnotationEntity = (XYAnnotationEntity)object;
        if (this.rendererIndex == xYAnnotationEntity.rendererIndex) return true;
        return false;
    }
}

