/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.EGraphLayout;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.LayoutingPanel$1;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public final class LayoutingPanel
extends JPanel {
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 2;
    private final JComboBox initalLayout = new JComboBox();
    private final JComboBox autoLayouting = new JComboBox();
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;

    public LayoutingPanel(String string, ESettingsDialogType eSettingsDialogType) {
        super(new BorderLayout());
        Preconditions.checkNotNull(string);
        if (eSettingsDialogType == null) throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        if (eSettingsDialogType == ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        }
        this.dialogType = eSettingsDialogType;
        this.settings = null;
        this.init(string);
    }

    public LayoutingPanel(String string, ESettingsDialogType eSettingsDialogType, GraphSettings graphSettings) {
        super(new BorderLayout());
        Preconditions.checkNotNull(string);
        if (eSettingsDialogType == null) throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        if (eSettingsDialogType != ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        }
        this.dialogType = eSettingsDialogType;
        this.settings = graphSettings;
        this.init(string);
    }

    private boolean getAutoLayouting(BinDiffConfigFile binDiffConfigFile) {
        switch (LayoutingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getAutoLayouting();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getAutoLayouting();
            }
        }
        return this.settings.getLayoutSettings().getAutomaticLayouting();
    }

    private EGraphLayout getDefaultGraphLayout(BinDiffConfigFile binDiffConfigFile) {
        switch (LayoutingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return EGraphLayout.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getDefaultGraphLayout());
            }
            case 2: {
                return EGraphLayout.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getDefaultGraphLayout());
            }
        }
        return this.settings.getLayoutSettings().getDefaultGraphLayout();
    }

    private void init(String string) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.initalLayout.addItem("Hierarchical");
        this.initalLayout.addItem("Orthogonal");
        this.initalLayout.addItem("Circular");
        this.autoLayouting.addItem("On");
        this.autoLayouting.addItem("Off");
        this.setCurrentValues();
        JPanel jPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        jPanel.setBorder(new TitledBorder(string));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Default layout", 275, this.initalLayout, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Automatic layouting", 275, this.autoLayouting, 25));
        this.add((Component)jPanel, "North");
    }

    public boolean getAutoLayouting() {
        if (this.autoLayouting.getSelectedIndex() != 0) return false;
        return true;
    }

    public EGraphLayout getDefaultLayout() {
        return EGraphLayout.getEnum(this.initalLayout.getSelectedIndex());
    }

    public void getDefaultLayout(EGraphLayout eGraphLayout) {
        this.initalLayout.setSelectedIndex(EGraphLayout.getOrdinal(eGraphLayout));
    }

    public void setAutoLayouting(boolean bl2) {
        this.autoLayouting.setSelectedIndex(bl2 ? 0 : 1);
    }

    public void setCurrentValues() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        this.initalLayout.setSelectedIndex(EGraphLayout.getOrdinal(this.getDefaultGraphLayout(binDiffConfigFile)));
        this.autoLayouting.setSelectedIndex(this.getAutoLayouting(binDiffConfigFile) ? 0 : 1);
    }
}

