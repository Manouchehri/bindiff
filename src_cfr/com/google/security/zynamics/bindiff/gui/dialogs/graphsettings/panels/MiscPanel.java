/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.EGraphSynchronization;
import com.google.security.zynamics.bindiff.graph.settings.GraphDisplaySettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.MiscPanel$1;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.sliders.DoubleLabeledSlider;
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

public class MiscPanel
extends JPanel {
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 4;
    private final JComboBox viewSynchronization = new JComboBox();
    private final JComboBox gradientBackground = new JComboBox();
    private final JComboBox layoutAnimation = new JComboBox();
    private final DoubleLabeledSlider animationSpeed = new DoubleLabeledSlider("  Slow  ", "  Fast  ", 1, 10, false, new LineBorder(Color.GRAY));
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;

    public MiscPanel(String string, ESettingsDialogType eSettingsDialogType) {
        super(new BorderLayout());
        Preconditions.checkNotNull(string);
        if (eSettingsDialogType == null) throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        if (eSettingsDialogType == ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        }
        this.dialogType = eSettingsDialogType;
        this.settings = null;
        this.animationSpeed.setInverted(true);
        this.init(string);
    }

    public MiscPanel(String string, ESettingsDialogType eSettingsDialogType, GraphSettings graphSettings) {
        super(new BorderLayout());
        Preconditions.checkNotNull(string);
        if (eSettingsDialogType == null) throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        if (eSettingsDialogType != ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        }
        this.dialogType = eSettingsDialogType;
        this.settings = graphSettings;
        this.animationSpeed.setInverted(true);
        this.init(string);
    }

    private int getAnimationSpeed(BinDiffConfigFile binDiffConfigFile) {
        switch (MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getAnimationSpeed();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getAnimationSpeed();
            }
        }
        return this.settings.getDisplaySettings().getAnimationSpeed();
    }

    private boolean getGradientBackground(BinDiffConfigFile binDiffConfigFile) {
        switch (MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getGradientBackground();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getGradientBackground();
            }
        }
        return this.settings.getDisplaySettings().getGradientBackground();
    }

    private boolean getLayoutAnimation(BinDiffConfigFile binDiffConfigFile) {
        switch (MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getLayoutAnimation();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getLayoutAnimation();
            }
        }
        return this.settings.getLayoutSettings().getAnimateLayout();
    }

    private boolean getViewSynchronization(BinDiffConfigFile binDiffConfigFile) {
        switch (MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getViewSynchronization();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getViewSynchronization();
            }
        }
        if (this.settings.getGraphSyncMode() != EGraphSynchronization.SYNC) return false;
        return true;
    }

    private void init(String string) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.viewSynchronization.addItem("On");
        this.viewSynchronization.addItem("Off");
        this.gradientBackground.addItem("On");
        this.gradientBackground.addItem("Off");
        this.layoutAnimation.addItem("On");
        this.layoutAnimation.addItem("Off");
        this.setCurrentValues();
        int n2 = this.dialogType != ESettingsDialogType.NON_INITIAL ? 4 : 3;
        JPanel jPanel = new JPanel(new GridLayout(n2, 1, 5, 5));
        jPanel.setBorder(new TitledBorder(string));
        if (this.dialogType != ESettingsDialogType.NON_INITIAL) {
            jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Views synchronization", 275, this.viewSynchronization, 25));
        }
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Gradient background", 275, this.gradientBackground, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Layout animation", 275, this.layoutAnimation, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Animation speed", 275, this.animationSpeed, 25));
        this.add((Component)jPanel, "North");
    }

    public int getAnimationSpeed() {
        return this.animationSpeed.getValue();
    }

    public boolean getGradientBackground() {
        if (this.gradientBackground.getSelectedIndex() != 0) return false;
        return true;
    }

    public boolean getLayoutAnimation() {
        if (this.layoutAnimation.getSelectedIndex() != 0) return false;
        return true;
    }

    public boolean getViewSynchronization() {
        if (this.viewSynchronization.getSelectedIndex() != 0) return false;
        return true;
    }

    public void setCurrentValues() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        this.viewSynchronization.setSelectedIndex(this.getViewSynchronization(binDiffConfigFile) ? 0 : 1);
        this.gradientBackground.setSelectedIndex(this.getGradientBackground(binDiffConfigFile) ? 0 : 1);
        this.layoutAnimation.setSelectedIndex(this.getLayoutAnimation(binDiffConfigFile) ? 0 : 1);
        this.animationSpeed.setValue(this.getAnimationSpeed(binDiffConfigFile));
    }
}

