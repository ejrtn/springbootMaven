package com.example.demo.utils;



import java.util.ArrayList;
import java.util.Random;

public class Numbergeneration {
	
	public String SudokuPrint(int count) {
		int[] arr = new int[81];
		int s=0;
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		Random random= new Random();
		for(int i=0;i<81;i++) {
			
			if(arrlist.size()==0) {
				for(int x=1;x<10;x++) {
					arrlist.add(x);
				}
			}
			while(true) {
				int num = random.nextInt(arrlist.size());
				if(line_y(i,num,arr,arrlist)==1) {
					arr[i]=arrlist.get(num);
					arrlist.remove(num);
					break;
				}
				s++;
				if(s>100000) {
					i=-1;
					for(int x=0;x<81;x++) {
						arr[x]=0;
					}
					s=0;
					arrlist.removeAll(arrlist);
					break;
				}
			}
		}
		
		String ss="";
		ArrayList<Integer> arrayarr = new ArrayList<Integer>();
		for(int i=0;i<81;i++) {
			arrayarr.add(i);
		}
		for(int i=0;i<count;i++) {
			int z=random.nextInt(arrayarr.size());
			arr[arrayarr.get(z)]=0;
			arrayarr.remove(z);
		}
		for(int i=0;i<81;i++) {
			ss+=arr[i];
			if(i%9==8) {
				ss+="/";
			}
			
//			System.out.print(arr[i]+" ");
//			if(i%9==8) {
//				System.out.println();
//			}
		}
		return ss;
	}
	public int line_y(int i,int x,int[] arr, ArrayList<Integer> arrlist) {
		int num=x;
		for(int p=0;p<9;p++) {
			if(arr[(p*9)+(i%9)]==arrlist.get(num) && (p*9)+(i%9)!=i) {
				return 0;
			}		
		}
		return line_a(i,x,arr,arrlist);
	}
	
	public int line_a(int i,int x,int[] arr, ArrayList<Integer> arrlist) {
		int num=x;
		if(i==0 || i==1 || i==2 || i==9 || i==10 || i==11 || i==18 || i==19 || i==20) {
			for(int p=0;p<81;p++) {
				if(p==0 || p==1 || p==2 || p==9 || p==10 || p==11 || p==18 || p==19 || p==20) {
					if(arr[p]==arrlist.get(num)&&p!=i) {
						return 0;
					}
				}
			}
		}
		else if(i==3 || i==4 || i==5 || i==12 || i==13 || i==14 || i==21 || i==22 || i==23) {
			for(int p=0;p<81;p++) {
				if(p==3 || p==4 || p==5 || p==12 || p==13 || p==14 || p==21 || p==22 || p==23) {
					if(arr[p]==arrlist.get(num)&&p!=i) {
						return 0;
					}
				}
			}
		}
		else if(i==6 || i==7 || i==8 || i==15 || i==16 || i==17 || i==24 || i==25 || i==26) {
			for(int p=0;p<81;p++) {
				if(p==6 || p==7 || p==8 || p==15 || p==16 || p==17 || p==24 || p==25 || p==26) {
					if(arr[p]==arrlist.get(num)&&p!=i) {
						return 0;
					}
				}
			}
		}
		else if(i==27 || i==28 || i==29 || i==36 || i==37 || i==38 || i==45 || i==46 || i==47) {
			for(int p=0;p<81;p++) {
				if(p==27 || p==28 || p==29 || p==36 || p==37 || p==38 || p==45 || p==46 || p==47) {
					if(arr[p]==arrlist.get(num)&&p!=i) {
						return 0;
					}
				}
			}
		}
		else if(i==30 || i==31 || i==32 || i==39 || i==40 || i==41 || i==48 || i==49 || i==50) {
			for(int p=0;p<81;p++) {
				if(p==30 || p==31 || p==32 || p==39 || p==40 || p==41 || p==48 || p==49 || p==50) {
					if(arr[p]==arrlist.get(num)&&p!=i) {
						return 0;
					}
				}
			}
		}
		else if(i==33 || i==34 || i==35 || i==42 || i==43 || i==44 || i==51 || i==52 || i==53) {
			for(int p=0;p<81;p++) {
				if(p==33 || p==34 || p==35 || p==42 || p==43 || p==44 || p==51 || p==52 || p==53) {
					if(arr[p]==arrlist.get(num)&&p!=i) {
						return 0;
					}
				}
			}
		}
		else if(i==54 || i==55 || i==56 || i==63 || i==64 || i==65 || i==72 || i==73 || i==74) {
			for(int p=0;p<81;p++) {
				if(p==54 || p==55 || p==56 || p==63 || p==64 || p==65 || p==72 || p==73 || p==74) {
					if(arr[p]==arrlist.get(num)&&p!=i) {
						return 0;
					}
				}
			}
		}
		else if(i==57 || i==58 || i==59 || i==66 || i==67 || i==68 || i==75 || i==76 || i==77) {
			for(int p=0;p<81;p++) {
				if(p==57 || p==58 || p==59 || p==66 || p==67 || p==68 || p==75 || p==76 || p==77) {
					if(arr[p]==arrlist.get(num)&&p!=i) {
						return 0;
					}
				}
			}
		}
		else if(i==60 || i==61 || i==62 || i==69 || i==70 || i==71 || i==78 || i==79 || i==80) {
			for(int p=0;p<81;p++) {
				if(p==60 || p==61 || p==62 || p==69 || p==70 || p==71 || p==78 || p==79 || p==80) {
					if(arr[p]==arrlist.get(num)&&p!=i) {
						return 0;
					}
				}
			}
		}
		return 1;
	}
}
