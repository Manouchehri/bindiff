/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.io.Serializable;
import org.jfree.util.ObjectUtilities;

public class MeanAndStandardDeviation
implements Serializable {
    private static final long serialVersionUID = 7413468697315721515L;
    private Number mean;
    private Number standardDeviation;

    public MeanAndStandardDeviation(double d2, double d3) {
        this(new Double(d2), new Double(d3));
    }

    public MeanAndStandardDeviation(Number number, Number number2) {
        this.mean = number;
        this.standardDeviation = number2;
    }

    public Number getMean() {
        return this.mean;
    }

    public Number getStandardDeviation() {
        return this.standardDeviation;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MeanAndStandardDeviation)) {
            return false;
        }
        MeanAndStandardDeviation meanAndStandardDeviation = (MeanAndStandardDeviation)object;
        if (!ObjectUtilities.equal(this.mean, meanAndStandardDeviation.mean)) {
            return false;
        }
        if (ObjectUtilities.equal(this.standardDeviation, meanAndStandardDeviation.standardDeviation)) return true;
        return false;
    }
}

