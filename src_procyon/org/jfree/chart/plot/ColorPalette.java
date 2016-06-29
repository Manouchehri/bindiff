package org.jfree.chart.plot;

import java.io.*;
import java.awt.*;
import java.util.*;
import org.jfree.chart.axis.*;

public abstract class ColorPalette implements Serializable, Cloneable
{
    private static final long serialVersionUID = -9029901853079622051L;
    protected double minZ;
    protected double maxZ;
    protected int[] r;
    protected int[] g;
    protected int[] b;
    protected double[] tickValues;
    protected boolean logscale;
    protected boolean inverse;
    protected String paletteName;
    protected boolean stepped;
    protected static final double log10;
    
    public ColorPalette() {
        this.minZ = -1.0;
        this.maxZ = -1.0;
        this.tickValues = null;
        this.logscale = false;
        this.inverse = false;
        this.paletteName = null;
        this.stepped = false;
    }
    
    public Paint getColor(final double n) {
        final int n2 = (int)(253.0 * (n - this.minZ) / (this.maxZ - this.minZ)) + 2;
        return new Color(this.r[n2], this.g[n2], this.b[n2]);
    }
    
    public Color getColor(final int n) {
        return new Color(this.r[n], this.g[n], this.b[n]);
    }
    
    public Color getColorLinear(double minZ) {
        if (this.stepped) {
            int binarySearch = Arrays.binarySearch(this.tickValues, minZ);
            if (binarySearch < 0) {
                binarySearch = -1 * binarySearch - 2;
            }
            if (binarySearch < 0) {
                minZ = this.minZ;
            }
            else {
                minZ = this.tickValues[binarySearch];
            }
        }
        return this.getColor(Math.max(Math.min((int)(253.0 * (minZ - this.minZ) / (this.maxZ - this.minZ)) + 2, 255), 2));
    }
    
    public Color getColorLog(double n) {
        final double minZ = this.minZ;
        final double maxZ = this.maxZ;
        if (this.minZ <= 0.0) {
            this.maxZ = maxZ - minZ + 1.0;
            this.minZ = 1.0;
            n = n - minZ + 1.0;
        }
        final double n2 = Math.log(this.minZ) / ColorPalette.log10;
        final double n3 = Math.log(this.maxZ) / ColorPalette.log10;
        n = Math.log(n) / ColorPalette.log10;
        int n4;
        if (this.stepped) {
            final int length = this.tickValues.length;
            n4 = 256 / (length - 1) * (int)(length * (n - n2) / (n3 - n2)) + 2;
        }
        else {
            n4 = (int)(253.0 * (n - n2) / (n3 - n2)) + 2;
        }
        final int max = Math.max(Math.min(n4, 255), 2);
        this.minZ = minZ;
        this.maxZ = maxZ;
        return this.getColor(max);
    }
    
    public double getMaxZ() {
        return this.maxZ;
    }
    
    public double getMinZ() {
        return this.minZ;
    }
    
    public Paint getPaint(final double n) {
        if (this.isLogscale()) {
            return this.getColorLog(n);
        }
        return this.getColorLinear(n);
    }
    
    public String getPaletteName() {
        return this.paletteName;
    }
    
    public double[] getTickValues() {
        return this.tickValues;
    }
    
    public abstract void initialize();
    
    public void invertPalette() {
        final int[] array = new int[256];
        final int[] array2 = new int[256];
        final int[] array3 = new int[256];
        for (int i = 0; i < 256; ++i) {
            array[i] = this.r[i];
            array2[i] = this.g[i];
            array3[i] = this.b[i];
        }
        for (int j = 2; j < 256; ++j) {
            this.r[j] = array[257 - j];
            this.g[j] = array2[257 - j];
            this.b[j] = array3[257 - j];
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
    
    public void setInverse(final boolean inverse) {
        this.inverse = inverse;
        this.initialize();
        if (inverse) {
            this.invertPalette();
        }
    }
    
    public void setLogscale(final boolean logscale) {
        this.logscale = logscale;
    }
    
    public void setMaxZ(final double maxZ) {
        this.maxZ = maxZ;
    }
    
    public void setMinZ(final double minZ) {
        this.minZ = minZ;
    }
    
    public void setPaletteName(final String paletteName) {
        this.paletteName = paletteName;
    }
    
    public void setStepped(final boolean stepped) {
        this.stepped = stepped;
    }
    
    public void setTickValues(final double[] tickValues) {
        this.tickValues = tickValues;
    }
    
    public void setTickValues(final List list) {
        this.tickValues = new double[list.size()];
        for (int i = 0; i < this.tickValues.length; ++i) {
            this.tickValues[i] = list.get(i).getValue();
        }
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ColorPalette)) {
            return false;
        }
        final ColorPalette colorPalette = (ColorPalette)o;
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
        if (this.paletteName != null) {
            if (this.paletteName.equals(colorPalette.paletteName)) {
                return Arrays.equals(this.r, colorPalette.r) && Arrays.equals(this.tickValues, colorPalette.tickValues);
            }
        }
        else if (colorPalette.paletteName == null) {
            return Arrays.equals(this.r, colorPalette.r) && Arrays.equals(this.tickValues, colorPalette.tickValues);
        }
        return false;
    }
    
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.minZ);
        final int n = (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.maxZ);
        return 29 * (29 * (29 * (29 * (29 * n + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32)) + (this.logscale ? 1 : 0)) + (this.inverse ? 1 : 0)) + ((this.paletteName != null) ? this.paletteName.hashCode() : 0)) + (this.stepped ? 1 : 0);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    static {
        log10 = Math.log(10.0);
    }
}
