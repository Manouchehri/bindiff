package com.google.common.math;

import com.google.common.annotations.*;
import com.google.common.base.*;

@GoogleInternal
public final class PairedStatsAccumulator
{
    private final StatsAccumulator xStats;
    private final StatsAccumulator yStats;
    private double sumOfProductsOfDeltas;
    
    public PairedStatsAccumulator() {
        this.xStats = new StatsAccumulator();
        this.yStats = new StatsAccumulator();
        this.sumOfProductsOfDeltas = 0.0;
    }
    
    public void add(final double n, final double n2) {
        this.xStats.add(n);
        if (this.xStats.count() > 1L) {
            this.sumOfProductsOfDeltas += (n - this.xStats.mean()) * (n2 - this.yStats.mean());
        }
        this.yStats.add(n2);
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
        Preconditions.checkState(this.count() != 0L);
        return this.sumOfProductsOfDeltas / this.count();
    }
    
    public final double sampleCovariance() {
        Preconditions.checkState(this.count() > 1L);
        return this.sumOfProductsOfDeltas / (this.count() - 1L);
    }
    
    public final double pearsonsCorrelationCoefficient() {
        Preconditions.checkState(this.count() != 0L);
        final double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        final double sumOfSquaresOfDeltas2 = this.yStats.sumOfSquaresOfDeltas();
        Preconditions.checkState(sumOfSquaresOfDeltas > 0.0);
        Preconditions.checkState(sumOfSquaresOfDeltas2 > 0.0);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(this.ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }
    
    public final LinearTransformation leastSquaresFit() {
        Preconditions.checkState(this.count() > 1L);
        final double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas <= 0.0) {
            Preconditions.checkState(this.yStats.sumOfSquaresOfDeltas() > 0.0);
            return LinearTransformation.vertical(this.xStats.mean());
        }
        if (this.yStats.sumOfSquaresOfDeltas() > 0.0) {
            return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas);
        }
        return LinearTransformation.horizontal(this.yStats.mean());
    }
    
    private double ensurePositive(final double n) {
        if (n > 0.0) {
            return n;
        }
        return Double.MIN_VALUE;
    }
    
    private static double ensureInUnitRange(final double n) {
        if (n >= 1.0) {
            return 1.0;
        }
        if (n <= -1.0) {
            return -1.0;
        }
        return n;
    }
}
