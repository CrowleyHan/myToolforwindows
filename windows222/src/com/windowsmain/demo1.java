package com.windowsmain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.sun.awt.AWTUtilities;
import com.windowsdao.ButtonIcon;
import com.windowsdao.GetUtils;
import com.windowspojo.ButtonIconA;

public class demo1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ��ʼ��һ�����ڣ���ʼ�����ڵ�λ�úͳߴ�
	 */
	static GetUtils gu = new GetUtils();
	private static int oX;
	private static int oY;
	static JFrame jf;
	static JPanel LeftJP;
	static JPanel JPA = new JPanel();
	static JPopupMenu JPM = new JPopupMenu();

	public static void main(String[] args) {
		demo1.returnJframe();
	}

	/**
	 * s ���ڵĳ�ʼ��
	 */
	@SuppressWarnings("static-access")
	public static void returnJframe() {

		jf = new demo1();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setDefaultLookAndFeelDecorated(true);
		tool();
		// ���ڴ�Ų˵������
		LeftJP = new JPanel();
		// �������Ĵ�С
		LeftJP.setSize(60, 80);
		// �����������ԣ�1͸��2�ޱ߿�
		LeftJP.setBackground(Color.white);
		LeftJP.setOpaque(false);
		// ��һ����ť���˵���ť(Բ�εİ�ť)��
		JButton bb1 = new CircleButton("");
		// ���ð�ť�ı���ͼƬ
		// ����һ��ͼƬ
		Image image = new ImageIcon("D:\\SoftText\\setimage\\png\\p10.png").getImage();
		ImageIcon icon1 = new ImageIcon();
		icon1.setImage(image.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		bb1.setIcon(icon1);
		// ��ӵ���¼�
		bb1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					// ��������������ɷ��ఴť
					// �������з��࣬�����ؽ����
					// ����һ�����ڴ�Ű�ť�����
					JPanel jp1 = new JPanel();
					// �������͸��
//					jp1.setBackground(Color.white);
//					jp1.setOpaque(false);
					// ��ȡ���༯��
					ArrayList<String> list = gu.getCategory();
					// �Է�������������Ҫ���Ŀ�͸�
					// ��͸ߵĵļ�����򣺼��㣺�Ȼ�ȡ��Ļ�ߴ�A��Ȼ��������ߴ�B�����B������Ļ�ߴ��70%����߶�*2
					// ��ȡ��ȵ�70%
					int widths = (int) ((gu.getWindowsSize().width) * 0.7);
					int hrow = 1;
					// ���������
					int jpsize = list.size() * 60;
					int allA = list.size() * 90;

					if (jpsize > widths) {
						// �������ȴ��ڴ����70����ť�������2
						hrow = 2;
					}
					// s�������Ĳ��ָ�ʽΪ���񲼾�
					GridLayout gl=  new GridLayout(1, list.size());
					gl.setHgap(3);
					gl.setVgap(3);
					jp1.setLayout(gl);

					for (String s : list) {
						JButton bb2 = new CircleButton(s);
						// s���ð�ť͸��
//						bb2.setBackground(Color.white);
//						bb2.setOpaque(false);
						bb2.setBackground(Color.white);
						bb2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								// ��ť�¼���̷���������еĳ���JP2
								// ��ȡ���еĳ���
								ArrayList<String> names = gu.getExEnames(s);
								int AllB = names.size() * 70;
								GridLayout gls=  new GridLayout(1, names.size());
								gls.setHgap(3);
								gls.setVgap(5);
								JPanel butt = new JPanel(gls);
								
								butt.setBackground(Color.white);
								butt.setOpaque(false);
//								for (String name : names) {
//									ButtonIcon jp = new ButtonIcon();
//									jp.getButton1(name, s, null);
//									butt.add(jp);
//								}
								for (String name : names) {
									JPanel jp = new ButtonIconA(s, name);
//									jp.getButton1(name, s, null);
									butt.add(jp);
								}

								JPA.removeAll();
								JPA.add(butt, BorderLayout.CENTER);
								Double dou = (double) (AllB + 120);
								jf.setSize(AllB + 120, 97);
								AWTUtilities.setWindowShape(jf,
										new RoundRectangle2D.Double(0.0D, 0.0D, dou, 101.0D, 26.0D, 26.0D));
								JPA.updateUI();
								JPA.repaint();
								jf.repaint();
							}
						});
						jp1.add(bb2);
					}
					JPA.removeAll();
					JPA.add(jp1, BorderLayout.CENTER);
					Double doul = (double) (allA + 120);
					AWTUtilities.setWindowShape(jf, new RoundRectangle2D.Double(0.0D, 0.0D, doul, 101.0D, 26.0D, 26.0D));
					jf.setSize(allA + 120, 101);
					JPA.updateUI();
					JPA.repaint();
					jf.repaint();

				} else if (e.getButton() == MouseEvent.BUTTON2) {

					jf.dispatchEvent(new WindowEvent(jf, WindowEvent.WINDOW_CLOSING));

				} else if (e.getButton() == MouseEvent.BUTTON3) {
					//

					JPM.show(bb1, e.getX(), e.getY());
					;
				}
			}
		});
		LeftJP.add(bb1);

		jf.add(JPA, BorderLayout.CENTER);
		// ������Χ�������ʽ
		jf.add(LeftJP, BorderLayout.WEST);
		jf.setUndecorated(true);
		jf.setBounds(100, 100, 100, 100);
		AWTUtilities.setWindowShape(jf,
				new RoundRectangle2D.Double(0.0D, 0.0D, jf.getWidth(), jf.getHeight(), 26.0D, 26.0D));
//		jf.setOpacity(0.5f);
//		jf.setBackground(new Color(0,0,0,0));
		jf.setVisible(true);
		((demo1) jf).BigAllListener();

	}

	void BigAllListener() {
		// ��ȡ����λ��
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				oX = e.getX();
				oY = e.getY();
			}
		});
		// �����϶���������λ��
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - oX, p.y + e.getY() - oY);
//	                //��ȡX���꣬�ж�X��λ��������ڿ��65%�򷴹���
//	                int widthsm=(int) ((gu.getWindowsSize().width)*0.3);	                
//	                int widths=(int) ((gu.getWindowsSize().width)*0.7);
//	            if((p.x + e.getX() - oX)>widths) {
//
//	            	jf.add(LeftJP,BorderLayout.EAST);
//	            	jf.add(JPA, BorderLayout.CENTER);
//	            	jf.repaint();
//	            }else if((p.x + e.getX() - oX)<widthsm) {
//	            	jf.add(LeftJP,BorderLayout.WEST);
//	            	jf.add(JPA, BorderLayout.CENTER);
//	            	jf.repaint();
//	            }

			}
		});

	}

	/**
	 * �˵���
	 */
	static void tool() {
		// ���߲˵�

		JMenu menuA = new JMenu("������");
		JMenuItem A1 = new JMenuItem("���[  �ļ���  ]��");
		JMenuItem A2 = new JMenuItem("���[   ��  ��   ]��");
		JMenuItem menuB = new JMenuItem("�½�����");
		JMenuItem menuC = new JMenuItem("�������·����");
		JMenuItem f5 = new JMenuItem("ˢ��");
		JMenuItem ends = new JMenuItem("�˳�(����������)");

		A1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		menuB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// �½����ࣺ���жϷ����Ƿ���ڣ�����Ѵ�������ʾ�Ѿ�����
				ArrayList<String> lista = gu.getCategory();
				String nameres = null;
//						JOptionPane.showInputDialog(demo1.this, "������������", menuB.getText());
				String inputValue = JOptionPane.showInputDialog("�������������");
				for (String name : lista) {
					if (inputValue.equals(name)) {
						nameres = nameres + "a";
					} else {
					}
				}
				if (null != nameres) {
					JOptionPane.showMessageDialog(null, "�����Ѵ��ڣ�����ʧ��");
				} else {
					// xд�뵽������
					boolean re = gu.setFileName(inputValue);
					if (re) {
						JOptionPane.showMessageDialog(null, "���ഴ���ɹ�");
					} else {
						JOptionPane.showMessageDialog(null, "����ʧ��");
					}
				}
			}
		});
		menuC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "������ܻ�ûд����������");
			}
		});

		f5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				AWTUtilities.setWindowShape(jf, new RoundRectangle2D.Double(0.0D, 0.0D, 100.0D, 99.0D, 26.0D, 26.0D));
				jf.repaint();
			}
		});

		ends.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}
		});
		menuA.add(A1);
		menuA.add(A2);
		JPM.add(menuA);
		JPM.add(menuB);
		JPM.add(menuC);
		JPM.add(f5);
		JPM.add(ends);
	}

}

class listenerA implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.equals("A1")) {

		} else if (e.equals("A2")) {

		} else if (e.equals("menuA")) {

		} else if (e.equals("menuB")) {

		} else if (e.equals("menuC")) {

		} else if (e.equals("f5")) {

		} else if (e.equals("ends")) {

		} else if (e.equals("")) {

		} else if (e.equals("")) {

		}

	}
}
