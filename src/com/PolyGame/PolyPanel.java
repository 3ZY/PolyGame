package com.PolyGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.util.Vector;

import javax.swing.JPanel;

import org.omg.CORBA.PolicyTypeHelper;

public class PolyPanel extends JPanel{
	
	Vector<Integer> vin;
	int maxEdge=0;
	
	private Color lineColor = new Color(121,121,121);//�߶���ɫ
	private Color backColor = new Color(0,255,0);
	private Color pointColor = new Color(255,255,255);//������ɫ
	public static int rectLength = 50;//���ο��
	public static int ovalLength=30;//Բ��ֱ��
	public static int maxNum=0;//���ֵ
	public static int myNum=0;//�ҵĽ�
	public static int edgeNum =Var.MyNum;
	public static int flag=0;//�Ƿ���ʾ���Ž�
	public PolyPanel(){
//		this.setBackground(backColor);
	}
	
	//���������Ϸ
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		
		Stroke lineStroke =new BasicStroke(8.0f);//�߿�
		Stroke rectStroke =new BasicStroke(2.0f);//Բ��
		
		if(this.edgeNum==0){//�����Ϸ
			g2d.setColor(Color.BLACK);//������ɫ
			g2d.setFont(new Font("΢���ź�",Font.ITALIC,24));//�ı�������ʽ	
			g2d.drawString("�����"+ this.myNum,235 , 205 );//��ֵ
			g2d.drawString("���ֵ��"+ this.maxNum,215 , 255 );//��ֵ
			
			
		}else{
			//����
			for(int i=0;i<Var.MyNum;i++){
				if(Var.myEdge[i].flag==0)
					continue;
				
				g2d.setColor(lineColor);//������ɫ
				g2d.setStroke(lineStroke);//���ÿ��
				g2d.drawLine(Var.myEdge[i].x1, Var.myEdge[i].y1, Var.myEdge[i].x2, Var.myEdge[i].y2);
				g2d.setColor(pointColor);//������ɫ
				g2d.fillOval(Var.myEdge[i].x3, Var.myEdge[i].y3, ovalLength, ovalLength);//������
				
				g2d.setStroke(rectStroke);//���ÿ��	
				
				g2d.setColor(Color.BLACK);//������ɫ
				g2d.drawOval(Var.myEdge[i].x3, Var.myEdge[i].y3, ovalLength, ovalLength);//���εı߿�
				
				g2d.setFont(new Font("΢���ź�",Font.ITALIC,24));//�ı�������ʽ	
				if(Var.myEdge[i].value==0){
					g2d.drawString("+", 5+Var.myEdge[i].x3, 22+Var.myEdge[i].y3);//��ֵ
				}else{
					g2d.drawString("X", 7+Var.myEdge[i].x3, 22+Var.myEdge[i].y3);//��ֵ
				}
				if(flag==1){
					int edge=i+2;
					if (edge>Var.MyNum)
						edge=1;
					g2d.drawString(""+edge, 40+Var.myEdge[i].x3, 22+Var.myEdge[i].y3);
				}
			}
			
			//��ʾ���Ž�
			if(flag==1){
				g2d.drawString("���Ž⣺"+this.maxNum+"    ���߹��̣�", 40, 490);
				g2d.drawString(""+maxEdge, 320, 490);
				for (int v= vin.size()-1; v>=0; v--){
					g2d.drawString(""+vin.get(v), 320+30*(Var.MyNum-1-v), 490);
				}
			}
			
			g2d.setStroke(rectStroke);//���ÿ��	
			for(int i=0;i<Var.MyNum;i++){
				//����ֵ��
				if(Var.myRect[i].flag==0)
					continue;	
				g2d.setColor(pointColor);//������ɫ
				g2d.fillRect(Var.myRect[i].x, Var.myRect[i].y, rectLength, rectLength);//������
			
				g2d.setColor(Color.BLACK);//������ɫ
				g2d.drawRect(Var.myRect[i].x, Var.myRect[i].y, rectLength, rectLength);//���εı߿�

				g2d.setFont(new Font("΢���ź�",Font.ITALIC,24));//�ı�������ʽ	
				g2d.drawString(""+Var.myRect[i].value, 6+Var.myRect[i].x, 34+Var.myRect[i].y);//��ֵ
			}
		}
		
		
	}//paint(Graphics g)
	
	public void init(){//��ʼ�����꼰��״̬
			Var.init();
			Var.flag=0;//���ɳ���
			this.getMaxSum();
		for(int i=0;i<Var.MyNum;i++){
			
			//���ݳ�ʼ״̬
			Var.myRectReset[i].flag  = 1;
			Var.myRectReset[i].value = Var.myRect[i].value;
			Var.myRectReset[i].x     = Var.myRect[i].x;
			Var.myRectReset[i].y     = Var.myRect[i].y;
			
			Var.myEdgeReset[i].flag  = 1;
			Var.myEdgeReset[i].value = Var.myEdge[i].value;
			Var.myEdgeReset[i].x1    = Var.myEdge[i].x1;
			Var.myEdgeReset[i].x2    = Var.myEdge[i].x2;
			Var.myEdgeReset[i].x3    = Var.myEdge[i].x3;
			Var.myEdgeReset[i].y1    = Var.myEdge[i].y1;
			Var.myEdgeReset[i].y2    = Var.myEdge[i].y2;
			Var.myEdgeReset[i].y3    = Var.myEdge[i].y3;
			
		}
	}
	
	public void backup(){//������һ��
		for(int i=0;i<Var.MyNum;i++){
			Var.myRectBack[i].flag  = Var.myRect[i].flag;
			Var.myRectBack[i].value = Var.myRect[i].value;
			Var.myRectBack[i].x     = Var.myRect[i].x;
			Var.myRectBack[i].y     = Var.myRect[i].y;
			
			Var.myEdgeBack[i].flag  = Var.myEdge[i].flag;
			Var.myEdgeBack[i].value = Var.myEdge[i].value;
			Var.myEdgeBack[i].x1    = Var.myEdge[i].x1;
			Var.myEdgeBack[i].x2    = Var.myEdge[i].x2;
			Var.myEdgeBack[i].x3    = Var.myEdge[i].x3;
			Var.myEdgeBack[i].y1    = Var.myEdge[i].y1;
			Var.myEdgeBack[i].y2    = Var.myEdge[i].y2;
			Var.myEdgeBack[i].y3    = Var.myEdge[i].y3;
		}
		Var.flag=1;//�ɳ���
	}
	
	int op[];
	int m[][][];
	int t[][][];
	int v[];
	int g[][][][];
	int maxf,minf;

	public void getMaxSum() {// ��ȡ���ֵ
		
		op=new int[Var.MyNum+1];
		m=new int[Var.MyNum+1][Var.MyNum+1][2];
		t=new int[Var.MyNum+1][Var.MyNum+1][2];
		v=new int[Var.MyNum+1];
		g=new int[Var.MyNum+1][Var.MyNum+1][Var.MyNum+1][2];
		vin=new Vector<Integer>();
		for(int i=1;i<=Var.MyNum;i++){
			m[i][1][0]=m[i][1][1]=Var.myRect[i-1].value;
			for (int j = 2; j <= Var.MyNum; j++) {
				m[i][j][0] = 9999;
				m[i][j][1] = -9999;
			}
			if(i-2<0)
				op[i] = Var.myEdge[Var.MyNum-1].value;
			else 
				op[i] = Var.myEdge[i-2].value;
//			op[i] = Var.myEdge[i-1].value;
		}
		
		for (int j = 2; j <= Var.MyNum; j++)
			for (int i = 1; i <= Var.MyNum; i++)
				for (int s = 1; s < j; s++) {
					minMax(i, s, j);
					if (m[i][j][0] > minf) {
						m[i][j][0] = minf;
						t[i][j][0] = s;
					}
					if (m[i][j][1] < maxf) {
						m[i][j][1] = maxf;
						t[i][j][1] = s;
					}
				}
		
		int maxSum=m[1][Var.MyNum][1];
		maxEdge=1;
	    for(int i=2;i<=Var.MyNum;i++)  
	    {  
	    	
	        if(m[i][Var.MyNum][1]>maxSum)  
	        {  
	            maxSum=m[i][Var.MyNum][1];  
	            maxEdge=i;
	        }  
	    }  
	    
		this.maxNum =maxSum;
		findway(maxEdge,Var.MyNum,1);	


	}

	void minMax(int i,int s,int j)
    {
    	int e[]=new int[5];
    	int a=m[i][s][0],
    	b=m[i][s][1],
    	r=(i+s-1)%Var.MyNum+1,
    	c=m[r][j-s][0],
    	d=m[r][j-s][1];
    	
    	if(op[r]==0)
    	{
    		minf=a+c;
    		maxf=b+d;
    		g[i][s][j][0]=0;
    		g[i][s][j][1]=0;
		 }
		 else 
		 {
		 	e[1]=a*c;
		 	e[2]=a*d;
		 	e[3]=b*c;
		 	e[4]=b*d;
		 	minf=e[1];
		 	maxf=e[1];
		 	for(int k=2;k<5;k++)
		 	{
		 		if(minf>(e[k])) 
				 {
				 	minf=e[k];
				 	g[i][s][j][0]=k;
				 }
		 		if(maxf<e[k])
				 {
		 			 maxf=e[k];
		 			 g[i][s][j][1]=k;
				 }
			 }
		 }
		  
	 }
	
	void findway(int i,int j,int bin)
	 {
	 	if(j==1)return;
	 	if(j==2)
	 	{
	 	  vin.add((i)%Var.MyNum+1);	
	 	  return;
		}
	    int s=t[i][j][bin];	
	    int	r=(i+s-1)%Var.MyNum+1;
	    vin.add(r);
	    switch(g[i][s][j][bin])
	    {
	    	case 0:findway(i,s,bin);findway(r,j-s,bin);break;
	    	case 1:findway(i,s,0);findway(r,j-s,0);break;
	    	case 2:findway(i,s,0);findway(r,j-s,1);break;
	    	case 3:findway(i,s,1);findway(r,j-s,0);break;
	    	case 4:findway(i,s,1);findway(r,j-s,1);break;
		}
	}	 
	
	
}
