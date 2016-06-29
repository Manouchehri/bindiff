/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.components.SliderPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.ProximityBrowsingPanel$1;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CDecFormatter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;

public class ProximityBrowsingPanel
extends JPanel {
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 5;
    private static final int SLIDER_MIN = 0;
    private static final int SLIDER_MAX = 10;
    private static final int SLIDER_LABEL_WIDTH = 25;
    private final JComboBox proximityBrowsing = new JComboBox();
    private final SliderPanel proximityBrowsingParentDepth = new SliderPanel(0, 0, 10, true, true, false, true, 25, 25);
    private final SliderPanel proximityBrowsingChildDepth = new SliderPanel(0, 0, 10, true, true, false, true, 25, 25);
    private final JFormattedTextField autoProximityBrowsingActivionThreshold = new JFormattedTextField(new DefaultFormatterFactory(new CDecFormatter(5)));
    private final JFormattedTextField visibilityWarningThreshold = new JFormattedTextField(new DefaultFormatterFactory(new CDecFormatter(5)));
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;

    public ProximityBrowsingPanel(String string, ESettingsDialogType eSettingsDialogType) {
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

    public ProximityBrowsingPanel(String string, ESettingsDialogType eSettingsDialogType, GraphSettings graphSettings) {
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

    private int getAutoProximityBrowsingActivationThreshold(BinDiffConfigFile binDiffConfigFile) {
        switch (ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getAutoProximityBrowsingActivationThreshold();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getAutoProximityBrowsingActivationThreshold();
            }
        }
        return this.settings.getProximitySettings().getAutoProximityBrowsingActivationThreshold();
    }

    private boolean getProximityBrowsing(BinDiffConfigFile binDiffConfigFile) {
        switch (ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getProximityBrowsing();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getProximityBrowsing();
            }
        }
        return this.settings.getProximitySettings().getProximityBrowsing();
    }

    private int getProximityBrowsingChildDepth(BinDiffConfigFile binDiffConfigFile) {
        switch (ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getProximityBrowsingChildDepth();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getProximityBrowsingChildDepth();
            }
        }
        return this.settings.getProximitySettings().getProximityBrowsingChildren();
    }

    private int getProximityBrowsingParentDepth(BinDiffConfigFile binDiffConfigFile) {
        switch (ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getProximityBrowsingParentDepth();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getProximityBrowsingParentDepth();
            }
        }
        return this.settings.getProximitySettings().getProximityBrowsingParents();
    }

    private int getVisibilityWarningThreshold(BinDiffConfigFile binDiffConfigFile) {
        switch (ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getVisibilityWarningThreshold();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getVisibilityWarningThreshold();
            }
        }
        return this.settings.getLayoutSettings().getVisibilityWarningThreshold();
    }

    private void init(String string) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.proximityBrowsing.addItem("On");
        this.proximityBrowsing.addItem("Off");
        this.setCurrentValues();
        int n2 = this.dialogType != ESettingsDialogType.NON_INITIAL ? 5 : 3;
        JPanel jPanel = new JPanel(new GridLayout(n2, 1, 5, 5));
        jPanel.setBorder(new TitledBorder(string));
        if (this.dialogType != ESettingsDialogType.NON_INITIAL) {
            jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Automatic proximity browsing", 275, this.proximityBrowsing, 25));
        }
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Proximity browsing parent depth", 275, this.proximityBrowsingParentDepth, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Proximity browsing child depth", 275, this.proximityBrowsingChildDepth, 25));
        if (this.dialogType != ESettingsDialogType.NON_INITIAL) {
            jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Automatic proximity browsing activation threshold", 275, this.autoProximityBrowsingActivionThreshold, 25));
        }
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Visibility Warning threshold", 275, this.visibilityWarningThreshold, 25));
        this.add((Component)jPanel, "North");
    }

    public void dispose() {
        this.proximityBrowsingParentDepth.dispose();
        this.proximityBrowsingChildDepth.dispose();
    }

    public int getAutoProximityBrowsingActivationThreshold() {
        return Integer.parseInt(this.autoProximityBrowsingActivionThreshold.getText());
    }

    public boolean getProximityBrowsing() {
        if (this.proximityBrowsing.getSelectedIndex() != 0) return false;
        return true;
    }

    public int getProximityBrowsingChildDepth() {
        return this.proximityBrowsingChildDepth.getValue();
    }

    public int getProximityBrowsingParentDepth() {
        return this.proximityBrowsingParentDepth.getValue();
    }

    public int getVisibilityWarningThreshold() {
        return Integer.parseInt(this.visibilityWarningThreshold.getText());
    }

    public void setCurrentValues() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        this.proximityBrowsing.setSelectedIndex(this.getProximityBrowsing(binDiffConfigFile) ? 0 : 1);
        this.proximityBrowsingParentDepth.setValue(this.getProximityBrowsingParentDepth(binDiffConfigFile));
        this.proximityBrowsingChildDepth.setValue(this.getProximityBrowsingChildDepth(binDiffConfigFile));
        this.autoProximityBrowsingActivionThreshold.setText(Integer.toString(this.getAutoProximityBrowsingActivationThreshold(binDiffConfigFile)));
        this.visibilityWarningThreshold.setText(Integer.toString(this.getVisibilityWarningThreshold(binDiffConfigFile)));
    }
}

