/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.ECircularLayoutStyle;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.CircularLayoutPanel$1;
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

public class CircularLayoutPanel
extends JPanel {
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 2;
    private final JComboBox layoutStyle = new JComboBox();
    private final JFormattedTextField minimumNodeDistance = new JFormattedTextField(new DefaultFormatterFactory(new CDecFormatter(3)));
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;

    public CircularLayoutPanel(String string, ESettingsDialogType eSettingsDialogType) {
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

    public CircularLayoutPanel(String string, ESettingsDialogType eSettingsDialogType, GraphSettings graphSettings) {
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

    private ECircularLayoutStyle getCircularLayoutStyle(BinDiffConfigFile binDiffConfigFile) {
        switch (CircularLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return ECircularLayoutStyle.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getCircularLayoutStyle());
            }
            case 2: {
                return ECircularLayoutStyle.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getCircularLayoutStyle());
            }
        }
        return this.settings.getLayoutSettings().getCircularLayoutStyle();
    }

    private int getMinimumNodeDistance(BinDiffConfigFile binDiffConfigFile) {
        switch (CircularLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getCircularMinimumNodeDistance();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getCircularMinimumNodeDistance();
            }
        }
        return (int)this.settings.getLayoutSettings().getMinimumCircularNodeDistance();
    }

    private void init(String string) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.layoutStyle.addItem("Compact");
        this.layoutStyle.addItem("Isolated");
        this.layoutStyle.addItem("Single Cycle");
        this.setCurrentValues();
        JPanel jPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        jPanel.setBorder(new TitledBorder(string));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Layout style", 275, this.layoutStyle, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Preferred node distance", 275, this.minimumNodeDistance, 25));
        this.add((Component)jPanel, "North");
    }

    public ECircularLayoutStyle getCircularLayoutStyle() {
        return ECircularLayoutStyle.getEnum(this.layoutStyle.getSelectedIndex());
    }

    public int getMinimumNodeDistance() {
        return Integer.parseInt(this.minimumNodeDistance.getText());
    }

    public void setCurrentValues() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        this.layoutStyle.setSelectedIndex(ECircularLayoutStyle.getOrdinal(this.getCircularLayoutStyle(binDiffConfigFile)));
        this.minimumNodeDistance.setText(Integer.toString(this.getMinimumNodeDistance(binDiffConfigFile)));
    }
}

