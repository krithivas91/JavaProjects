package displaySort;
public class InsertionSortAlgorithm extends SortAlg 
{
	protected InsertionSortAlgorithm(AlgorithmAnimator animator) 
	{
		super(animator);
	}
	@Override
	void sort(int[] a) 
	{
		 int l = 0; 
		    int k = 0; 
		    for(l = 1; l < a.length; l++)
		    { 
		      k = l; 
		      int val = a[l]; 
		      while(k > 0 && a[k - 1] > val)
		      { 
		        
		        a[k] = a[k-1]; 
		        pause(); 
		        k--; 
		      } 
		      a[k] = val; 
		      pause();	
	}
	}
}
