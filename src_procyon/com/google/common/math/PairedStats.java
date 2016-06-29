package com.google.common.math;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;

@GoogleInternal
public final class PairedStats implements Serializable
{
    private final Stats xStats;
    private final Stats yStats;
    private final double sumOfProductsOfDeltas;
    
    PairedStats(final Stats xStats, final Stats yStats, final double sumOfProductsOfDeltas) {
        this.xStats = xStats;
        this.yStats = yStats;
        this.sumOfProductsOfDeltas = sumOfProductsOfDeltas;
    }
    
    public long count() {
        return this.xStats.count();
    }
    
    public Stats xStats() {
        return this.xStats;
    }
    
    public Stats yStats() {
        return this.yStats;
    }
    
    public double populationCovariance() {
        Preconditions.checkState(this.count() != 0L);
        return this.sumOfProductsOfDeltas / this.count();
    }
    
    public double sampleCovariance() {
        Preconditions.checkState(this.count() > 1L);
        return this.sumOfProductsOfDeltas / (this.count() - 1L);
    }
    
    public double pearsonsCorrelationCoefficient() {
        Preconditions.checkState(this.count() != 0L);
        final double sumOfSquaresOfDeltas = this.xStats().sumOfSquaresOfDeltas();
        final double sumOfSquaresOfDeltas2 = this.yStats().sumOfSquaresOfDeltas();
        Preconditions.checkState(sumOfSquaresOfDeltas > 0.0);
        Preconditions.checkState(sumOfSquaresOfDeltas2 > 0.0);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }
    
    public LinearTransformation leastSquaresFit() {
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
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        final PairedStats pairedStats = (PairedStats)o;
        return this.xStats.equals(pairedStats.xStats) && this.yStats.equals(pairedStats.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.xStats, this.yStats, this.sumOfProductsOfDeltas);
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).add("populationCovariance", this.populationCovariance()).toString();
    }
    
    private static double ensurePositive(final double n) {
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
