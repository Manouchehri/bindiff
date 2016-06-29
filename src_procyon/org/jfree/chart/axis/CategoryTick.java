package org.jfree.chart.axis;

import org.jfree.text.*;
import org.jfree.ui.*;
import org.jfree.util.*;

public class CategoryTick extends Tick
{
    private Comparable category;
    private TextBlock label;
    private TextBlockAnchor labelAnchor;
    
    public CategoryTick(final Comparable category, final TextBlock label, final TextBlockAnchor labelAnchor, final TextAnchor textAnchor, final double n) {
        super("", TextAnchor.CENTER, textAnchor, n);
        this.category = category;
        this.label = label;
        this.labelAnchor = labelAnchor;
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
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof CategoryTick && super.equals(o)) {
            final CategoryTick categoryTick = (CategoryTick)o;
            return ObjectUtilities.equal(this.category, categoryTick.category) && ObjectUtilities.equal(this.label, categoryTick.label) && ObjectUtilities.equal(this.labelAnchor, categoryTick.labelAnchor);
        }
        return false;
    }
    
    public int hashCode() {
        return 37 * (37 * (37 * 41 + this.category.hashCode()) + this.label.hashCode()) + this.labelAnchor.hashCode();
    }
}
