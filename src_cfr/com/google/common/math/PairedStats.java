/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LinearTransformation;
import com.google.common.math.Stats;
import java.io.Serializable;
import javax.annotation.Nullable;

@GoogleInternal
public final class PairedStats
implements Serializable {
    private final Stats xStats;
    private final Stats yStats;
    private final double sumOfProductsOfDeltas;

    PairedStats(Stats stats, Stats stats2, double d2) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d2;
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
        Preconditions.checkState(this.count() != 0);
        return this.sumOfProductsOfDeltas / (double)this.count();
    }

    public double sampleCovariance() {
        Preconditions.checkState(this.count() > 1);
        return this.sumOfProductsOfDeltas / (double)(this.count() - 1);
    }

    public double pearsonsCorrelationCoefficient() {
        Preconditions.checkState(this.count() != 0);
        double d2 = this.xStats().sumOfSquaresOfDeltas();
        double d3 = this.yStats().sumOfSquaresOfDeltas();
        Preconditions.checkState(d2 > 0.0);
        Preconditions.checkState(d3 > 0.0);
        double d4 = PairedStats.ensurePositive(d2 * d3);
        return PairedStats.ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(d4));
    }

    public LinearTransformation leastSquaresFit() {
        Preconditions.checkState(this.count() > 1);
        double d2 = this.xStats.sumOfSquaresOfDeltas();
        if (d2 > 0.0) {
            if (this.yStats.sumOfSquaresOfDeltas() <= 0.0) return LinearTransformation.horizontal(this.yStats.mean());
            return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / d2);
        }
        Preconditions.checkState(this.yStats.sumOfSquaresOfDeltas() > 0.0);
        return LinearTransformation.vertical(this.xStats.mean());
    }

    public boolean equals(@Nullable Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats)object;
        if (!this.xStats.equals(pairedStats.xStats)) return false;
        if (!this.yStats.equals(pairedStats.yStats)) return false;
        if (Double.doubleToLongBits(this.sumOfProductsOfDeltas) != Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.xStats, this.yStats, this.sumOfProductsOfDeltas);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).add("populationCovariance", this.populationCovariance()).toString();
    }

    private static double ensurePositive(double d2) {
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

