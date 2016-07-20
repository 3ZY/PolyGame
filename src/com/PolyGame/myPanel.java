package com.PolyGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class myPanel extends JPanel{

	//ªÒ»°±≥æ∞
	Image im=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/back.png"));
	
	public myPanel(){
		this.setBackground(Color.white);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(im, 0, 2, 877, 557,this);
	}
}

