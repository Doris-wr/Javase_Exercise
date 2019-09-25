//折半排序法
public static void bsInsertSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int v=arr[i];
			int left=0;
			int right=arr.length;
			while(left<right) {
				int m=(left+right)/2;
				if(v>=arr[m]) {
					left=m+1;
				}else {
					right=m;
				}
			}
			for(int j=i;j>left;j--) {
				arr[j]=arr[j-1];
			}
			arr[left]=v;
		}
	}
  //插入排序法
  public static void insertSort0(int[] a) {
		for(int i=1;i<a.length;i++) {//无序区间
			int key=a[i];
			int j;
			for(j=i-1;j>=0;j--) {//有序区间
				if(a[j]<=key) {
					break;
				}else {
					a[j+1]=a[j];
				}
			}
			a[j+1]=key;
		}
	}
