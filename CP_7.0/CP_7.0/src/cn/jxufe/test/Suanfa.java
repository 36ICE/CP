package cn.jxufe.test;

import java.util.ArrayList;
//互评算法
public class Suanfa {

	public static void main(String[] args) {

		test1();
	}

	private static void test1() {
		int num = 5;
		ArrayList<T1> t1 = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			T1 t = new T1(i);
			t1.add(t);
		}

		// System.out.println((int)(Math.random()*t1.size())+1);

		for (int i = 0; i < t1.size(); i++) {
			if (t1.size() == 0){
				System.out.println("异常");
				return;
			}
			for (int j = 0; j < num; j++) {
				int x1 = (int) (Math.random() * t1.size());
				//不为自己    不评同一人多次     不被评超过num次      不评超过num人            四个条件
				while (x1 == i | find( t1.get(i), x1)
						| t1.get(x1).behas >= num) {
					x1 = (int) (Math.random() * t1.size());
				}
				//将过滤出的加入ids,并将behas加1
				t1.get(i).ids.add(x1);
				t1.get(x1).behas++;
			}
		}
		//输出
		for (int i = 0; i < t1.size(); i++) {
			System.out.print("评价人："+t1.get(i).userId+" 被评价：");
			for(int j=0;j<num;j++){
				System.out.print(t1.get(i).ids.get(j)+" ");
			}
			System.out.println();
		}
		
		yanzheng(t1,num);
	}
	//去除同一人评判多次
	static boolean find(T1 t,int x1){
		
				for(int start=0;start<(t.ids.size());start++){
					if(t.ids.get(start)==x1){
						return true;
					}
				}
		
		return false;
	}
	//验证函数
	static boolean yanzheng(ArrayList<T1> t1,int num){
		//主要是统计出现的次数  评价次数（不用验证），被评价次数
		ArrayList<T2> nums=new ArrayList<>();
		for(int i=0;i<t1.size();i++){
			nums.add(new T2(i));
		}
		for(int i=0;i<t1.size();i++){
			for(int j=0;j<num;j++){
				for(int k=0;k<nums.size();k++){
					if(nums.get(k).userId==t1.get(i).ids.get(j)){
						nums.get(k).count++;
					}
				}
			}
			//nums.get(t1.get(i).ids.get(j));
		}
		for(int i=0;i<t1.size();i++){
			System.out.println(nums.get(i).userId+"出现次数"+nums.get(i).count);
			if(nums.get(i).count!=num){
				System.out.println("error!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		return false;
	}

}
class T2{
	public T2(int userId) {
		this.userId=userId;
	}
	int userId;
	int count;
}

  class T1 {
	public T1(int userId) {
		this.userId = userId;
		
		this.behas=0;
	}
	int userId;
	ArrayList<Integer> ids = new ArrayList<>();
	int behas;
}
/*
 * 每人互评人数 num 参数：(我评价别人) 本人id
 * 
 * 分配互评人的id ArrList<Integer> ids=new ArrList<>(); 本人已分配需互评的人数 has 完成标识 flag 1，0
 * for(i=0;i<T1.size();i++){ if(T1.size()==0) return ;
 * 
 * for(j=0;j<num;j++){ x1= Math.random()*T1.size()+1;
 * while(x1==(i+1)&T1.get(i).ids==x1 & T1.get(x1).has<num){ x1=
 * Math.random()*T1.size()+1; } T1.get(i).ids.add(x1);
 * 
 * }
 * 
 * }
 */
