/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.math.LinearTransformation;
import com.google.common.math.PairedStats;
import com.google.common.math.Stats;
import com.google.common.math.StatsAccumulator;

@GoogleInternal
public final class PairedStatsAccumulator {
    private final StatsAccumulator xStats = new StatsAccumulator();
    private final StatsAccumulator yStats = new StatsAccumulator();
    private double sumOfProductsOfDeltas = 0.0;

    public void add(double d2, double d3) {
        this.xStats.add(d2);
        if (this.xStats.count() > 1) {
            this.sumOfProductsOfDeltas += (d2 - this.xStats.mean()) * (d3 - this.yStats.mean());
        }
        this.yStats.add(d3);
    }

    public PairedStats snapshot() {
        return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
    }

    public long count() {
        return this.xStats.count();
    }

    public Stats xStats() {
        return this.xStats.snapshot();
    }

    public Stats yStats() {
        return this.yStats.snapshot();
    }

    public double populationCovariance() {
        Preconditions.checkState(this.count() != 0);
        return this.sumOfProductsOfDeltas / (double)this.count();
    }

    public final double sampleCovariance() {
        Preconditions.checkState(this.count() > 1);
        return this.sumOfProductsOfDeltas / (double)(this.count() - 1);
    }

    public final double pearsonsCorrelationCoefficient() {
        Preconditions.checkState(this.count() != 0);
        double d2 = this.xStats.sumOfSquaresOfDeltas();
        double d3 = this.yStats.sumOfSquaresOfDeltas();
        Preconditions.checkState(d2 > 0.0);
        Preconditions.checkState(d3 > 0.0);
        double d4 = this.ensurePositive(d2 * d3);
        return PairedStatsAccumulator.ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(d4));
    }

    public final LinearTransformation leastSquaresFit() {
        Preconditions.checkState(this.count() > 1);
        double d2 = this.xStats.sumOfSquaresOfDeltas();
        if (d2 > 0.0) {
            if (this.yStats.sumOfSquaresOfDeltas() <= 0.0) return LinearTransformation.horizontal(this.yStats.mean());
            return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / d2);
        }
        Preconditions.checkState(this.yStats.sumOfSquaresOfDeltas() > 0.0);
        return LinearTransformation.vertical(this.xStats.mean());
    }

    private double ensurePositive(double d2) {
        if (d2 <= 0.0) return Double.MIN_VALUE;
        return d2;
    }

    private static double ensureInUnitRange(double d2) {
        if (d2 >= 1.0) {
            return 1.0;
        }
        if (d2 > -1.0) return d2;
        return -1.0;
    }
}

