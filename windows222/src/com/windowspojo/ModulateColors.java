package com.windowspojo;

import java.awt.Color;
 import java.awt.GridLayout;


 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import javax.swing.JScrollBar;
 
 public class ModulateColors {
 
     public static void main(String[] args) throws InterruptedException {
         JFrame frame=new JFrame("������ɫ");
         JPanel pColor=new JPanel();
         pColor.setBackground(new Color(255,0,0));//������屳����ɫ
         JLabel lColor=new JLabel("0,0,0");//������ǩ���󲢳�ʼ����ǩ
         JScrollBar sRed=new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);
         JScrollBar sGreen=new JScrollBar(JScrollBar.HORIZONTAL,0,1,0,256);
         JScrollBar sBlue=new JScrollBar(JScrollBar.HORIZONTAL,0,1,0,256);
         frame.setLayout(new GridLayout(5,1));//����frame��ܲ��ָ�ʽΪ���񲼾�
         frame.setSize(400,300);//����frame��Сʱ�Ͳ�������frame.pack()��Ȼ��������
         //��������ʹ��frame����һ������������Ӹ������
         frame.add(pColor);
         frame.add(lColor);
         frame.add(sRed);
         frame.add(sGreen);
         frame.add(sBlue);
 //        frame.pack();
         frame.setVisible(true);
         int nRed,nGreen,nBlue;
        while(true){
             nRed=sRed.getValue();//��ȡ��������Ӧ��ֵ
             nGreen=sGreen.getValue();
             nBlue=sBlue.getValue();
             Color col=new Color(nRed,nGreen,nBlue);//������ɫ��Ķ���ʵ������ɫ��Ķ��󣬲�����RGB��ֵ
             pColor.setBackground(col);
             lColor.setText(nRed+","+nGreen+","+nBlue);//�ڱ�ǩ�ﶯ̬��ʾRGB��Ӧ��ֵ
             Thread.sleep(300);//����ǰ�̹߳���ָ����ʱ�䣨300ms������whileÿ��ѭ�����300msʱ��
         }
     }
 
 }