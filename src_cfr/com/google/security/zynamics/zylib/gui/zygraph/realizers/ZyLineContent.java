/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CHighlighting;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CStyleRunData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent$ObjectWrapper;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ZyLineContent {
    private static final FontRenderContext m_fontContext = new FontRenderContext(null, true, true);
    private static final Composite DEFAULT_COMPOSITE = AlphaComposite.getInstance(3, 0.3f);
    private static final Composite NORMAL_COMPOSITE = AlphaComposite.getInstance(3, 1.0f);
    private static final Stroke DEFAULT_BORDER_STROKE = new BasicStroke(1.2f);
    private static final Stroke NORMAL_STROKE = new BasicStroke(1.0f);
    private String m_text;
    private AttributedString m_atext;
    private double m_charWidth;
    private double m_charHeight;
    private TextLayout m_textLayout;
    private final ArrayList m_highlighting = new ArrayList();
    private final List m_lineObjects = new ArrayList();
    private final IZyEditableObject m_model;
    private Color m_backgroundColor = null;
    private final List m_objects = new ArrayList();

    public ZyLineContent(String string, Font font, IZyEditableObject iZyEditableObject) {
        this(string, font, new ArrayList(), iZyEditableObject);
    }

    public ZyLineContent(String string, Font font, List list, IZyEditableObject iZyEditableObject) {
        Preconditions.checkNotNull(string, "Error: Text argument can't be null");
        Preconditions.checkNotNull(list, "Error: Text color style run can't be null.");
        this.m_model = iZyEditableObject;
        this.regenerateLine(string, font, list);
    }

    public ZyLineContent(String string, IZyEditableObject iZyEditableObject) {
        this(string, null, iZyEditableObject);
    }

    private int calculateRealLength(int n2, int n3) {
        int n4;
        if (n3 != -1) {
            n4 = n3;
            return n4;
        }
        n4 = this.m_text.length() - n2;
        return n4;
    }

    private void drawHighlighting(Graphics2D graphics2D, double d2, double d3, double d4, double d5, Color color) {
        graphics2D.setColor(color);
        int n2 = (int)Math.round(d2);
        int n3 = (int)Math.round(d3);
        int n4 = (int)Math.round(d5);
        int n5 = (int)Math.round(d4);
        graphics2D.setComposite(DEFAULT_COMPOSITE);
        graphics2D.fillRoundRect(n2, n3, n5, n4, 10, 10);
        graphics2D.setColor(color.darker());
        graphics2D.setStroke(DEFAULT_BORDER_STROKE);
        graphics2D.drawRoundRect(n2, n3, n5, n4, 10, 10);
        graphics2D.setComposite(NORMAL_COMPOSITE);
        graphics2D.setStroke(NORMAL_STROKE);
    }

    private void regenerateLine(String string, Font font, List list) {
        this.m_text = (String)Preconditions.checkNotNull(string, "Error: text argument can not be null");
        Preconditions.checkNotNull(list, "Error: textColorStyleRun argument can not be null");
        this.m_atext = new AttributedString(string);
        if (!this.isEmpty()) {
            if (font != null) {
                this.m_atext.addAttribute(TextAttribute.FONT, font);
            }
            for (CStyleRunData cStyleRunData : list) {
                int n2 = cStyleRunData.getStart();
                int n3 = this.calculateRealLength(n2, cStyleRunData.getLength());
                this.validatePartialLineArguments(n2, n3);
                this.m_atext.addAttribute(TextAttribute.FOREGROUND, cStyleRunData.getColor(), n2, n2 + n3);
                if (cStyleRunData.getLineObject() != null) {
                    this.m_lineObjects.add(cStyleRunData.getLineObject());
                }
                if (cStyleRunData.getObject() == null) continue;
                this.setObject(n2, n3, cStyleRunData.getObject());
            }
            this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
        }
        if (font == null) return;
        this.updateCharBounds(font);
    }

    private void updateCharBounds(Font font) {
        this.m_charWidth = font.getStringBounds(this.m_text, m_fontContext).getWidth() / (double)this.getTextLayout().getCharacterCount();
        this.m_charHeight = font.getLineMetrics(this.m_text, m_fontContext).getHeight();
    }

    private void validatePartialLineArguments(int n2, int n3) {
        Preconditions.checkArgument(n2 >= 0 && n2 < this.m_text.length(), "Error: Position argument is out of bounds (Position: %d, Length: %d/%d)", n2, n3, this.m_text.length());
        Preconditions.checkArgument(n3 > 0 || n2 + n3 <= this.m_text.length(), "Error: Length argument is out of bounds (Position: %d, Length: %d)", n2, n3);
    }

    public synchronized boolean clearHighlighting(int n2) {
        CHighlighting cHighlighting;
        if (this.m_highlighting.isEmpty()) {
            return false;
        }
        Iterator iterator = new ArrayList(this.m_highlighting).iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while ((cHighlighting = (CHighlighting)iterator.next()).getLevel() != n2);
        this.m_highlighting.remove(cHighlighting);
        return true;
    }

    public synchronized void draw(Graphics2D graphics2D, float f2, float f3) {
        if (this.isEmpty()) return;
        this.m_textLayout.draw(graphics2D, f2, f3);
        Iterator iterator = new ArrayList(this.m_highlighting).iterator();
        while (iterator.hasNext()) {
            CHighlighting cHighlighting = (CHighlighting)iterator.next();
            double d2 = (double)f2 + cHighlighting.getStart() - 2.0;
            double d3 = (double)f3 - this.m_charHeight + 4.0;
            double d4 = cHighlighting.getEnd() + 4.0;
            double d5 = this.m_charHeight - 1.0;
            this.drawHighlighting(graphics2D, d2, d3, d4, d5, cHighlighting.getColor());
        }
    }

    public Color getBackgroundColor() {
        return this.m_backgroundColor;
    }

    public List getBackgroundStyleRunData(int n2, int n3) {
        Preconditions.checkState(n2 >= 0 && n2 <= n3 && n2 < this.m_text.length(), "Illegal start value.");
        Preconditions.checkState(n3 >= 0 && n3 >= n2 && n3 < this.m_text.length(), "Illegal end value.");
        ArrayList<CStyleRunData> arrayList = new ArrayList<CStyleRunData>();
        AttributedCharacterIterator attributedCharacterIterator = this.m_atext.getIterator();
        attributedCharacterIterator.setIndex(n2);
        Color color = null;
        int n4 = n2;
        int n5 = n2;
        do {
            if (n5 > n3) {
                CStyleRunData cStyleRunData = new CStyleRunData(n4, n3 - n4 + 1, color);
                arrayList.add(cStyleRunData);
                return arrayList;
            }
            Color color2 = (Color)attributedCharacterIterator.getAttribute(TextAttribute.BACKGROUND);
            if (color2 != null && !color2.equals(color) || color != null && !color.equals(color2)) {
                if (color != null) {
                    CStyleRunData cStyleRunData = new CStyleRunData(n4, n5 - n4 + 1, color);
                    arrayList.add(cStyleRunData);
                }
                color = color2;
                n4 = n5;
            }
            attributedCharacterIterator.next();
            ++n5;
        } while (true);
    }

    public Rectangle2D getBounds() {
        if (!this.isEmpty()) return new Rectangle2D.Double(0.0, 0.0, this.m_charWidth * (double)this.m_text.length(), this.m_charHeight);
        AttributedString attributedString = new AttributedString(" ");
        TextLayout textLayout = new TextLayout(attributedString.getIterator(), m_fontContext);
        return textLayout.getBounds();
    }

    public double getCharWidth() {
        return this.m_charWidth;
    }

    public IZyEditableObject getLineFragmentObjectAt(int n2) {
        IZyEditableObject iZyEditableObject2;
        for (IZyEditableObject iZyEditableObject2 : this.m_lineObjects) {
            if (n2 < iZyEditableObject2.getStart() || n2 >= iZyEditableObject2.getStart() + iZyEditableObject2.getLength()) continue;
            return iZyEditableObject2;
        }
        Iterator iterator = this.m_lineObjects.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (n2 < (iZyEditableObject2 = (IZyEditableObject)iterator.next()).getStart() || n2 - 1 >= iZyEditableObject2.getStart() + iZyEditableObject2.getLength());
        return iZyEditableObject2;
    }

    public List getLineFragmentObjectList() {
        return this.m_lineObjects;
    }

    public IZyEditableObject getLineObject() {
        return this.m_model;
    }

    public Object getObject(int n2) {
        ZyLineContent$ObjectWrapper zyLineContent$ObjectWrapper = this.getObjectWrapper(n2);
        if (zyLineContent$ObjectWrapper == null) {
            return null;
        }
        Object object = zyLineContent$ObjectWrapper.getObject();
        return object;
    }

    public ZyLineContent$ObjectWrapper getObjectWrapper(int n2) {
        ZyLineContent$ObjectWrapper zyLineContent$ObjectWrapper;
        Iterator iterator = this.m_objects.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (n2 < (zyLineContent$ObjectWrapper = (ZyLineContent$ObjectWrapper)iterator.next()).getStart() || n2 >= zyLineContent$ObjectWrapper.getStart() + zyLineContent$ObjectWrapper.getLength());
        return zyLineContent$ObjectWrapper;
    }

    public String getText() {
        return this.m_text;
    }

    public String getText(IZyEditableObject iZyEditableObject) {
        Preconditions.checkNotNull(iZyEditableObject, "Error: editabeObject argument can not be null");
        int n2 = iZyEditableObject.getStart();
        int n3 = iZyEditableObject.getEnd();
        if (n2 >= this.m_text.length()) {
            return "";
        }
        if (n3 < this.m_text.length()) return this.m_text.substring(n2, n3);
        n3 = this.m_text.length();
        return this.m_text.substring(n2, n3);
    }

    public TextLayout getTextLayout() {
        if (!this.isEmpty()) return new TextLayout(this.m_atext.getIterator(), m_fontContext);
        AttributedString attributedString = new AttributedString("+");
        return new TextLayout(attributedString.getIterator(), m_fontContext);
    }

    public boolean hasHighlighting(int n2) {
        CHighlighting cHighlighting;
        if (this.isEmpty()) {
            return false;
        }
        if (this.m_highlighting.isEmpty()) {
            return false;
        }
        Iterator iterator = new ArrayList(this.m_highlighting).iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while ((cHighlighting = (CHighlighting)iterator.next()).getLevel() != n2);
        return true;
    }

    public boolean isEditable(int n2) {
        if (this.getLineFragmentObjectAt(n2) == null) return false;
        return true;
    }

    public boolean isEmpty() {
        if ("".equals(this.m_text)) return true;
        if (this.m_text == null) return true;
        return false;
    }

    public void setBackgroundColor(Color color) {
        this.m_backgroundColor = (Color)Preconditions.checkNotNull(color, "Error: Color argument can't be null");
        if (this.isEmpty()) return;
        this.m_atext.addAttribute(TextAttribute.BACKGROUND, color);
        this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
    }

    public void setBackgroundColor(int n2, int n3, Color color) {
        if (this.isEmpty()) return;
        int n4 = this.calculateRealLength(n2, n3);
        this.validatePartialLineArguments(n2, n4);
        this.m_atext.addAttribute(TextAttribute.BACKGROUND, color, n2, n2 + n4);
        this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
    }

    public void setFont(Font font) {
        Preconditions.checkNotNull(font, "Error: Font argument can't be null");
        if (this.isEmpty()) return;
        this.m_atext.addAttribute(TextAttribute.FONT, font);
        this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
        this.updateCharBounds(font);
    }

    public void setFont(int n2, int n3, Font font) {
        Preconditions.checkNotNull(font, "Error: Font argument can't be null");
        if (this.isEmpty()) return;
        int n4 = this.calculateRealLength(n2, n3);
        this.validatePartialLineArguments(n2, n4);
        Preconditions.checkNotNull(font, "Error: Font argument can't be null");
        this.m_atext.addAttribute(TextAttribute.FONT, font, n2, n2 + n4);
        this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
        this.updateCharBounds(font);
    }

    public synchronized boolean setHighlighting(int n2, Color color) {
        Preconditions.checkNotNull(color, "Error: Color argument can't be null");
        if (this.isEmpty()) {
            return false;
        }
        for (CHighlighting cHighlighting : new ArrayList(this.m_highlighting)) {
            if (cHighlighting.getLevel() != n2) continue;
            if (cHighlighting.getColor().equals(color)) {
                return false;
            }
            this.m_highlighting.remove(cHighlighting);
            break;
        }
        this.m_highlighting.add(new CHighlighting(n2, 0.0, (double)this.m_text.length() * this.m_charWidth, color));
        Collections.sort(this.m_highlighting);
        return true;
    }

    public synchronized void setHighlighting(int n2, int n3, int n4, Color color) {
        Preconditions.checkNotNull(color, "Error: color argument can not be null");
        if (this.isEmpty()) return;
        int n5 = this.calculateRealLength(n2, n3);
        this.validatePartialLineArguments(n2, n5);
        if (this.hasHighlighting(n4)) {
            this.clearHighlighting(n4);
        }
        this.m_highlighting.add(new CHighlighting(n4, (double)n2 * this.m_charWidth, (double)n5 * this.m_charWidth, color));
        Collections.sort(this.m_highlighting);
    }

    public void setObject(int n2, int n3, Object object) {
        Preconditions.checkNotNull(object, "Error: object argument can not be null");
        this.m_objects.add(new ZyLineContent$ObjectWrapper(n2, n3, object));
    }

    public void setTextColor(Color color) {
        Preconditions.checkNotNull(color, "Error: Color argument can't be null");
        if (this.isEmpty()) return;
        this.m_atext.addAttribute(TextAttribute.FOREGROUND, color);
        this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
    }

    public void setTextColor(int n2, int n3, Color color) {
        if (this.isEmpty()) return;
        int n4 = this.calculateRealLength(n2, n3);
        this.validatePartialLineArguments(n2, n4);
        this.m_atext.addAttribute(TextAttribute.FOREGROUND, color, n2, n2 + n4);
        this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
    }

    public String toString() {
        return this.getText();
    }
}

