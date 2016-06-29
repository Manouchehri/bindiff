/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay$1;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayCoordinate;
import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

class CodeDisplay$InternalListener
extends MouseAdapter
implements ICaretListener,
AdjustmentListener,
ComponentListener,
FocusListener,
KeyListener {
    final /* synthetic */ CodeDisplay this$0;

    private CodeDisplay$InternalListener(CodeDisplay codeDisplay) {
        this.this$0 = codeDisplay;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
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
        this.this$0.updateVisibleLinesAndColumns();
        CodeDisplay.access$100(this.this$0);
        CodeDisplay.access$200(this.this$0);
    }

    @Override
    public void componentShown(ComponentEvent componentEvent) {
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        this.this$0.repaint();
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        this.this$0.repaint();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!keyEvent.isActionKey()) {
            return;
        }
        CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(CodeDisplay.access$300(this.this$0));
        int n2 = codeDisplayCoordinate.getLine();
        int n3 = codeDisplayCoordinate.getRow();
        int n4 = codeDisplayCoordinate.getFieldIndex();
        int n5 = codeDisplayCoordinate.getColumn();
        switch (keyEvent.getKeyCode()) {
            case 38: {
                if (n2 == 0) {
                    int n6 = n3 - 1;
                    codeDisplayCoordinate.setRow(Math.max(n6, 0));
                    int n7 = CodeDisplay.access$400(this.this$0).getMaximumLinesForRow(n6);
                    if (n7 <= 0) break;
                    codeDisplayCoordinate.setLine(CodeDisplay.access$400(this.this$0).getMaximumLinesForRow(n6) - 1);
                    break;
                }
                codeDisplayCoordinate.setLine(n2 - 1);
                break;
            }
            case 40: {
                if (n2 == CodeDisplay.access$400(this.this$0).getMaximumLinesForRow(n3) - 1) {
                    codeDisplayCoordinate.setRow(Math.min(n3 + 1, CodeDisplay.access$400(this.this$0).getNumberOfRows()));
                    codeDisplayCoordinate.setLine(0);
                    break;
                }
                codeDisplayCoordinate.setLine(n2 + 1);
                break;
            }
            case 37: {
                if (n4 == 0) {
                    codeDisplayCoordinate.setColumn(n5 - 1);
                    codeDisplayCoordinate.setFieldIndex(CodeDisplay.access$400(this.this$0).getColumnWidthInCharacters(n5 - 1) - 1);
                    break;
                }
                codeDisplayCoordinate.setFieldIndex(n4 - 1);
                break;
            }
            case 39: {
                n4 = codeDisplayCoordinate.getFieldIndex();
                if (n4 == CodeDisplay.access$400(this.this$0).getColumnWidthInCharacters(n5) - 1) {
                    codeDisplayCoordinate.setColumn(n5 + 1);
                    codeDisplayCoordinate.setFieldIndex(0);
                    break;
                }
                codeDisplayCoordinate.setFieldIndex(n4 + 1);
                break;
            }
            case 34: {
                for (int i2 = 0; i2 < CodeDisplay.access$500(this.this$0) - 2; ++i2) {
                    if (codeDisplayCoordinate.getLine() >= CodeDisplay.access$400(this.this$0).getMaximumLinesForRow(n3) - 1) {
                        codeDisplayCoordinate.setRow(Math.min(codeDisplayCoordinate.getRow() + 1, CodeDisplay.access$400(this.this$0).getNumberOfRows()));
                        codeDisplayCoordinate.setLine(0);
                        continue;
                    }
                    codeDisplayCoordinate.setLine(codeDisplayCoordinate.getLine() + 1);
                }
                CodeDisplay.access$600(this.this$0).setValue(codeDisplayCoordinate.getRow());
                break;
            }
            case 33: {
                for (int i3 = 0; i3 < CodeDisplay.access$500(this.this$0) - 2; ++i3) {
                    if (codeDisplayCoordinate.getLine() == 0) {
                        int n8 = Math.max(codeDisplayCoordinate.getRow() - 1, 0);
                        codeDisplayCoordinate.setRow(Math.max(n8, 0));
                        codeDisplayCoordinate.setLine(CodeDisplay.access$400(this.this$0).getMaximumLinesForRow(n8) - 1);
                        continue;
                    }
                    codeDisplayCoordinate.setLine(Math.max(codeDisplayCoordinate.getLine() - 1, 0));
                }
                CodeDisplay.access$600(this.this$0).setValue(codeDisplayCoordinate.getRow());
                break;
            }
            case 36: {
                CodeDisplay.access$400(this.this$0).keyPressedOrTyped(codeDisplayCoordinate, keyEvent);
                break;
            }
            case 35: {
                CodeDisplay.access$400(this.this$0).keyPressedOrTyped(codeDisplayCoordinate, keyEvent);
                break;
            }
            case 8: {
                CodeDisplay.access$400(this.this$0).keyPressedOrTyped(codeDisplayCoordinate, keyEvent);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        if (!CodeDisplay.access$400(this.this$0).canHaveCaret(codeDisplayCoordinate)) return;
        this.this$0.setCaretPosition(codeDisplayCoordinate);
        CodeDisplay.access$100(this.this$0);
        CodeDisplay.access$700(this.this$0);
        this.this$0.repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (!CodeDisplay.access$400(this.this$0).isEditable(CodeDisplay.access$300(this.this$0))) return;
        CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(CodeDisplay.access$300(this.this$0));
        CodeDisplay.access$400(this.this$0).keyPressedOrTyped(CodeDisplay.access$300(this.this$0), keyEvent);
        if (!codeDisplayCoordinate.equals(CodeDisplay.access$300(this.this$0))) {
            CodeDisplay.access$700(this.this$0);
        }
        CodeDisplay.access$100(this.this$0);
        this.this$0.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.this$0.requestFocusInWindow();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        CodeDisplayCoordinate codeDisplayCoordinate = new CodeDisplayCoordinate(0, 0, 0, 0);
        if (!CodeDisplay.access$800(this.this$0, mouseEvent.getX(), mouseEvent.getY(), codeDisplayCoordinate)) {
            return;
        }
        if (!CodeDisplay.access$400(this.this$0).canHaveCaret(codeDisplayCoordinate)) return;
        this.this$0.setCaretPosition(codeDisplayCoordinate);
        CodeDisplay.access$100(this.this$0);
        CodeDisplay.access$700(this.this$0);
        this.this$0.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        int n2 = mouseWheelEvent.getWheelRotation();
        CodeDisplay.access$600(this.this$0).setValue(CodeDisplay.access$600(this.this$0).getValue() + n2);
    }

    /* synthetic */ CodeDisplay$InternalListener(CodeDisplay codeDisplay, CodeDisplay$1 codeDisplay$1) {
        this(codeDisplay);
    }
}

