package org.jfree.ui;

import org.jfree.date.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class SerialDateChooserPanel extends JPanel implements ActionListener
{
    public static final Color DEFAULT_DATE_BUTTON_COLOR;
    public static final Color DEFAULT_MONTH_BUTTON_COLOR;
    private SerialDate date;
    private Color dateButtonColor;
    private Color monthButtonColor;
    private Color chosenOtherButtonColor;
    private int firstDayOfWeek;
    private int yearSelectionRange;
    private Font dateFont;
    private JComboBox monthSelector;
    private JComboBox yearSelector;
    private JButton todayButton;
    private JButton[] buttons;
    private boolean refreshing;
    
    public SerialDateChooserPanel() {
        this(SerialDate.createInstance(new Date()), false, SerialDateChooserPanel.DEFAULT_DATE_BUTTON_COLOR, SerialDateChooserPanel.DEFAULT_MONTH_BUTTON_COLOR);
    }
    
    public SerialDateChooserPanel(final SerialDate serialDate, final boolean b) {
        this(serialDate, b, SerialDateChooserPanel.DEFAULT_DATE_BUTTON_COLOR, SerialDateChooserPanel.DEFAULT_MONTH_BUTTON_COLOR);
    }
    
    public SerialDateChooserPanel(final SerialDate date, final boolean b, final Color dateButtonColor, final Color monthButtonColor) {
        super(new BorderLayout());
        this.chosenOtherButtonColor = Color.darkGray;
        this.firstDayOfWeek = 1;
        this.yearSelectionRange = 20;
        this.dateFont = new Font("SansSerif", 0, 10);
        this.monthSelector = null;
        this.yearSelector = null;
        this.todayButton = null;
        this.buttons = null;
        this.refreshing = false;
        this.date = date;
        this.dateButtonColor = dateButtonColor;
        this.monthButtonColor = monthButtonColor;
        this.add(this.constructSelectionPanel(), "North");
        this.add(this.getCalendarPanel(), "Center");
        if (b) {
            this.add(this.constructControlPanel(), "South");
        }
    }
    
    public void setDate(final SerialDate date) {
        this.date = date;
        this.monthSelector.setSelectedIndex(date.getMonth() - 1);
        this.refreshYearSelector();
        this.refreshButtons();
    }
    
    public SerialDate getDate() {
        return this.date;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("monthSelectionChanged")) {
            this.date = SerialDate.createInstance(this.date.getDayOfMonth(), ((JComboBox)actionEvent.getSource()).getSelectedIndex() + 1, this.date.getYYYY());
            this.refreshButtons();
        }
        else if (actionEvent.getActionCommand().equals("yearSelectionChanged")) {
            if (!this.refreshing) {
                this.date = SerialDate.createInstance(this.date.getDayOfMonth(), this.date.getMonth(), (int)((JComboBox)actionEvent.getSource()).getSelectedItem());
                this.refreshYearSelector();
                this.refreshButtons();
            }
        }
        else if (actionEvent.getActionCommand().equals("todayButtonClicked")) {
            this.setDate(SerialDate.createInstance(new Date()));
        }
        else if (actionEvent.getActionCommand().equals("dateButtonClicked")) {
            this.setDate(SerialDate.addDays(Integer.parseInt(((JButton)actionEvent.getSource()).getName()), this.getFirstVisibleDate()));
        }
    }
    
    private JPanel getCalendarPanel() {
        final JPanel panel = new JPanel(new GridLayout(7, 7));
        panel.add(new JLabel("Sun", 0));
        panel.add(new JLabel("Mon", 0));
        panel.add(new JLabel("Tue", 0));
        panel.add(new JLabel("Wed", 0));
        panel.add(new JLabel("Thu", 0));
        panel.add(new JLabel("Fri", 0));
        panel.add(new JLabel("Sat", 0));
        this.buttons = new JButton[42];
        for (int i = 0; i < 42; ++i) {
            final JButton button = new JButton("");
            button.setMargin(new Insets(1, 1, 1, 1));
            button.setName(Integer.toString(i));
            button.setFont(this.dateFont);
            button.setFocusPainted(false);
            button.setActionCommand("dateButtonClicked");
            button.addActionListener(this);
            panel.add(this.buttons[i] = button);
        }
        return panel;
    }
    
    protected Color getButtonColor(final SerialDate serialDate) {
        if (this.date.equals(this.date)) {
            return this.dateButtonColor;
        }
        if (serialDate.getMonth() == this.date.getMonth()) {
            return this.monthButtonColor;
        }
        return this.chosenOtherButtonColor;
    }
    
    protected SerialDate getFirstVisibleDate() {
        SerialDate serialDate;
        for (serialDate = SerialDate.addDays(-1, SerialDate.createInstance(1, this.date.getMonth(), this.date.getYYYY())); serialDate.getDayOfWeek() != this.getFirstDayOfWeek(); serialDate = SerialDate.addDays(-1, serialDate)) {}
        return serialDate;
    }
    
    private int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }
    
    protected void refreshButtons() {
        SerialDate serialDate = this.getFirstVisibleDate();
        for (int i = 0; i < 42; ++i) {
            final JButton button = this.buttons[i];
            button.setText(String.valueOf(serialDate.getDayOfWeek()));
            button.setBackground(this.getButtonColor(serialDate));
            serialDate = SerialDate.addDays(1, serialDate);
        }
    }
    
    private void refreshYearSelector() {
        if (!this.refreshing) {
            this.refreshing = true;
            this.yearSelector.removeAllItems();
            final Enumeration<Object> elements = this.getYears(this.date.getYYYY()).elements();
            while (elements.hasMoreElements()) {
                this.yearSelector.addItem(elements.nextElement());
            }
            this.yearSelector.setSelectedItem(new Integer(this.date.getYYYY()));
            this.refreshing = false;
        }
    }
    
    private Vector getYears(final int n) {
        final Vector<Integer> vector = new Vector<Integer>();
        for (int i = n - this.yearSelectionRange; i <= n + this.yearSelectionRange; ++i) {
            vector.addElement(new Integer(i));
        }
        return vector;
    }
    
    private JPanel constructSelectionPanel() {
        final JPanel panel = new JPanel();
        (this.monthSelector = new JComboBox((E[])SerialDate.getMonths())).addActionListener(this);
        this.monthSelector.setActionCommand("monthSelectionChanged");
        panel.add(this.monthSelector);
        (this.yearSelector = new JComboBox(this.getYears(0))).addActionListener(this);
        this.yearSelector.setActionCommand("yearSelectionChanged");
        panel.add(this.yearSelector);
        return panel;
    }
    
    private JPanel constructControlPanel() {
        final JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        (this.todayButton = new JButton("Today")).addActionListener(this);
        this.todayButton.setActionCommand("todayButtonClicked");
        panel.add(this.todayButton);
        return panel;
    }
    
    static {
        DEFAULT_DATE_BUTTON_COLOR = Color.red;
        DEFAULT_MONTH_BUTTON_COLOR = Color.lightGray;
    }
}
