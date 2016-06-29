package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.*;
import java.awt.font.*;
import java.text.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.*;

public class ZyLineContent
{
    private static final FontRenderContext m_fontContext;
    private static final Composite DEFAULT_COMPOSITE;
    private static final Composite NORMAL_COMPOSITE;
    private static final Stroke DEFAULT_BORDER_STROKE;
    private static final Stroke NORMAL_STROKE;
    private String m_text;
    private AttributedString m_atext;
    private double m_charWidth;
    private double m_charHeight;
    private TextLayout m_textLayout;
    private final ArrayList m_highlighting;
    private final List m_lineObjects;
    private final IZyEditableObject m_model;
    private Color m_backgroundColor;
    private final List m_objects;
    
    public ZyLineContent(final String s, final Font font, final IZyEditableObject zyEditableObject) {
        this(s, font, new ArrayList(), zyEditableObject);
    }
    
    public ZyLineContent(final String s, final Font font, final List list, final IZyEditableObject model) {
        this.m_highlighting = new ArrayList();
        this.m_lineObjects = new ArrayList();
        this.m_backgroundColor = null;
        this.m_objects = new ArrayList();
        Preconditions.checkNotNull(s, (Object)"Error: Text argument can't be null");
        Preconditions.checkNotNull(list, (Object)"Error: Text color style run can't be null.");
        this.m_model = model;
        this.regenerateLine(s, font, list);
    }
    
    public ZyLineContent(final String s, final IZyEditableObject zyEditableObject) {
        this(s, null, zyEditableObject);
    }
    
    private int calculateRealLength(final int n, final int n2) {
        return (n2 != -1) ? n2 : (this.m_text.length() - n);
    }
    
    private void drawHighlighting(final Graphics2D graphics2D, final double n, final double n2, final double n3, final double n4, final Color color) {
        graphics2D.setColor(color);
        final int n5 = (int)Math.round(n);
        final int n6 = (int)Math.round(n2);
        final int n7 = (int)Math.round(n4);
        final int n8 = (int)Math.round(n3);
        graphics2D.setComposite(ZyLineContent.DEFAULT_COMPOSITE);
        graphics2D.fillRoundRect(n5, n6, n8, n7, 10, 10);
        graphics2D.setColor(color.darker());
        graphics2D.setStroke(ZyLineContent.DEFAULT_BORDER_STROKE);
        graphics2D.drawRoundRect(n5, n6, n8, n7, 10, 10);
        graphics2D.setComposite(ZyLineContent.NORMAL_COMPOSITE);
        graphics2D.setStroke(ZyLineContent.NORMAL_STROKE);
    }
    
    private void regenerateLine(final String s, final Font font, final List list) {
        this.m_text = (String)Preconditions.checkNotNull(s, (Object)"Error: text argument can not be null");
        Preconditions.checkNotNull(list, (Object)"Error: textColorStyleRun argument can not be null");
        this.m_atext = new AttributedString(s);
        if (!this.isEmpty()) {
            if (font != null) {
                this.m_atext.addAttribute(TextAttribute.FONT, font);
            }
            for (final CStyleRunData cStyleRunData : list) {
                final int start = cStyleRunData.getStart();
                final int calculateRealLength = this.calculateRealLength(start, cStyleRunData.getLength());
                this.validatePartialLineArguments(start, calculateRealLength);
                this.m_atext.addAttribute(TextAttribute.FOREGROUND, cStyleRunData.getColor(), start, start + calculateRealLength);
                if (cStyleRunData.getLineObject() != null) {
                    this.m_lineObjects.add(cStyleRunData.getLineObject());
                }
                if (cStyleRunData.getObject() != null) {
                    this.setObject(start, calculateRealLength, cStyleRunData.getObject());
                }
            }
            this.m_textLayout = new TextLayout(this.m_atext.getIterator(), ZyLineContent.m_fontContext);
        }
        if (font != null) {
            this.updateCharBounds(font);
        }
    }
    
    private void updateCharBounds(final Font font) {
        this.m_charWidth = font.getStringBounds(this.m_text, ZyLineContent.m_fontContext).getWidth() / this.getTextLayout().getCharacterCount();
        this.m_charHeight = font.getLineMetrics(this.m_text, ZyLineContent.m_fontContext).getHeight();
    }
    
    private void validatePartialLineArguments(final int n, final int n2) {
        Preconditions.checkArgument(n >= 0 && n < this.m_text.length(), "Error: Position argument is out of bounds (Position: %d, Length: %d/%d)", n, n2, this.m_text.length());
        Preconditions.checkArgument(n2 > 0 || n + n2 <= this.m_text.length(), "Error: Length argument is out of bounds (Position: %d, Length: %d)", n, n2);
    }
    
    public synchronized boolean clearHighlighting(final int n) {
        if (this.m_highlighting.isEmpty()) {
            return false;
        }
        for (final CHighlighting cHighlighting : new ArrayList<CHighlighting>(this.m_highlighting)) {
            if (cHighlighting.getLevel() == n) {
                this.m_highlighting.remove(cHighlighting);
                return true;
            }
        }
        return false;
    }
    
    public synchronized void draw(final Graphics2D graphics2D, final float n, final float n2) {
        if (!this.isEmpty()) {
            this.m_textLayout.draw(graphics2D, n, n2);
            for (final CHighlighting cHighlighting : new ArrayList<CHighlighting>(this.m_highlighting)) {
                this.drawHighlighting(graphics2D, n + cHighlighting.getStart() - 2.0, n2 - this.m_charHeight + 4.0, cHighlighting.getEnd() + 4.0, this.m_charHeight - 1.0, cHighlighting.getColor());
            }
        }
    }
    
    public Color getBackgroundColor() {
        return this.m_backgroundColor;
    }
    
    public List getBackgroundStyleRunData(final int index, final int n) {
        Preconditions.checkState(index >= 0 && index <= n && index < this.m_text.length(), (Object)"Illegal start value.");
        Preconditions.checkState(n >= 0 && n >= index && n < this.m_text.length(), (Object)"Illegal end value.");
        final ArrayList<CStyleRunData> list = new ArrayList<CStyleRunData>();
        final AttributedCharacterIterator iterator = this.m_atext.getIterator();
        iterator.setIndex(index);
        Color color = null;
        int n2 = index;
        for (int i = index; i <= n; ++i) {
            final Color color2 = (Color)iterator.getAttribute(TextAttribute.BACKGROUND);
            if ((color2 != null && !color2.equals(color)) || (color != null && !color.equals(color2))) {
                if (color != null) {
                    list.add(new CStyleRunData(n2, i - n2 + 1, color));
                }
                color = color2;
                n2 = i;
            }
            iterator.next();
        }
        list.add(new CStyleRunData(n2, n - n2 + 1, color));
        return list;
    }
    
    public Rectangle2D getBounds() {
        if (this.isEmpty()) {
            return new TextLayout(new AttributedString(" ").getIterator(), ZyLineContent.m_fontContext).getBounds();
        }
        return new Rectangle2D.Double(0.0, 0.0, this.m_charWidth * this.m_text.length(), this.m_charHeight);
    }
    
    public double getCharWidth() {
        return this.m_charWidth;
    }
    
    public IZyEditableObject getLineFragmentObjectAt(final int n) {
        for (final IZyEditableObject zyEditableObject : this.m_lineObjects) {
            if (n >= zyEditableObject.getStart() && n < zyEditableObject.getStart() + zyEditableObject.getLength()) {
                return zyEditableObject;
            }
        }
        for (final IZyEditableObject zyEditableObject2 : this.m_lineObjects) {
            if (n >= zyEditableObject2.getStart() && n - 1 < zyEditableObject2.getStart() + zyEditableObject2.getLength()) {
                return zyEditableObject2;
            }
        }
        return null;
    }
    
    public List getLineFragmentObjectList() {
        return this.m_lineObjects;
    }
    
    public IZyEditableObject getLineObject() {
        return this.m_model;
    }
    
    public Object getObject(final int n) {
        final ZyLineContent$ObjectWrapper objectWrapper = this.getObjectWrapper(n);
        return (objectWrapper == null) ? null : objectWrapper.getObject();
    }
    
    public ZyLineContent$ObjectWrapper getObjectWrapper(final int n) {
        for (final ZyLineContent$ObjectWrapper zyLineContent$ObjectWrapper : this.m_objects) {
            if (n >= zyLineContent$ObjectWrapper.getStart() && n < zyLineContent$ObjectWrapper.getStart() + zyLineContent$ObjectWrapper.getLength()) {
                return zyLineContent$ObjectWrapper;
            }
        }
        return null;
    }
    
    public String getText() {
        return this.m_text;
    }
    
    public String getText(final IZyEditableObject zyEditableObject) {
        Preconditions.checkNotNull(zyEditableObject, (Object)"Error: editabeObject argument can not be null");
        final int start = zyEditableObject.getStart();
        int n = zyEditableObject.getEnd();
        if (start >= this.m_text.length()) {
            return "";
        }
        if (n >= this.m_text.length()) {
            n = this.m_text.length();
        }
        return this.m_text.substring(start, n);
    }
    
    public TextLayout getTextLayout() {
        if (this.isEmpty()) {
            return new TextLayout(new AttributedString("+").getIterator(), ZyLineContent.m_fontContext);
        }
        return new TextLayout(this.m_atext.getIterator(), ZyLineContent.m_fontContext);
    }
    
    public boolean hasHighlighting(final int n) {
        if (this.isEmpty()) {
            return false;
        }
        if (this.m_highlighting.isEmpty()) {
            return false;
        }
        final Iterator<CHighlighting> iterator = new ArrayList<CHighlighting>(this.m_highlighting).iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getLevel() == n) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isEditable(final int n) {
        return this.getLineFragmentObjectAt(n) != null;
    }
    
    public boolean isEmpty() {
        return "".equals(this.m_text) || this.m_text == null;
    }
    
    public void setBackgroundColor(final Color color) {
        this.m_backgroundColor = (Color)Preconditions.checkNotNull(color, (Object)"Error: Color argument can't be null");
        if (!this.isEmpty()) {
            this.m_atext.addAttribute(TextAttribute.BACKGROUND, color);
            this.m_textLayout = new TextLayout(this.m_atext.getIterator(), ZyLineContent.m_fontContext);
        }
    }
    
    public void setBackgroundColor(final int n, final int n2, final Color color) {
        if (!this.isEmpty()) {
            final int calculateRealLength = this.calculateRealLength(n, n2);
            this.validatePartialLineArguments(n, calculateRealLength);
            this.m_atext.addAttribute(TextAttribute.BACKGROUND, color, n, n + calculateRealLength);
            this.m_textLayout = new TextLayout(this.m_atext.getIterator(), ZyLineContent.m_fontContext);
        }
    }
    
    public void setFont(final Font font) {
        Preconditions.checkNotNull(font, (Object)"Error: Font argument can't be null");
        if (!this.isEmpty()) {
            this.m_atext.addAttribute(TextAttribute.FONT, font);
            this.m_textLayout = new TextLayout(this.m_atext.getIterator(), ZyLineContent.m_fontContext);
            this.updateCharBounds(font);
        }
    }
    
    public void setFont(final int n, final int n2, final Font font) {
        Preconditions.checkNotNull(font, (Object)"Error: Font argument can't be null");
        if (!this.isEmpty()) {
            final int calculateRealLength = this.calculateRealLength(n, n2);
            this.validatePartialLineArguments(n, calculateRealLength);
            Preconditions.checkNotNull(font, (Object)"Error: Font argument can't be null");
            this.m_atext.addAttribute(TextAttribute.FONT, font, n, n + calculateRealLength);
            this.m_textLayout = new TextLayout(this.m_atext.getIterator(), ZyLineContent.m_fontContext);
            this.updateCharBounds(font);
        }
    }
    
    public synchronized boolean setHighlighting(final int n, final Color color) {
        Preconditions.checkNotNull(color, (Object)"Error: Color argument can't be null");
        if (this.isEmpty()) {
            return false;
        }
        for (final CHighlighting cHighlighting : new ArrayList<CHighlighting>(this.m_highlighting)) {
            if (cHighlighting.getLevel() == n) {
                if (cHighlighting.getColor().equals(color)) {
                    return false;
                }
                this.m_highlighting.remove(cHighlighting);
                break;
            }
        }
        this.m_highlighting.add(new CHighlighting(n, 0.0, this.m_text.length() * this.m_charWidth, color));
        Collections.sort((List<Comparable>)this.m_highlighting);
        return true;
    }
    
    public synchronized void setHighlighting(final int n, final int n2, final int n3, final Color color) {
        Preconditions.checkNotNull(color, (Object)"Error: color argument can not be null");
        if (!this.isEmpty()) {
            final int calculateRealLength = this.calculateRealLength(n, n2);
            this.validatePartialLineArguments(n, calculateRealLength);
            if (this.hasHighlighting(n3)) {
                this.clearHighlighting(n3);
            }
            this.m_highlighting.add(new CHighlighting(n3, n * this.m_charWidth, calculateRealLength * this.m_charWidth, color));
            Collections.sort((List<Comparable>)this.m_highlighting);
        }
    }
    
    public void setObject(final int n, final int n2, final Object o) {
        Preconditions.checkNotNull(o, (Object)"Error: object argument can not be null");
        this.m_objects.add(new ZyLineContent$ObjectWrapper(n, n2, o));
    }
    
    public void setTextColor(final Color color) {
        Preconditions.checkNotNull(color, (Object)"Error: Color argument can't be null");
        if (!this.isEmpty()) {
            this.m_atext.addAttribute(TextAttribute.FOREGROUND, color);
            this.m_textLayout = new TextLayout(this.m_atext.getIterator(), ZyLineContent.m_fontContext);
        }
    }
    
    public void setTextColor(final int n, final int n2, final Color color) {
        if (!this.isEmpty()) {
            final int calculateRealLength = this.calculateRealLength(n, n2);
            this.validatePartialLineArguments(n, calculateRealLength);
            this.m_atext.addAttribute(TextAttribute.FOREGROUND, color, n, n + calculateRealLength);
            this.m_textLayout = new TextLayout(this.m_atext.getIterator(), ZyLineContent.m_fontContext);
        }
    }
    
    @Override
    public String toString() {
        return this.getText();
    }
    
    static {
        m_fontContext = new FontRenderContext(null, true, true);
        DEFAULT_COMPOSITE = AlphaComposite.getInstance(3, 0.3f);
        NORMAL_COMPOSITE = AlphaComposite.getInstance(3, 1.0f);
        DEFAULT_BORDER_STROKE = new BasicStroke(1.2f);
        NORMAL_STROKE = new BasicStroke(1.0f);
    }
}
