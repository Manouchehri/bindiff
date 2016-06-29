package com.google.security.zynamics.zylib.gui.CodeDisplay;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.JCaret.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import java.awt.*;

public class CodeDisplay extends JComponent
{
    private FontMetrics fontMetrics;
    private Font textFont;
    private final JScrollBar verticalScrollbar;
    private final JScrollBar horizontalScrollbar;
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
    
    public static String padRight(final String s, final int n) {
        if (n == 0) {
            return "";
        }
        return String.format(new StringBuilder(16).append("%1$-").append(n).append("s").toString(), s);
    }
    
    public CodeDisplay(final ICodeDisplayModel codeModel) {
        this.verticalScrollbar = new JScrollBar(1, 0, 1, 0, 1);
        this.horizontalScrollbar = new JScrollBar(0, 0, 1, 0, 1);
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
        this.codeModel = codeModel;
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
        int caretX = 0;
        final CodeDisplayCoordinate caretPosition = new CodeDisplayCoordinate(0, 0, 0, 0);
        for (int i = 0; i < this.codeModel.getNumberOfColumns(); ++i) {
            caretX += this.codeModel.getColumnWidthInCharacters(i);
            caretPosition.setColumn(i);
            if (this.codeModel.canHaveCaret(caretPosition)) {
                this.setCaretPosition(caretPosition);
                this.caretX = caretX;
                this.caretY = 1;
            }
        }
    }
    
    private void initializeGraphicsBuffer() {
        this.bufferedImage = new BufferedImage((this.codeModel.getTotalWidthInCharacters() + 1) * this.fontCharWidth, (this.currentlyVisibleLines + 10) * this.fontLineHeight, 1);
        this.bufferedGraphics = (Graphics2D)this.bufferedImage.getGraphics();
    }
    
    private void notifyCaretListeners() {
        final Iterator<CodeDisplayEventListener> iterator = this.eventListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().caretChanged(this.caretPosition);
        }
    }
    
    private void initializeFontMetrics(final Font font) {
        final Graphics2D graphics2D = (Graphics2D)new BufferedImage(10, 10, 1).getGraphics();
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
        this.add(this.verticalScrollbar, "East");
        this.horizontalScrollbar.addAdjustmentListener(this.listener);
        this.add(this.horizontalScrollbar, "South");
    }
    
    private int getNumberOfVisibleColumns() {
        final int n = this.getWidth() - this.verticalScrollbar.getWidth();
        return n / this.fontCharWidth + ((n % this.fontCharWidth != 0) ? 1 : 0);
    }
    
    private int getNumberOfVisibleLines() {
        final int n = this.getHeight() - this.horizontalScrollbar.getHeight();
        return n / this.fontLineHeight + ((n % this.fontLineHeight != 0) ? 1 : 0);
    }
    
    private void setScrollBarMaximum() {
        int numberOfRows = this.codeModel.getNumberOfRows();
        if (numberOfRows < 0) {
            numberOfRows = 0;
            this.verticalScrollbar.setValue(0);
            this.verticalScrollbar.setEnabled(false);
        }
        else {
            this.verticalScrollbar.setEnabled(true);
        }
        this.verticalScrollbar.setMaximum(numberOfRows);
        final int totalWidthInCharacters = this.codeModel.getTotalWidthInCharacters();
        if (this.getWidth() - this.verticalScrollbar.getWidth() >= totalWidthInCharacters * this.fontCharWidth) {
            this.horizontalScrollbar.setValue(0);
            this.horizontalScrollbar.setEnabled(false);
        }
        else {
            this.horizontalScrollbar.setMaximum(totalWidthInCharacters + 1);
            this.horizontalScrollbar.setEnabled(true);
        }
    }
    
    private void updateCharacterBufferFromModel() {
        this.charBuffer.clear();
        this.charBuffer.setBackgroundColor(Color.LIGHT_GRAY.brighter());
        this.currentFirstRow = this.verticalScrollbar.getValue();
        this.currentFirstCharColumn = this.horizontalScrollbar.getValue();
        int caretY = 0;
        if (this.codeModel.hasHeaderRow()) {
            caretY = 1;
            int n = 0;
            for (int i = 0; i < this.codeModel.getNumberOfColumns(); ++i) {
                this.charBuffer.copyInto(0, n, this.codeModel.getHeader(i));
                n += this.codeModel.getColumnWidthInCharacters(i);
            }
        }
        for (int j = this.currentFirstRow; j < Math.min(this.currentFirstRow + this.currentlyVisibleLines, this.codeModel.getNumberOfRows()); ++j) {
            for (int k = (j == this.currentFirstRow) ? this.currentFirstLine : 0; k < this.codeModel.getMaximumLinesForRow(j); ++k) {
                int n2 = 0;
                for (int l = 0; l < this.codeModel.getNumberOfColumns(); ++l) {
                    if (this.caretPosition.getRow() == j && this.caretPosition.getLine() == k && this.caretPosition.getColumn() == l) {
                        this.caretX = n2 + this.caretPosition.getFieldIndex();
                        this.caretY = caretY;
                    }
                    final FormattedCharacterBuffer lineFormatted = this.codeModel.getLineFormatted(j, l, k);
                    if (lineFormatted != null) {
                        this.charBuffer.copyInto(caretY, n2, lineFormatted);
                    }
                    final int n3 = caretY * this.fontLineHeight + this.fontLineHeight / 2;
                    if (!this.yCoordinateToRowAndLine.containsKey(n3)) {
                        this.yCoordinateToRowAndLine.put(n3, new CodeDisplayCoordinate(j, k, 0, 0));
                    }
                    else {
                        final CodeDisplayCoordinate codeDisplayCoordinate = this.yCoordinateToRowAndLine.get(n3);
                        codeDisplayCoordinate.setRow(j);
                        codeDisplayCoordinate.setLine(k);
                    }
                    n2 += this.codeModel.getColumnWidthInCharacters(l);
                }
                ++caretY;
            }
        }
        this.setScrollBarMaximum();
    }
    
    @Override
    protected void paintComponent(final Graphics graphics) {
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
        final int numberOfVisibleLines = this.getNumberOfVisibleLines();
        final int numberOfVisibleColumns = this.getNumberOfVisibleColumns();
        if (this.currentlyVisibleLines != numberOfVisibleLines || this.currentlyVisibleColumns != numberOfVisibleColumns) {
            this.currentlyVisibleLines = numberOfVisibleLines;
            this.currentlyVisibleColumns = numberOfVisibleColumns;
            final int totalWidthInCharacters = this.codeModel.getTotalWidthInCharacters();
            final int n = this.currentlyVisibleLines + 1;
            this.charBuffer = new FormattedCharacterBuffer(n, totalWidthInCharacters);
            this.bufferedImage = new BufferedImage(totalWidthInCharacters * this.fontCharWidth, n * this.fontLineHeight, 1);
            this.bufferedGraphics = (Graphics2D)this.bufferedImage.getGraphics();
        }
    }
    
    void setSelectionStart() {
    }
    
    private boolean fillColumnAndFieldIndexFromX(int n, final CodeDisplayCoordinate codeDisplayCoordinate) {
        n += this.currentFirstCharColumn * this.fontCharWidth;
        int n2 = 0;
        for (int i = 0; i < this.codeModel.getNumberOfColumns(); ++i) {
            final int n3 = n2 + this.codeModel.getColumnWidthInCharacters(i) * this.fontCharWidth;
            if (n >= n2 && n < n3) {
                n -= n2;
                final int fieldIndex = n / this.fontCharWidth;
                codeDisplayCoordinate.setColumn(i);
                codeDisplayCoordinate.setFieldIndex(fieldIndex);
                return true;
            }
            n2 = n3;
        }
        return false;
    }
    
    private boolean fillCoordinateFromXY(final int n, final int n2, final CodeDisplayCoordinate codeDisplayCoordinate) {
        final Map.Entry<Integer, CodeDisplayCoordinate> floorEntry = this.yCoordinateToRowAndLine.floorEntry(n2);
        if (floorEntry == null) {
            codeDisplayCoordinate.setRow(2);
            codeDisplayCoordinate.setColumn(1);
            return true;
        }
        codeDisplayCoordinate.setRow(floorEntry.getValue().getRow());
        codeDisplayCoordinate.setLine(floorEntry.getValue().getLine());
        return this.fillColumnAndFieldIndexFromX(n, codeDisplayCoordinate);
    }
    
    public CodeDisplayCoordinate getCaretPosition() {
        return this.caretPosition;
    }
    
    public void setCaretPosition(final CodeDisplayCoordinate caretPosition) {
        this.caretPosition = caretPosition;
    }
    
    public int rowAtPoint(final Point point) {
        final CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(0, 0, 0, 0);
        this.fillCoordinateFromXY(point.x, point.y, codeDisplayCoordinate);
        return codeDisplayCoordinate.getRow();
    }
    
    public int columnAtPoint(final Point point) {
        final CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(0, 0, 0, 0);
        this.fillCoordinateFromXY(point.x, point.y, codeDisplayCoordinate);
        return codeDisplayCoordinate.getColumn();
    }
    
    public int lineAtPoint(final Point point) {
        final CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(0, 0, 0, 0);
        this.fillCoordinateFromXY(point.x, point.y, codeDisplayCoordinate);
        return codeDisplayCoordinate.getLine();
    }
    
    public void addCaretChangedListener(final CodeDisplayEventListener codeDisplayEventListener) {
        this.eventListeners.add(codeDisplayEventListener);
    }
    
    public void removeCaretChangedListener(final CodeDisplayEventListener codeDisplayEventListener) {
        this.eventListeners.remove(codeDisplayEventListener);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.fontCharWidth * this.codeModel.getTotalWidthInCharacters(), this.fontLineHeight * 40);
    }
}
