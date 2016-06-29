/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.EdgesPanel$1;
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

public class EdgesPanel
extends JPanel {
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 1;
    private final JComboBox drawBends = new JComboBox();
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;

    public EdgesPanel(String string, ESettingsDialogType eSettingsDialogType) {
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

    public EdgesPanel(String string, ESettingsDialogType eSettingsDialogType, GraphSettings graphSettings) {
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

    private boolean getDrawBends(BinDiffConfigFile binDiffConfigFile) {
        switch (EdgesPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getDrawBends();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getDrawBends();
            }
        }
        return this.settings.getDrawBends();
    }

    private void init(String string) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.drawBends.addItem("On");
        this.drawBends.addItem("Off");
        this.setCurrentValues();
        JPanel jPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        jPanel.setBorder(new TitledBorder(string));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Draw bends", 275, this.drawBends, 25));
        this.add((Component)jPanel, "North");
    }

    public boolean getDrawBends() {
        if (this.drawBends.getSelectedIndex() != 0) return false;
        return true;
    }

    public void setCurrentValues() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        this.drawBends.setSelectedIndex(this.getDrawBends(binDiffConfigFile) ? 0 : 1);
    }
}

