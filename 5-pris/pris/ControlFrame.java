/*
 * ControlFrame.java   --   created on Jan 23, 2012, 4:18:47 PM
 * @author levenick
 */
package pris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ControlFrame extends JFrame {

    PrisFrame thePrisFrame;

    public ControlFrame(PrisFrame f) {
        thePrisFrame = f;
        initComponents();
        setSize(500, 500);
        setVisible(true);
        update();
    }

    void setSlider(JSlider aSlider, JTextField aTF) {
        aSlider.setValue(Integer.parseInt(aTF.getText()));
    }

    void setTF(JSlider aSlider, JTextField aTF) {
        aTF.setText("" + aSlider.getValue());
    }

    void update() {
        Params.delay = delaySlider.getValue();
        Params.size = sizeSlider.getValue();
        Params.ccPayoff = ccSlider.getValue();
        Params.dcPayoff = dcSlider.getValue();
        Params.ddPayoff = ddSlider.getValue();
        Params.rounds = roundsSlider.getValue();
        Params.percentCoop = percentSlider.getValue();

        setTF(delaySlider, delayTF);
        setTF(sizeSlider, sizeTF);
        setTF(ccSlider, ccTF);
        setTF(dcSlider, dcTF);
        setTF(ddSlider, ddTF);
        setTF(roundsSlider, roundsTF);
        setTF(percentSlider, percentTF);
    }

    private void initComponents() {

        goStopButton = new JButton();
        delaySlider = new JSlider();
        delayTF = new JTextField();
        sizeTF = new JTextField();
        sizeSlider = new JSlider();
        ccSlider = new JSlider();
        ccTF = new JTextField();
        dcSlider = new JSlider();
        dcTF = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        stepButton = new JButton();
        ddSlider = new JSlider();
        ddTF = new JTextField();
        jLabel5 = new JLabel();
        roundsSlider = new JSlider();
        roundsTF = new JTextField();
        jLabel6 = new JLabel();
        percentSlider = new JSlider();
        percentTF = new JTextField();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        goStopButton.setText("go");
        goStopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                goStopButtonActionPerformed(evt);
            }
        });
        add(goStopButton);

        delaySlider.setMaximum(1000);
        delaySlider.setMinorTickSpacing(1);
        delaySlider.setSnapToTicks(true);
        delaySlider.setValue(100);
        delaySlider.setAutoscrolls(true);
        delaySlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                delaySliderStateChanged(evt);
            }
        });
        add(delaySlider);

        delayTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                delayTFActionPerformed(evt);
            }
        });
        add(delayTF);

        sizeTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sizeTFActionPerformed(evt);
            }
        });
        add(sizeTF);

        sizeSlider.setMaximum(1000);
        sizeSlider.setMinimum(5);
        sizeSlider.setValue(200);
        sizeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                sizeSliderStateChanged(evt);
            }
        });
        add(sizeSlider);

        ccSlider.setMajorTickSpacing(1);
        ccSlider.setSnapToTicks(true);
        ccSlider.setValue(48);
        ccSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                ccSliderStateChanged(evt);
            }
        });
        add(ccSlider);

        ccTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ccTFActionPerformed(evt);
            }
        });
        add(ccTF);

        dcSlider.setMajorTickSpacing(1);
        dcSlider.setSnapToTicks(true);
        dcSlider.setValue(77);
        dcSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                dcSliderStateChanged(evt);
            }
        });
        add(dcSlider);

        dcTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dcTFActionPerformed(evt);
            }
        });
        add(dcTF);

        jLabel1.setText("CC");
        add(jLabel1);

        jLabel2.setText("DC");
        add(jLabel2);

        jLabel3.setText("delay");
        add(jLabel3);

        jLabel4.setText("size");
        add(jLabel4);

        stepButton.setText("step");
        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                stepButtonActionPerformed(evt);
            }
        });
        add(stepButton);

        ddSlider.setMajorTickSpacing(1);
        ddSlider.setMaximum(30);
        ddSlider.setSnapToTicks(true);
        ddSlider.setValue(0);
        ddSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                ddSliderStateChanged(evt);
            }
        });
        add(ddSlider);

        ddTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ddTFActionPerformed(evt);
            }
        });
        add(ddTF);

        jLabel5.setText("DD");
        add(jLabel5);

        roundsSlider.setMajorTickSpacing(1);
        roundsSlider.setMaximum(20);
        roundsSlider.setSnapToTicks(true);
        roundsSlider.setValue(1);
        roundsSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                roundsSliderStateChanged(evt);
            }
        });
        add(roundsSlider);

        roundsTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                roundsTFActionPerformed(evt);
            }
        });
        add(roundsTF);

        jLabel6.setText("Rounds");
        add(jLabel6);

        percentSlider.setMajorTickSpacing(10);
        percentSlider.setSnapToTicks(true);
        percentSlider.setValue(100);
        percentSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                percentSliderStateChanged(evt);
            }
        });
        add(percentSlider);

        percentTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                percentTFActionPerformed(evt);
            }
        });
        add(percentTF);

        jLabel7.setText("%coop");
        add(jLabel7);

        jLabel8.setText("0");
        add(jLabel8);

        jLabel9.setText("100");
        add(jLabel9);

        pack();
    }

    private void goStopButtonActionPerformed(ActionEvent evt) {
        thePrisFrame.toggleRunning();
        if (thePrisFrame.running) {
            goStopButton.setText("stop");
        } else {
            goStopButton.setText("go");
        }
    }

    private void delaySliderStateChanged(ChangeEvent evt) {
        update();
    }

    private void delayTFActionPerformed(ActionEvent evt) {
        setSlider(delaySlider, delayTF);
        update();
    }

    private void sizeTFActionPerformed(ActionEvent evt) {
        setSlider(sizeSlider, sizeTF);
        update();
    }

    private void sizeSliderStateChanged(ChangeEvent evt) {
        update();
    }

    private void ccSliderStateChanged(ChangeEvent evt) {
        update();
    }

    private void ccTFActionPerformed(ActionEvent evt) {
        setSlider(ccSlider, ccTF);
        update();
    }

    private void dcSliderStateChanged(ChangeEvent evt) {
        update();
    }

    private void dcTFActionPerformed(ActionEvent evt) {
        setSlider(dcSlider, dcTF);
        update();
    }

    private void stepButtonActionPerformed(ActionEvent evt) {
        goStopButton.setText("go");
        thePrisFrame.step();

    }

    private void ddSliderStateChanged(ChangeEvent evt) {
                update();
    }

    private void ddTFActionPerformed(ActionEvent evt) {
        setSlider(ddSlider, ddTF);
        update();
    }

    private void roundsSliderStateChanged(ChangeEvent evt) {
        update();
    }

    private void roundsTFActionPerformed(ActionEvent evt) {
        setSlider(roundsSlider, roundsTF);
        update();
    }

    private void percentSliderStateChanged(ChangeEvent evt) {
        update();
    }

    private void percentTFActionPerformed(ActionEvent evt) {
        setSlider(percentSlider, percentTF);
        update();
    }

    private JSlider ccSlider;
    private JSlider dcSlider;
    private JSlider ddSlider;
    private JSlider delaySlider;
    private JSlider roundsSlider;
    private JSlider sizeSlider;
    private JSlider percentSlider;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField ccTF;
    private JTextField dcTF;
    private JTextField ddTF;
    private JTextField delayTF;
    private JButton goStopButton;
    private JButton stepButton;
    private JTextField percentTF;
    private JTextField roundsTF;
    private JTextField sizeTF;
}
