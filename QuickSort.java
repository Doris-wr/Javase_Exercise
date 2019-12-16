
class QuickSort{
private int[] data;
QuickSort(int[] data){
this.data=data;
}
public void startSort(int low,int high){
if(low>=high) return;
int partition=Partition(low,high);//以第一个元素为基准元素，大于基准元素的在右边
//小于基准元素的在左边
startSort(low,partition-1);//分治法的体现
startSort(partition+1,high);
}
/*
* 将数组分成两块，返回基准元素在数组中的位置
* @param arr 待排序数组
* @param low,high规定数组中的待排序数据块位置
* */
public int Partition(int low,int high){
int begin=low;
int end=high;
int key=data[low];//取该数组块的第一个元素作为基准元素
while(begin<end){
while(begin<end&&data[end]>=key){
end--;
}
data[begin]=data[end];//第一处，从后开始找到第一个小于key的元素，将这个元素放到begin位置（key已经复制了该位置原来的值，不用担心覆盖问题）
while(begin<end&&data[begin]<=key){
begin++;
}
data[end]=data[begin];//第二处，从前开始往后找到第一个大于key的元素，注意看好begin和end 的大小，将这个元素放到end位置
}
data[begin]=key;//基准元素居中，第三处，将复制的key即原先的data[begin]放到中间位置
return begin;
}
public void display(){
for(int i=0;i<data.length;i++)
System.out.print(data[i]+",");
}
}
public class Solution {
public static void main(String[] args){
int[] num={7,6,5,4,8,10,11};
QuickSort q=new QuickSort(num);
q.startSort(0, num.length-1);
q.display();
}
}
————————————————
版权声明：本文为CSDN博主「Fishing_Fly」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/u013276277/article/details/72466632
