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
	 * 初始化一个窗口，初始化窗口的位置和尺寸
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
	 * s 窗口的初始化
	 */
	@SuppressWarnings("static-access")
	public static void returnJframe() {

		jf = new demo1();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setDefaultLookAndFeelDecorated(true);
		tool();
		// 用于存放菜单的面板
		LeftJP = new JPanel();
		// 设置面板的大小
		LeftJP.setSize(60, 80);
		// 设置面板的属性：1透明2无边框
		LeftJP.setBackground(Color.white);
		LeftJP.setOpaque(false);
		// 第一个按钮，菜单按钮(圆形的按钮)。
		JButton bb1 = new CircleButton("");
		// 设置按钮的背景图片
		// 加载一张图片
		Image image = new ImageIcon("D:\\SoftText\\setimage\\png\\p10.png").getImage();
		ImageIcon icon1 = new ImageIcon();
		icon1.setImage(image.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		bb1.setIcon(icon1);
		// 添加点击事件
		bb1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					// 如果鼠标左击则生成分类按钮
					// 加载所有分类，并返回结果集
					// 生成一个用于存放按钮的面板
					JPanel jp1 = new JPanel();
					// 面板设置透明
//					jp1.setBackground(Color.white);
//					jp1.setOpaque(false);
					// 获取分类集合
					ArrayList<String> list = gu.getCategory();
					// 以分类数量计算需要面板的宽和高
					// 宽和高的的计算规则：计算：先获取屏幕尺寸A，然后计算面板尺寸B，如果B大于屏幕尺寸的70%，则高度*2
					// 获取宽度的70%
					int widths = (int) ((gu.getWindowsSize().width) * 0.7);
					int hrow = 1;
					// 计算面板宽度
					int jpsize = list.size() * 60;
					int allA = list.size() * 90;

					if (jpsize > widths) {
						// 如果面板宽度大于窗体的70，则按钮行数变成2
						hrow = 2;
					}
					// s设置面板的布局格式为网格布局
					GridLayout gl=  new GridLayout(1, list.size());
					gl.setHgap(3);
					gl.setVgap(3);
					jp1.setLayout(gl);

					for (String s : list) {
						JButton bb2 = new CircleButton(s);
						// s设置按钮透明
//						bb2.setBackground(Color.white);
//						bb2.setOpaque(false);
						bb2.setBackground(Color.white);
						bb2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								// 按钮事件是谭家旗下所有的程序到JP2
								// 获取所有的程序
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
		// 设置外围窗体的样式
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
		// 获取鼠标的位置
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				oX = e.getX();
				oY = e.getY();
			}
		});
		// 监听拖动，并设置位置
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - oX, p.y + e.getY() - oY);
//	                //获取X坐标，判断X的位置如果大于宽的65%则反过来
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
	 * 菜单条
	 */
	static void tool() {
		// 工具菜单

		JMenu menuA = new JMenu("添加组件");
		JMenuItem A1 = new JMenuItem("添加[  文件夹  ]到");
		JMenuItem A2 = new JMenuItem("添加[   文  件   ]到");
		JMenuItem menuB = new JMenuItem("新建分类");
		JMenuItem menuC = new JMenuItem("添加启动路径到");
		JMenuItem f5 = new JMenuItem("刷新");
		JMenuItem ends = new JMenuItem("退出(单机鼠标滚轮)");

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
				// 新建分类：先判断分类是否存在，如果已存在则提示已经存在
				ArrayList<String> lista = gu.getCategory();
				String nameres = null;
//						JOptionPane.showInputDialog(demo1.this, "请输入新名字", menuB.getText());
				String inputValue = JOptionPane.showInputDialog("请输入分类名字");
				for (String name : lista) {
					if (inputValue.equals(name)) {
						nameres = nameres + "a";
					} else {
					}
				}
				if (null != nameres) {
					JOptionPane.showMessageDialog(null, "分类已存在，创建失败");
				} else {
					// x写入到电脑中
					boolean re = gu.setFileName(inputValue);
					if (re) {
						JOptionPane.showMessageDialog(null, "分类创建成功");
					} else {
						JOptionPane.showMessageDialog(null, "创建失败");
					}
				}
			}
		});
		menuC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "这个功能还没写，哈哈哈哈");
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
