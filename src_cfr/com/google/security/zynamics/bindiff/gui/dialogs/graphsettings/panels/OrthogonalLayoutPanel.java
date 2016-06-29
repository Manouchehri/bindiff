/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.ELayoutOrientation;
import com.google.security.zynamics.bindiff.enums.EOrthogonalLayoutStyle;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.OrthogonalLayoutPanel$1;
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

public class OrthogonalLayoutPanel
extends JPanel {
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 3;
    private final JComboBox orientation = new JComboBox();
    private final JComboBox layoutStyle = new JComboBox();
    private final JFormattedTextField minimumNodeDistance = new JFormattedTextField(new DefaultFormatterFactory(new CDecFormatter(3)));
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;

    public OrthogonalLayoutPanel(String string, ESettingsDialogType eSettingsDialogType) {
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

    public OrthogonalLayoutPanel(String string, ESettingsDialogType eSettingsDialogType, GraphSettings graphSettings) {
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

    private int getMinimumNodeDistance(BinDiffConfigFile binDiffConfigFile) {
        switch (OrthogonalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getOrthogonalMinimumNodeDistance();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getOrthogonalMinimumNodeDistance();
            }
        }
        return (int)this.settings.getLayoutSettings().getMinimumOrthogonalNodeDistance();
    }

    private EOrthogonalLayoutStyle getOrthogonalLayoutStyle(BinDiffConfigFile binDiffConfigFile) {
        switch (OrthogonalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return EOrthogonalLayoutStyle.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getOrthogonalLayoutStyle());
            }
            case 2: {
                return EOrthogonalLayoutStyle.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getOrthogonalLayoutStyle());
            }
        }
        return this.settings.getLayoutSettings().getOrthogonalLayoutStyle();
    }

    private ELayoutOrientation getOrthogonalOrientation(BinDiffConfigFile binDiffConfigFile) {
        switch (OrthogonalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return ELayoutOrientation.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getOrthogonalOrientation());
            }
            case 2: {
                return ELayoutOrientation.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getOrthogonalOrientation());
            }
        }
        return this.settings.getLayoutSettings().getOrthogonalLayoutOrientation();
    }

    private void init(String string) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.layoutStyle.addItem("Normal");
        this.layoutStyle.addItem("Tree");
        this.orientation.addItem("Horizontal");
        this.orientation.addItem("Vertical");
        this.setCurrentValues();
        JPanel jPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        jPanel.setBorder(new TitledBorder(string));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Layout Style", 275, this.layoutStyle, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Layout orientation", 275, this.orientation, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Minimum node distance", 275, this.minimumNodeDistance, 25));
        this.add((Component)jPanel, "North");
    }

    public int getMinimumNodeDistance() {
        return Integer.parseInt(this.minimumNodeDistance.getText());
    }

    public EOrthogonalLayoutStyle getOrthogonalLayoutStyle() {
        return EOrthogonalLayoutStyle.getEnum(this.layoutStyle.getSelectedIndex());
    }

    public ELayoutOrientation getOrthogonalOrientation() {
        return ELayoutOrientation.getEnum(this.orientation.getSelectedIndex());
    }

    public void setCurrentValues() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        this.layoutStyle.setSelectedIndex(EOrthogonalLayoutStyle.getOrdinal(this.getOrthogonalLayoutStyle(binDiffConfigFile)));
        this.orientation.setSelectedIndex(ELayoutOrientation.getOrdinal(this.getOrthogonalOrientation(binDiffConfigFile)));
        this.minimumNodeDistance.setText(Integer.toString(this.getMinimumNodeDistance(binDiffConfigFile)));
    }
}

