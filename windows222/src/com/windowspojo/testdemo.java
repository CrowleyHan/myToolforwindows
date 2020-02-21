package com.windowspojo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class testdemo {
	
	
	public static void main(String[] args) {
		
		JFramedemo( );
	}

	
	
	
	
	
	
	
	
	static void JFramedemo() {
		  JFrame jf=new JFrame();
	        jf.setSize(500,500);
	        jf.setLocationRelativeTo(null);
	        jf.setDefaultCloseOperation(3);
	        jf.setResizable(false);
		GridBagLayout gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		JPanel jp=new JPanel(gbl);
		JButton b1=new JButton("上面");
		JButton b2=new JButton("下面");
		JButton b3=new JButton("左面");
		JButton b4=new JButton("右面");
		JButton b51=new JButton("中间1");
		JButton b52=new JButton("中间2");
		JButton b53=new JButton("中间3");
		JButton b54=new JButton("中间4");
		//上
		gbc.gridwidth=0;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx=5;
		gbc.weighty=1;
		gbl.setConstraints(b1, gbc);
		
		//做
		gbc.gridwidth=1;

		gbc.gridx=0;
		gbc.gridy=1;
		gbc.weightx=1;
		gbc.weighty=3;
		gbl.setConstraints(b3, gbc);
		
		//右
		gbc.gridx=4;
		gbc.gridy=1;
		gbc.weightx=1;
		gbc.weighty=3;
		gbl.setConstraints(b4, gbc);
		//中间1
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.weightx=1;
		gbc.weighty=2;
		gbl.setConstraints(b51, gbc);
		//中间2
				gbc.gridx=2;
				gbc.gridy=1;
				gbc.weightx=2;
				gbc.weighty=1;
				gbl.setConstraints(b52, gbc);
				//中间3
				gbc.gridx=1;
				gbc.gridy=2;
				gbc.weightx=1;
				gbc.weighty=2;
				gbl.setConstraints(b53, gbc);
				//中间4
				gbc.gridx=2;
				gbc.gridy=3;
				gbc.weightx=2;
				gbc.weighty=1;
				gbl.setConstraints(b54, gbc);
		
		//下
		gbc.gridwidth=0;

		gbc.gridx=0;
		gbc.gridy=6;
		gbc.weightx=5;
		gbc.weighty=1;
		gbl.setConstraints(b2, gbc);
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		jp.add(b1);
		jp.add(b2);
		jp.add(b3);
		jp.add(b4);		
		jp.add(b51);
		jp.add(b52);
		
		jf.add(jp);
		jf.setVisible(true);
	}
}
