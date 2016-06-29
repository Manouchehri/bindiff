package com.google.security.zynamics.zylib.gui.JRegisterView;

import javax.swing.*;
import java.math.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.JCaret.*;
import java.util.*;
import java.awt.*;

public class JRegisterView extends JPanel implements Scrollable
{
    private static final long serialVersionUID = -918576778293064213L;
    private final Font m_font;
    private final IRegisterModel m_registerModel;
    private int m_longestRegisterName;
    private int m_highlightedRegister;
    private int m_charWidth;
    private final Color m_modifiedColor;
    private final Color m_textColor;
    private static final int m_paddingLeft = 10;
    private final Color m_bgColorEdit;
    private final Color m_bgColorHighlight;
    private int m_editedRegister;
    private final JCaret m_caret;
    private int m_caretPosition;
    private BigInteger m_editValue;
    private final Color m_backgroundColor;
    private final Color m_disabledColor;
    private IMenuProvider m_menuProvider;
    private final JRegisterView$InternalListener m_listener;
    
    public JRegisterView(final IRegisterModel registerModel) {
        this.m_font = new Font(GuiHelper.getMonospaceFont(), 0, 12);
        this.m_longestRegisterName = 0;
        this.m_highlightedRegister = -1;
        this.m_modifiedColor = Color.RED;
        this.m_textColor = Color.BLACK;
        this.m_bgColorEdit = new Color(16765152);
        this.m_bgColorHighlight = Color.WHITE;
        this.m_editedRegister = -1;
        this.m_caret = new JCaret();
        this.m_caretPosition = 0;
        this.m_editValue = BigInteger.ZERO;
        this.m_backgroundColor = new Color(13421823);
        this.m_disabledColor = Color.GRAY;
        this.m_listener = new JRegisterView$InternalListener(this, null);
        Preconditions.checkNotNull(registerModel, (Object)"Error: Argument registerModel can't be null");
        registerModel.addListener(this.m_listener);
        this.setFocusable(true);
        this.setOpaque(true);
        this.initializeListeners();
        this.m_registerModel = registerModel;
        this.updateLongestRegisterName();
        this.setBackground(this.m_backgroundColor);
        this.updatePreferredSize();
    }
    
    private void drawCaret(final Graphics graphics) {
        if (this.hasFocus() && this.m_editedRegister != -1) {
            final Rectangle registerBounds = this.getRegisterBounds(this.m_editedRegister);
            this.m_caret.draw(graphics, registerBounds.x + this.m_caretPosition * this.m_charWidth + this.m_longestRegisterName * this.m_charWidth + 5 - 1, registerBounds.y, this.m_font.getSize());
        }
    }
    
    private void drawHighlightedRegister(final Graphics graphics) {
        if (!this.isEnabled()) {
            return;
        }
        if (this.m_editedRegister != -1) {
            graphics.setColor(this.m_bgColorEdit);
            final Rectangle registerBounds = this.getRegisterBounds(this.m_editedRegister);
            graphics.fillRect(registerBounds.x, registerBounds.y, registerBounds.width, registerBounds.height);
        }
        else if (this.m_highlightedRegister != -1) {
            graphics.setColor(this.m_bgColorHighlight);
            final Rectangle registerBounds2 = this.getRegisterBounds(this.m_highlightedRegister);
            graphics.fillRect(registerBounds2.x, registerBounds2.y, registerBounds2.width, registerBounds2.height);
        }
    }
    
    private void drawRegisters(final Graphics graphics) {
        int n = this.m_font.getSize() + 5;
        final int size = this.m_font.getSize();
        int n2 = 0;
        for (final RegisterInformationInternal registerInformationInternal : this.m_registerModel.getRegisterInformation()) {
            if (this.isEnabled()) {
                graphics.setColor((registerInformationInternal.isModified() || n2 == this.m_editedRegister) ? this.m_modifiedColor : this.m_textColor);
            }
            else {
                graphics.setColor(this.m_disabledColor);
            }
            graphics.drawString(registerInformationInternal.getRegisterName(), 10, n);
            final BigInteger and = ((n2 == this.m_editedRegister) ? this.m_editValue : registerInformationInternal.getValue()).and((registerInformationInternal.getRegisterSize() == 8) ? BigInteger.valueOf(Long.MAX_VALUE) : BigInteger.valueOf(4294967295L));
            String s;
            if (registerInformationInternal.getRegisterSize() != 0) {
                s = String.format(new StringBuilder(14).append("%0").append(2 * registerInformationInternal.getRegisterSize()).append("X").toString(), and);
            }
            else {
                s = String.valueOf(and.and(BigInteger.ONE));
            }
            graphics.drawString(s, 15 + this.m_charWidth * this.m_longestRegisterName, n);
            ++n2;
            n += size;
        }
    }
    
    private void enterEditMode(final int editedRegister) {
        this.requestFocusInWindow();
        this.m_caret.setVisible(true);
        this.m_editedRegister = editedRegister;
        this.m_caretPosition = 0;
        this.m_editValue = this.m_registerModel.getRegisterInformation(editedRegister).getValue();
        this.repaint();
    }
    
    private Rectangle getRegisterBounds(final int n) {
        return new Rectangle(10, 7 + n * this.m_font.getSize(), 5 + this.m_charWidth * (this.m_longestRegisterName + this.m_registerModel.getRegisterInformation(n).getRegisterSize() * 2), this.m_font.getSize() - 1);
    }
    
    private int getRegisterNumber(final int n, final int n2) {
        final int size = this.m_font.getSize();
        if (n2 >= 7 && n2 <= 7 + size * this.m_registerModel.getNumberOfRegisters()) {
            final int min = Math.min((n2 - 7) / size, this.m_registerModel.getNumberOfRegisters() - 1);
            if (min == -1) {
                return -1;
            }
            final RegisterInformationInternal registerInformation = this.m_registerModel.getRegisterInformation(min);
            final int n3 = 15 + this.m_charWidth * (this.m_longestRegisterName + ((registerInformation.getRegisterSize() == 0) ? 1 : (registerInformation.getRegisterSize() * 2)));
            if (n >= 10 && n <= n3) {
                return min;
            }
        }
        return -1;
    }
    
    private void initializeListeners() {
        this.addMouseListener(this.m_listener);
        this.addMouseMotionListener(this.m_listener);
        this.addKeyListener(this.m_listener);
        this.addFocusListener(this.m_listener);
        this.m_caret.addCaretListener(this.m_listener);
    }
    
    private void leaveEditMode(final boolean b) {
        if (b) {
            final RegisterInformationInternal registerInformation = this.m_registerModel.getRegisterInformation(this.m_editedRegister);
            if (!Objects.equals(this.m_editValue, registerInformation.getValue())) {
                this.beginRegisterUpdate();
                this.m_registerModel.setValue(registerInformation.getRegisterName(), this.m_editValue);
                this.endRegisterUpdate();
            }
        }
        this.m_caret.setVisible(false);
        this.m_editedRegister = -1;
        this.m_caretPosition = 0;
        this.repaint();
    }
    
    private void updateLongestRegisterName() {
        this.m_longestRegisterName = Integer.MIN_VALUE;
        for (final RegisterInformationInternal registerInformationInternal : this.m_registerModel.getRegisterInformation()) {
            if (registerInformationInternal.getRegisterName().length() > this.m_longestRegisterName) {
                this.m_longestRegisterName = registerInformationInternal.getRegisterName().length();
            }
        }
    }
    
    private void updatePreferredSize() {
        this.setPreferredSize(new Dimension(200, this.m_font.getSize() + 5 + this.m_registerModel.getNumberOfRegisters() * this.m_font.getSize()));
        this.revalidate();
        this.updateUI();
    }
    
    @Override
    protected void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setFont(this.m_font);
        this.m_charWidth = (int)graphics.getFontMetrics().getStringBounds("0", graphics).getWidth();
        if (this.m_registerModel != null) {
            this.drawHighlightedRegister(graphics);
            this.drawRegisters(graphics);
            if (this.m_caret.isVisible()) {
                this.drawCaret(graphics);
            }
        }
    }
    
    public void beginRegisterUpdate() {
        final RegisterInformationInternal[] registerInformation = this.m_registerModel.getRegisterInformation();
        for (int length = registerInformation.length, i = 0; i < length; ++i) {
            registerInformation[i].setModified(false);
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
    public int getScrollableBlockIncrement(final Rectangle rectangle, final int n, final int n2) {
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
    public int getScrollableUnitIncrement(final Rectangle rectangle, final int n, final int n2) {
        return this.m_font.getSize();
    }
    
    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        this.repaint();
    }
    
    public void setMenuProvider(final IMenuProvider menuProvider) {
        this.m_menuProvider = menuProvider;
    }
}
