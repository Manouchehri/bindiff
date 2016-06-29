/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.jfree.date.SerialDate;

public class SerialDateChooserPanel
extends JPanel
implements ActionListener {
    public static final Color DEFAULT_DATE_BUTTON_COLOR = Color.red;
    public static final Color DEFAULT_MONTH_BUTTON_COLOR = Color.lightGray;
    private SerialDate date;
    private Color dateButtonColor;
    private Color monthButtonColor;
    private Color chosenOtherButtonColor = Color.darkGray;
    private int firstDayOfWeek = 1;
    private int yearSelectionRange = 20;
    private Font dateFont = new Font("SansSerif", 0, 10);
    private JComboBox monthSelector = null;
    private JComboBox yearSelector = null;
    private JButton todayButton = null;
    private JButton[] buttons = null;
    private boolean refreshing = false;

    public SerialDateChooserPanel() {
        this(SerialDate.createInstance(new Date()), false, DEFAULT_DATE_BUTTON_COLOR, DEFAULT_MONTH_BUTTON_COLOR);
    }

    public SerialDateChooserPanel(SerialDate serialDate, boolean bl2) {
        this(serialDate, bl2, DEFAULT_DATE_BUTTON_COLOR, DEFAULT_MONTH_BUTTON_COLOR);
    }

    public SerialDateChooserPanel(SerialDate serialDate, boolean bl2, Color color, Color color2) {
        super(new BorderLayout());
        this.date = serialDate;
        this.dateButtonColor = color;
        this.monthButtonColor = color2;
        this.add((Component)this.constructSelectionPanel(), "North");
        this.add((Component)this.getCalendarPanel(), "Center");
        if (!bl2) return;
        this.add((Component)this.constructControlPanel(), "South");
    }

    public void setDate(SerialDate serialDate) {
        this.date = serialDate;
        this.monthSelector.setSelectedIndex(serialDate.getMonth() - 1);
        this.refreshYearSelector();
        this.refreshButtons();
    }

    public SerialDate getDate() {
        return this.date;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("monthSelectionChanged")) {
            JComboBox jComboBox = (JComboBox)actionEvent.getSource();
            this.date = SerialDate.createInstance(this.date.getDayOfMonth(), jComboBox.getSelectedIndex() + 1, this.date.getYYYY());
            this.refreshButtons();
            return;
        }
        if (actionEvent.getActionCommand().equals("yearSelectionChanged")) {
            if (this.refreshing) return;
            JComboBox jComboBox = (JComboBox)actionEvent.getSource();
            Integer n2 = (Integer)jComboBox.getSelectedItem();
            this.date = SerialDate.createInstance(this.date.getDayOfMonth(), this.date.getMonth(), n2);
            this.refreshYearSelector();
            this.refreshButtons();
            return;
        }
        if (actionEvent.getActionCommand().equals("todayButtonClicked")) {
            this.setDate(SerialDate.createInstance(new Date()));
            return;
        }
        if (!actionEvent.getActionCommand().equals("dateButtonClicked")) return;
        JButton jButton = (JButton)actionEvent.getSource();
        int n3 = Integer.parseInt(jButton.getName());
        SerialDate serialDate = this.getFirstVisibleDate();
        SerialDate serialDate2 = SerialDate.addDays(n3, serialDate);
        this.setDate(serialDate2);
    }

    private JPanel getCalendarPanel() {
        JPanel jPanel = new JPanel(new GridLayout(7, 7));
        jPanel.add(new JLabel("Sun", 0));
        jPanel.add(new JLabel("Mon", 0));
        jPanel.add(new JLabel("Tue", 0));
        jPanel.add(new JLabel("Wed", 0));
        jPanel.add(new JLabel("Thu", 0));
        jPanel.add(new JLabel("Fri", 0));
        jPanel.add(new JLabel("Sat", 0));
        this.buttons = new JButton[42];
        int n2 = 0;
        while (n2 < 42) {
            JButton jButton = new JButton("");
            jButton.setMargin(new Insets(1, 1, 1, 1));
            jButton.setName(Integer.toString(n2));
            jButton.setFont(this.dateFont);
            jButton.setFocusPainted(false);
            jButton.setActionCommand("dateButtonClicked");
            jButton.addActionListener(this);
            this.buttons[n2] = jButton;
            jPanel.add(jButton);
            ++n2;
        }
        return jPanel;
    }

    protected Color getButtonColor(SerialDate serialDate) {
        if (this.date.equals(this.date)) {
            return this.dateButtonColor;
        }
        if (serialDate.getMonth() != this.date.getMonth()) return this.chosenOtherButtonColor;
        return this.monthButtonColor;
    }

    protected SerialDate getFirstVisibleDate() {
        SerialDate serialDate = SerialDate.createInstance(1, this.date.getMonth(), this.date.getYYYY());
        serialDate = SerialDate.addDays(-1, serialDate);
        while (serialDate.getDayOfWeek() != this.getFirstDayOfWeek()) {
            serialDate = SerialDate.addDays(-1, serialDate);
        }
        return serialDate;
    }

    private int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    protected void refreshButtons() {
        SerialDate serialDate = this.getFirstVisibleDate();
        int n2 = 0;
        while (n2 < 42) {
            JButton jButton = this.buttons[n2];
            jButton.setText(String.valueOf(serialDate.getDayOfWeek()));
            jButton.setBackground(this.getButtonColor(serialDate));
            serialDate = SerialDate.addDays(1, serialDate);
            ++n2;
        }
    }

    private void refreshYearSelector() {
        if (this.refreshing) return;
        this.refreshing = true;
        this.yearSelector.removeAllItems();
        Vector vector = this.getYears(this.date.getYYYY());
        Enumeration enumeration = vector.elements();
        do {
            if (!enumeration.hasMoreElements()) {
                this.yearSelector.setSelectedItem(new Integer(this.date.getYYYY()));
                this.refreshing = false;
                return;
            }
            this.yearSelector.addItem(enumeration.nextElement());
        } while (true);
    }

    private Vector getYears(int n2) {
        Vector<Integer> vector = new Vector<Integer>();
        int n3 = n2 - this.yearSelectionRange;
        while (n3 <= n2 + this.yearSelectionRange) {
            vector.addElement(new Integer(n3));
            ++n3;
        }
        return vector;
    }

    private JPanel constructSelectionPanel() {
        JPanel jPanel = new JPanel();
        this.monthSelector = new JComboBox<String>(SerialDate.getMonths());
        this.monthSelector.addActionListener(this);
        this.monthSelector.setActionCommand("monthSelectionChanged");
        jPanel.add(this.monthSelector);
        this.yearSelector = new JComboBox(this.getYears(0));
        this.yearSelector.addActionListener(this);
        this.yearSelector.setActionCommand("yearSelectionChanged");
        jPanel.add(this.yearSelector);
        return jPanel;
    }

    private JPanel constructControlPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        this.todayButton = new JButton("Today");
        this.todayButton.addActionListener(this);
        this.todayButton.setActionCommand("todayButtonClicked");
        jPanel.add(this.todayButton);
        return jPanel;
    }
}

