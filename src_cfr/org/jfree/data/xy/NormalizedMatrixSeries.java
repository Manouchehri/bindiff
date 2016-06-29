/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.xy.MatrixSeries;

public class NormalizedMatrixSeries
extends MatrixSeries {
    public static final double DEFAULT_SCALE_FACTOR = 1.0;
    private double m_scaleFactor = 1.0;
    private double m_totalSum = Double.MIN_VALUE;

    public NormalizedMatrixSeries(String string, int n2, int n3) {
        super(string, n2, n3);
    }

    @Override
    public Number getItem(int n2) {
        int n3 = this.getItemRow(n2);
        int n4 = this.getItemColumn(n2);
        double d2 = this.get(n3, n4) * this.m_scaleFactor;
        return new Double(d2 / this.m_totalSum);
    }

    public void setScaleFactor(double d2) {
        this.m_scaleFactor = d2;
    }

    public double getScaleFactor() {
        return this.m_scaleFactor;
    }

    @Override
    public void update(int n2, int n3, double d2) {
        this.m_totalSum -= this.get(n2, n3);
        this.m_totalSum += d2;
        super.update(n2, n3, d2);
    }

    @Override
    public void zeroAll() {
        this.m_totalSum = 0.0;
        super.zeroAll();
    }
}

