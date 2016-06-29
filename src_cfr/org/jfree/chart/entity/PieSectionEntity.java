/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.general.PieDataset;

public class PieSectionEntity
extends ChartEntity
implements Serializable {
    private static final long serialVersionUID = 9199892576531984162L;
    private PieDataset dataset;
    private int pieIndex;
    private int sectionIndex;
    private Comparable sectionKey;

    public PieSectionEntity(Shape shape, PieDataset pieDataset, int n2, int n3, Comparable comparable, String string, String string2) {
        super(shape, string, string2);
        this.dataset = pieDataset;
        this.pieIndex = n2;
        this.sectionIndex = n3;
        this.sectionKey = comparable;
    }

    public PieDataset getDataset() {
        return this.dataset;
    }

    public void setDataset(PieDataset pieDataset) {
        this.dataset = pieDataset;
    }

    public int getPieIndex() {
        return this.pieIndex;
    }

    public void setPieIndex(int n2) {
        this.pieIndex = n2;
    }

    public int getSectionIndex() {
        return this.sectionIndex;
    }

    public void setSectionIndex(int n2) {
        this.sectionIndex = n2;
    }

    public Comparable getSectionKey() {
        return this.sectionKey;
    }

    public void setSectionKey(Comparable comparable) {
        this.sectionKey = comparable;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("PieSection: ").append(this.pieIndex).append(", ").append(this.sectionIndex).append("(").append(this.sectionKey.toString()).append(")").toString();
    }
}

