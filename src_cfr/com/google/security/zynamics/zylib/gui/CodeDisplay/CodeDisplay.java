/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay$1;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay$InternalListener;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayCoordinate;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayEventListener;
import com.google.security.zynamics.zylib.gui.CodeDisplay.FormattedCharacterBuffer;
import com.google.security.zynamics.zylib.gui.CodeDisplay.ICodeDisplayModel;
import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JComponent;
import javax.swing.JScrollBar;

public class CodeDisplay
extends JComponent {
    private FontMetrics fontMetrics;
    private Font textFont;
    private final JScrollBar verticalScrollbar = new JScrollBar(1, 0, 1, 0, 1);
    private final JScrollBar horizontalScrollbar = new JScrollBar(0, 0, 1, 0, 1);
    private final CodeDisplay$InternalListener listener;
    private final ICodeDisplayModel codeModel;
    private BufferedImage bufferedImage;
    private Graphics2D bufferedGraphics;
    private int fontCharWidth;
    private int fontLineHeight;
    private final JCaret caret;
    private CodeDisplayCoordinate caretPosition;
    private int caretX;
    private int caretY;
    private int currentlyVisibleLines;
    private int currentlyVisibleColumns;
    private int currentFirstRow;
    private int currentFirstLine;
    private int currentFirstCharColumn;
    private FormattedCharacterBuffer charBuffer;
    private List eventListeners;
    private TreeMap yCoordinateToRowAndLine;

    public static String padRight(String string, int n2) {
        if (n2 != 0) return String.format(new StringBuilder(16).append("%1$-").append(n2).append("s").toString(), string);
        return "";
    }

    public CodeDisplay(ICodeDisplayModel iCodeDisplayModel) {
        this.listener = new CodeDisplay$InternalListener(this, null);
        this.fontCharWidth = 0;
        this.fontLineHeight = 0;
        this.caret = new JCaret();
        this.caretPosition = new CodeDisplayCoordinate(0, 0, 0, 0);
        this.caretX = 0;
        this.caretY = 0;
        this.currentlyVisibleLines = 0;
        this.currentlyVisibleColumns = 0;
        this.currentFirstRow = 0;
        this.currentFirstLine = 0;
        this.currentFirstCharColumn = 0;
        this.charBuffer = new FormattedCharacterBuffer(0, 0);
        this.eventListeners = new ArrayList();
        this.yCoordinateToRowAndLine = new TreeMap();
        this.codeModel = iCodeDisplayModel;
        this.textFont = new Font("Monospaced", 0, 12);
        this.setFocusable(true);
        this.setLayout(new BorderLayout());
        this.initializeListeners();
        this.initializeScrollbars();
        this.initializeFontMetrics(this.textFont);
        this.currentlyVisibleLines = this.getNumberOfVisibleLines();
        this.currentlyVisibleColumns = this.getNumberOfVisibleColumns();
        this.initializeGraphicsBuffer();
        this.setScrollBarMaximum();
        this.setEnabled(true);
        int n2 = 0;
        CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(0, 0, 0, 0);
        int n3 = 0;
        while (n3 < this.codeModel.getNumberOfColumns()) {
            n2 += this.codeModel.getColumnWidthInCharacters(n3);
            codeDisplayCoordinate.setColumn(n3);
            if (this.codeModel.canHaveCaret(codeDisplayCoordinate)) {
                this.setCaretPosition(codeDisplayCoordinate);
                this.caretX = n2;
                this.caretY = 1;
            }
            ++n3;
        }
    }

    private void initializeGraphicsBuffer() {
        this.bufferedImage = new BufferedImage((this.codeModel.getTotalWidthInCharacters() + 1) * this.fontCharWidth, (this.currentlyVisibleLines + 10) * this.fontLineHeight, 1);
        this.bufferedGraphics = (Graphics2D)this.bufferedImage.getGraphics();
    }

    private void notifyCaretListeners() {
        Iterator iterator = this.eventListeners.iterator();
        while (iterator.hasNext()) {
            CodeDisplayEventListener codeDisplayEventListener = (CodeDisplayEventListener)iterator.next();
            codeDisplayEventListener.caretChanged(this.caretPosition);
        }
    }

    private void initializeFontMetrics(Font font) {
        BufferedImage bufferedImage = new BufferedImage(10, 10, 1);
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setFont(font);
        this.fontMetrics = graphics2D.getFontMetrics();
        this.fontCharWidth = this.fontMetrics.getMaxAdvance();
        this.fontLineHeight = this.fontMetrics.getHeight();
    }

    private void initializeListeners() {
        this.addMouseListener(this.listener);
        this.addMouseMotionListener(this.listener);
        this.addMouseWheelListener(this.listener);
        this.addFocusListener(this.listener);
        this.addComponentListener(this.listener);
        this.addKeyListener(this.listener);
        this.caret.addCaretListener(this.listener);
    }

    private void initializeScrollbars() {
        this.verticalScrollbar.addAdjustmentListener(this.listener);
        this.add((Component)this.verticalScrollbar, "East");
        this.horizontalScrollbar.addAdjustmentListener(this.listener);
        this.add((Component)this.horizontalScrollbar, "South");
    }

    private int getNumberOfVisibleColumns() {
        int n2;
        int n3 = this.getWidth() - this.verticalScrollbar.getWidth();
        if (n3 % this.fontCharWidth == 0) {
            n2 = 0;
            return n3 / this.fontCharWidth + n2;
        }
        n2 = 1;
        return n3 / this.fontCharWidth + n2;
    }

    private int getNumberOfVisibleLines() {
        int n2;
        int n3 = this.getHeight() - this.horizontalScrollbar.getHeight();
        if (n3 % this.fontLineHeight == 0) {
            n2 = 0;
            return n3 / this.fontLineHeight + n2;
        }
        n2 = 1;
        return n3 / this.fontLineHeight + n2;
    }

    private void setScrollBarMaximum() {
        int n2 = this.codeModel.getNumberOfRows();
        int n3 = n2;
        if (n3 < 0) {
            n3 = 0;
            this.verticalScrollbar.setValue(0);
            this.verticalScrollbar.setEnabled(false);
        } else {
            this.verticalScrollbar.setEnabled(true);
        }
        this.verticalScrollbar.setMaximum(n3);
        int n4 = this.codeModel.getTotalWidthInCharacters();
        int n5 = this.getWidth();
        if ((n5 -= this.verticalScrollbar.getWidth()) >= n4 * this.fontCharWidth) {
            this.horizontalScrollbar.setValue(0);
            this.horizontalScrollbar.setEnabled(false);
            return;
        }
        this.horizontalScrollbar.setMaximum(n4 + 1);
        this.horizontalScrollbar.setEnabled(true);
    }

    private void updateCharacterBufferFromModel() {
        int n2;
        int n3;
        this.charBuffer.clear();
        this.charBuffer.setBackgroundColor(Color.LIGHT_GRAY.brighter());
        this.currentFirstRow = this.verticalScrollbar.getValue();
        this.currentFirstCharColumn = this.horizontalScrollbar.getValue();
        int n4 = 0;
        if (this.codeModel.hasHeaderRow()) {
            n4 = 1;
            n2 = 0;
            for (n3 = 0; n3 < this.codeModel.getNumberOfColumns(); n2 += this.codeModel.getColumnWidthInCharacters((int)n3), ++n3) {
                this.charBuffer.copyInto(0, n2, this.codeModel.getHeader(n3));
            }
        }
        n2 = this.currentFirstRow;
        block1 : do {
            if (n2 >= Math.min(this.currentFirstRow + this.currentlyVisibleLines, this.codeModel.getNumberOfRows())) {
                this.setScrollBarMaximum();
                return;
            }
            int n5 = n3 = n2 == this.currentFirstRow ? this.currentFirstLine : 0;
            do {
                int n6;
                if (n3 < this.codeModel.getMaximumLinesForRow(n2)) {
                    n6 = 0;
                } else {
                    ++n2;
                    continue block1;
                }
                for (int i2 = 0; i2 < this.codeModel.getNumberOfColumns(); n6 += this.codeModel.getColumnWidthInCharacters((int)i2), ++i2) {
                    int n7;
                    FormattedCharacterBuffer formattedCharacterBuffer;
                    if (this.caretPosition.getRow() == n2 && this.caretPosition.getLine() == n3 && this.caretPosition.getColumn() == i2) {
                        this.caretX = n6 + this.caretPosition.getFieldIndex();
                        this.caretY = n4;
                    }
                    if ((formattedCharacterBuffer = this.codeModel.getLineFormatted(n2, i2, n3)) != null) {
                        this.charBuffer.copyInto(n4, n6, formattedCharacterBuffer);
                    }
                    if (!this.yCoordinateToRowAndLine.containsKey(n7 = n4 * this.fontLineHeight + this.fontLineHeight / 2)) {
                        this.yCoordinateToRowAndLine.put(n7, new CodeDisplayCoordinate(n2, n3, 0, 0));
                        continue;
                    }
                    CodeDisplayCoordinate codeDisplayCoordinate = (CodeDisplayCoordinate)this.yCoordinateToRowAndLine.get(n7);
                    codeDisplayCoordinate.setRow(n2);
                    codeDisplayCoordinate.setLine(n3);
                }
                ++n4;
                ++n3;
            } while (true);
            break;
        } while (true);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.bufferedGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.updateVisibleLinesAndColumns();
        this.updateCharacterBufferFromModel();
        this.currentFirstRow = this.verticalScrollbar.getValue();
        this.currentFirstCharColumn = this.horizontalScrollbar.getValue();
        this.charBuffer.paintBuffer(this.bufferedGraphics, 0, 0, this.currentFirstCharColumn);
        graphics.drawImage(this.bufferedImage, 2, 2, this);
        this.caret.draw(graphics, 2 + this.caretX * this.fontCharWidth, 6 + this.caretY * this.fontLineHeight, this.fontLineHeight - 1);
    }

    void updateVisibleLinesAndColumns() {
        int n2 = this.getNumberOfVisibleLines();
        int n3 = this.getNumberOfVisibleColumns();
        if (this.currentlyVisibleLines == n2) {
            if (this.currentlyVisibleColumns == n3) return;
        }
        this.currentlyVisibleLines = n2;
        this.currentlyVisibleColumns = n3;
        int n4 = this.codeModel.getTotalWidthInCharacters();
        int n5 = this.currentlyVisibleLines + 1;
        this.charBuffer = new FormattedCharacterBuffer(n5, n4);
        this.bufferedImage = new BufferedImage(n4 * this.fontCharWidth, n5 * this.fontLineHeight, 1);
        this.bufferedGraphics = (Graphics2D)this.bufferedImage.getGraphics();
    }

    void setSelectionStart() {
    }

    private boolean fillColumnAndFieldIndexFromX(int n2, CodeDisplayCoordinate codeDisplayCoordinate) {
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (n5 < this.codeModel.getNumberOfColumns()) {
            int n6 = n3 + this.codeModel.getColumnWidthInCharacters(n5) * this.fontCharWidth;
            if (n2 >= n3 && (n2 += this.currentFirstCharColumn * this.fontCharWidth) < n6) {
                n4 = (n2 -= n3) / this.fontCharWidth;
                codeDisplayCoordinate.setColumn(n5);
                codeDisplayCoordinate.setFieldIndex(n4);
                return true;
            }
            n3 = n6;
            ++n5;
        }
        return false;
    }

    private boolean fillCoordinateFromXY(int n2, int n3, CodeDisplayCoordinate codeDisplayCoordinate) {
        Map.Entry entry = this.yCoordinateToRowAndLine.floorEntry(n3);
        if (entry == null) {
            codeDisplayCoordinate.setRow(2);
            codeDisplayCoordinate.setColumn(1);
            return true;
        }
        codeDisplayCoordinate.setRow(((CodeDisplayCoordinate)entry.getValue()).getRow());
        codeDisplayCoordinate.setLine(((CodeDisplayCoordinate)entry.getValue()).getLine());
        return this.fillColumnAndFieldIndexFromX(n2, codeDisplayCoordinate);
    }

    public CodeDisplayCoordinate getCaretPosition() {
        return this.caretPosition;
    }

    public void setCaretPosition(CodeDisplayCoordinate codeDisplayCoordinate) {
        this.caretPosition = codeDisplayCoordinate;
    }

    public int rowAtPoint(Point point) {
        CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(0, 0, 0, 0);
        this.fillCoordinateFromXY(point.x, point.y, codeDisplayCoordinate);
        return codeDisplayCoordinate.getRow();
    }

    public int columnAtPoint(Point point) {
        CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(0, 0, 0, 0);
        this.fillCoordinateFromXY(point.x, point.y, codeDisplayCoordinate);
        return codeDisplayCoordinate.getColumn();
    }

    public int lineAtPoint(Point point) {
        CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(0, 0, 0, 0);
        this.fillCoordinateFromXY(point.x, point.y, codeDisplayCoordinate);
        return codeDisplayCoordinate.getLine();
    }

    public void addCaretChangedListener(CodeDisplayEventListener codeDisplayEventListener) {
        this.eventListeners.add(codeDisplayEventListener);
    }

    public void removeCaretChangedListener(CodeDisplayEventListener codeDisplayEventListener) {
        this.eventListeners.remove(codeDisplayEventListener);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.fontCharWidth * this.codeModel.getTotalWidthInCharacters(), this.fontLineHeight * 40);
    }

    static /* synthetic */ void access$100(CodeDisplay codeDisplay) {
        codeDisplay.updateCharacterBufferFromModel();
    }

    static /* synthetic */ void access$200(CodeDisplay codeDisplay) {
        codeDisplay.setScrollBarMaximum();
    }

    static /* synthetic */ CodeDisplayCoordinate access$300(CodeDisplay codeDisplay) {
        return codeDisplay.caretPosition;
    }

    static /* synthetic */ ICodeDisplayModel access$400(CodeDisplay codeDisplay) {
        return codeDisplay.codeModel;
    }

    static /* synthetic */ int access$500(CodeDisplay codeDisplay) {
        return codeDisplay.currentlyVisibleLines;
    }

    static /* synthetic */ JScrollBar access$600(CodeDisplay codeDisplay) {
        return codeDisplay.verticalScrollbar;
    }

    static /* synthetic */ void access$700(CodeDisplay codeDisplay) {
        codeDisplay.notifyCaretListeners();
    }

    static /* synthetic */ boolean access$800(CodeDisplay codeDisplay, int n2, int n3, CodeDisplayCoordinate codeDisplayCoordinate) {
        return codeDisplay.fillCoordinateFromXY(n2, n3, codeDisplayCoordinate);
    }
}

