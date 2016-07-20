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

	private int PolyPanel_HEIGHT=497;//���������
	private int PolyPanel_WIDTH=573;//���������
	myPanel mp=null; //�������
	JButton[] jb=null; //��ť��
	PolyPanel pp=null; //��������
	Play play =null;
	public PolyGame(){
		
		mp = new myPanel();
		mp.setLayout(null);
		
		pp= new PolyPanel();//��������
		pp.init();
		play=new Play(pp);
		pp.addMouseListener(play);
		pp.setBounds(0, 45, this.PolyPanel_WIDTH, this.PolyPanel_HEIGHT); //����PolyPanel λ�ü���С
		pp.setOpaque(false);//�������͸��
		mp.add(pp); //���PolyPanel�����
		
		
		jb=new JButton[6];		//��ť��
		//Ϊ����ť����
		jb[0] = new JButton("����");
		jb[1] = new JButton("����");
		jb[2] = new JButton("���ѡ��");
		jb[3] = new JButton("��Ϸ����");
		jb[4] = new JButton("����Ϸ");
		jb[5] = new JButton("��ʾ����");
		

		// ���ð�ťλ�����С
		jb[0].setBounds(565, 290, 100, 30);
		jb[1].setBounds(685, 290, 100, 30);
		jb[2].setBounds(565, 350, 100, 30);
		jb[3].setBounds(685, 350, 120, 30);
		jb[4].setBounds(565, 410, 100, 30);
		jb[5].setBounds(685, 410, 120, 30);
		
		//���ð�ť����
		jb[0].setActionCommand("����");
		jb[1].setActionCommand("����");
		jb[2].setActionCommand("���ѡ��");
		jb[3].setActionCommand("��Ϸ����");
		jb[4].setActionCommand("����Ϸ");
		jb[5].setActionCommand("���Ž�");
		
		// ���ð�ť��ʽ������������
		for (int i = 0; i < 6; i++) {
			jb[i].setFont(new Font("΢���ź�", 1, 19)); // ��������
			jb[i].setForeground(Color.black); // ������ɫ
			jb[i].setBorder(null); // ����ʾ�߿�
			jb[i].setContentAreaFilled(false); // ��ť���͸��
			mp.add(jb[i]); // ��Ӱ�ť�������
			jb[i].addActionListener(this); // ��Ӱ�ť����
		}
		
		//����ͼ��
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/ico.png")));	
		
		this.add(mp,BorderLayout.CENTER); //������������������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�������Ϸ");	//���ô��ڱ���
		this.setSize(889,585);	//���ô��ڴ�С
		this.setResizable(false);//���ɸı䴰�ڴ�С
		this.setLocationRelativeTo(null);//����
		this.setVisible(true);//���ڿ���
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolyGame myPolyGame = new PolyGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action=e.getActionCommand();
		if(action.equals("����")){
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
					Var.flag=0;//���ɳ���
					pp.repaint();
				}
			}
			
			
		}else if(action.equals("����")){
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
				Var.flag=0;//���ɳ���
				pp.repaint();
			}
			
		}else if(action.equals("���ѡ��")){
			if(PolyPanel.edgeNum>0){
				Random rand = new Random();
				int i=rand.nextInt(Var.MyNum);
				while(Var.myEdge[i].flag!=1){
					i=rand.nextInt(Var.MyNum);
				}
				play.changeStat(i);

			}
			
		}else if(action.equals("��Ϸ����")){
			final JDialog jd = new JDialog();
            jd.setBounds(550, 300, 260, 150);
            jd.setTitle("��Ϸ����");
            final JTextField edgeInput = new JTextField(10);
            final JTextField rangeInput = new JTextField(10);
            jd.getContentPane().setLayout(new GridLayout(3, 3));
            jd.add(new JLabel("������"));
            jd.add(edgeInput);
            jd.add(new JLabel("���ֵ"));
            jd.add(rangeInput);
            JButton jbYes=new JButton("ȷ��");
            JButton jbCencel=new JButton("ȡ��");
           
            jbYes.addActionListener(new ActionListener()
            {
            	public void actionPerformed(ActionEvent arg0) {

            		String str1 = edgeInput.getText().trim();
            		String str2 = rangeInput.getText().trim();

            		try {
            			int edgeInt = Integer.parseInt(str1);
            			int rangeInt = Integer.parseInt(str2);
            			if( edgeInt<3){
            				JOptionPane.showMessageDialog(null, "��������Ϊ3");
            			}else if(edgeInt>Var.maxNum){
            				JOptionPane.showMessageDialog(null, "��������Ϊ100");
            			}else if( rangeInt<1){
            				JOptionPane.showMessageDialog(null, "���ֵ����Ϊ������");
            			}else{
            				Var.MyNum=edgeInt;
            				Var.myRange=rangeInt;
            				pp.init();
            				pp.repaint();
            				PolyPanel.edgeNum=Var.MyNum;
            				jd.dispose();
            			}
            			
            		} catch (NumberFormatException e) {
            			JOptionPane.showMessageDialog(null, "���������Ϣ��");
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
            jd.setModal(true);//ȷ�������Ĵ�������������ǰ��
            jd.setVisible(true);

            
		}else if(action.equals("����Ϸ")){
			pp.init();
			pp.repaint();
			PolyPanel.edgeNum=Var.MyNum;
		}else if(action.equals("���Ž�")){
			if(PolyPanel.flag==0){
				PolyPanel.flag=1;
				jb[5].setText("��������");
			}else{
				PolyPanel.flag=0;
				jb[5].setText("��ʾ����");
			}
			pp.repaint();
		}
	
	}

}
