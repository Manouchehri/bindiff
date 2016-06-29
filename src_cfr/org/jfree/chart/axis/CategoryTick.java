/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import org.jfree.chart.axis.Tick;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;

public class CategoryTick
extends Tick {
    private Comparable category;
    private TextBlock label;
    private TextBlockAnchor labelAnchor;

    public CategoryTick(Comparable comparable, TextBlock textBlock, TextBlockAnchor textBlockAnchor, TextAnchor textAnchor, double d2) {
        super("", TextAnchor.CENTER, textAnchor, d2);
        this.category = comparable;
        this.label = textBlock;
        this.labelAnchor = textBlockAnchor;
    }

    public Comparable getCategory() {
        return this.category;
    }

    public TextBlock getLabel() {
        return this.label;
    }

    public TextBlockAnchor getLabelAnchor() {
        return this.labelAnchor;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CategoryTick)) return false;
        if (!super.equals(object)) return false;
        CategoryTick categoryTick = (CategoryTick)object;
        if (!ObjectUtilities.equal(this.category, categoryTick.category)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.label, categoryTick.label)) {
            return false;
        }
        if (ObjectUtilities.equal(this.labelAnchor, categoryTick.labelAnchor)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 41;
        n2 = 37 * n2 + this.category.hashCode();
        n2 = 37 * n2 + this.label.hashCode();
        return 37 * n2 + this.labelAnchor.hashCode();
    }
}

