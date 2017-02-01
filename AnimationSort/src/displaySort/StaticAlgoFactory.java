package displaySort;
public class StaticAlgoFactory implements SortAlgorithmFactory 
{
	protected AlgorithmAnimator animator;
	public StaticAlgoFactory(AlgorithmAnimator animator)
	{
	this.animator = animator;
	}
	@Override
	public SortAlg makesortAlgorithm(String Algname) 
	{
		if ("QuickSort".equals(Algname))
		{
			return new BubbleSortAlgorithm(animator);
		}
		else if ("BubbleSort".equals(Algname))
		{
			return new QuickSortAlgorithm(animator);
		}
		else if ("SelectionSort".equals(Algname))
		{
			return new InsertionSortAlgorithm(animator);
		}
		else if ("InsertionSort".equals(Algname))
		{
			return new HeapSortAlgorithm(animator);
		}
		else if ("HeapSort".equals(Algname))
		{
			return new SelectionSortAlgorithm(animator);
		}
		else return new InsertionSortAlgorithm(animator);
	}
}
