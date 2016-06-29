/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.title;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.VerticalAlignment;

public class DateTitle
extends TextTitle
implements Serializable {
    private static final long serialVersionUID = -465434812763159881L;

    public DateTitle() {
        this(1);
    }

    public DateTitle(int n2) {
        this(n2, Locale.getDefault(), new Font("Dialog", 0, 12), Color.black);
    }

    public DateTitle(int n2, Locale locale, Font font, Paint paint) {
        this(n2, locale, font, paint, RectangleEdge.BOTTOM, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, Title.DEFAULT_PADDING);
    }

    public DateTitle(int n2, Locale locale, Font font, Paint paint, RectangleEdge rectangleEdge, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, RectangleInsets rectangleInsets) {
        super(DateFormat.getDateInstance(n2, locale).format(new Date()), font, paint, rectangleEdge, horizontalAlignment, verticalAlignment, rectangleInsets);
    }

    public void setDateFormat(int n2, Locale locale) {
        this.setText(DateFormat.getDateInstance(n2, locale).format(new Date()));
    }
}

