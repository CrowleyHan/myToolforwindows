//package com.windows;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionAdapter;
//import java.util.ArrayList;
//
//import javax.swing.*;
//
//import com.dao.GetPath;
//import com.dao.GetUtils;
//
//public class BigOneWin extends JFrame {
//	
//	  private static int oX;
//	    private static int oY;
//	    private static Dimension d1=new Dimension(60, 90);
//	    private static Insets ints=new Insets(0, 0, 0, 0);
//	    //滚动条
//	    JScrollPane jspA;
//	    JScrollBar jsbA;
//			// 工具条
//		  JToolBar jtb;
//		  // 菜单条组件
//		  JMenuBar jmb;
//		  JMenu menu1, menu2, menu3;
//		  JMenuItem item2, item3, item4, item5, item6, item7;
//		  JMenu xinjian,xinjian1;// 二级菜单
//		  JMenuItem file,file1, del,delet,ref,help ,test1;
//		  JPanel jp1,jp2,jp4,cardpan,Jimage;
//		  Button b2;
//		  JButton bb,bb1,bb2,bb3,bb4;
//		  JLabel lb1,lb2,lb3;
//		  private CardLayout card;
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	GridBagLayout layout = new GridBagLayout();
//    GridBagConstraints s = new GridBagConstraints();
//	public BigOneWin () throws Exception {
//	
//		this.bigwindows();
//		this.BigAllListener();
//		
//	}
//	/**
//	 * 最上方的工具栏
//	 */
//	
//	void tools(ArrayList<String>butt) {
//		  jtb=new JToolBar();
//		  jmb=new JMenuBar();
//		  jp1=new JPanel();
//		  jp2=new JPanel(card);
//		  jp4=new JPanel(layout);
//		  menu1 = new JMenu("添加程序");
//	      menu1.setMnemonic('F');// 设置助记符
//	      menu2 = new JMenu("添加文件夹?");
//	      menu2.setMnemonic('E');
//	      menu3 = new JMenu("帮助");
//	      menu3.setMnemonic('O');
//	      xinjian=new JMenu("文件添加到");
//	      xinjian1=new JMenu("文件夹添加到");
//	      file=new JMenuItem("添加程序");
//	      file1=new JMenuItem("添加文件夹");
//	      delet=new JMenuItem("删除全部");
//	      ref=new JMenuItem("刷新");
//	      help=new JMenuItem("操作指南");
//	      test1=new JMenuItem("点了也没用");
//	      for (String str : butt) {
//	    	  
//	    	  item2 = new JMenuItem(str);
//	    	  xinjian.add(item2);
//	    	  item2.addActionListener(new ActionListener() {
//	    		  
//	    		  @Override
//	    		  public void actionPerformed(ActionEvent e) {
//	    			  // TODO Auto-generated method stub
//	    			  GetPath gp=new GetPath();
//	    			  GetUtils gu=new GetUtils();
//	    			  gu.setText(	gp.getFilePath(),str);
//	    			  //System.out.println("category=="+item2.getText());
//	    		  }
//	    	  });
//	    //	 file.add(xinjian);
//			
//		}    for (String str : butt) {
//	    	  
//	    	  item3 = new JMenuItem(str);
//	    	  xinjian1.add(item3);
//	    //	 file.add(xinjian);
//	    	  item3.addActionListener(new ActionListener() {
//	    		  
//	    		  @Override
//	    		  public void actionPerformed(ActionEvent e) {
//	    			  // TODO Auto-generated method stub
//	    			  GetPath gp=new GetPath();
//	    			  GetUtils gu=new GetUtils();
//	    			  gu.setText(	gp.getDirPath().getPath(),str);
//	    			  //System.out.println("category=="+item2.getText());
//	    		  }
//	    	  });
//			
//		}
//	      
//	      
//	      menu1.add(xinjian);
//	      menu1.add(xinjian1);
//	      menu1.add(file1);
//	      menu2.add(delet);
//	      menu2.add(test1);
//	      menu3.add(ref);
//	      menu3.add(help);
//	      jmb.add(menu1);
//	      jmb.add(menu3);
//	      jmb.add(menu2);
//	}
//	/**
//	 * 窗口的初始化样式
//	 * @throws Exception
//	 */
//	void bigwindows() throws Exception {
//		  setTitle("快捷入口");
//		GetUtils gu=new GetUtils();
//		  card=new CardLayout();
//		  ArrayList<String>butt= gu.getCategory();
//			this.tools(butt);
//	      //透明化设置
////	      setUndecorated(true);
////	      setOpacity(0.5f);
//	      setVisible(true);
//	      setJMenuBar(jmb);
//	      setSize(450, 300);
//	      //添加按钮及卡片
//	      for (String string : butt) {
//			bb=new JButton(string);
//			bb.setMargin(ints);
//			String bname=bb.getText();//按钮/分类的名字
//			jp1.add(bb);
//			//根据分类添加对应的内容
//			ArrayList<String>exename= gu.getExEnames(bname);
//			for (String d : exename) {
//				Jimage=new ButtonIcon().getButton1(d, "程序", null);
//				jp4.add(Jimage);
//			}
//			jp2.add(jp4);
//			
//		}
//	      
//	      //设置jp1的布局
//	      jp1.setLayout(new GridLayout());
////	      jp1.add();
//	      jp2.setBackground(Color.white);
//	      //添加分类栏，图标栏目和底部按钮
//	      getContentPane().add(jp2,BorderLayout.CENTER);
//	      getContentPane().add(jp1,BorderLayout.SOUTH);
//	      //设置中间位置尺寸setPreferredSize。原方法setSize在布局管理器中不生效
//	      Dimension d2=new Dimension(getWidth(), getHeight());
//	      jp4.setPreferredSize(d1);
//	      jp4.setLayout(new FlowLayout());
//	      jp2.setPreferredSize(d2);
//	      //居中
//	      setLocationRelativeTo(null);
//	      //关闭方法
//	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	
//	      this.pack();
//	
//	}
//	/**
//	 * 鼠标的监听方法
//	 * 
//	 */
//	void BigAllListener() {
//		//获取鼠标的位置
//		  addMouseListener(new MouseAdapter() {
//	            @Override
//	            public void mousePressed(MouseEvent e) {
//	                oX = e.getX();
//	                oY = e.getY();
//	            }
//	        });  
//	      //监听拖动，并设置位置
//	        	addMouseMotionListener(new MouseMotionAdapter() {
//	            @Override
//	            public void mouseDragged(MouseEvent e) {
//	                Point p = getLocation();
//	                setLocation(p.x + e.getX() - oX, p.y + e.getY() - oY);
//	            }
//	        });
//	        	
////------------------------------点击添加程序时候触发的方法
////	        	item2.addActionListener(new ActionListener() {
////					
////					@Override
////					public void actionPerformed(ActionEvent e) {
////						// TODO Auto-generated method stub
////						System.out.println("bbbbbbbbbb");
////						GetPath gp=new GetPath();
////						GetUtils gu=new GetUtils();
////						gu.setText(	gp.getFilePath(),item2.getName());
////						//System.out.println(gu.getTextPath(""));
////					}
////				});
//	        	//分类按钮的点击事件
//	        	bb.addMouseListener(new MouseAdapter() {
//	        		@Override
//	        		public void mouseClicked(MouseEvent e) {
//	        		}
//				});
//	        	//分类按钮的点击事件
//	        	bb.addMouseListener(new MouseAdapter() {
//	        		@Override
//	        		public void mouseClicked(MouseEvent e) {
//	        		
//	        		}
//				});
//	        	
//	        	  bb.addActionListener(new ActionListener() {
//        
//        @Override
//        public void actionPerformed(ActionEvent arg0) {
//            // TODO Auto-generated method stub
//           // jp2.show(jp4, bb.getText());    
//        }
//    });
//	        	 
//		
//	}
//	
//	
//	
//
//
//}
