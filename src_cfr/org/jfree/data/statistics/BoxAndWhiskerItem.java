/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.jfree.util.ObjectUtilities;

public class BoxAndWhiskerItem
implements Serializable {
    private static final long serialVersionUID = 7329649623148167423L;
    private Number mean;
    private Number median;
    private Number q1;
    private Number q3;
    private Number minRegularValue;
    private Number maxRegularValue;
    private Number minOutlier;
    private Number maxOutlier;
    private List outliers;

    public BoxAndWhiskerItem(Number number, Number number2, Number number3, Number number4, Number number5, Number number6, Number number7, Number number8, List list) {
        this.mean = number;
        this.median = number2;
        this.q1 = number3;
        this.q3 = number4;
        this.minRegularValue = number5;
        this.maxRegularValue = number6;
        this.minOutlier = number7;
        this.maxOutlier = number8;
        this.outliers = list;
    }

    public Number getMean() {
        return this.mean;
    }

    public Number getMedian() {
        return this.median;
    }

    public Number getQ1() {
        return this.q1;
    }

    public Number getQ3() {
        return this.q3;
    }

    public Number getMinRegularValue() {
        return this.minRegularValue;
    }

    public Number getMaxRegularValue() {
        return this.maxRegularValue;
    }

    public Number getMinOutlier() {
        return this.minOutlier;
    }

    public Number getMaxOutlier() {
        return this.maxOutlier;
    }

    public List getOutliers() {
        if (this.outliers != null) return Collections.unmodifiableList(this.outliers);
        return null;
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append("[mean=").append(this.mean).append(",median=").append(this.median).append(",q1=").append(this.q1).append(",q3=").append(this.q3).append("]").toString();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BoxAndWhiskerItem)) {
            return false;
        }
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)object;
        if (!ObjectUtilities.equal(this.mean, boxAndWhiskerItem.mean)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.median, boxAndWhiskerItem.median)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.q1, boxAndWhiskerItem.q1)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.q3, boxAndWhiskerItem.q3)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.minRegularValue, boxAndWhiskerItem.minRegularValue)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.maxRegularValue, boxAndWhiskerItem.maxRegularValue)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.minOutlier, boxAndWhiskerItem.minOutlier)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.maxOutlier, boxAndWhiskerItem.maxOutlier)) {
            return false;
        }
        if (ObjectUtilities.equal(this.outliers, boxAndWhiskerItem.outliers)) return true;
        return false;
    }
}

