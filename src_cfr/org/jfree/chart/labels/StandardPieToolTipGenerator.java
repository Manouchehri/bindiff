/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractPieItemLabelGenerator;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.util.PublicCloneable;

public class StandardPieToolTipGenerator
extends AbstractPieItemLabelGenerator
implements Serializable,
Cloneable,
PieToolTipGenerator,
PublicCloneable {
    private static final long serialVersionUID = 2995304200445733779L;
    public static final String DEFAULT_TOOLTIP_FORMAT = "{0}: ({1}, {2})";
    public static final String DEFAULT_SECTION_LABEL_FORMAT = "{0} = {1}";

    public StandardPieToolTipGenerator() {
        this("{0} = {1}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
    }

    public StandardPieToolTipGenerator(String string) {
        this(string, NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
    }

    public StandardPieToolTipGenerator(String string, NumberFormat numberFormat, NumberFormat numberFormat2) {
        super(string, numberFormat, numberFormat2);
    }

    @Override
    public String generateToolTip(PieDataset pieDataset, Comparable comparable) {
        return this.generateSectionLabel(pieDataset, comparable);
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

