 public int numJewelsInStones(String J,String S) {
		 //把所有的宝石放在Set中
		 Set<Character>jewels=new TreeSet<>();
		 for(char j:J.toCharArray()) {
			 jewels.add(j);
		 }
		 //遍历所有的石头
		 int count=0;
		 for(char s:S.toCharArray()) {
			 if(jewels.contains(s)) {
				 count++;
			 }
		 }
		 return count;
	 }
