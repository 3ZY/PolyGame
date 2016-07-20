package com.PolyGame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PolyGame extends JFrame implements ActionListener{

	private int PolyPanel_HEIGHT=497;//多边形面板高
	private int PolyPanel_WIDTH=573;//多边形面板宽
	myPanel mp=null; //界面面板
	JButton[] jb=null; //按钮组
	PolyPanel pp=null; //多边形面板
	Play play =null;
	public PolyGame(){
		
		mp = new myPanel();
		mp.setLayout(null);
		
		pp= new PolyPanel();//多边形面板
		pp.init();
		play=new Play(pp);
		pp.addMouseListener(play);
		pp.setBounds(0, 45, this.PolyPanel_WIDTH, this.PolyPanel_HEIGHT); //设置PolyPanel 位置及大小
		pp.setOpaque(false);//设置面板透明
		mp.add(pp); //添加PolyPanel至面板
		
		
		jb=new JButton[6];		//按钮组
		//为各按钮命名
		jb[0] = new JButton("撤销");
		jb[1] = new JButton("重做");
		jb[2] = new JButton("随机选择");
		jb[3] = new JButton("游戏设置");
		jb[4] = new JButton("新游戏");
		jb[5] = new JButton("显示最优");
		

		// 设置按钮位置与大小
		jb[0].setBounds(565, 290, 100, 30);
		jb[1].setBounds(685, 290, 100, 30);
		jb[2].setBounds(565, 350, 100, 30);
		jb[3].setBounds(685, 350, 120, 30);
		jb[4].setBounds(565, 410, 100, 30);
		jb[5].setBounds(685, 410, 120, 30);
		
		//设置按钮命令
		jb[0].setActionCommand("撤销");
		jb[1].setActionCommand("重做");
		jb[2].setActionCommand("随机选择");
		jb[3].setActionCommand("游戏设置");
		jb[4].setActionCommand("新游戏");
		jb[5].setActionCommand("最优解");
		
		// 设置按钮格式并添加至主面板
		for (int i = 0; i < 6; i++) {
			jb[i].setFont(new Font("微软雅黑", 1, 19)); // 文字字体
			jb[i].setForeground(Color.black); // 文字颜色
			jb[i].setBorder(null); // 不显示边框
			jb[i].setContentAreaFilled(false); // 按钮面板透明
			mp.add(jb[i]); // 添加按钮至主面板
			jb[i].addActionListener(this); // 添加按钮监听
		}
		
		//设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/ico.png")));	
		
		this.add(mp,BorderLayout.CENTER); //主界面添加主界面面板
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("多边形游戏");	//设置窗口标题
		this.setSize(889,585);	//设置窗口大小
		this.setResizable(false);//不可改变窗口大小
		this.setLocationRelativeTo(null);//居中
		this.setVisible(true);//窗口可视
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolyGame myPolyGame = new PolyGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action=e.getActionCommand();
		if(action.equals("撤销")){
			if(Var.flag==1){
				if (PolyPanel.edgeNum != Var.MyNum) {
					for (int i = 0; i < Var.MyNum; i++) {
						Var.myRect[i].flag  = Var.myRectBack[i].flag;
						Var.myRect[i].value = Var.myRectBack[i].value;
						Var.myRect[i].x     = Var.myRectBack[i].x;
						Var.myRect[i].y     = Var.myRectBack[i].y;

						Var.myEdge[i].flag  = Var.myEdgeBack[i].flag;
						Var.myEdge[i].value = Var.myEdgeBack[i].value;
						Var.myEdge[i].x1    = Var.myEdgeBack[i].x1;
						Var.myEdge[i].x2    = Var.myEdgeBack[i].x2;
						Var.myEdge[i].x3    = Var.myEdgeBack[i].x3;
						Var.myEdge[i].y1    = Var.myEdgeBack[i].y1;
						Var.myEdge[i].y2    = Var.myEdgeBack[i].y2;
						Var.myEdge[i].y3    = Var.myEdgeBack[i].y3;
					}
					PolyPanel.edgeNum++;
					Var.flag=0;//不可撤销
					pp.repaint();
				}
			}
			
			
		}else if(action.equals("重做")){
			if (PolyPanel.edgeNum != Var.MyNum) {
				for (int i = 0; i < Var.MyNum; i++) {
					Var.myRect[i].flag  = Var.myRectReset[i].flag;
					Var.myRect[i].value = Var.myRectReset[i].value;
					Var.myRect[i].x     = Var.myRectReset[i].x;
					Var.myRect[i].y     = Var.myRectReset[i].y;

					Var.myEdge[i].flag  = Var.myEdgeReset[i].flag;
					Var.myEdge[i].value = Var.myEdgeReset[i].value;
					Var.myEdge[i].x1    = Var.myEdgeReset[i].x1;
					Var.myEdge[i].x2    = Var.myEdgeReset[i].x2;
					Var.myEdge[i].x3    = Var.myEdgeReset[i].x3;
					Var.myEdge[i].y1    = Var.myEdgeReset[i].y1;
					Var.myEdge[i].y2    = Var.myEdgeReset[i].y2;
					Var.myEdge[i].y3    = Var.myEdgeReset[i].y3;
				}
				PolyPanel.edgeNum=Var.MyNum;
				Var.flag=0;//不可撤销
				pp.repaint();
			}
			
		}else if(action.equals("随机选择")){
			if(PolyPanel.edgeNum>0){
				Random rand = new Random();
				int i=rand.nextInt(Var.MyNum);
				while(Var.myEdge[i].flag!=1){
					i=rand.nextInt(Var.MyNum);
				}
				play.changeStat(i);

			}
			
		}else if(action.equals("游戏设置")){
			final JDialog jd = new JDialog();
            jd.setBounds(550, 300, 260, 150);
            jd.setTitle("游戏设置");
            final JTextField edgeInput = new JTextField(10);
            final JTextField rangeInput = new JTextField(10);
            jd.getContentPane().setLayout(new GridLayout(3, 3));
            jd.add(new JLabel("顶点数"));
            jd.add(edgeInput);
            jd.add(new JLabel("最大值"));
            jd.add(rangeInput);
            JButton jbYes=new JButton("确定");
            JButton jbCencel=new JButton("取消");
           
            jbYes.addActionListener(new ActionListener()
            {
            	public void actionPerformed(ActionEvent arg0) {

            		String str1 = edgeInput.getText().trim();
            		String str2 = rangeInput.getText().trim();

            		try {
            			int edgeInt = Integer.parseInt(str1);
            			int rangeInt = Integer.parseInt(str2);
            			if( edgeInt<3){
            				JOptionPane.showMessageDialog(null, "边数至少为3");
            			}else if(edgeInt>Var.maxNum){
            				JOptionPane.showMessageDialog(null, "边数至多为100");
            			}else if( rangeInt<1){
            				JOptionPane.showMessageDialog(null, "最大值必须为正整数");
            			}else{
            				Var.MyNum=edgeInt;
            				Var.myRange=rangeInt;
            				pp.init();
            				pp.repaint();
            				PolyPanel.edgeNum=Var.MyNum;
            				jd.dispose();
            			}
            			
            		} catch (NumberFormatException e) {
            			JOptionPane.showMessageDialog(null, "输入错误信息！");
            		}
            	}
            });
            
            
            jbCencel.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					jd.dispose();
				}
			});
            
            jd.add(jbYes);
            jd.add(jbCencel);
            jd.setModal(true);//确保弹出的窗口在其他窗口前面
            jd.setVisible(true);

            
		}else if(action.equals("新游戏")){
			pp.init();
			pp.repaint();
			PolyPanel.edgeNum=Var.MyNum;
		}else if(action.equals("最优解")){
			if(PolyPanel.flag==0){
				PolyPanel.flag=1;
				jb[5].setText("隐藏最优");
			}else{
				PolyPanel.flag=0;
				jb[5].setText("显示最优");
			}
			pp.repaint();
		}
	
	}

}
