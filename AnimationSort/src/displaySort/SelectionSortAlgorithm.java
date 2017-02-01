package displaySort;
public class SelectionSortAlgorithm extends SortAlg 
{
	protected SelectionSortAlgorithm(AlgorithmAnimator animator) 
	{
		super(animator);
	}
	@Override
	void sort(int[] a) 
	{
		for (int i = 0; i < a.length-1; i++ )
		{
			for (int j = i+1; j < a.length; j++) 
			{ 
				if (a[j] < a[i])
				{
					swap(a, j, i);
					pause();
					
				}
			}
		}
	}
}
