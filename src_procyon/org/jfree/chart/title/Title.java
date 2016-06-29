package org.jfree.chart.title;

import org.jfree.chart.block.*;
import org.jfree.ui.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.event.*;
import org.jfree.util.*;
import java.io.*;

public abstract class Title extends AbstractBlock implements Serializable, Cloneable, Block
{
    private static final long serialVersionUID = -6675162505277817221L;
    public static final RectangleEdge DEFAULT_POSITION;
    public static final HorizontalAlignment DEFAULT_HORIZONTAL_ALIGNMENT;
    public static final VerticalAlignment DEFAULT_VERTICAL_ALIGNMENT;
    public static final RectangleInsets DEFAULT_PADDING;
    private RectangleEdge position;
    private HorizontalAlignment horizontalAlignment;
    private VerticalAlignment verticalAlignment;
    private transient EventListenerList listenerList;
    private boolean notify;
    static Class class$org$jfree$chart$event$TitleChangeListener;
    
    protected Title() {
        this(Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);
    }
    
    protected Title(final RectangleEdge rectangleEdge, final HorizontalAlignment horizontalAlignment, final VerticalAlignment verticalAlignment) {
        this(rectangleEdge, horizontalAlignment, verticalAlignment, Title.DEFAULT_PADDING);
    }
    
    protected Title(final RectangleEdge position, final HorizontalAlignment horizontalAlignment, final VerticalAlignment verticalAlignment, final RectangleInsets padding) {
        if (position == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        if (horizontalAlignment == null) {
            throw new IllegalArgumentException("Null 'horizontalAlignment' argument.");
        }
        if (verticalAlignment == null) {
            throw new IllegalArgumentException("Null 'verticalAlignment' argument.");
        }
        if (padding == null) {
            throw new IllegalArgumentException("Null 'spacer' argument.");
        }
        this.position = position;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.setPadding(padding);
        this.listenerList = new EventListenerList();
        this.notify = true;
    }
    
    public RectangleEdge getPosition() {
        return this.position;
    }
    
    public void setPosition(final RectangleEdge position) {
        if (position == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        if (this.position != position) {
            this.position = position;
            this.notifyListeners(new TitleChangeEvent(this));
        }
    }
    
    public HorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }
    
    public void setHorizontalAlignment(final HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            throw new IllegalArgumentException("Null 'alignment' argument.");
        }
        if (this.horizontalAlignment != horizontalAlignment) {
            this.horizontalAlignment = horizontalAlignment;
            this.notifyListeners(new TitleChangeEvent(this));
        }
    }
    
    public VerticalAlignment getVerticalAlignment() {
        return this.verticalAlignment;
    }
    
    public void setVerticalAlignment(final VerticalAlignment verticalAlignment) {
        if (verticalAlignment == null) {
            throw new IllegalArgumentException("Null 'alignment' argument.");
        }
        if (this.verticalAlignment != verticalAlignment) {
            this.verticalAlignment = verticalAlignment;
            this.notifyListeners(new TitleChangeEvent(this));
        }
    }
    
    public boolean getNotify() {
        return this.notify;
    }
    
    public void setNotify(final boolean notify) {
        this.notify = notify;
        if (notify) {
            this.notifyListeners(new TitleChangeEvent(this));
        }
    }
    
    public abstract void draw(final Graphics2D p0, final Rectangle2D p1);
    
    public Object clone() {
        final Title title = (Title)super.clone();
        title.listenerList = new EventListenerList();
        return title;
    }
    
    public void addChangeListener(final TitleChangeListener titleChangeListener) {
        this.listenerList.add((Title.class$org$jfree$chart$event$TitleChangeListener == null) ? (Title.class$org$jfree$chart$event$TitleChangeListener = class$("org.jfree.chart.event.TitleChangeListener")) : Title.class$org$jfree$chart$event$TitleChangeListener, titleChangeListener);
    }
    
    public void removeChangeListener(final TitleChangeListener titleChangeListener) {
        this.listenerList.remove((Title.class$org$jfree$chart$event$TitleChangeListener == null) ? (Title.class$org$jfree$chart$event$TitleChangeListener = class$("org.jfree.chart.event.TitleChangeListener")) : Title.class$org$jfree$chart$event$TitleChangeListener, titleChangeListener);
    }
    
    protected void notifyListeners(final TitleChangeEvent titleChangeEvent) {
        if (this.notify) {
            final Object[] listenerList = this.listenerList.getListenerList();
            for (int i = listenerList.length - 2; i >= 0; i -= 2) {
                if (listenerList[i] == ((Title.class$org$jfree$chart$event$TitleChangeListener == null) ? (Title.class$org$jfree$chart$event$TitleChangeListener = class$("org.jfree.chart.event.TitleChangeListener")) : Title.class$org$jfree$chart$event$TitleChangeListener)) {
                    ((TitleChangeListener)listenerList[i + 1]).titleChanged(titleChangeEvent);
                }
            }
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Title)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Title title = (Title)o;
        return this.position == title.position && this.horizontalAlignment == title.horizontalAlignment && this.verticalAlignment == title.verticalAlignment && this.notify == title.notify;
    }
    
    public int hashCode() {
        return 37 * (37 * (37 * 193 + ObjectUtilities.hashCode(this.position)) + ObjectUtilities.hashCode(this.horizontalAlignment)) + ObjectUtilities.hashCode(this.verticalAlignment);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.listenerList = new EventListenerList();
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        DEFAULT_POSITION = RectangleEdge.TOP;
        DEFAULT_HORIZONTAL_ALIGNMENT = HorizontalAlignment.CENTER;
        DEFAULT_VERTICAL_ALIGNMENT = VerticalAlignment.CENTER;
        DEFAULT_PADDING = new RectangleInsets(1.0, 1.0, 1.0, 1.0);
    }
}
