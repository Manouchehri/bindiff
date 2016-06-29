/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.Color;
import java.awt.Paint;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.jfree.chart.axis.ValueTick;

public abstract class ColorPalette
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -9029901853079622051L;
    protected double minZ = -1.0;
    protected double maxZ = -1.0;
    protected int[] r;
    protected int[] g;
    protected int[] b;
    protected double[] tickValues = null;
    protected boolean logscale = false;
    protected boolean inverse = false;
    protected String paletteName = null;
    protected boolean stepped = false;
    protected static final double log10 = Math.log(10.0);

    public Paint getColor(double d2) {
        int n2 = (int)(253.0 * (d2 - this.minZ) / (this.maxZ - this.minZ)) + 2;
        return new Color(this.r[n2], this.g[n2], this.b[n2]);
    }

    public Color getColor(int n2) {
        return new Color(this.r[n2], this.g[n2], this.b[n2]);
    }

    public Color getColorLinear(double d2) {
        int n2 = 0;
        if (this.stepped) {
            int n3 = Arrays.binarySearch(this.tickValues, d2);
            if (n3 < 0) {
                n3 = -1 * n3 - 2;
            }
            d2 = n3 < 0 ? this.minZ : this.tickValues[n3];
        }
        n2 = (int)(253.0 * (d2 - this.minZ) / (this.maxZ - this.minZ)) + 2;
        n2 = Math.min(n2, 255);
        n2 = Math.max(n2, 2);
        return this.getColor(n2);
    }

    public Color getColorLog(double d2) {
        int n2 = 0;
        double d3 = this.minZ;
        double d4 = this.maxZ;
        if (this.minZ <= 0.0) {
            this.maxZ = d4 - d3 + 1.0;
            this.minZ = 1.0;
            d2 = d2 - d3 + 1.0;
        }
        double d5 = Math.log(this.minZ) / log10;
        double d6 = Math.log(this.maxZ) / log10;
        d2 = Math.log(d2) / log10;
        if (this.stepped) {
            int n3 = this.tickValues.length;
            int n4 = 256 / (n3 - 1);
            n2 = n4 * (int)((double)n3 * (d2 - d5) / (d6 - d5)) + 2;
        } else {
            n2 = (int)(253.0 * (d2 - d5) / (d6 - d5)) + 2;
        }
        n2 = Math.min(n2, 255);
        n2 = Math.max(n2, 2);
        this.minZ = d3;
        this.maxZ = d4;
        return this.getColor(n2);
    }

    public double getMaxZ() {
        return this.maxZ;
    }

    public double getMinZ() {
        return this.minZ;
    }

    public Paint getPaint(double d2) {
        if (!this.isLogscale()) return this.getColorLinear(d2);
        return this.getColorLog(d2);
    }

    public String getPaletteName() {
        return this.paletteName;
    }

    public double[] getTickValues() {
        return this.tickValues;
    }

    public abstract void initialize();

    public void invertPalette() {
        int n2;
        int[] arrn = new int[256];
        int[] arrn2 = new int[256];
        int[] arrn3 = new int[256];
        for (n2 = 0; n2 < 256; ++n2) {
            arrn[n2] = this.r[n2];
            arrn2[n2] = this.g[n2];
            arrn3[n2] = this.b[n2];
        }
        n2 = 2;
        while (n2 < 256) {
            this.r[n2] = arrn[257 - n2];
            this.g[n2] = arrn2[257 - n2];
            this.b[n2] = arrn3[257 - n2];
            ++n2;
        }
    }

    public boolean isInverse() {
        return this.inverse;
    }

    public boolean isLogscale() {
        return this.logscale;
    }

    public boolean isStepped() {
        return this.stepped;
    }

    public void setInverse(boolean bl2) {
        this.inverse = bl2;
        this.initialize();
        if (!bl2) return;
        this.invertPalette();
    }

    public void setLogscale(boolean bl2) {
        this.logscale = bl2;
    }

    public void setMaxZ(double d2) {
        this.maxZ = d2;
    }

    public void setMinZ(double d2) {
        this.minZ = d2;
    }

    public void setPaletteName(String string) {
        this.paletteName = string;
    }

    public void setStepped(boolean bl2) {
        this.stepped = bl2;
    }

    public void setTickValues(double[] arrd) {
        this.tickValues = arrd;
    }

    public void setTickValues(List list) {
        this.tickValues = new double[list.size()];
        int n2 = 0;
        while (n2 < this.tickValues.length) {
            this.tickValues[n2] = ((ValueTick)list.get(n2)).getValue();
            ++n2;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ColorPalette)) {
            return false;
        }
        ColorPalette colorPalette = (ColorPalette)object;
        if (this.inverse != colorPalette.inverse) {
            return false;
        }
        if (this.logscale != colorPalette.logscale) {
            return false;
        }
        if (this.maxZ != colorPalette.maxZ) {
            return false;
        }
        if (this.minZ != colorPalette.minZ) {
            return false;
        }
        if (this.stepped != colorPalette.stepped) {
            return false;
        }
        if (!Arrays.equals(this.b, colorPalette.b)) {
            return false;
        }
        if (!Arrays.equals(this.g, colorPalette.g)) {
            return false;
        }
        if (this.paletteName != null ? !this.paletteName.equals(colorPalette.paletteName) : colorPalette.paletteName != null) {
            return false;
        }
        if (!Arrays.equals(this.r, colorPalette.r)) {
            return false;
        }
        if (Arrays.equals(this.tickValues, colorPalette.tickValues)) return true;
        return false;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.minZ);
        int n2 = (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.maxZ);
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        n2 = 29 * n2 + (this.logscale ? 1 : 0);
        n2 = 29 * n2 + (this.inverse ? 1 : 0);
        n2 = 29 * n2 + (this.paletteName != null ? this.paletteName.hashCode() : 0);
        return 29 * n2 + (this.stepped ? 1 : 0);
    }

    public Object clone() {
        return (ColorPalette)super.clone();
    }
}

