package com.windowspojo;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import com.windowsdao.ButtonIcon;
import com.windowsdao.GetUtils;

public class ButtonIconA extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	GetUtils gu=new GetUtils();

	JPopupMenu jpm = new JPopupMenu();
	Color colors=new Color(95,182,250);
//	String category;
	/**
	 *  	 生出一个jpanel，包含上部分的按钮和下部分的标签，然后是圆角的
	 *  	
	 * @param category
	 * @param name
	 */
	public   ButtonIconA(String category ,String name) {
		// 获取图标
				Icon icon = gu.getBigIcon(gu.getTextPath(name, category));
		JButton bb=new CircleButtonSmall(null);
		GridBagLayout gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		bb.setIcon(icon);
		bb.setBackground(colors);
		JLabel lb=new JLabel(name,JLabel.CENTER);
		lb.setBackground(Color.white);
		setLayout(gbl);
		lb.setPreferredSize(new Dimension(62, 19));
		bb.setToolTipText("<html>" + name + "<br/>" + "所在位置：" + gu.getTextPath(name, category) + "</html>");
		lb.setToolTipText("<html>" + name + "<br/>" + "所在位置：" + gu.getTextPath(name, category) + "</html>");
		gbc.fill=GridBagConstraints.BOTH;
		
		gbc.insets=new Insets(3, 3, 3, 3);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=7;
		gbc.gridwidth=1;
		gbl.setConstraints(bb, gbc);

		gbc.gridx=0;
		gbc.gridy=8;
		gbc.gridheight=3;
		gbc.gridwidth=1;
		gbl.setConstraints(lb, gbc);
		
		entMouse(lb,bb, category);
		add(bb);
		add(lb);
		setSize(65, 88);
		setBackground(colors);
		
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
	public 	void entMouse(JLabel jb1, JButton bb,String category) {
		jb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					gu = new GetUtils();

					try {
						boolean a = gu.StartFile(gu.getTextPath(jb1.getText(), category));
						System.out.println("点击事件按=" + jb1.getText() + category + a);

					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else if (e.getButton() == MouseEvent.BUTTON2) {
					// 点击中间
					JOptionPane.showMessageDialog(ButtonIconA.this, "丫头，爸爸爱你呦");

				} else if (e.getButton() == MouseEvent.BUTTON3) {
					jb1.getText();
					jpmTool(category,jb1.getText());
					jpm.show(jb1, e.getX(), e.getY());

				}
			}
		});
		bb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					gu = new GetUtils();

					try {
						boolean a = gu.StartFile(gu.getTextPath(jb1.getText(), category));
						System.out.println("点击事件按=" + jb1.getText() + category + a);

					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else if (e.getButton() == MouseEvent.BUTTON2) {
					// 点击中间
					JOptionPane.showMessageDialog(ButtonIconA.this, "丫头，爸爸爱你呦");

				} else if (e.getButton() == MouseEvent.BUTTON3) {
					jb1.getText();
					jpmTool(category,jb1.getText());
					jpm.show(jb1, e.getX(), e.getY());

				}
			}
		});

	}
	
	
	public void jpmTool(String category,String name) {

		JMenuItem jmt1 = new JMenuItem("删除");
		JMenuItem jmt2 = new JMenuItem("重命名");
		JMenuItem jmt3 = new JMenuItem("打开文件所在目录");
		
		jmt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//删除目标
				boolean resR = gu.RemoveName(category,name);
				if (resR) {
					JOptionPane.showMessageDialog(ButtonIconA.this, "删除成功");
				} else {
					JOptionPane.showMessageDialog(ButtonIconA.this, "删除失败");
				}
				
			}
		});
		
		jmt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//重命名
				boolean nameres=false;
				String namenew=JOptionPane.showInputDialog(ButtonIconA.this, "请输入新名字", name);
				
				if(namenew!=null) {
					nameres=gu.findName(namenew, category);
					if(nameres) {
						//没有同名程序
						//进行重命名
						gu.upDateName(name, category, namenew);
					}else {
						JOptionPane.showMessageDialog(ButtonIconA.this, "名字重复，请重新命名");
					}
				}else if(namenew==null) {
					JOptionPane.showMessageDialog(ButtonIconA.this, "取消命名");

				}
			}
		});
		jmt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// TODO Auto-generated method stub
				File spath = new File(gu.getTextPath(name, category).getParent());
				System.out.println("打开的路径="+spath);

				try {
					 gu.StartFile(spath);
				} catch (IOException e1) {
		
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		
		jpm.add(jmt3);
		jpm.add(jmt2);		
		jpm.add(jmt1);
	}
	
}
