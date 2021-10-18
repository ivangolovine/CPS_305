
public class IntListMethods {
	public static String getAuthorName() 
	{
		return "Golovine, Ivan";
	}
	public static String getRyersonID()
	{
		return "500813431";
	}

	public static int removeIfDivisible(int n, int k)
	{	
		if(n == 0) { return 0; }
		int first = n;
		int m = IntList.getNext(n);
		
		while(IntList.getKey(n)%k == 0) {
			first = IntList.setNext(n, 0);
			IntList.release(n);
			n = m;
			m = IntList.getNext(m);
        }
		while(m != 0)
		{	
			if (IntList.getKey(m)%k != 0)
			{
				n = m;
				m = IntList.getNext(m);
			}
		
			else if (m!=0 && IntList.getKey(m)%k == 0)
			{
			 	int j = IntList.getNext(m);
			 	IntList.setNext(n, IntList.setNext(m, 0));
				IntList.release(m);
				m = j;	
			}
		}
		return first;  
	}
	public static int sort(int n) 
	{
		if (n == 0 || IntList.getNext(n)==0)
		{
			return n;
		}
			int mid = getMid(n);
			int nextMid = IntList.getNext(mid);
			IntList.setNext(mid, 0);
		return merge(sort(n), sort(nextMid));
	}
	
	private static int merge(int left, int right) {
		
		int lN = 0;
		int temp = 0;
		int merged = 0;
		
		while (left != 0 && right != 0)
		{
			if (IntList.getKey(left) > IntList.getKey(right))
			{
				temp = right;
				right = IntList.getNext(right);
			}
			else
			{
				temp = left;
				left = IntList.getNext(left);
			}
			if(merged == 0)
			{
				merged = temp;
			}
			else
			{
				IntList.setNext(lN, temp);
			}
			lN = temp;
		}
		
		if(left != 0)
		{
			IntList.setNext(lN, left);
		}
		else{
			IntList.setNext(lN, right);
		}
		return merged;	
	}

	private static int getMid(int first) {
		  if(first == 0){
		   return first;
		  }	
		  int p1 = first;
		  int p2 = first;

		  while(p2!=0 && IntList.getNext(p2)!=0 && IntList.getNext(IntList.getNext(p2))!=0){
			  p1 = IntList.getNext(p1);
			  p2 = IntList.getNext(IntList.getNext(p2));
		  }
		  return p1;
		 }
	
}