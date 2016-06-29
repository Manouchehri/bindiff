/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.function;

import org.jfree.data.function.Function2D;

public class NormalDistributionFunction2D
implements Function2D {
    private double mean;
    private double std;

    public NormalDistributionFunction2D(double d2, double d3) {
        this.mean = d2;
        this.std = d3;
    }

    public double getMean() {
        return this.mean;
    }

    public double getStandardDeviation() {
        return this.std;
    }

    @Override
    public double getValue(double d2) {
        return Math.exp(-1.0 * (d2 - this.mean) * (d2 - this.mean) / (2.0 * this.std * this.std)) / Math.sqrt(6.283185307179586 * this.std * this.std);
    }
}

