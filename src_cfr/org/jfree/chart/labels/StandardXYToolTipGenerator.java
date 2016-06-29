/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractXYItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class StandardXYToolTipGenerator
extends AbstractXYItemLabelGenerator
implements Serializable,
Cloneable,
XYToolTipGenerator,
PublicCloneable {
    private static final long serialVersionUID = -3564164459039540784L;
    public static final String DEFAULT_TOOL_TIP_FORMAT = "{0}: ({1}, {2})";

    public static StandardXYToolTipGenerator getTimeSeriesInstance() {
        return new StandardXYToolTipGenerator("{0}: ({1}, {2})", DateFormat.getInstance(), NumberFormat.getInstance());
    }

    public StandardXYToolTipGenerator() {
        this("{0}: ({1}, {2})", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
    }

    public StandardXYToolTipGenerator(String string, NumberFormat numberFormat, NumberFormat numberFormat2) {
        super(string, numberFormat, numberFormat2);
    }

    public StandardXYToolTipGenerator(String string, DateFormat dateFormat, NumberFormat numberFormat) {
        super(string, dateFormat, numberFormat);
    }

    public StandardXYToolTipGenerator(String string, NumberFormat numberFormat, DateFormat dateFormat) {
        super(string, numberFormat, dateFormat);
    }

    public StandardXYToolTipGenerator(String string, DateFormat dateFormat, DateFormat dateFormat2) {
        super(string, dateFormat, dateFormat2);
    }

    @Override
    public String generateToolTip(XYDataset xYDataset, int n2, int n3) {
        return this.generateLabelString(xYDataset, n2, n3);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof StandardXYToolTipGenerator) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

