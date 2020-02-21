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
	// 工具条
	JPopupMenu jpm = new JPopupMenu();
	JMenuItem jmt1 = new JMenuItem("删除");
	JMenuItem jmt2 = new JMenuItem("重命名");
	JMenuItem jmt3 = new JMenuItem("打开文件所在目录");

	/**
	 * 自动生成的标准按钮
	 * 
	 * @param name
	 * @param category
	 */
	public JPanel getButton1(String name, String category, Color color) {
		categoryOne = category;
		// 获取图标
		Icon icon = gu.getBigIcon(gu.getTextPath(name, category));
		// 创建按钮
		jb1 = new JButton(name, icon);
//		jb1.setBackground(new Color(0,0,0,0));
		jb1.setPreferredSize(new Dimension(60, 88));
		jb1.setBackground(Color.white);
		jb1.setOpaque(false);
		jb1.setMargin(new Insets(0, 0, 0, 0));// 让按钮大小自适应内容大小，但超出部分仍旧不显示
		jb1.setVerticalTextPosition(SwingConstants.BOTTOM);// 必须设置文字树直方向位置
		jb1.setHorizontalTextPosition(SwingConstants.CENTER);// 必须设置文字水平方向位置
		// 设置焦点框的状态false为不显示
		jb1.setFocusPainted(false);
		// 提示文本
		jb1.setToolTipText("<html>" + name + "<br/>" + "所在位置：" + gu.getTextPath(name, category) + "</html>");

		add(jb1, BorderLayout.CENTER);
		this.ListenerEnt(name, category);
		entMouse(jb1, category);
		setBackground(Color.white);
		setOpaque(false);
		return this;

	}

	/**
	 * 生成只有图标的按钮
	 * 
	 * @param name
	 * @param category
	 */
	public JPanel getButton2(String name, String category, Color color) {
		categoryOne = category;

		// 获取图标
		Icon icon = gu.getBigIcon(gu.getTextPath(name, category));
		// 创建按钮
		jb1 = new JButton(icon);
		jb1.setBackground(Color.white);
		jb1.setMargin(new Insets(0, 0, 0, 0));// 让按钮大小自适应内容大小，但超出部分仍旧不显示
		// 设置焦点框的状态false为不显示
		jb1.setFocusPainted(false);
		// 提示文本
		jb1.setToolTipText("<html>" + name + "<br/>" + "位置：" + gu.getTextPath(name, category) + "</html>");

		add(jb1, BorderLayout.CENTER);
		// 启动方法
		this.ListenerEnt(name, category);
		entMouse(jb1, category);
		return this;

	}

	/**
	 * 生成带小图标的
	 * 
	 * @param name
	 * @param category
	 */
	public JPanel getButton3(String name, String category, Color color) {
		categoryOne = category;

		// 获取图标
		Icon icon = gu.getSmallIcon(gu.getTextPath(name, category));
		// 创建按钮
		jb1 = new JButton(name, icon);
		jb1.setBackground(Color.white);
		jb1.setMargin(new Insets(0, 0, 0, 0));// 让按钮大小自适应内容大小，但超出部分仍旧不显示
		jb1.setBorder(null);
		// 设置焦点框的状态false为不显示
		jb1.setFocusPainted(false);
		// 提示文本
		jb1.setToolTipText("<html>" + name + "<br/>" + "所在位置：" + gu.getTextPath(name, category) + "</html>");
		add(jb1, BorderLayout.CENTER);
		this.ListenerEnt(name, category);
		entMouse(jb1, category);
		return this;

	}

	/**
	 * 鼠标点击事件
	 */
	void ListenerEnt(String name, String category) {

//	 //拖动的监听事件
//	  addMouseListener(new MouseAdapter() {
//           @Override
//           public void mousePressed(MouseEvent e) {
//               oX = e.getX();
//               oY = e.getY();
//           }
//       });  
//     //监听拖动，并设置位置
//       	addMouseMotionListener(new MouseMotionAdapter() {
//           @Override
//           public void mouseDragged(MouseEvent e) {
//               Point p = getLocation();
//               setLocation(p.x + e.getX() - oX, p.y + e.getY() - oY);
//           }
//       });
		// 点击的事件


	}

public 	void entMouse(JButton jb1, String category) {
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
					JOptionPane.showMessageDialog(ButtonIcon2.this, "丫头，爸爸爱你呦");

				} else if (e.getButton() == MouseEvent.BUTTON3) {
					Tool1(category);
					jpm.show(jb1, e.getX(), e.getY());

				}
			}
		});

	}

	/**
	 * 给按钮添加工具条选项
	 */
	void Tool1( String nemeaaaa ) {
		jmt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// 删除
				boolean resR = gu.RemoveName(categoryOne, jb1.getText());
				if (resR) {
					JOptionPane.showMessageDialog(ButtonIcon2.this, "删除成功");
				} else {
					JOptionPane.showMessageDialog(ButtonIcon2.this, "删除失败");
				}
			
			}
		});
		jmt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// 打开文件所在目录
				// 先获取文件目录
				jb1.getText();
				File spath = new File(gu.getTextPath(jb1.getText(), nemeaaaa).getParent());
				System.out.println("打开的路径="+spath);

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

				// 重命名:递归：方法传入true
				newNameNew = JOptionPane.showInputDialog(ButtonIcon2.this, "请输入新名字", jb1.getText());
				if (newNameNew != null) {
					findnames(gu.findName(newNameNew, categoryOne), jb1);
				} else {
					JOptionPane.showMessageDialog(ButtonIcon2.this, "取消命名");
				}
			
				
			}
		});
		jpm.add(jmt1);
		jpm.add(jmt2);
		jpm.add(jmt3);

	}

	public void actionPerformed(ActionEvent e,String cat) {
		if (e.getSource() == jmt1) {
			// 删除
			boolean resR = gu.RemoveName(categoryOne, jb1.getText());
			if (resR) {
				JOptionPane.showMessageDialog(ButtonIcon2.this, "删除成功");
			} else {
				JOptionPane.showMessageDialog(ButtonIcon2.this, "删除失败");
			}
		}
		if (e.getSource() == jmt2) {
			// 重命名:递归：方法传入true
			newNameNew = JOptionPane.showInputDialog(ButtonIcon2.this, "请输入新名字", jb1.getText());
//			if (newNameNew != null) {
				findnames(gu.findName(newNameNew, categoryOne), jb1);
//			} else {
//				JOptionPane.showMessageDialog(ButtonIcon.this, "取消命名");
//			}
		}
		if (e.getSource() == jmt3) {
			// 打开文件所在目录
			// 先获取文件目录
			jb1.getText();
			File spath = new File(gu.getTextPath(jb1.getText(), categoryOne).getParent());
			System.out.println("打开的路径="+spath);

			try {
				 gu.StartFile(spath);
			} catch (IOException e1) {
	
				e1.printStackTrace();
			}

		}

	}

	// 递归确认名字是否重复
	boolean findnames(boolean name, JButton jb1) {
		if (!name) {
			newNameNew = JOptionPane.showInputDialog(ButtonIcon2.this, "名字不可重复，请重新输入", jb1.getText());

			return findnames(gu.findName(newNameNew, categoryOne), jb1);

		} else if (name) {
			if (newNameNew == null) {
				JOptionPane.showMessageDialog(ButtonIcon2.this, "取消命名");
				
			} else {
				gu.upDateName(jb1.getText(), categoryOne, newNameNew);
			}
			return false;
		}

		return name;

	}

}
