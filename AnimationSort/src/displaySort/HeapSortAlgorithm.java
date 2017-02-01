package displaySort;
public class HeapSortAlgorithm extends SortAlg 
{
	protected HeapSortAlgorithm(AlgorithmAnimator animator) 
	{
		super(animator);
	}
	@Override
	   public void sort(int[] a) { 
        for(int i = a.length / 2; i >= 0; i--) 
            Heapify( a, i, a.length ); 
        for(int i = a.length - 1; i > 0; i--) { 
            swap(a, 0, i); 
            Heapify( a, 0, i ); 
        } 
    } 
     private void Heapify(int[] a, int i, int j) { 
        int leaf; 
        int temp; 
  
        for( temp = a[i]; shift(i) < j; i = leaf){ 
            leaf = shift(i); 
            if(leaf != j - 1 && a[leaf] < a[leaf + 1]) 
                leaf++; 
            if(temp < a[leaf]) 
                a[i] = a[leaf]; 
            else 
                break; 
        } 
        a[i] = temp; 
    } 
    private int shift(int i) { 
        return 2 * i + 1; 
    } 
}
