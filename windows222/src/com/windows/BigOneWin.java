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
//	    //������
//	    JScrollPane jspA;
//	    JScrollBar jsbA;
//			// ������
//		  JToolBar jtb;
//		  // �˵������
//		  JMenuBar jmb;
//		  JMenu menu1, menu2, menu3;
//		  JMenuItem item2, item3, item4, item5, item6, item7;
//		  JMenu xinjian,xinjian1;// �����˵�
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
//	 * ���Ϸ��Ĺ�����
//	 */
//	
//	void tools(ArrayList<String>butt) {
//		  jtb=new JToolBar();
//		  jmb=new JMenuBar();
//		  jp1=new JPanel();
//		  jp2=new JPanel(card);
//		  jp4=new JPanel(layout);
//		  menu1 = new JMenu("��ӳ���");
//	      menu1.setMnemonic('F');// �������Ƿ�
//	      menu2 = new JMenu("����ļ���?");
//	      menu2.setMnemonic('E');
//	      menu3 = new JMenu("����");
//	      menu3.setMnemonic('O');
//	      xinjian=new JMenu("�ļ���ӵ�");
//	      xinjian1=new JMenu("�ļ�����ӵ�");
//	      file=new JMenuItem("��ӳ���");
//	      file1=new JMenuItem("����ļ���");
//	      delet=new JMenuItem("ɾ��ȫ��");
//	      ref=new JMenuItem("ˢ��");
//	      help=new JMenuItem("����ָ��");
//	      test1=new JMenuItem("����Ҳû��");
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
//	 * ���ڵĳ�ʼ����ʽ
//	 * @throws Exception
//	 */
//	void bigwindows() throws Exception {
//		  setTitle("������");
//		GetUtils gu=new GetUtils();
//		  card=new CardLayout();
//		  ArrayList<String>butt= gu.getCategory();
//			this.tools(butt);
//	      //͸��������
////	      setUndecorated(true);
////	      setOpacity(0.5f);
//	      setVisible(true);
//	      setJMenuBar(jmb);
//	      setSize(450, 300);
//	      //��Ӱ�ť����Ƭ
//	      for (String string : butt) {
//			bb=new JButton(string);
//			bb.setMargin(ints);
//			String bname=bb.getText();//��ť/���������
//			jp1.add(bb);
//			//���ݷ�����Ӷ�Ӧ������
//			ArrayList<String>exename= gu.getExEnames(bname);
//			for (String d : exename) {
//				Jimage=new ButtonIcon().getButton1(d, "����", null);
//				jp4.add(Jimage);
//			}
//			jp2.add(jp4);
//			
//		}
//	      
//	      //����jp1�Ĳ���
//	      jp1.setLayout(new GridLayout());
////	      jp1.add();
//	      jp2.setBackground(Color.white);
//	      //��ӷ�������ͼ����Ŀ�͵ײ���ť
//	      getContentPane().add(jp2,BorderLayout.CENTER);
//	      getContentPane().add(jp1,BorderLayout.SOUTH);
//	      //�����м�λ�óߴ�setPreferredSize��ԭ����setSize�ڲ��ֹ������в���Ч
//	      Dimension d2=new Dimension(getWidth(), getHeight());
//	      jp4.setPreferredSize(d1);
//	      jp4.setLayout(new FlowLayout());
//	      jp2.setPreferredSize(d2);
//	      //����
//	      setLocationRelativeTo(null);
//	      //�رշ���
//	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	
//	      this.pack();
//	
//	}
//	/**
//	 * ���ļ�������
//	 * 
//	 */
//	void BigAllListener() {
//		//��ȡ����λ��
//		  addMouseListener(new MouseAdapter() {
//	            @Override
//	            public void mousePressed(MouseEvent e) {
//	                oX = e.getX();
//	                oY = e.getY();
//	            }
//	        });  
//	      //�����϶���������λ��
//	        	addMouseMotionListener(new MouseMotionAdapter() {
//	            @Override
//	            public void mouseDragged(MouseEvent e) {
//	                Point p = getLocation();
//	                setLocation(p.x + e.getX() - oX, p.y + e.getY() - oY);
//	            }
//	        });
//	        	
////------------------------------�����ӳ���ʱ�򴥷��ķ���
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
//	        	//���ఴť�ĵ���¼�
//	        	bb.addMouseListener(new MouseAdapter() {
//	        		@Override
//	        		public void mouseClicked(MouseEvent e) {
//	        		}
//				});
//	        	//���ఴť�ĵ���¼�
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
