/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import com.google.security.zynamics.zylib.gui.JRegisterView.IRegistersChangedListener;
import com.google.security.zynamics.zylib.gui.JRegisterView.JRegisterView;
import com.google.security.zynamics.zylib.gui.JRegisterView.JRegisterView$1;
import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformationInternal;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.math.BigInteger;
import javax.swing.JPopupMenu;

class JRegisterView$InternalListener
implements ICaretListener,
IRegistersChangedListener,
FocusListener,
KeyListener,
MouseListener,
MouseMotionListener {
    final /* synthetic */ JRegisterView this$0;

    private JRegisterView$InternalListener(JRegisterView jRegisterView) {
        this.this$0 = jRegisterView;
    }

    private int hexToValue(char c2) {
        if (c2 >= 'A' && c2 <= 'F') {
            return c2 - 65 + 10;
        }
        if (c2 < 'a') return c2 - 48;
        if (c2 > 'f') return c2 - 48;
        return c2 - 97 + 10;
    }

    private boolean isHexChar(char c2) {
        if (c2 >= 'a') {
            if (c2 <= 'f') return true;
        }
        if (c2 >= 'A') {
            if (c2 <= 'F') return true;
        }
        if (c2 < '0') return false;
        if (c2 > '9') return false;
        return true;
    }

    @Override
    public void caretStatusChanged(JCaret jCaret) {
        this.this$0.repaint();
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        if (JRegisterView.access$100(this.this$0) == 1) return;
        JRegisterView.access$200(this.this$0, false);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 39) {
            if (JRegisterView.access$300(this.this$0) != 2 * JRegisterView.access$400(this.this$0).getRegisterInformation(JRegisterView.access$100(this.this$0)).getRegisterSize()) {
                JRegisterView.access$308(this.this$0);
            }
            keyEvent.consume();
            JRegisterView.access$500(this.this$0).setVisible(true);
            this.this$0.repaint();
            return;
        }
        if (keyEvent.getKeyCode() == 37) {
            if (JRegisterView.access$300(this.this$0) != 0) {
                JRegisterView.access$310(this.this$0);
            }
            keyEvent.consume();
            JRegisterView.access$500(this.this$0).setVisible(true);
            this.this$0.repaint();
            return;
        }
        if (keyEvent.getKeyCode() == 10) {
            if (JRegisterView.access$100(this.this$0) == -1) {
                if (JRegisterView.access$600(this.this$0) != -1) {
                    JRegisterView.access$700(this.this$0, JRegisterView.access$600(this.this$0));
                }
            } else {
                JRegisterView.access$200(this.this$0, true);
            }
            this.this$0.repaint();
            return;
        }
        if (!this.isHexChar(keyEvent.getKeyChar())) return;
        int n2 = JRegisterView.access$400(this.this$0).getRegisterInformation(JRegisterView.access$100(this.this$0)).getRegisterSize();
        if (JRegisterView.access$300(this.this$0) == 2 * n2) {
            return;
        }
        long l2 = this.hexToValue(keyEvent.getKeyChar());
        long l3 = n2 * 8 - 4 - JRegisterView.access$300(this.this$0) * 4;
        long l4 = 15 << (int)l3;
        long l5 = l2 << (int)l3;
        JRegisterView.access$802(this.this$0, JRegisterView.access$800(this.this$0).and(BigInteger.valueOf(l4 ^ -1)).or(BigInteger.valueOf(l5)));
        JRegisterView.access$308(this.this$0);
        JRegisterView.access$500(this.this$0).setVisible(true);
        this.this$0.repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        JPopupMenu jPopupMenu;
        int n2 = JRegisterView.access$900(this.this$0, mouseEvent.getX(), mouseEvent.getY());
        if (mouseEvent.getButton() == 1) {
            if (mouseEvent.getClickCount() == 1) {
                if (JRegisterView.access$100(this.this$0) == -1) return;
                if (n2 == JRegisterView.access$100(this.this$0)) return;
                JRegisterView.access$200(this.this$0, false);
                return;
            }
            if (mouseEvent.getClickCount() != 2) return;
            if (n2 == -1) return;
            if (JRegisterView.access$100(this.this$0) != -1) return;
            RegisterInformationInternal registerInformationInternal = JRegisterView.access$400(this.this$0).getRegisterInformation(n2);
            if (registerInformationInternal.getRegisterSize() == 0) {
                JRegisterView.access$400(this.this$0).setValue(registerInformationInternal.getRegisterName(), registerInformationInternal.getValue().xor(BigInteger.ONE));
                return;
            }
            JRegisterView.access$700(this.this$0, JRegisterView.access$600(this.this$0));
            return;
        }
        if (mouseEvent.getButton() != 3) return;
        if (mouseEvent.getClickCount() != 1) return;
        if (JRegisterView.access$100(this.this$0) != -1 && n2 != JRegisterView.access$100(this.this$0)) {
            JRegisterView.access$200(this.this$0, false);
        }
        if ((jPopupMenu = JRegisterView.access$1000(this.this$0).getRegisterMenu(n2)) == null) return;
        jPopupMenu.show(this.this$0, mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        if (JRegisterView.access$100(this.this$0) != -1) return;
        JRegisterView.access$602(this.this$0, -1);
        this.this$0.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        JRegisterView.access$602(this.this$0, JRegisterView.access$900(this.this$0, mouseEvent.getX(), mouseEvent.getY()));
        this.this$0.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void registerDataChanged() {
        JRegisterView.access$1100(this.this$0);
        JRegisterView.access$1200(this.this$0);
        this.this$0.repaint();
    }

    /* synthetic */ JRegisterView$InternalListener(JRegisterView jRegisterView, JRegisterView$1 jRegisterView$1) {
        this(jRegisterView);
    }
}

