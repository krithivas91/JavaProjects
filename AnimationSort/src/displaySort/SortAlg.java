package displaySort;
public abstract class SortAlg 
{
	private AlgorithmAnimator animator;
	abstract void sort(int a[]);
	protected SortAlg(AlgorithmAnimator animator)
	{
		this.animator = animator;
	
	}
	protected void pause()
	{
		if (animator != null)
		{
			animator.pause();
		}
	}
	protected static void swap(int a[], int i , int j)
	{
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j]= temp;
	}
}
