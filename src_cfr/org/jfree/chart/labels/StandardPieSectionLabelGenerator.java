/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.AttributedString;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractPieItemLabelGenerator;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.util.ObjectList;

public class StandardPieSectionLabelGenerator
extends AbstractPieItemLabelGenerator
implements Serializable,
Cloneable,
PieSectionLabelGenerator {
    private static final long serialVersionUID = 3064190563760203668L;
    public static final String DEFAULT_SECTION_LABEL_FORMAT = "{0}";
    private ObjectList attributedLabels = new ObjectList();

    public StandardPieSectionLabelGenerator() {
        this("{0}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
    }

    public StandardPieSectionLabelGenerator(String string) {
        this(string, NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
    }

    public StandardPieSectionLabelGenerator(String string, NumberFormat numberFormat, NumberFormat numberFormat2) {
        super(string, numberFormat, numberFormat2);
    }

    public AttributedString getAttributedLabel(int n2) {
        return (AttributedString)this.attributedLabels.get(n2);
    }

    public void setAttributedLabel(int n2, AttributedString attributedString) {
        this.attributedLabels.set(n2, attributedString);
    }

    @Override
    public String generateSectionLabel(PieDataset pieDataset, Comparable comparable) {
        return super.generateSectionLabel(pieDataset, comparable);
    }

    @Override
    public AttributedString generateAttributedSectionLabel(PieDataset pieDataset, Comparable comparable) {
        return this.getAttributedLabel(pieDataset.getIndex(comparable));
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StandardPieSectionLabelGenerator)) {
            return false;
        }
        StandardPieSectionLabelGenerator standardPieSectionLabelGenerator = (StandardPieSectionLabelGenerator)object;
        if (!this.attributedLabels.equals(standardPieSectionLabelGenerator.attributedLabels)) {
            return false;
        }
        if (super.equals(object)) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

