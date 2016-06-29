/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.general.Convert;
import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import com.google.security.zynamics.zylib.gui.JHexPanel.IDataChangedListener;
import com.google.security.zynamics.zylib.gui.JHexPanel.IHexPanelListener;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$1;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$Views;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import javax.swing.JPopupMenu;

class JHexView$InternalListener
implements ICaretListener,
IDataChangedListener,
AdjustmentListener,
ComponentListener,
FocusListener,
KeyListener,
MouseListener,
MouseMotionListener,
MouseWheelListener {
    final /* synthetic */ JHexView this$0;

    private JHexView$InternalListener(JHexView jHexView) {
        this.this$0 = jHexView;
    }

    private void keyPressedInAsciiView(KeyEvent keyEvent) {
        byte[] arrby = JHexView.access$1100(this.this$0).getData(this.this$0.getCurrentOffset(), 1);
        if (JHexView.access$1200(this.this$0) >= (long)(JHexView.access$1100(this.this$0).getDataLength() * 2)) {
            return;
        }
        arrby[0] = (byte)keyEvent.getKeyChar();
        JHexView.access$1100(this.this$0).setData(this.this$0.getCurrentOffset(), arrby);
        JHexView.access$1300(this.this$0, JHexView.access$1200(this.this$0) + 2);
    }

    private void keyPressedInHexView(KeyEvent keyEvent) {
        byte[] arrby = JHexView.access$1100(this.this$0).getData(this.this$0.getCurrentOffset(), 1);
        long l2 = JHexView.access$1400(this.this$0) + JHexView.access$1200(this.this$0);
        if (JHexView.access$1200(this.this$0) >= (long)(JHexView.access$1100(this.this$0).getDataLength() * 2)) {
            return;
        }
        int n2 = Character.digit(keyEvent.getKeyChar(), 16);
        if (n2 == -1) {
            return;
        }
        arrby[0] = l2 % 2 == 0 ? (byte)(arrby[0] & 15 | n2 << 4) : (byte)(arrby[0] & 240 | n2);
        JHexView.access$1100(this.this$0).setData(this.this$0.getCurrentOffset(), arrby);
        JHexView.access$1300(this.this$0, JHexView.access$1200(this.this$0) + 1);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        if (adjustmentEvent.getSource() == JHexView.access$1500(this.this$0)) {
            JHexView.access$1602(this.this$0, adjustmentEvent.getValue());
        } else {
            JHexView.access$1702(this.this$0, adjustmentEvent.getValue());
        }
        this.this$0.repaint();
    }

    @Override
    public void caretStatusChanged(JCaret jCaret) {
        this.this$0.repaint();
    }

    @Override
    public void componentHidden(ComponentEvent componentEvent) {
    }

    @Override
    public void componentMoved(ComponentEvent componentEvent) {
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {
        JHexView.access$1800(this.this$0);
        int n2 = this.this$0.getWidth() + 1 - JHexView.access$1500(this.this$0).getWidth();
        int n3 = this.this$0.getHeight() + 1 - JHexView.access$1900(this.this$0).getHeight();
        n2 = Math.max(1, n2);
        n3 = Math.max(1, n3);
        JHexView.access$2002(this.this$0, new BufferedImage(n2, n3, 1));
        JHexView.access$2102(this.this$0, JHexView.access$2000(this.this$0).getGraphics());
    }

    @Override
    public void componentShown(ComponentEvent componentEvent) {
    }

    @Override
    public void dataChanged() {
        JHexView.access$1800(this.this$0);
        this.this$0.repaint();
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        JHexView.access$2200(this.this$0).setVisible(true);
        this.this$0.repaint();
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        this.this$0.repaint();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        if (JHexView.access$2300(this.this$0) == JHexView$Views.HEX_VIEW) {
            if (JHexView.access$1100(this.this$0).isEditable() && Convert.isHexCharacter(keyEvent.getKeyChar())) {
                this.keyPressedInHexView(keyEvent);
            }
        } else if (JHexView.access$1100(this.this$0).isEditable() && Convert.isPrintableCharacter(keyEvent.getKeyChar())) {
            this.keyPressedInAsciiView(keyEvent);
        }
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
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        int n2 = mouseEvent.getX();
        int n3 = mouseEvent.getY();
        if (n3 < 16 - (JHexView.access$2400(this.this$0) - JHexView.access$2500(this.this$0))) {
            JHexView.access$2700(this.this$0, 2 * JHexView.access$2600(this.this$0) - 2 * JHexView.access$900(this.this$0));
            if (this.this$0.getSelectionLength() - (long)(2 * JHexView.access$900(this.this$0)) < 0) {
                return;
            }
            this.this$0.setSelectionLength(this.this$0.getSelectionLength() - (long)(2 * JHexView.access$900(this.this$0)));
            return;
        }
        if (n3 < JHexView.access$2400(this.this$0) * JHexView.access$2800(this.this$0)) {
            int n4 = JHexView.access$2900(this.this$0, n2, n3);
            if (n4 == -1) return;
            this.this$0.setSelectionLength((long)n4 - JHexView.access$1200(this.this$0));
            this.this$0.repaint();
            return;
        }
        JHexView.access$2700(this.this$0, 2 * JHexView.access$2600(this.this$0) + 2 * JHexView.access$900(this.this$0));
        if (this.this$0.getSelectionLength() + (long)(2 * JHexView.access$900(this.this$0)) > 2 * ((long)JHexView.access$1100(this.this$0).getDataLength() - JHexView.access$1200(this.this$0))) {
            return;
        }
        this.this$0.setSelectionLength(this.this$0.getSelectionLength() + (long)(2 * JHexView.access$900(this.this$0)));
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        JHexView.access$3002(this.this$0, mouseEvent.getX());
        JHexView.access$3102(this.this$0, mouseEvent.getY());
        this.this$0.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int n2;
        int n3;
        Object object;
        int n4;
        if (!this.this$0.isEnabled()) {
            return;
        }
        if (mouseEvent.getButton() == 1 || mouseEvent.getButton() == 3) {
            JHexView.access$3202(this.this$0, 0);
            this.this$0.requestFocusInWindow();
            n2 = mouseEvent.getX();
            n4 = mouseEvent.getY();
            n3 = JHexView.access$2900(this.this$0, n2, n4);
            if (n3 != -1) {
                JHexView.access$2200(this.this$0).setVisible(true);
                JHexView.access$3300(this.this$0, n3);
                if (JHexView.access$3400(this.this$0, n2, n4)) {
                    JHexView.access$2302(this.this$0, JHexView$Views.HEX_VIEW);
                } else if (JHexView.access$3500(this.this$0, n2, n4)) {
                    JHexView.access$2302(this.this$0, JHexView$Views.ASCII_VIEW);
                }
                this.this$0.repaint();
            } else {
                object = JHexView.access$3600(this.this$0).iterator();
                while (object.hasNext()) {
                    IHexPanelListener iHexPanelListener = (IHexPanelListener)object.next();
                    iHexPanelListener.selectionChanged(JHexView.access$3700(this.this$0), JHexView.access$3200(this.this$0));
                }
                this.this$0.repaint();
            }
        }
        if (mouseEvent.getButton() != 3) return;
        n2 = mouseEvent.getX();
        n3 = JHexView.access$2900(this.this$0, n2, n4 = mouseEvent.getY());
        if (n3 == -1) return;
        JHexView.access$2200(this.this$0).setVisible(true);
        if (JHexView.access$3800(this.this$0) != null && (object = JHexView.access$3800(this.this$0).createMenu(this.this$0.getCurrentOffset())) != null) {
            object.show(this.this$0, n2, n4);
        }
        this.this$0.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        int n2 = mouseWheelEvent.getWheelRotation();
        JHexView.access$1500(this.this$0).setValue(JHexView.access$1500(this.this$0).getValue() + n2);
    }

    /* synthetic */ JHexView$InternalListener(JHexView jHexView, JHexView$1 jHexView$1) {
        this(jHexView);
    }
}

