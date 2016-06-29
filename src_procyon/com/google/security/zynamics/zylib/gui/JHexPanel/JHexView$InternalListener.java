package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JCaret.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.gui.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import com.google.common.base.*;

class JHexView$InternalListener implements ICaretListener, IDataChangedListener, AdjustmentListener, ComponentListener, FocusListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
    final /* synthetic */ JHexView this$0;
    
    private JHexView$InternalListener(final JHexView this$0) {
        this.this$0 = this$0;
    }
    
    private void keyPressedInAsciiView(final KeyEvent keyEvent) {
        final byte[] data = this.this$0.m_dataProvider.getData(this.this$0.getCurrentOffset(), 1);
        if (this.this$0.getSelectionStart() >= this.this$0.m_dataProvider.getDataLength() * 2) {
            return;
        }
        data[0] = (byte)keyEvent.getKeyChar();
        this.this$0.m_dataProvider.setData(this.this$0.getCurrentOffset(), data);
        this.this$0.setSelectionStart(this.this$0.getSelectionStart() + 2L);
    }
    
    private void keyPressedInHexView(final KeyEvent keyEvent) {
        final byte[] data = this.this$0.m_dataProvider.getData(this.this$0.getCurrentOffset(), 1);
        final long n = this.this$0.m_baseAddress + this.this$0.getSelectionStart();
        if (this.this$0.getSelectionStart() >= this.this$0.m_dataProvider.getDataLength() * 2) {
            return;
        }
        final int digit = Character.digit(keyEvent.getKeyChar(), 16);
        if (digit == -1) {
            return;
        }
        if (n % 2L == 0L) {
            data[0] = (byte)((data[0] & 0xF) | digit << 4);
        }
        else {
            data[0] = (byte)((data[0] & 0xF0) | digit);
        }
        this.this$0.m_dataProvider.setData(this.this$0.getCurrentOffset(), data);
        this.this$0.setSelectionStart(this.this$0.getSelectionStart() + 1L);
    }
    
    @Override
    public void adjustmentValueChanged(final AdjustmentEvent adjustmentEvent) {
        if (adjustmentEvent.getSource() == this.this$0.m_scrollbar) {
            this.this$0.m_firstRow = adjustmentEvent.getValue();
        }
        else {
            this.this$0.m_firstColumn = adjustmentEvent.getValue();
        }
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
        this.this$0.setScrollBarMaximum();
        this.this$0.img = new BufferedImage(Math.max(1, this.this$0.getWidth() + 1 - this.this$0.m_scrollbar.getWidth()), Math.max(1, this.this$0.getHeight() + 1 - this.this$0.m_horizontalScrollbar.getHeight()), 1);
        this.this$0.bufferGraphics = this.this$0.img.getGraphics();
    }
    
    @Override
    public void componentShown(final ComponentEvent componentEvent) {
    }
    
    @Override
    public void dataChanged() {
        this.this$0.setScrollBarMaximum();
        this.this$0.repaint();
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
        this.this$0.m_caret.setVisible(true);
        this.this$0.repaint();
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        this.this$0.repaint();
    }
    
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        if (this.this$0.m_activeView == JHexView$Views.HEX_VIEW) {
            if (this.this$0.m_dataProvider.isEditable() && Convert.isHexCharacter(keyEvent.getKeyChar())) {
                this.keyPressedInHexView(keyEvent);
            }
        }
        else if (this.this$0.m_dataProvider.isEditable() && Convert.isPrintableCharacter(keyEvent.getKeyChar())) {
            this.keyPressedInAsciiView(keyEvent);
        }
        this.this$0.repaint();
    }
    
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
    }
    
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseDragged(final MouseEvent mouseEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        final int x = mouseEvent.getX();
        final int y = mouseEvent.getY();
        if (y < 16 - (this.this$0.m_rowHeight - this.this$0.m_charHeight)) {
            this.this$0.scrollToPosition(2 * this.this$0.getFirstVisibleByte() - 2 * this.this$0.m_bytesPerRow);
            if (this.this$0.getSelectionLength() - 2 * this.this$0.m_bytesPerRow < 0L) {
                return;
            }
            this.this$0.setSelectionLength(this.this$0.getSelectionLength() - 2 * this.this$0.m_bytesPerRow);
        }
        else if (y >= this.this$0.m_rowHeight * this.this$0.getNumberOfVisibleRows()) {
            this.this$0.scrollToPosition(2 * this.this$0.getFirstVisibleByte() + 2 * this.this$0.m_bytesPerRow);
            if (this.this$0.getSelectionLength() + 2 * this.this$0.m_bytesPerRow > 2L * (this.this$0.m_dataProvider.getDataLength() - this.this$0.getSelectionStart())) {
                return;
            }
            this.this$0.setSelectionLength(this.this$0.getSelectionLength() + 2 * this.this$0.m_bytesPerRow);
        }
        else {
            final int access$2900 = this.this$0.getNibbleAtCoordinate(x, y);
            if (access$2900 != -1) {
                this.this$0.setSelectionLength(access$2900 - this.this$0.getSelectionStart());
                this.this$0.repaint();
            }
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseExited(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseMoved(final MouseEvent mouseEvent) {
        this.this$0.m_lastMouseX = mouseEvent.getX();
        this.this$0.m_lastMouseY = mouseEvent.getY();
        this.this$0.repaint();
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        if (mouseEvent.getButton() == 1 || mouseEvent.getButton() == 3) {
            this.this$0.m_selectionLength = 0L;
            this.this$0.requestFocusInWindow();
            final int x = mouseEvent.getX();
            final int y = mouseEvent.getY();
            final int access$2900 = this.this$0.getNibbleAtCoordinate(x, y);
            if (access$2900 != -1) {
                this.this$0.m_caret.setVisible(true);
                this.this$0.setCurrentPosition(access$2900);
                if (this.this$0.isInsideHexView(x, y)) {
                    this.this$0.m_activeView = JHexView$Views.HEX_VIEW;
                }
                else if (this.this$0.isInsideAsciiView(x, y)) {
                    this.this$0.m_activeView = JHexView$Views.ASCII_VIEW;
                }
                this.this$0.repaint();
            }
            else {
                final Iterator<IHexPanelListener> iterator = this.this$0.m_listeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().selectionChanged(this.this$0.m_selectionStart, this.this$0.m_selectionLength);
                }
                this.this$0.repaint();
            }
        }
        if (mouseEvent.getButton() == 3) {
            final int x2 = mouseEvent.getX();
            final int y2 = mouseEvent.getY();
            if (this.this$0.getNibbleAtCoordinate(x2, y2) != -1) {
                this.this$0.m_caret.setVisible(true);
                if (this.this$0.m_menuCreator != null) {
                    final JPopupMenu menu = this.this$0.m_menuCreator.createMenu(this.this$0.getCurrentOffset());
                    if (menu != null) {
                        menu.show(this.this$0, x2, y2);
                    }
                }
                this.this$0.repaint();
            }
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseWheelMoved(final MouseWheelEvent mouseWheelEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        this.this$0.m_scrollbar.setValue(this.this$0.m_scrollbar.getValue() + mouseWheelEvent.getWheelRotation());
    }
}
