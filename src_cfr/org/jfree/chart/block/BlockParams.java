/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import org.jfree.chart.block.EntityBlockParams;

public class BlockParams
implements EntityBlockParams {
    private boolean generateEntities = false;
    private double translateX = 0.0;
    private double translateY = 0.0;

    @Override
    public boolean getGenerateEntities() {
        return this.generateEntities;
    }

    public void setGenerateEntities(boolean bl2) {
        this.generateEntities = bl2;
    }

    public double getTranslateX() {
        return this.translateX;
    }

    public void setTranslateX(double d2) {
        this.translateX = d2;
    }

    public double getTranslateY() {
        return this.translateY;
    }

    public void setTranslateY(double d2) {
        this.translateY = d2;
    }
}

