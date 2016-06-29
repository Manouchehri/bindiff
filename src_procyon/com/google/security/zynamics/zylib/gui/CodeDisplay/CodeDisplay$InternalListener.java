package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.JCaret.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import java.awt.*;

class CodeDisplay$InternalListener extends MouseAdapter implements ICaretListener, AdjustmentListener, ComponentListener, FocusListener, KeyListener
{
    final /* synthetic */ CodeDisplay this$0;
    
    private CodeDisplay$InternalListener(final CodeDisplay this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void adjustmentValueChanged(final AdjustmentEvent adjustmentEvent) {
        this.this$0.repaint();
    }
    
    @Override
    public void caretStatusChanged(final JCaret caret) {
        this.this$0.repaint();
    }
    
    @Override
    public void componentHidden(final ComponentEvent componentEvent) {
    }
    
    @Override
    public void componentMoved(final ComponentEvent componentEvent) {
    }
    
    @Override
    public void componentResized(final ComponentEvent componentEvent) {
        this.this$0.updateVisibleLinesAndColumns();
        this.this$0.updateCharacterBufferFromModel();
        this.this$0.setScrollBarMaximum();
    }
    
    @Override
    public void componentShown(final ComponentEvent componentEvent) {
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
        this.this$0.repaint();
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        this.this$0.repaint();
    }
    
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        if (!keyEvent.isActionKey()) {
            return;
        }
        final CodeDisplayCoordinate caretPosition = new CodeDisplayCoordinate(this.this$0.caretPosition);
        final int line = caretPosition.getLine();
        final int row = caretPosition.getRow();
        final int fieldIndex = caretPosition.getFieldIndex();
        final int column = caretPosition.getColumn();
        switch (keyEvent.getKeyCode()) {
            case 38: {
                if (line == 0) {
                    final int n = row - 1;
                    caretPosition.setRow(Math.max(n, 0));
                    if (this.this$0.codeModel.getMaximumLinesForRow(n) > 0) {
                        caretPosition.setLine(this.this$0.codeModel.getMaximumLinesForRow(n) - 1);
                    }
                    break;
                }
                caretPosition.setLine(line - 1);
                break;
            }
            case 40: {
                if (line == this.this$0.codeModel.getMaximumLinesForRow(row) - 1) {
                    caretPosition.setRow(Math.min(row + 1, this.this$0.codeModel.getNumberOfRows()));
                    caretPosition.setLine(0);
                    break;
                }
                caretPosition.setLine(line + 1);
                break;
            }
            case 37: {
                if (fieldIndex == 0) {
                    caretPosition.setColumn(column - 1);
                    caretPosition.setFieldIndex(this.this$0.codeModel.getColumnWidthInCharacters(column - 1) - 1);
                    break;
                }
                caretPosition.setFieldIndex(fieldIndex - 1);
                break;
            }
            case 39: {
                final int fieldIndex2 = caretPosition.getFieldIndex();
                if (fieldIndex2 == this.this$0.codeModel.getColumnWidthInCharacters(column) - 1) {
                    caretPosition.setColumn(column + 1);
                    caretPosition.setFieldIndex(0);
                    break;
                }
                caretPosition.setFieldIndex(fieldIndex2 + 1);
                break;
            }
            case 34: {
                for (int i = 0; i < this.this$0.currentlyVisibleLines - 2; ++i) {
                    if (caretPosition.getLine() >= this.this$0.codeModel.getMaximumLinesForRow(row) - 1) {
                        caretPosition.setRow(Math.min(caretPosition.getRow() + 1, this.this$0.codeModel.getNumberOfRows()));
                        caretPosition.setLine(0);
                    }
                    else {
                        caretPosition.setLine(caretPosition.getLine() + 1);
                    }
                }
                this.this$0.verticalScrollbar.setValue(caretPosition.getRow());
                break;
            }
            case 33: {
                for (int j = 0; j < this.this$0.currentlyVisibleLines - 2; ++j) {
                    if (caretPosition.getLine() == 0) {
                        final int max = Math.max(caretPosition.getRow() - 1, 0);
                        caretPosition.setRow(Math.max(max, 0));
                        caretPosition.setLine(this.this$0.codeModel.getMaximumLinesForRow(max) - 1);
                    }
                    else {
                        caretPosition.setLine(Math.max(caretPosition.getLine() - 1, 0));
                    }
                }
                this.this$0.verticalScrollbar.setValue(caretPosition.getRow());
                break;
            }
            case 36: {
                this.this$0.codeModel.keyPressedOrTyped(caretPosition, keyEvent);
                break;
            }
            case 35: {
                this.this$0.codeModel.keyPressedOrTyped(caretPosition, keyEvent);
                break;
            }
            case 8: {
                this.this$0.codeModel.keyPressedOrTyped(caretPosition, keyEvent);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        if (this.this$0.codeModel.canHaveCaret(caretPosition)) {
            this.this$0.setCaretPosition(caretPosition);
            this.this$0.updateCharacterBufferFromModel();
            this.this$0.notifyCaretListeners();
            this.this$0.repaint();
        }
    }
    
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
    }
    
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        if (this.this$0.codeModel.isEditable(this.this$0.caretPosition)) {
            final CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(this.this$0.caretPosition);
            this.this$0.codeModel.keyPressedOrTyped(this.this$0.caretPosition, keyEvent);
            if (!codeDisplayCoordinate.equals(this.this$0.caretPosition)) {
                this.this$0.notifyCaretListeners();
            }
            this.this$0.updateCharacterBufferFromModel();
            this.this$0.repaint();
        }
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        this.this$0.requestFocusInWindow();
    }
    
    @Override
    public void mouseDragged(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseEntered(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseExited(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseMoved(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        final CodeDisplayCoordinate caretPosition = new CodeDisplayCoordinate(0, 0, 0, 0);
        if (!this.this$0.fillCoordinateFromXY(mouseEvent.getX(), mouseEvent.getY(), caretPosition)) {
            return;
        }
        if (this.this$0.codeModel.canHaveCaret(caretPosition)) {
            this.this$0.setCaretPosition(caretPosition);
            this.this$0.updateCharacterBufferFromModel();
            this.this$0.notifyCaretListeners();
            this.this$0.repaint();
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseWheelMoved(final MouseWheelEvent mouseWheelEvent) {
        this.this$0.verticalScrollbar.setValue(this.this$0.verticalScrollbar.getValue() + mouseWheelEvent.getWheelRotation());
    }
}
