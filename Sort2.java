//希尔排序法
public static void shellSort(int[] arr) {
		int gap=arr.length;
		while(true) {
			gap=(gap/3)+1;
			insertSortWithGap(arr,gap);
			if(gap==1) {
				break;
			}
		}
	}
	public static void insertSortWithGap(int[] arr,int gap) {
		for(int i=gap;i<arr.length;i++) {
			int key =arr[i];
			int j;
			for(j=i-gap;j>=0&&arr[j]>key;j-=gap) {
				arr[j+gap]=arr[j];
			}
			arr[j+gap]=key;
		}
 }
//选择排序法，每次找最大的放在无序区间的最后
	public static void selectSort1(int[] arr) {
		//无序：[0,array。length-i-1)
		//有序：[arr.length-i,arr.length)
		for(int i=0;i<arr.length-1;i++) {//外层循环表示n个数要选出n-1个出来,数组就有序了
			int maxIndex=0;
			for(int j=1;j<arr.length-i;j++) {//内层循环表示遍历整个无序区间
				if(arr[j]<arr[maxIndex]) {
					maxIndex=j;
				}
			}
			swap(arr,maxIndex,arr.length-1-i);
		} 
 }
//选择排序法，每次找最小的往前放
	public static void selectSort2(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			//无序区间[i,array.lenght)
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			swap(arr,minIndex,i);
		}	
}	
