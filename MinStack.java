class MinStack{
	private ArrayList<Integer> normal=new ArrayList<>();
	private ArrayList<Integer> min=new ArrayList<>();
	public MinStack() {}
	public void push(int x) {
		normal.add(x);
		int m;
		if(min.size()==0) {
			m=x;
		}else if(x<=min.get(min.size()-1)){
			m=x;
		}else {
			m=min.get(min.size()-1);
		}
		min.add(m);
	}
	public void pop() {
		normal.remove(normal.size()-1);
		min.remove(min.size()-1);
	}
	public int top() {
		return normal.get(normal.size()-1);
	}
	public int getMin() {
		return min.get(min.size()-1);
	}
}
