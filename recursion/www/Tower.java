package com.recursion.www;
/**
 * ººÅµËþÎÊÌâ
 * @author 23176
 *
 */

public class Tower {
	static int nDisks = 3;
	public static void main(String[] args){
		doTowers(nDisks,'A','B','C');
	}
	private static void doTowers(int topN, char from, char inter, char to) {
		if(topN == 1){
			System.out.println("disk 1 from"+from+"to"+to);
		}
		else{
			doTowers(topN-1, from, to, inter);	//from-->inter
			System.out.println("disk"+topN+"from"+from+"to"+to);
			doTowers(topN-1, inter, from, to); 	//inter-->to
		}
	}

}
