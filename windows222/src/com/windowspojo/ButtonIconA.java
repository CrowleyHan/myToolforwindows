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
	 *  	 ����һ��jpanel�������ϲ��ֵİ�ť���²��ֵı�ǩ��Ȼ����Բ�ǵ�
	 *  	
	 * @param category
	 * @param name
	 */
	public   ButtonIconA(String category ,String name) {
		// ��ȡͼ��
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
		bb.setToolTipText("<html>" + name + "<br/>" + "����λ�ã�" + gu.getTextPath(name, category) + "</html>");
		lb.setToolTipText("<html>" + name + "<br/>" + "����λ�ã�" + gu.getTextPath(name, category) + "</html>");
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
						System.out.println("����¼���=" + jb1.getText() + category + a);

					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else if (e.getButton() == MouseEvent.BUTTON2) {
					// ����м�
					JOptionPane.showMessageDialog(ButtonIconA.this, "Ѿͷ���ְְ�����");

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
						System.out.println("����¼���=" + jb1.getText() + category + a);

					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else if (e.getButton() == MouseEvent.BUTTON2) {
					// ����м�
					JOptionPane.showMessageDialog(ButtonIconA.this, "Ѿͷ���ְְ�����");

				} else if (e.getButton() == MouseEvent.BUTTON3) {
					jb1.getText();
					jpmTool(category,jb1.getText());
					jpm.show(jb1, e.getX(), e.getY());

				}
			}
		});

	}
	
	
	public void jpmTool(String category,String name) {

		JMenuItem jmt1 = new JMenuItem("ɾ��");
		JMenuItem jmt2 = new JMenuItem("������");
		JMenuItem jmt3 = new JMenuItem("���ļ�����Ŀ¼");
		
		jmt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//ɾ��Ŀ��
				boolean resR = gu.RemoveName(category,name);
				if (resR) {
					JOptionPane.showMessageDialog(ButtonIconA.this, "ɾ���ɹ�");
				} else {
					JOptionPane.showMessageDialog(ButtonIconA.this, "ɾ��ʧ��");
				}
				
			}
		});
		
		jmt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//������
				boolean nameres=false;
				String namenew=JOptionPane.showInputDialog(ButtonIconA.this, "������������", name);
				
				if(namenew!=null) {
					nameres=gu.findName(namenew, category);
					if(nameres) {
						//û��ͬ������
						//����������
						gu.upDateName(name, category, namenew);
					}else {
						JOptionPane.showMessageDialog(ButtonIconA.this, "�����ظ�������������");
					}
				}else if(namenew==null) {
					JOptionPane.showMessageDialog(ButtonIconA.this, "ȡ������");

				}
			}
		});
		jmt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// TODO Auto-generated method stub
				File spath = new File(gu.getTextPath(name, category).getParent());
				System.out.println("�򿪵�·��="+spath);

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
