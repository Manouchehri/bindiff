/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog$InternalCancelButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog$InternalOkButtonListener;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ViewSearchOptionsDialog
extends BaseDialog {
    private static final ImageIcon APP_ICON = ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png");
    private final ViewSearchOptionsDialog$InternalOkButtonListener okButtonListener;
    private final ViewSearchOptionsDialog$InternalCancelButtonListener cancelButtonListener;
    private final JButton okButton;
    private final JButton cancelButton;
    private final JCheckBox regExBox;
    private final JCheckBox caseSensitiveBox;
    private final JCheckBox primarySideBox;
    private final JCheckBox secondarySideBox;
    private final JCheckBox tempViewTables;
    private boolean okButtonPressed;

    public ViewSearchOptionsDialog(Window window, String string, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        super(window, string);
        this.okButtonListener = new ViewSearchOptionsDialog$InternalOkButtonListener(this, null);
        this.cancelButtonListener = new ViewSearchOptionsDialog$InternalCancelButtonListener(this, null);
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.okButtonPressed = false;
        this.setIconImage(APP_ICON.getImage());
        this.okButton.addActionListener(this.okButtonListener);
        this.cancelButton.addActionListener(this.cancelButtonListener);
        this.regExBox = new JCheckBox("Regular Expression", bl2);
        this.caseSensitiveBox = new JCheckBox("Case sensitive", bl3);
        this.primarySideBox = new JCheckBox("Primary Side", bl4);
        this.secondarySideBox = new JCheckBox("Secondary Side", bl5);
        this.tempViewTables = new JCheckBox("Only search in last temporary search result table", bl6);
        this.init();
        GuiHelper.centerChildToParent(window, this, true);
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel jPanel2 = new JPanel(new GridLayout(2, 1));
        jPanel2.setBorder(new TitledBorder(""));
        jPanel2.add(this.regExBox);
        jPanel2.add(this.caseSensitiveBox);
        JPanel jPanel3 = new JPanel(new GridLayout(2, 1));
        jPanel3.setBorder(new TitledBorder(""));
        jPanel3.add(this.primarySideBox);
        jPanel3.add(this.secondarySideBox);
        JPanel jPanel4 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel4.add(jPanel2);
        jPanel4.add(jPanel3);
        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel5.add((Component)jPanel4, "Center");
        JPanel jPanel6 = new JPanel(new BorderLayout());
        jPanel6.setBorder(new EmptyBorder(5, 0, 0, 0));
        jPanel6.add((Component)this.tempViewTables, "Center");
        jPanel5.add((Component)jPanel6, "South");
        JPanel jPanel7 = new JPanel(new BorderLayout());
        jPanel7.setBorder(new EmptyBorder(10, 0, 0, 0));
        JPanel jPanel8 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel8.add(this.okButton);
        jPanel8.add(this.cancelButton);
        jPanel7.add((Component)jPanel8, "East");
        jPanel.add((Component)jPanel5, "Center");
        jPanel.add((Component)jPanel7, "South");
        this.add((Component)jPanel, "Center");
        this.pack();
        this.setMinimumSize(new Dimension(this.getPreferredSize().width, this.getPreferredSize().height));
        this.setResizable(false);
    }

    public void disableSideCheckboxes() {
        this.primarySideBox.setEnabled(false);
        this.secondarySideBox.setEnabled(false);
    }

    @Override
    public void dispose() {
        this.okButton.removeActionListener(this.okButtonListener);
        this.cancelButton.removeActionListener(this.cancelButtonListener);
        super.dispose();
    }

    public boolean getCaseSensitiveSelected() {
        return this.caseSensitiveBox.isSelected();
    }

    public boolean getOkButtonPressed() {
        return this.okButtonPressed;
    }

    public boolean getPrimarySideSearch() {
        return this.primarySideBox.isSelected();
    }

    public boolean getRegExSelected() {
        return this.regExBox.isSelected();
    }

    public boolean getSecondarySideSearch() {
        return this.secondarySideBox.isSelected();
    }

    public boolean getTemporaryTableUse() {
        return this.tempViewTables.isSelected();
    }

    static /* synthetic */ boolean access$202(ViewSearchOptionsDialog viewSearchOptionsDialog, boolean bl2) {
        viewSearchOptionsDialog.okButtonPressed = bl2;
        return viewSearchOptionsDialog.okButtonPressed;
    }
}

