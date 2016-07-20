package com.PolyGame;

import java.awt.Point;

public class Var {
	static int maxNum=100;//最大边数
	public static int myRange=5;
	public static int MyNum=5;
	public static MyRect myRect[] = new MyRect[maxNum];//多边形
	public static MyEdge myEdge[] = new MyEdge[maxNum];//边
	public static MyRect myRectReset[] = new MyRect[maxNum];//多边形 重做
	public static MyEdge myEdgeReset[] = new MyEdge[maxNum];//边 重做
	public static MyRect myRectBack[] = new MyRect[maxNum];//多边形 撤销
	public static MyEdge myEdgeBack[] = new MyEdge[maxNum];//边 撤销
	public static int flag=0;
	private static int startX=250;// 顶点的X坐标
	private static int startY=10;// 顶点的Y坐标
	private static int r=200;// 外接圆的半径
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
	public static void init(){//坐标初始化
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

	private static Point nextPoint(double arc) {// arc为弧度，在顶点处建立直角坐标系，用r和arc确定下一个点的坐标
		Point p = new Point();
		p.x = (int) (myRect[0].x + r * Math.sin(arc));
		p.y = (int) (myRect[0].y + r - r * Math.cos(arc));
		return p;
	}
}
