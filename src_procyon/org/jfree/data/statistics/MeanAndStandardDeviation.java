package org.jfree.data.statistics;

import java.io.*;
import org.jfree.util.*;

public class MeanAndStandardDeviation implements Serializable
{
    private static final long serialVersionUID = 7413468697315721515L;
    private Number mean;
    private Number standardDeviation;
    
    public MeanAndStandardDeviation(final double n, final double n2) {
        this(new Double(n), new Double(n2));
    }
    
    public MeanAndStandardDeviation(final Number mean, final Number standardDeviation) {
        this.mean = mean;
        this.standardDeviation = standardDeviation;
    }
    
    public Number getMean() {
        return this.mean;
    }
    
    public Number getStandardDeviation() {
        return this.standardDeviation;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MeanAndStandardDeviation)) {
            return false;
        }
        final MeanAndStandardDeviation meanAndStandardDeviation = (MeanAndStandardDeviation)o;
        return ObjectUtilities.equal(this.mean, meanAndStandardDeviation.mean) && ObjectUtilities.equal(this.standardDeviation, meanAndStandardDeviation.standardDeviation);
    }
}
