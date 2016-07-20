package com.PolyGame;

import java.util.Random;

public class MyRect {
	int x,y;//坐标
	int value;//数值
	int flag;//是否存在
	public void init(){ //数值初始化
		Random rand = new Random();
		this.value=rand.nextInt(Var.myRange);
		if(rand.nextInt(2)==0){
			this.value=-this.value;
		}
		this.flag=1;

	}
}
