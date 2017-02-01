package displaySort;
public class QuickSortAlgorithm extends SortAlg 
{
	public void quickSort(int a[], int loO, int hiO)
	{
		int lo=loO, hi =hiO,mid;
		pause();
		if(hiO>loO)
		{
			mid = a[(loO+hiO)/2];
			while(lo <= hi)
			{
				while((lo<hiO) && (a[lo]<mid))
				{
					++lo;
				}
		while((hi>loO) && (a[hi]>mid))
		{
			--hi;
		}
		
		if (lo <= hi)
		{
			swap(a,lo,hi);
			pause();
			++lo;
			--hi;
		}
			}
			if(loO < hi)
			{
				quickSort(a, loO, hi);
			}
			if(lo<hiO)
			{
			quickSort(a, lo, hiO);	
			}			
		}	
	}
	protected QuickSortAlgorithm(AlgorithmAnimator animator) 
	{
		super(animator);
	}
	@Override
	void sort(int[] a) 
	{
	
		quickSort(a, 0, a.length-1);
	}
}

