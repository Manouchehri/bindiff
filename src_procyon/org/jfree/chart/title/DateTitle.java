package org.jfree.chart.title;

import java.io.*;
import java.awt.*;
import org.jfree.ui.*;
import java.text.*;
import java.util.*;

public class DateTitle extends TextTitle implements Serializable
{
    private static final long serialVersionUID = -465434812763159881L;
    
    public DateTitle() {
        this(1);
    }
    
    public DateTitle(final int n) {
        this(n, Locale.getDefault(), new Font("Dialog", 0, 12), Color.black);
    }
    
    public DateTitle(final int n, final Locale locale, final Font font, final Paint paint) {
        this(n, locale, font, paint, RectangleEdge.BOTTOM, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, Title.DEFAULT_PADDING);
    }
    
    public DateTitle(final int n, final Locale locale, final Font font, final Paint paint, final RectangleEdge rectangleEdge, final HorizontalAlignment horizontalAlignment, final VerticalAlignment verticalAlignment, final RectangleInsets rectangleInsets) {
        super(DateFormat.getDateInstance(n, locale).format(new Date()), font, paint, rectangleEdge, horizontalAlignment, verticalAlignment, rectangleInsets);
    }
    
    public void setDateFormat(final int n, final Locale locale) {
        this.setText(DateFormat.getDateInstance(n, locale).format(new Date()));
    }
}
