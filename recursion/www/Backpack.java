package com.recursion.www;
/**
 * 用递归解决背包问题
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Backpack {
	private static int maxWeight;
	//private static int lastWeight;
	//private static int[] arr;
	//private static int i = 0;
	public static ArrayList<Integer> adapt = new ArrayList<>();
	private static int size;
	public static void main(String[] args) throws IOException{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(in);
		System.out.println("please input the backpack weight");
		maxWeight =Integer.parseInt(buff.readLine());
		//lastWeight = maxWeight;
		System.out.println("please input the array size");
		size = Integer.parseInt(buff.readLine()) ;
		DArray array = new DArray(size);
		System.out.println("please input the array");
		for(int i=0;i<size;i++){
			array.insert(Integer.parseInt(buff.readLine()));
		}
		array.mergeSort();
		array.display();
		//arr = new int[size];
		size--;
		boolean a = BackPack(array,0,size,maxWeight);
		System.out.println(adapt.toString());
	}
	private static boolean BackPack(DArray array,int start, int end,int weight) {
		boolean flag = false;
		for(int m = end;m>=start;m--){
			int temp = (int) (weight - array.peek(m));
			if(temp==0) flag = true;
			else if(temp<0) flag = false;
			else
				flag = BackPack(array,start,end-1,temp);
			if(flag){
				adapt.add((int) array.peek(m));
				return true;
			}
		}
		
		return flag;
		
		
	}

/*	private static void BackPack(DArray array, int s) {
		
		lastWeight = (int) (lastWeight - array.peek(s));
		System.out.println(lastWeight);
		
		if(lastWeight == 0){
			arr[i] = (int) array.peek(s);
			System.out.println("success");
		}
		else if(lastWeight>0){
				arr[i] = (int) array.peek(s);
				i++;
				BackPack(array,s-1);
			}
		else if(lastWeight<0)
			{
				size--;
				lastWeight = maxWeight;
				i = 0;
				BackPack(array,size);
			}
				
		
	}
*/
	
}
