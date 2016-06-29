package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.*;
import java.awt.font.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

public class ZyLabelContent implements Iterable
{
    private static final int FONTSIZE = 11;
    private static final int LINEHEIGHT = 15;
    private int m_leftPadding;
    private int m_rightPadding;
    private int m_topPadding;
    private int m_bottomPadding;
    private final IZyEditableObject m_model;
    private IZyLineEditor m_lineEditor;
    private final ZyCaret m_caret;
    private boolean m_selectable;
    private boolean m_editable;
    private boolean m_showCaret;
    private Color m_selectionColor;
    private final ArrayList m_content;
    private boolean m_sloppy;
    
    public ZyLabelContent(final IZyEditableObject model) {
        this.m_leftPadding = 10;
        this.m_rightPadding = 10;
        this.m_topPadding = 10;
        this.m_bottomPadding = 10;
        this.m_lineEditor = null;
        this.m_caret = new ZyCaret(this);
        this.m_selectable = true;
        this.m_editable = false;
        this.m_showCaret = false;
        this.m_selectionColor = Color.WHITE;
        this.m_content = new ArrayList();
        this.m_sloppy = false;
        this.m_model = model;
    }
    
    public ZyLabelContent(final IZyEditableObject zyEditableObject, final boolean selectable, final boolean editable) {
        this.m_leftPadding = 10;
        this.m_rightPadding = 10;
        this.m_topPadding = 10;
        this.m_bottomPadding = 10;
        this.m_lineEditor = null;
        this.m_caret = new ZyCaret(this);
        this.m_selectable = true;
        this.m_editable = false;
        this.m_showCaret = false;
        this.m_selectionColor = Color.WHITE;
        this.m_content = new ArrayList();
        this.m_sloppy = false;
        this.m_model = (IZyEditableObject)Preconditions.checkNotNull(zyEditableObject, (Object)"Error: Node model can't be null.");
        this.m_selectable = selectable;
        this.m_editable = editable;
    }
    
    private AffineTransform calcSelectionTransformationMatrix(final AffineTransform affineTransform, final double n, final double n2, final int n3) {
        final double scaleX = affineTransform.getScaleX();
        final double scaleY = affineTransform.getScaleY();
        return new AffineTransform(scaleX, 0.0, 0.0, scaleY, affineTransform.getTranslateX() + n * scaleX, affineTransform.getTranslateY() + (n2 + n3 * this.getLineHeight()) * scaleY);
    }
    
    public void addLineContent(final ZyLineContent zyLineContent) {
        Preconditions.checkNotNull(zyLineContent, (Object)"Internal Error: Line content can't be null");
        this.m_content.add(zyLineContent);
    }
    
    public void draw(final Graphics2D graphics2D, final double n, final double n2) {
        if (this.m_sloppy) {
            return;
        }
        if (!this.m_selectable || !this.m_showCaret) {
            final float n3 = (float)n + this.m_leftPadding;
            float n4 = (float)n2 + this.m_topPadding + 11.0f;
            final Iterator<ZyLineContent> iterator = (Iterator<ZyLineContent>)this.getContent().iterator();
            while (iterator.hasNext()) {
                iterator.next().draw(graphics2D, n3, n4);
                n4 += 15.0f;
            }
            return;
        }
        final AffineTransform transform = graphics2D.getTransform();
        final Color color = graphics2D.getColor();
        final float n5 = (float)n + this.getPaddingLeft();
        final float n6 = (float)n2 + this.getPaddingTop() + this.getFontSize();
        final double lineHeight = this.getLineHeight();
        graphics2D.setColor(Color.BLACK);
        for (int i = 0; i < this.getLineCount(); ++i) {
            final TextLayout textLayout = this.getLineContent(i).getTextLayout();
            if (!this.getLineContent(i).isEmpty()) {
                textLayout.draw(graphics2D, n5, (float)(n6 + i * lineHeight));
            }
            if (i == this.m_caret.getYmousePressed()) {
                graphics2D.setTransform(this.calcSelectionTransformationMatrix(transform, n5, n6, i));
                if (this.getLineContent(i).isEmpty()) {
                    this.m_caret.setCaretStartPos(0);
                }
                else if (this.m_caret.getCaretStartPos() >= textLayout.getCharacterCount()) {
                    this.m_caret.setCaretStartPos(textLayout.getCharacterCount());
                }
                final Shape[] caretShapes = textLayout.getCaretShapes(this.m_caret.getCaretStartPos());
                graphics2D.setColor(this.m_selectionColor.darker());
                graphics2D.draw(caretShapes[0]);
                graphics2D.setTransform(transform);
            }
            if (i == this.m_caret.getYmouseReleased()) {
                graphics2D.setTransform(this.calcSelectionTransformationMatrix(transform, n5, n6, i));
                if (this.getLineContent(i).isEmpty()) {
                    this.m_caret.setCaretEndPos(0);
                }
                else if (this.m_caret.getCaretEndPos() >= textLayout.getCharacterCount()) {
                    this.m_caret.setCaretEndPos(textLayout.getCharacterCount());
                }
                final Shape[] caretShapes2 = textLayout.getCaretShapes(this.m_caret.getCaretEndPos());
                graphics2D.setColor(this.m_selectionColor.darker().darker());
                graphics2D.draw(caretShapes2[0]);
                graphics2D.setTransform(transform);
            }
        }
        if (this.m_caret.getXmousePressed() != this.m_caret.getXmouseReleased()) {
            int n7 = this.m_caret.getYmousePressed();
            int n8 = this.m_caret.getYmouseReleased();
            if (n7 > n8) {
                n7 = this.m_caret.getYmouseReleased();
                n8 = this.m_caret.getYmousePressed();
            }
            int n9 = this.m_caret.getXmousePressed();
            int n10 = this.m_caret.getXmouseReleased();
            if (n9 > n10) {
                n9 = this.m_caret.getXmouseReleased();
                n10 = this.m_caret.getXmousePressed();
            }
            graphics2D.setColor(this.m_selectionColor);
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.5f));
            for (int j = n7; j <= n8; ++j) {
                graphics2D.setTransform(this.calcSelectionTransformationMatrix(transform, n5, n6, j));
                final TextLayout textLayout2 = this.getLineContent(j).getTextLayout();
                int characterCount = n10;
                if (n9 <= textLayout2.getCharacterCount()) {
                    if (this.getLineContent(j).isEmpty()) {
                        characterCount = n9;
                    }
                    else if (n10 > textLayout2.getCharacterCount()) {
                        characterCount = textLayout2.getCharacterCount();
                    }
                    graphics2D.fill(textLayout2.getLogicalHighlightShape(n9, characterCount));
                }
            }
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            graphics2D.setTransform(transform);
        }
        graphics2D.setColor(color);
        graphics2D.setTransform(transform);
    }
    
    public Rectangle2D getBounds() {
        double width = 0.0;
        double n = this.m_topPadding + this.m_bottomPadding;
        for (final ZyLineContent zyLineContent : this.getContent()) {
            if (zyLineContent.getBounds().getWidth() > width) {
                width = zyLineContent.getBounds().getWidth();
            }
            n += 15.0;
        }
        return new Rectangle2D.Double(0.0, 0.0, width + this.m_rightPadding + this.m_leftPadding, n);
    }
    
    public ZyCaret getCaret() {
        return this.m_caret;
    }
    
    public List getContent() {
        return new ArrayList(this.m_content);
    }
    
    public int getFirstLineIndexOfModelAt(int n) {
        final ZyLineContent lineContent = this.getLineContent(n);
        if (lineContent != null) {
            final IZyEditableObject lineObject = lineContent.getLineObject();
            while (--n >= 0) {
                if (this.m_content.get(n).getLineObject() != lineObject) {
                    return n + 1;
                }
            }
        }
        return n;
    }
    
    public int getFontSize() {
        return 11;
    }
    
    public int getLastLineIndexOfModelAt(int n) {
        final ZyLineContent lineContent = this.getLineContent(n);
        if (lineContent != null) {
            final IZyEditableObject lineObject = lineContent.getLineObject();
            while (++n < this.m_content.size()) {
                if (this.m_content.get(n).getLineObject() != lineObject) {
                    return n - 1;
                }
            }
            return this.m_content.size() - 1;
        }
        return n;
    }
    
    public ZyLineContent getLineContent(final int n) {
        return this.m_content.get(n);
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
    
    public int getLineIndex(final ZyLineContent zyLineContent) {
        return this.m_content.indexOf(zyLineContent);
    }
    
    public IZyEditableObject getModel() {
        return this.m_model;
    }
    
    public int getNonPureCommentLineIndexOfModelAt(final int n) {
        if (this.getLineContent(n) != null) {
            final int firstLineIndexOfModel = this.getFirstLineIndexOfModelAt(n);
            for (int lastLineIndexOfModel = this.getLastLineIndexOfModelAt(n), i = firstLineIndexOfModel; i <= lastLineIndexOfModel; ++i) {
                final ZyLineContent lineContent = this.getLineContent(i);
                final List lineFragmentObjectList = lineContent.getLineFragmentObjectList();
                if (lineContent.getLineObject() == null || !lineContent.getLineObject().isPlaceholder()) {
                    if (lineFragmentObjectList.size() == 0) {
                        return i;
                    }
                    if (lineFragmentObjectList.get(0).isCommentDelimiter() && lineFragmentObjectList.get(0).getStart() > 0) {
                        return i;
                    }
                }
            }
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
        if (!this.m_caret.isSelection()) {
            return "";
        }
        int n = this.m_caret.getYmousePressed();
        int n2 = this.m_caret.getYmouseReleased();
        if (n > n2) {
            n = this.m_caret.getYmouseReleased();
            n2 = this.m_caret.getYmousePressed();
        }
        int n3 = this.m_caret.getXmousePressed();
        int n4 = this.m_caret.getXmouseReleased();
        if (n3 > this.m_caret.getXmouseReleased()) {
            n3 = this.m_caret.getXmouseReleased();
            n4 = this.m_caret.getXmousePressed();
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = n; i <= n2; ++i) {
            final String text = this.getLineContent(i).getText();
            if (text == null || text.length() < 1 || text.length() < n3) {
                sb.append("\n");
            }
            else if (text.length() < n4) {
                sb.append(text.substring(n3));
                if (!"\n".equals(text) && i < n2) {
                    sb.append("\n");
                }
            }
            else {
                sb.append(text.substring(n3, n4));
                if (!"\n".equals(text) && i < n2) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
    
    public void insertLine(final ZyLineContent zyLineContent, final int n) {
        final ArrayList<ZyLineContent> list = new ArrayList<ZyLineContent>();
        if (n >= this.m_content.size()) {
            this.m_content.add(zyLineContent);
        }
        else {
            int n2 = 0;
            for (final ZyLineContent zyLineContent2 : this.getContent()) {
                if (n2++ == n) {
                    list.add(zyLineContent);
                }
                list.add(zyLineContent2);
            }
            this.m_content.clear();
            this.m_content.addAll(list);
        }
    }
    
    public boolean isEditable() {
        return this.m_editable;
    }
    
    public boolean isSelectable() {
        return this.m_selectable;
    }
    
    @Override
    public Iterator iterator() {
        return this.m_content.iterator();
    }
    
    public void removeLine(final int n) {
        this.m_content.remove(n);
    }
    
    public void selectAll(final IZyNodeRealizer zyNodeRealizer) {
        this.m_caret.selectAll();
        zyNodeRealizer.repaint();
    }
    
    public void setEditable(final boolean editable) {
        if (this.m_model == null || this.m_lineEditor == null) {
            return;
        }
        this.m_editable = editable;
        if (this.m_editable) {
            this.m_selectable = true;
        }
    }
    
    public void setLineEditor(final IZyLineEditor lineEditor) {
        this.m_lineEditor = lineEditor;
    }
    
    public void setPadding(final int topPadding, final int leftPadding, final int bottomPadding, final int rightPadding) {
        this.m_leftPadding = leftPadding;
        this.m_rightPadding = rightPadding;
        this.m_topPadding = topPadding;
        this.m_bottomPadding = bottomPadding;
    }
    
    public void setPaddingLeft(final int leftPadding) {
        this.m_leftPadding = leftPadding;
    }
    
    public void setRightPadding(final int rightPadding) {
        this.m_rightPadding = rightPadding;
    }
    
    public void setSelectable(final boolean selectable) {
        if (this.m_model == null) {
            return;
        }
        this.m_selectable = selectable;
    }
    
    public void setSelectionColor(final Color selectionColor) {
        this.m_selectionColor = selectionColor;
    }
    
    public void setSloppy(final boolean sloppy) {
        this.m_sloppy = sloppy;
    }
    
    public void showCaret(final boolean showCaret) {
        this.m_showCaret = showCaret;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final Iterator<ZyLineContent> iterator = this.m_content.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().toString());
            sb.append('\n');
        }
        return sb.toString();
    }
    
    public void updateContentSelectionColor(final Color color, final boolean b) {
        final Color darker = color.darker();
        if (b) {
            this.setSelectionColor(darker.darker());
        }
        else {
            this.setSelectionColor(darker);
        }
    }
}
