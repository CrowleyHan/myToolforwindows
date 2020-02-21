package com.windowspojo;

import java.awt.Color;
 import java.awt.GridLayout;


 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import javax.swing.JScrollBar;
 
 public class ModulateColors {
 
     public static void main(String[] args) throws InterruptedException {
         JFrame frame=new JFrame("调制颜色");
         JPanel pColor=new JPanel();
         pColor.setBackground(new Color(255,0,0));//设置面板背景颜色
         JLabel lColor=new JLabel("0,0,0");//创建标签对象并初始化标签
         JScrollBar sRed=new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);
         JScrollBar sGreen=new JScrollBar(JScrollBar.HORIZONTAL,0,1,0,256);
         JScrollBar sBlue=new JScrollBar(JScrollBar.HORIZONTAL,0,1,0,256);
         frame.setLayout(new GridLayout(5,1));//设置frame框架布局格式为网格布局
         frame.setSize(400,300);//设置frame大小时就不能设置frame.pack()不然不起作用
         //以下是在使用frame对象一次在网格里添加各个组件
         frame.add(pColor);
         frame.add(lColor);
         frame.add(sRed);
         frame.add(sGreen);
         frame.add(sBlue);
 //        frame.pack();
         frame.setVisible(true);
         int nRed,nGreen,nBlue;
        while(true){
             nRed=sRed.getValue();//获取滚动条对应的值
             nGreen=sGreen.getValue();
             nBlue=sBlue.getValue();
             Color col=new Color(nRed,nGreen,nBlue);//创建颜色类的对象并实例化颜色类的对象，参数是RGB的值
             pColor.setBackground(col);
             lColor.setText(nRed+","+nGreen+","+nBlue);//在标签里动态显示RGB对应的值
             Thread.sleep(300);//将当前线程挂起指定的时间（300ms）即：while每次循环间隔300ms时间
         }
     }
 
 }