package com.PolyGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Play extends MouseAdapter{

	private int x,y;
	private PolyPanel pp=null;
	public Play(PolyPanel pp){
		this.pp=pp;
	}
   
	//������
	public void mouseReleased(MouseEvent e){
		super.mouseReleased(e);
		x=e.getPoint().x;
		y=e.getPoint().y;
		
		for (int i=0;i<Var.MyNum;i++){
			if( Math.pow(x-Var.myEdge[i].x3-PolyPanel.ovalLength/2,2)+Math.pow(y-Var.myEdge[i].y3-PolyPanel.ovalLength/2,2)<=Math.pow(PolyPanel.ovalLength/2,2)){
				if(Var.myEdge[i].flag==1){//����˵�i�ߣ����ñ�δ�������
					this.changeStat(i);
				}
				
			}
		}
	}//mouseReleased(MouseEvent e)
	
	//��߸ı�
	public void changeStat(int i){
		int point1=-1,point2=-1,edge1=-1,flag=0;
		
		for(int j=0;j<Var.MyNum;j++){//�жϸñ߰�����������
			if(Var.myEdge[i].x1==Var.myRect[j].x + PolyPanel.rectLength/2
					&& Var.myEdge[i].y1==Var.myRect[j].y + PolyPanel.rectLength/2){
				point1=j;
			}
			if(Var.myEdge[i].x2==Var.myRect[j].x + PolyPanel.rectLength/2
					&& Var.myEdge[i].y2==Var.myRect[j].y + PolyPanel.rectLength/2){
				point2=j;
			}
		}
		for(int j =0;j<Var.MyNum;j++){//�ж�ǰ����������
			if(Var.myEdge[j].flag==1){
				if(Var.myEdge[j].x2==Var.myRect[point1].x + PolyPanel.rectLength/2
						&& Var.myEdge[j].y2==Var.myRect[point1].y + PolyPanel.rectLength/2){
					edge1=j;
					flag=1;
				}
			}
		}
		
		if(PolyPanel.edgeNum>0){
			pp.backup();
			Var.myEdge[i].flag=0;
			if(PolyPanel.edgeNum<Var.MyNum){
				if(Var.myEdge[i].value==0){//+ �ӷ�
					Var.myRect[point2].value+=Var.myRect[point1].value;
				}else{//x �˷�
					Var.myRect[point2].value*=Var.myRect[point1].value;
				}
				Var.myRect[point1].flag=0;
				if(flag==1){//ǰ��ıߴ���
					Var.myEdge[edge1].x2=Var.myRect[point2].x + PolyPanel.rectLength/2;
					Var.myEdge[edge1].y2=Var.myRect[point2].y + PolyPanel.rectLength/2;
					Var.myEdge[edge1].x3=(Var.myEdge[edge1].x1 + Var.myEdge[edge1].x2-PolyPanel.ovalLength)/2;
					Var.myEdge[edge1].y3=(Var.myEdge[edge1].y1 + Var.myEdge[edge1].y2-PolyPanel.ovalLength)/2;
				}
			}
			PolyPanel.edgeNum--;
			if(PolyPanel.edgeNum==0){//�����Ϸ
				PolyPanel.myNum=Var.myRect[point2].value;
			}
			pp.repaint();
		}
	}//changeStat(int i)

}//class Play
