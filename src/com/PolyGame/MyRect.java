package com.PolyGame;

import java.util.Random;

public class MyRect {
	int x,y;//����
	int value;//��ֵ
	int flag;//�Ƿ����
	public void init(){ //��ֵ��ʼ��
		Random rand = new Random();
		this.value=rand.nextInt(Var.myRange);
		if(rand.nextInt(2)==0){
			this.value=-this.value;
		}
		this.flag=1;

	}
}
