package com.windowspojo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.windowsdao.GetUtils;

public class DemoGB {
	
	
	public static void main(String[] args) {
		
		
		JFrame jf=new JFrame();
		GridBagLayout gu=new GridBagLayout();
		JPanel jp=new JPanel(gu);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton bb1=new JButton("bb1");
		JButton bb2=new JButton("bb2");
		JButton bb3=new JButton("bb3");
		JButton bb4=new JButton("bb4");
		JButton bb5=new JButton("bb5");
		JButton bb6=new JButton("bb6");
		JButton bb7=new JButton("bb7");
		JButton bb8=new JButton("bb8");
		JButton bb9=new JButton("bb9");
		bb1.setBackground(Color.white);
		bb2.setBackground(Color.yellow);
		bb3.setBackground(Color.pink);
		bb4.setBackground(Color.green);
		bb5.setBackground(Color.green);
		bb6.setBackground(Color.pink);
		bb7.setBackground(Color.yellow);
		bb8.setBackground(Color.white);
		bb9.setBackground(Color.white);
		GridBagConstraints gs=new GridBagConstraints();
		gs.fill=GridBagConstraints.BOTH;
		
		gs.gridx=0;
		gs.gridy=0;
		gs.gridheight=1;
		gs.gridwidth=10;
		gu.setConstraints(bb1, gs);
		
		gs.gridx=0;
		gs.gridy=1;
		gs.gridheight=8;
		gs.gridwidth=2;
		gu.setConstraints(bb2, gs);
		
		gs.gridx=2;
		gs.gridy=3;
		gs.gridheight=6;
		gs.gridwidth=2;
		gu.setConstraints(bb3, gs);
		
		gs.gridx=2;
		gs.gridy=1;
		gs.gridheight=2;
		gs.gridwidth=5;
		gu.setConstraints(bb4, gs);
		
		gs.gridx=4;
		gs.gridy=7;
		gs.gridheight=2;
		gs.gridwidth=5;
		gu.setConstraints(bb5, gs);
		
		gs.gridx=7;
		gs.gridy=1;
		gs.gridheight=6;
		gs.gridwidth=2;
		gu.setConstraints(bb6, gs);
		
		gs.gridx=9;
		gs.gridy=1;
		gs.gridheight=8;
		gs.gridwidth=1;
		gu.setConstraints(bb7, gs);
		
		gs.gridx=0;
		gs.gridy=9;
		gs.gridheight=2;
		gs.gridwidth=10;
		gu.setConstraints(bb8, gs);
		gs.gridx=4;
		gs.gridy=3;
		gs.gridheight=4;
		gs.gridwidth=3;
		gu.setConstraints(bb9, gs);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		jp.add(bb1);
		jp.add(bb2);
		jp.add(bb3);
		jp.add(bb4);
		jp.add(bb5);
		jp.add(bb6);
		jp.add(bb7);		
		jp.add(bb8);	
		jp.add(bb9);
//		jp.setPreferredSize(new Dimension(499, 499));
		jf.add(jp);
		jf.setBounds(10, 10, 500, 500);
		jf.setVisible(true);
	}

	
}
