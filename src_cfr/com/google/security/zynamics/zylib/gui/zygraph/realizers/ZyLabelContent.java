/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyCaret;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ZyLabelContent
implements Iterable {
    private static final int FONTSIZE = 11;
    private static final int LINEHEIGHT = 15;
    private int m_leftPadding = 10;
    private int m_rightPadding = 10;
    private int m_topPadding = 10;
    private int m_bottomPadding = 10;
    private final IZyEditableObject m_model;
    private IZyLineEditor m_lineEditor = null;
    private final ZyCaret m_caret;
    private boolean m_selectable;
    private boolean m_editable;
    private boolean m_showCaret;
    private Color m_selectionColor;
    private final ArrayList m_content;
    private boolean m_sloppy;

    public ZyLabelContent(IZyEditableObject iZyEditableObject) {
        this.m_caret = new ZyCaret(this);
        this.m_selectable = true;
        this.m_editable = false;
        this.m_showCaret = false;
        this.m_selectionColor = Color.WHITE;
        this.m_content = new ArrayList();
        this.m_sloppy = false;
        this.m_model = iZyEditableObject;
    }

    public ZyLabelContent(IZyEditableObject iZyEditableObject, boolean bl2, boolean bl3) {
        this.m_caret = new ZyCaret(this);
        this.m_selectable = true;
        this.m_editable = false;
        this.m_showCaret = false;
        this.m_selectionColor = Color.WHITE;
        this.m_content = new ArrayList();
        this.m_sloppy = false;
        this.m_model = (IZyEditableObject)Preconditions.checkNotNull(iZyEditableObject, "Error: Node model can't be null.");
        this.m_selectable = bl2;
        this.m_editable = bl3;
    }

    private AffineTransform calcSelectionTransformationMatrix(AffineTransform affineTransform, double d2, double d3, int n2) {
        double d4 = affineTransform.getScaleX();
        double d5 = affineTransform.getScaleY();
        double d6 = affineTransform.getTranslateX() + d2 * d4;
        double d7 = affineTransform.getTranslateY() + (d3 + (double)n2 * this.getLineHeight()) * d5;
        return new AffineTransform(d4, 0.0, 0.0, d5, d6, d7);
    }

    public void addLineContent(ZyLineContent zyLineContent) {
        Preconditions.checkNotNull(zyLineContent, "Internal Error: Line content can't be null");
        this.m_content.add(zyLineContent);
    }

    public void draw(Graphics2D graphics2D, double d2, double d3) {
        int n2;
        if (this.m_sloppy) {
            return;
        }
        if (!this.m_selectable || !this.m_showCaret) {
            float f2 = (float)d2 + (float)this.m_leftPadding;
            float f3 = (float)d3 + (float)this.m_topPadding + 11.0f;
            Iterator iterator = this.getContent().iterator();
            while (iterator.hasNext()) {
                ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
                zyLineContent.draw(graphics2D, f2, f3);
                f3 += 15.0f;
            }
            return;
        }
        AffineTransform affineTransform = graphics2D.getTransform();
        Color color = graphics2D.getColor();
        float f4 = (float)d2 + (float)this.getPaddingLeft();
        float f5 = (float)d3 + (float)this.getPaddingTop() + (float)this.getFontSize();
        double d4 = this.getLineHeight();
        graphics2D.setColor(Color.BLACK);
        for (n2 = 0; n2 < this.getLineCount(); ++n2) {
            Shape[] arrshape;
            TextLayout textLayout = this.getLineContent(n2).getTextLayout();
            if (!this.getLineContent(n2).isEmpty()) {
                textLayout.draw(graphics2D, f4, (float)((double)f5 + (double)n2 * d4));
            }
            if (n2 == this.m_caret.getYmousePressed()) {
                graphics2D.setTransform(this.calcSelectionTransformationMatrix(affineTransform, f4, f5, n2));
                if (this.getLineContent(n2).isEmpty()) {
                    this.m_caret.setCaretStartPos(0);
                } else if (this.m_caret.getCaretStartPos() >= textLayout.getCharacterCount()) {
                    this.m_caret.setCaretStartPos(textLayout.getCharacterCount());
                }
                arrshape = textLayout.getCaretShapes(this.m_caret.getCaretStartPos());
                graphics2D.setColor(this.m_selectionColor.darker());
                graphics2D.draw(arrshape[0]);
                graphics2D.setTransform(affineTransform);
            }
            if (n2 != this.m_caret.getYmouseReleased()) continue;
            graphics2D.setTransform(this.calcSelectionTransformationMatrix(affineTransform, f4, f5, n2));
            if (this.getLineContent(n2).isEmpty()) {
                this.m_caret.setCaretEndPos(0);
            } else if (this.m_caret.getCaretEndPos() >= textLayout.getCharacterCount()) {
                this.m_caret.setCaretEndPos(textLayout.getCharacterCount());
            }
            arrshape = textLayout.getCaretShapes(this.m_caret.getCaretEndPos());
            graphics2D.setColor(this.m_selectionColor.darker().darker());
            graphics2D.draw(arrshape[0]);
            graphics2D.setTransform(affineTransform);
        }
        if (this.m_caret.getXmousePressed() != this.m_caret.getXmouseReleased()) {
            int n3;
            int n4;
            int n5;
            n2 = this.m_caret.getYmousePressed();
            if (n2 > (n4 = this.m_caret.getYmouseReleased())) {
                n2 = this.m_caret.getYmouseReleased();
                n4 = this.m_caret.getYmousePressed();
            }
            if ((n3 = this.m_caret.getXmousePressed()) > (n5 = this.m_caret.getXmouseReleased())) {
                n3 = this.m_caret.getXmouseReleased();
                n5 = this.m_caret.getXmousePressed();
            }
            graphics2D.setColor(this.m_selectionColor);
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.5f));
            for (int i2 = n2; i2 <= n4; ++i2) {
                graphics2D.setTransform(this.calcSelectionTransformationMatrix(affineTransform, f4, f5, i2));
                TextLayout textLayout = this.getLineContent(i2).getTextLayout();
                int n6 = n5;
                if (n3 > textLayout.getCharacterCount()) continue;
                if (this.getLineContent(i2).isEmpty()) {
                    n6 = n3;
                } else if (n5 > textLayout.getCharacterCount()) {
                    n6 = textLayout.getCharacterCount();
                }
                Shape shape = textLayout.getLogicalHighlightShape(n3, n6);
                graphics2D.fill(shape);
            }
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            graphics2D.setTransform(affineTransform);
        }
        graphics2D.setColor(color);
        graphics2D.setTransform(affineTransform);
    }

    public Rectangle2D getBounds() {
        double d2 = 0.0;
        double d3 = this.m_topPadding + this.m_bottomPadding;
        Iterator iterator = this.getContent().iterator();
        while (iterator.hasNext()) {
            ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
            if (zyLineContent.getBounds().getWidth() > d2) {
                d2 = zyLineContent.getBounds().getWidth();
            }
            d3 += 15.0;
        }
        return new Rectangle2D.Double(0.0, 0.0, d2 + (double)this.m_rightPadding + (double)this.m_leftPadding, d3);
    }

    public ZyCaret getCaret() {
        return this.m_caret;
    }

    public List getContent() {
        return new ArrayList(this.m_content);
    }

    public int getFirstLineIndexOfModelAt(int n2) {
        ZyLineContent zyLineContent = this.getLineContent(n2);
        if (zyLineContent == null) return n2;
        IZyEditableObject iZyEditableObject = zyLineContent.getLineObject();
        int n3 = n2;
        do {
            if (--n3 < 0) return n2;
        } while (((ZyLineContent)this.m_content.get(n3)).getLineObject() == iZyEditableObject);
        return n3 + 1;
    }

    public int getFontSize() {
        return 11;
    }

    public int getLastLineIndexOfModelAt(int n2) {
        ZyLineContent zyLineContent = this.getLineContent(n2);
        if (zyLineContent == null) return n2;
        IZyEditableObject iZyEditableObject = zyLineContent.getLineObject();
        int n3 = n2;
        do {
            if (++n3 >= this.m_content.size()) return this.m_content.size() - 1;
        } while (((ZyLineContent)this.m_content.get(n3)).getLineObject() == iZyEditableObject);
        return n3 - 1;
    }

    public ZyLineContent getLineContent(int n2) {
        return (ZyLineContent)this.m_content.get(n2);
    }

    public int getLineCount() {
        return this.m_content.size();
    }

    public IZyLineEditor getLineEditor() {
        return this.m_lineEditor;
    }

    public double getLineHeight() {
        return 15.0;
    }

    public int getLineIndex(ZyLineContent zyLineContent) {
        return this.m_content.indexOf(zyLineContent);
    }

    public IZyEditableObject getModel() {
        return this.m_model;
    }

    public int getNonPureCommentLineIndexOfModelAt(int n2) {
        ZyLineContent zyLineContent = this.getLineContent(n2);
        if (zyLineContent == null) return -1;
        int n3 = this.getFirstLineIndexOfModelAt(n2);
        int n4 = this.getLastLineIndexOfModelAt(n2);
        int n5 = n3;
        while (n5 <= n4) {
            ZyLineContent zyLineContent2 = this.getLineContent(n5);
            List list = zyLineContent2.getLineFragmentObjectList();
            if (zyLineContent2.getLineObject() == null || !zyLineContent2.getLineObject().isPlaceholder()) {
                if (list.size() == 0) {
                    return n5;
                }
                if (((IZyEditableObject)list.get(0)).isCommentDelimiter() && ((IZyEditableObject)list.get(0)).getStart() > 0) {
                    return n5;
                }
            }
            ++n5;
        }
        return -1;
    }

    public int getPaddingLeft() {
        return this.m_leftPadding;
    }

    public int getPaddingTop() {
        return this.m_topPadding;
    }

    public int getRightPadding() {
        return this.m_rightPadding;
    }

    public String getSelectedText() {
        int n2;
        if (!this.m_caret.isSelection()) {
            return "";
        }
        int n3 = this.m_caret.getYmousePressed();
        if (n3 > (n2 = this.m_caret.getYmouseReleased())) {
            n3 = this.m_caret.getYmouseReleased();
            n2 = this.m_caret.getYmousePressed();
        }
        int n4 = this.m_caret.getXmousePressed();
        int n5 = this.m_caret.getXmouseReleased();
        if (n4 > this.m_caret.getXmouseReleased()) {
            n4 = this.m_caret.getXmouseReleased();
            n5 = this.m_caret.getXmousePressed();
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n6 = n3;
        while (n6 <= n2) {
            String string = this.getLineContent(n6).getText();
            if (string == null || string.length() < 1 || string.length() < n4) {
                stringBuilder.append("\n");
            } else if (string.length() < n5) {
                stringBuilder.append(string.substring(n4));
                if (!"\n".equals(string) && n6 < n2) {
                    stringBuilder.append("\n");
                }
            } else {
                stringBuilder.append(string.substring(n4, n5));
                if (!"\n".equals(string) && n6 < n2) {
                    stringBuilder.append("\n");
                }
            }
            ++n6;
        }
        return stringBuilder.toString();
    }

    public void insertLine(ZyLineContent zyLineContent, int n2) {
        ArrayList<ZyLineContent> arrayList = new ArrayList<ZyLineContent>();
        if (n2 >= this.m_content.size()) {
            this.m_content.add(zyLineContent);
            return;
        }
        int n3 = 0;
        Iterator iterator = this.getContent().iterator();
        do {
            if (!iterator.hasNext()) {
                this.m_content.clear();
                this.m_content.addAll(arrayList);
                return;
            }
            ZyLineContent zyLineContent2 = (ZyLineContent)iterator.next();
            if (n3++ == n2) {
                arrayList.add(zyLineContent);
            }
            arrayList.add(zyLineContent2);
        } while (true);
    }

    public boolean isEditable() {
        return this.m_editable;
    }

    public boolean isSelectable() {
        return this.m_selectable;
    }

    public Iterator iterator() {
        return this.m_content.iterator();
    }

    public void removeLine(int n2) {
        this.m_content.remove(n2);
    }

    public void selectAll(IZyNodeRealizer iZyNodeRealizer) {
        this.m_caret.selectAll();
        iZyNodeRealizer.repaint();
    }

    public void setEditable(boolean bl2) {
        if (this.m_model == null) return;
        if (this.m_lineEditor == null) {
            return;
        }
        this.m_editable = bl2;
        if (!this.m_editable) return;
        this.m_selectable = true;
    }

    public void setLineEditor(IZyLineEditor iZyLineEditor) {
        this.m_lineEditor = iZyLineEditor;
    }

    public void setPadding(int n2, int n3, int n4, int n5) {
        this.m_leftPadding = n3;
        this.m_rightPadding = n5;
        this.m_topPadding = n2;
        this.m_bottomPadding = n4;
    }

    public void setPaddingLeft(int n2) {
        this.m_leftPadding = n2;
    }

    public void setRightPadding(int n2) {
        this.m_rightPadding = n2;
    }

    public void setSelectable(boolean bl2) {
        if (this.m_model == null) {
            return;
        }
        this.m_selectable = bl2;
    }

    public void setSelectionColor(Color color) {
        this.m_selectionColor = color;
    }

    public void setSloppy(boolean bl2) {
        this.m_sloppy = bl2;
    }

    public void showCaret(boolean bl2) {
        this.m_showCaret = bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.m_content.iterator();
        while (iterator.hasNext()) {
            ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
            stringBuilder.append(zyLineContent.toString());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public void updateContentSelectionColor(Color color, boolean bl2) {
        Color color2 = color.darker();
        if (bl2) {
            this.setSelectionColor(color2.darker());
            return;
        }
        this.setSelectionColor(color2);
    }
}

