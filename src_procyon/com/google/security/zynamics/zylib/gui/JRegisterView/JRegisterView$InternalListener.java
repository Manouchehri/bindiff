package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.security.zynamics.zylib.gui.JCaret.*;
import java.math.*;
import java.awt.event.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.common.base.*;
import java.util.*;
import java.awt.*;

class JRegisterView$InternalListener implements ICaretListener, IRegistersChangedListener, FocusListener, KeyListener, MouseListener, MouseMotionListener
{
    final /* synthetic */ JRegisterView this$0;
    
    private JRegisterView$InternalListener(final JRegisterView this$0) {
        this.this$0 = this$0;
    }
    
    private int hexToValue(final char c) {
        if (c >= 'A' && c <= 'F') {
            return c - 'A' + '\n';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + '\n';
        }
        return c - '0';
    }
    
    private boolean isHexChar(final char c) {
        return (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9');
    }
    
    @Override
    public void caretStatusChanged(final JCaret caret) {
        this.this$0.repaint();
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        if (this.this$0.m_editedRegister != 1) {
            this.this$0.leaveEditMode(false);
        }
    }
    
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 39) {
            if (this.this$0.m_caretPosition != 2 * this.this$0.m_registerModel.getRegisterInformation(this.this$0.m_editedRegister).getRegisterSize()) {
                this.this$0.m_caretPosition++;
            }
            keyEvent.consume();
            this.this$0.m_caret.setVisible(true);
            this.this$0.repaint();
        }
        else if (keyEvent.getKeyCode() == 37) {
            if (this.this$0.m_caretPosition != 0) {
                this.this$0.m_caretPosition--;
            }
            keyEvent.consume();
            this.this$0.m_caret.setVisible(true);
            this.this$0.repaint();
        }
        else if (keyEvent.getKeyCode() == 10) {
            if (this.this$0.m_editedRegister == -1) {
                if (this.this$0.m_highlightedRegister != -1) {
                    this.this$0.enterEditMode(this.this$0.m_highlightedRegister);
                }
            }
            else {
                this.this$0.leaveEditMode(true);
            }
            this.this$0.repaint();
        }
        else if (this.isHexChar(keyEvent.getKeyChar())) {
            final int registerSize = this.this$0.m_registerModel.getRegisterInformation(this.this$0.m_editedRegister).getRegisterSize();
            if (this.this$0.m_caretPosition == 2 * registerSize) {
                return;
            }
            final long n = this.hexToValue(keyEvent.getKeyChar());
            final long n2 = registerSize * 8 - 4 - this.this$0.m_caretPosition * 4;
            this.this$0.m_editValue = this.this$0.m_editValue.and(BigInteger.valueOf(~(15L << (int)n2))).or(BigInteger.valueOf(n << (int)n2));
            this.this$0.m_caretPosition++;
            this.this$0.m_caret.setVisible(true);
            this.this$0.repaint();
        }
    }
    
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
    }
    
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        final int access$900 = this.this$0.getRegisterNumber(mouseEvent.getX(), mouseEvent.getY());
        if (mouseEvent.getButton() == 1) {
            if (mouseEvent.getClickCount() == 1) {
                if (this.this$0.m_editedRegister != -1 && access$900 != this.this$0.m_editedRegister) {
                    this.this$0.leaveEditMode(false);
                }
            }
            else if (mouseEvent.getClickCount() == 2 && access$900 != -1 && this.this$0.m_editedRegister == -1) {
                final RegisterInformationInternal registerInformation = this.this$0.m_registerModel.getRegisterInformation(access$900);
                if (registerInformation.getRegisterSize() == 0) {
                    this.this$0.m_registerModel.setValue(registerInformation.getRegisterName(), registerInformation.getValue().xor(BigInteger.ONE));
                }
                else {
                    this.this$0.enterEditMode(this.this$0.m_highlightedRegister);
                }
            }
        }
        else if (mouseEvent.getButton() == 3 && mouseEvent.getClickCount() == 1) {
            if (this.this$0.m_editedRegister != -1 && access$900 != this.this$0.m_editedRegister) {
                this.this$0.leaveEditMode(false);
            }
            final JPopupMenu registerMenu = this.this$0.m_menuProvider.getRegisterMenu(access$900);
            if (registerMenu != null) {
                registerMenu.show(this.this$0, mouseEvent.getX(), mouseEvent.getY());
            }
        }
    }
    
    @Override
    public void mouseDragged(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseEntered(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseExited(final MouseEvent mouseEvent) {
        if (this.this$0.m_editedRegister == -1) {
            this.this$0.m_highlightedRegister = -1;
            this.this$0.repaint();
        }
    }
    
    @Override
    public void mouseMoved(final MouseEvent mouseEvent) {
        this.this$0.m_highlightedRegister = this.this$0.getRegisterNumber(mouseEvent.getX(), mouseEvent.getY());
        this.this$0.repaint();
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
    }
    
    @Override
    public void registerDataChanged() {
        this.this$0.updatePreferredSize();
        this.this$0.updateLongestRegisterName();
        this.this$0.repaint();
    }
}
