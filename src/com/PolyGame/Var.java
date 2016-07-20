package com.PolyGame;

import java.awt.Point;

public class Var {
	static int maxNum=100;//������
	public static int myRange=5;
	public static int MyNum=5;
	public static MyRect myRect[] = new MyRect[maxNum];//�����
	public static MyEdge myEdge[] = new MyEdge[maxNum];//��
	public static MyRect myRectReset[] = new MyRect[maxNum];//����� ����
	public static MyEdge myEdgeReset[] = new MyEdge[maxNum];//�� ����
	public static MyRect myRectBack[] = new MyRect[maxNum];//����� ����
	public static MyEdge myEdgeBack[] = new MyEdge[maxNum];//�� ����
	public static int flag=0;
	private static int startX=250;// �����X����
	private static int startY=10;// �����Y����
	private static int r=200;// ���Բ�İ뾶
	static{
		for(int i=0;i<maxNum;i++){
			myRect[i]=new MyRect();
			myEdge[i]=new MyEdge();
			myRectReset[i]=new MyRect();
			myEdgeReset[i]=new MyEdge();
			myRectBack[i]=new MyRect();
			myEdgeBack[i]=new MyEdge();
		}
	}
	public static void init(){//�����ʼ��
		for(int i = 0;i<maxNum;i++){
			myRect[i].flag=0;
			myEdge[i].flag=0;
		}
		posOfPoint(MyNum);
	}
	
	private static void posOfPoint(int bianshu) { 
		myRect[0].x = startX;
		myRect[0].y = startY;
		myRect[0].init();
		Point p = new Point();
		for (int i = 1; i < bianshu; i++) {
			p = nextPoint(((2 * Math.PI) / bianshu) * i);
			myRect[i].x = p.x;
			myRect[i].y = p.y;
			myRect[i].init();
		}
		for(int i=0;i<bianshu;i++){
			myEdge[i].init(i);
		}
	}

	private static Point nextPoint(double arc) {// arcΪ���ȣ��ڶ��㴦����ֱ������ϵ����r��arcȷ����һ���������
		Point p = new Point();
		p.x = (int) (myRect[0].x + r * Math.sin(arc));
		p.y = (int) (myRect[0].y + r - r * Math.cos(arc));
		return p;
	}
}
