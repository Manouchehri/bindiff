/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.io.Serializable;
import org.jfree.chart.plot.ColorPalette;

public class GreyPalette
extends ColorPalette
implements Serializable {
    private static final long serialVersionUID = -2120941170159987395L;

    public GreyPalette() {
        this.initialize();
    }

    @Override
    public void initialize() {
        this.setPaletteName("Grey");
        this.r = new int[256];
        this.g = new int[256];
        this.b = new int[256];
        this.r[0] = 255;
        this.g[0] = 255;
        this.b[0] = 255;
        this.r[1] = 0;
        this.g[1] = 0;
        this.b[1] = 0;
        int n2 = 2;
        while (n2 < 256) {
            this.r[n2] = n2;
            this.g[n2] = n2;
            this.b[n2] = n2++;
        }
    }
}

