package com.windowsdao;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import com.windowsdao.GetUtils;

public class ButtonIcon2 extends JPanel  {

	private static final long serialVersionUID = 1L;

	GetUtils gu = new GetUtils();
	JButton jb1;
	String categoryOne;
	String newNameNew;
	// ������
	JPopupMenu jpm = new JPopupMenu();
	JMenuItem jmt1 = new JMenuItem("ɾ��");
	JMenuItem jmt2 = new JMenuItem("������");
	JMenuItem jmt3 = new JMenuItem("���ļ�����Ŀ¼");

	/**
	 * �Զ����ɵı�׼��ť
	 * 
	 * @param name
	 * @param category
	 */
	public JPanel getButton1(String name, String category, Color color) {
		categoryOne = category;
		// ��ȡͼ��
		Icon icon = gu.getBigIcon(gu.getTextPath(name, category));
		// ������ť
		jb1 = new JButton(name, icon);
//		jb1.setBackground(new Color(0,0,0,0));
		jb1.setPreferredSize(new Dimension(60, 88));
		jb1.setBackground(Color.white);
		jb1.setOpaque(false);
		jb1.setMargin(new Insets(0, 0, 0, 0));// �ð�ť��С����Ӧ���ݴ�С�������������Ծɲ���ʾ
		jb1.setVerticalTextPosition(SwingConstants.BOTTOM);// ��������������ֱ����λ��
		jb1.setHorizontalTextPosition(SwingConstants.CENTER);// ������������ˮƽ����λ��
		// ���ý�����״̬falseΪ����ʾ
		jb1.setFocusPainted(false);
		// ��ʾ�ı�
		jb1.setToolTipText("<html>" + name + "<br/>" + "����λ�ã�" + gu.getTextPath(name, category) + "</html>");

		add(jb1, BorderLayout.CENTER);
		this.ListenerEnt(name, category);
		entMouse(jb1, category);
		setBackground(Color.white);
		setOpaque(false);
		return this;

	}

	/**
	 * ����ֻ��ͼ��İ�ť
	 * 
	 * @param name
	 * @param category
	 */
	public JPanel getButton2(String name, String category, Color color) {
		categoryOne = category;

		// ��ȡͼ��
		Icon icon = gu.getBigIcon(gu.getTextPath(name, category));
		// ������ť
		jb1 = new JButton(icon);
		jb1.setBackground(Color.white);
		jb1.setMargin(new Insets(0, 0, 0, 0));// �ð�ť��С����Ӧ���ݴ�С�������������Ծɲ���ʾ
		// ���ý�����״̬falseΪ����ʾ
		jb1.setFocusPainted(false);
		// ��ʾ�ı�
		jb1.setToolTipText("<html>" + name + "<br/>" + "λ�ã�" + gu.getTextPath(name, category) + "</html>");

		add(jb1, BorderLayout.CENTER);
		// ��������
		this.ListenerEnt(name, category);
		entMouse(jb1, category);
		return this;

	}

	/**
	 * ���ɴ�Сͼ���
	 * 
	 * @param name
	 * @param category
	 */
	public JPanel getButton3(String name, String category, Color color) {
		categoryOne = category;

		// ��ȡͼ��
		Icon icon = gu.getSmallIcon(gu.getTextPath(name, category));
		// ������ť
		jb1 = new JButton(name, icon);
		jb1.setBackground(Color.white);
		jb1.setMargin(new Insets(0, 0, 0, 0));// �ð�ť��С����Ӧ���ݴ�С�������������Ծɲ���ʾ
		jb1.setBorder(null);
		// ���ý�����״̬falseΪ����ʾ
		jb1.setFocusPainted(false);
		// ��ʾ�ı�
		jb1.setToolTipText("<html>" + name + "<br/>" + "����λ�ã�" + gu.getTextPath(name, category) + "</html>");
		add(jb1, BorderLayout.CENTER);
		this.ListenerEnt(name, category);
		entMouse(jb1, category);
		return this;

	}

	/**
	 * ������¼�
	 */
	void ListenerEnt(String name, String category) {

//	 //�϶��ļ����¼�
//	  addMouseListener(new MouseAdapter() {
//           @Override
//           public void mousePressed(MouseEvent e) {
//               oX = e.getX();
//               oY = e.getY();
//           }
//       });  
//     //�����϶���������λ��
//       	addMouseMotionListener(new MouseMotionAdapter() {
//           @Override
//           public void mouseDragged(MouseEvent e) {
//               Point p = getLocation();
//               setLocation(p.x + e.getX() - oX, p.y + e.getY() - oY);
//           }
//       });
		// ������¼�


	}

public 	void entMouse(JButton jb1, String category) {
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
					JOptionPane.showMessageDialog(ButtonIcon2.this, "Ѿͷ���ְְ�����");

				} else if (e.getButton() == MouseEvent.BUTTON3) {
					Tool1(category);
					jpm.show(jb1, e.getX(), e.getY());

				}
			}
		});

	}

	/**
	 * ����ť��ӹ�����ѡ��
	 */
	void Tool1( String nemeaaaa ) {
		jmt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// ɾ��
				boolean resR = gu.RemoveName(categoryOne, jb1.getText());
				if (resR) {
					JOptionPane.showMessageDialog(ButtonIcon2.this, "ɾ���ɹ�");
				} else {
					JOptionPane.showMessageDialog(ButtonIcon2.this, "ɾ��ʧ��");
				}
			
			}
		});
		jmt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// ���ļ�����Ŀ¼
				// �Ȼ�ȡ�ļ�Ŀ¼
				jb1.getText();
				File spath = new File(gu.getTextPath(jb1.getText(), nemeaaaa).getParent());
				System.out.println("�򿪵�·��="+spath);

				try {
					 gu.StartFile(spath);
				} catch (IOException e1) {
		
					e1.printStackTrace();
				}

			
				
			}
		});
		jmt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// ������:�ݹ飺��������true
				newNameNew = JOptionPane.showInputDialog(ButtonIcon2.this, "������������", jb1.getText());
				if (newNameNew != null) {
					findnames(gu.findName(newNameNew, categoryOne), jb1);
				} else {
					JOptionPane.showMessageDialog(ButtonIcon2.this, "ȡ������");
				}
			
				
			}
		});
		jpm.add(jmt1);
		jpm.add(jmt2);
		jpm.add(jmt3);

	}

	public void actionPerformed(ActionEvent e,String cat) {
		if (e.getSource() == jmt1) {
			// ɾ��
			boolean resR = gu.RemoveName(categoryOne, jb1.getText());
			if (resR) {
				JOptionPane.showMessageDialog(ButtonIcon2.this, "ɾ���ɹ�");
			} else {
				JOptionPane.showMessageDialog(ButtonIcon2.this, "ɾ��ʧ��");
			}
		}
		if (e.getSource() == jmt2) {
			// ������:�ݹ飺��������true
			newNameNew = JOptionPane.showInputDialog(ButtonIcon2.this, "������������", jb1.getText());
//			if (newNameNew != null) {
				findnames(gu.findName(newNameNew, categoryOne), jb1);
//			} else {
//				JOptionPane.showMessageDialog(ButtonIcon.this, "ȡ������");
//			}
		}
		if (e.getSource() == jmt3) {
			// ���ļ�����Ŀ¼
			// �Ȼ�ȡ�ļ�Ŀ¼
			jb1.getText();
			File spath = new File(gu.getTextPath(jb1.getText(), categoryOne).getParent());
			System.out.println("�򿪵�·��="+spath);

			try {
				 gu.StartFile(spath);
			} catch (IOException e1) {
	
				e1.printStackTrace();
			}

		}

	}

	// �ݹ�ȷ�������Ƿ��ظ�
	boolean findnames(boolean name, JButton jb1) {
		if (!name) {
			newNameNew = JOptionPane.showInputDialog(ButtonIcon2.this, "���ֲ����ظ�������������", jb1.getText());

			return findnames(gu.findName(newNameNew, categoryOne), jb1);

		} else if (name) {
			if (newNameNew == null) {
				JOptionPane.showMessageDialog(ButtonIcon2.this, "ȡ������");
				
			} else {
				gu.upDateName(jb1.getText(), categoryOne, newNameNew);
			}
			return false;
		}

		return name;

	}

}
