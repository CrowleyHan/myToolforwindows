package com.windowspojo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class PartPanel extends JPanel {


private static final long serialVersionUID = 1L;




public PartPanel() {
super();
setOpaque(true);
setSize(80, 90);
setBackground(new Color(36, 179, 193));
JLabel nameLabel = new JLabel("Ô²½ÇÃæ°å", JLabel.CENTER);
nameLabel.setForeground(Color.white);
nameLabel.setBounds(0, 0, 80, 30);
nameLabel.setAlignmentY(0.1f);
JButton bb=new JButton("yuanjiao");
add(nameLabel);
}

@Override
public void paint(Graphics g) {
int fieldX = 0;
int fieldY = 0;
int fieldWeight = getSize().width;
int fieldHeight = getSize().height;
RoundRectangle2D rect = new RoundRectangle2D.Double(fieldX, fieldY, fieldWeight, fieldHeight, 20, 20);
g.setClip(rect);
super.paint(g);
}


public static void main(String[] args) {
JFrame frame = new JFrame("Ô²½ÇÃæss °å");
frame.setLayout(null);
frame.setBounds(500, 300, 500, 500);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
PartPanel panel = new PartPanel();
panel.setLocation(100, 100);
frame.add(panel);
frame.setVisible(true);
}
}

