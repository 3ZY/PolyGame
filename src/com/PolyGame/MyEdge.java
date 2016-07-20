package com.PolyGame;

import java.util.Random;

public class MyEdge {
	int x1,x2,y1,y2,x3,y3;//×ø±ê
	int flag;//ÊÇ·ñ´æÔÚ
	int value;//·ûºÅ
	public void init(int i){
		int j=i+1;
		Random rand= new Random();
		this.value=rand.nextInt(2);
		this.flag = 1;
		if(i==Var.MyNum-1){
			j=0;
		}
		this.x1 = Var.myRect[i].x+PolyPanel.rectLength/2;// rect[].x+rectLength/2
		this.y1 = Var.myRect[i].y+PolyPanel.rectLength/2;// rect[].y+rectLength/2
		this.x2 = Var.myRect[j].x+PolyPanel.rectLength/2;
		this.y2 = Var.myRect[j].y+PolyPanel.rectLength/2;
		this.x3 = (this.x1 + this.x2 - PolyPanel.ovalLength) / 2;// (x1+x2-ovalLength)/2
		this.y3 = (this.y1+this.y2 - PolyPanel.ovalLength )/ 2;// (y1+y2-ovalLength)/2

		
	}
}
