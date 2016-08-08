package com.recursion.www;

public class Power {
	

	public static void main(String[] args){
		long a = power(3, 18);
		System.out.println(a);
	}

	private static long power(long i, long j) {
	
		if(j == 1){
			return i;
		}
		else if(j>1 && j%2==0){
			i = i*i;
			j = j/2;
			i = power(i,j);
		}
		else if(j>1 && j%2==1){
			i = i*power(i*i,j/2);
		}
		return i;
		
	}
}
