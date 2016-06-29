/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import com.google.security.zynamics.zylib.gui.JRegisterView.IMenuProvider;
import com.google.security.zynamics.zylib.gui.JRegisterView.IRegisterModel;
import com.google.security.zynamics.zylib.gui.JRegisterView.IRegistersChangedListener;
import com.google.security.zynamics.zylib.gui.JRegisterView.JRegisterView$1;
import com.google.security.zynamics.zylib.gui.JRegisterView.JRegisterView$InternalListener;
import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformationInternal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.math.BigInteger;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.Scrollable;

public class JRegisterView
extends JPanel
implements Scrollable {
    private static final long serialVersionUID = -918576778293064213L;
    private final Font m_font = new Font(GuiHelper.getMonospaceFont(), 0, 12);
    private final IRegisterModel m_registerModel;
    private int m_longestRegisterName = 0;
    private int m_highlightedRegister = -1;
    private int m_charWidth;
    private final Color m_modifiedColor = Color.RED;
    private final Color m_textColor = Color.BLACK;
    private static final int m_paddingLeft = 10;
    private final Color m_bgColorEdit = new Color(16765152);
    private final Color m_bgColorHighlight = Color.WHITE;
    private int m_editedRegister = -1;
    private final JCaret m_caret = new JCaret();
    private int m_caretPosition = 0;
    private BigInteger m_editValue = BigInteger.ZERO;
    private final Color m_backgroundColor = new Color(13421823);
    private final Color m_disabledColor = Color.GRAY;
    private IMenuProvider m_menuProvider;
    private final JRegisterView$InternalListener m_listener;

    public JRegisterView(IRegisterModel iRegisterModel) {
        this.m_listener = new JRegisterView$InternalListener(this, null);
        Preconditions.checkNotNull(iRegisterModel, "Error: Argument registerModel can't be null");
        iRegisterModel.addListener(this.m_listener);
        this.setFocusable(true);
        this.setOpaque(true);
        this.initializeListeners();
        this.m_registerModel = iRegisterModel;
        this.updateLongestRegisterName();
        this.setBackground(this.m_backgroundColor);
        this.updatePreferredSize();
    }

    private void drawCaret(Graphics graphics) {
        if (!this.hasFocus()) return;
        if (this.m_editedRegister == -1) return;
        Rectangle rectangle = this.getRegisterBounds(this.m_editedRegister);
        int n2 = this.m_font.getSize();
        int n3 = rectangle.x + this.m_caretPosition * this.m_charWidth + this.m_longestRegisterName * this.m_charWidth + 5 - 1;
        int n4 = rectangle.y;
        this.m_caret.draw(graphics, n3, n4, n2);
    }

    private void drawHighlightedRegister(Graphics graphics) {
        if (!this.isEnabled()) {
            return;
        }
        if (this.m_editedRegister != -1) {
            graphics.setColor(this.m_bgColorEdit);
            Rectangle rectangle = this.getRegisterBounds(this.m_editedRegister);
            graphics.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            return;
        }
        if (this.m_highlightedRegister == -1) return;
        graphics.setColor(this.m_bgColorHighlight);
        Rectangle rectangle = this.getRegisterBounds(this.m_highlightedRegister);
        graphics.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    private void drawRegisters(Graphics graphics) {
        int n2;
        int n3 = n2 = this.m_font.getSize() + 5;
        int n4 = this.m_font.getSize();
        int n5 = 0;
        RegisterInformationInternal[] arrregisterInformationInternal = this.m_registerModel.getRegisterInformation();
        int n6 = arrregisterInformationInternal.length;
        int n7 = 0;
        while (n7 < n6) {
            String string;
            RegisterInformationInternal registerInformationInternal = arrregisterInformationInternal[n7];
            if (this.isEnabled()) {
                graphics.setColor(registerInformationInternal.isModified() || n5 == this.m_editedRegister ? this.m_modifiedColor : this.m_textColor);
            } else {
                graphics.setColor(this.m_disabledColor);
            }
            graphics.drawString(registerInformationInternal.getRegisterName(), 10, n3);
            BigInteger bigInteger = (n5 == this.m_editedRegister ? this.m_editValue : registerInformationInternal.getValue()).and(registerInformationInternal.getRegisterSize() == 8 ? BigInteger.valueOf(Long.MAX_VALUE) : BigInteger.valueOf(0xFFFFFFFFL));
            if (registerInformationInternal.getRegisterSize() != 0) {
                int n8 = 2 * registerInformationInternal.getRegisterSize();
                String string2 = new StringBuilder(14).append("%0").append(n8).append("X").toString();
                string = String.format(string2, bigInteger);
            } else {
                string = String.valueOf(bigInteger.and(BigInteger.ONE));
            }
            graphics.drawString(string, 15 + this.m_charWidth * this.m_longestRegisterName, n3);
            ++n5;
            n3 += n4;
            ++n7;
        }
    }

    private void enterEditMode(int n2) {
        this.requestFocusInWindow();
        this.m_caret.setVisible(true);
        this.m_editedRegister = n2;
        this.m_caretPosition = 0;
        this.m_editValue = this.m_registerModel.getRegisterInformation(n2).getValue();
        this.repaint();
    }

    private Rectangle getRegisterBounds(int n2) {
        RegisterInformationInternal registerInformationInternal = this.m_registerModel.getRegisterInformation(n2);
        int n3 = 7 + n2 * this.m_font.getSize();
        int n4 = 5 + this.m_charWidth * (this.m_longestRegisterName + registerInformationInternal.getRegisterSize() * 2);
        int n5 = this.m_font.getSize() - 1;
        return new Rectangle(10, n3, n4, n5);
    }

    private int getRegisterNumber(int n2, int n3) {
        int n4 = this.m_font.getSize();
        if (n3 < 7) return -1;
        if (n3 > 7 + n4 * this.m_registerModel.getNumberOfRegisters()) return -1;
        int n5 = (n3 - 7) / n4;
        if ((n5 = Math.min(n5, this.m_registerModel.getNumberOfRegisters() - 1)) == -1) {
            return -1;
        }
        RegisterInformationInternal registerInformationInternal = this.m_registerModel.getRegisterInformation(n5);
        int n6 = registerInformationInternal.getRegisterSize() == 0 ? 1 : registerInformationInternal.getRegisterSize() * 2;
        int n7 = 15 + this.m_charWidth * (this.m_longestRegisterName + n6);
        if (n2 < 10) return -1;
        if (n2 > n7) return -1;
        return n5;
    }

    private void initializeListeners() {
        this.addMouseListener(this.m_listener);
        this.addMouseMotionListener(this.m_listener);
        this.addKeyListener(this.m_listener);
        this.addFocusListener(this.m_listener);
        this.m_caret.addCaretListener(this.m_listener);
    }

    private void leaveEditMode(boolean bl2) {
        RegisterInformationInternal registerInformationInternal;
        if (bl2 && !Objects.equals(this.m_editValue, (registerInformationInternal = this.m_registerModel.getRegisterInformation(this.m_editedRegister)).getValue())) {
            this.beginRegisterUpdate();
            this.m_registerModel.setValue(registerInformationInternal.getRegisterName(), this.m_editValue);
            this.endRegisterUpdate();
        }
        this.m_caret.setVisible(false);
        this.m_editedRegister = -1;
        this.m_caretPosition = 0;
        this.repaint();
    }

    private void updateLongestRegisterName() {
        this.m_longestRegisterName = Integer.MIN_VALUE;
        RegisterInformationInternal[] arrregisterInformationInternal = this.m_registerModel.getRegisterInformation();
        int n2 = arrregisterInformationInternal.length;
        int n3 = 0;
        while (n3 < n2) {
            RegisterInformationInternal registerInformationInternal = arrregisterInformationInternal[n3];
            if (registerInformationInternal.getRegisterName().length() > this.m_longestRegisterName) {
                this.m_longestRegisterName = registerInformationInternal.getRegisterName().length();
            }
            ++n3;
        }
    }

    private void updatePreferredSize() {
        int n2 = this.m_font.getSize() + 5;
        int n3 = this.m_font.getSize();
        int n4 = n2 + this.m_registerModel.getNumberOfRegisters() * n3;
        this.setPreferredSize(new Dimension(200, n4));
        this.revalidate();
        this.updateUI();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setFont(this.m_font);
        this.m_charWidth = (int)graphics.getFontMetrics().getStringBounds("0", graphics).getWidth();
        if (this.m_registerModel == null) return;
        this.drawHighlightedRegister(graphics);
        this.drawRegisters(graphics);
        if (!this.m_caret.isVisible()) return;
        this.drawCaret(graphics);
    }

    public void beginRegisterUpdate() {
        RegisterInformationInternal[] arrregisterInformationInternal = this.m_registerModel.getRegisterInformation();
        int n2 = arrregisterInformationInternal.length;
        int n3 = 0;
        while (n3 < n2) {
            RegisterInformationInternal registerInformationInternal = arrregisterInformationInternal[n3];
            registerInformationInternal.setModified(false);
            ++n3;
        }
    }

    public void dispose() {
        this.removeMouseListener(this.m_listener);
        this.removeMouseMotionListener(this.m_listener);
        this.removeKeyListener(this.m_listener);
        this.removeFocusListener(this.m_listener);
        this.m_caret.removeListener(this.m_listener);
        this.m_caret.stop();
    }

    public void endRegisterUpdate() {
        this.repaint();
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return this.getPreferredSize();
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle rectangle, int n2, int n3) {
        return 5 * this.m_font.getSize();
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle rectangle, int n2, int n3) {
        return this.m_font.getSize();
    }

    @Override
    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        this.repaint();
    }

    public void setMenuProvider(IMenuProvider iMenuProvider) {
        this.m_menuProvider = iMenuProvider;
    }

    static /* synthetic */ int access$100(JRegisterView jRegisterView) {
        return jRegisterView.m_editedRegister;
    }

    static /* synthetic */ void access$200(JRegisterView jRegisterView, boolean bl2) {
        jRegisterView.leaveEditMode(bl2);
    }

    static /* synthetic */ int access$300(JRegisterView jRegisterView) {
        return jRegisterView.m_caretPosition;
    }

    static /* synthetic */ IRegisterModel access$400(JRegisterView jRegisterView) {
        return jRegisterView.m_registerModel;
    }

    static /* synthetic */ int access$308(JRegisterView jRegisterView) {
        return jRegisterView.m_caretPosition++;
    }

    static /* synthetic */ JCaret access$500(JRegisterView jRegisterView) {
        return jRegisterView.m_caret;
    }

    static /* synthetic */ int access$310(JRegisterView jRegisterView) {
        return jRegisterView.m_caretPosition--;
    }

    static /* synthetic */ int access$600(JRegisterView jRegisterView) {
        return jRegisterView.m_highlightedRegister;
    }

    static /* synthetic */ void access$700(JRegisterView jRegisterView, int n2) {
        jRegisterView.enterEditMode(n2);
    }

    static /* synthetic */ BigInteger access$802(JRegisterView jRegisterView, BigInteger bigInteger) {
        jRegisterView.m_editValue = bigInteger;
        return jRegisterView.m_editValue;
    }

    static /* synthetic */ BigInteger access$800(JRegisterView jRegisterView) {
        return jRegisterView.m_editValue;
    }

    static /* synthetic */ int access$900(JRegisterView jRegisterView, int n2, int n3) {
        return jRegisterView.getRegisterNumber(n2, n3);
    }

    static /* synthetic */ IMenuProvider access$1000(JRegisterView jRegisterView) {
        return jRegisterView.m_menuProvider;
    }

    static /* synthetic */ int access$602(JRegisterView jRegisterView, int n2) {
        jRegisterView.m_highlightedRegister = n2;
        return jRegisterView.m_highlightedRegister;
    }

    static /* synthetic */ void access$1100(JRegisterView jRegisterView) {
        jRegisterView.updatePreferredSize();
    }

    static /* synthetic */ void access$1200(JRegisterView jRegisterView) {
        jRegisterView.updateLongestRegisterName();
    }
}

