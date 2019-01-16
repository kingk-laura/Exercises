class maxHeap
{
  public int count;
  public int[] arr;
  public maxHeap(int size)
  {
    count = 0;
    arr = new int[size];
  }

  private int parent(int i)
  {
    if( (i-1)/2 >= 0 && (i-1)/2 < count)
      return (i-1)/2;
    else
      return -1;
  }

  private int lc(int i)
  {
    if( 2*i+1 >= 0 && 2*i + 1 < count)
      return 2*i+1;
    else
      return -1;
  }

  private int rc(int i)
  {
    if( 2*i+2 >= 0 && 2*i+2 < count)
      return 2*i+2;
    else
      return -1;
  }

  public void swap(int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void pop()
  {
    if(count <= 0)
      throw new IllegalArgument("Empty.");
    else
    {
      int temp = arr[0];
      arr[0] = arr[count-1];
      count -= 1;
      BubbleDown(0);
      return temp;
    }
  }

  public void push(int i)
  {
    arr[count] = i;
    count += 1;
    BubbleUp(count - 1);
  }

  private void BubbleUp(int i)
  {
    int parent = parent(i);
    if(parent < 0)
      return;
    else
    {
      if(arr[parent] < arr[i])
      {
        swap(parent, i);
        BubbleUp(parent);
      }
      else
        return;
    }
  }

  private void BubbleDown(int i)
  {
    int lc = lc(i);
    int rc = rc(i);
    if(lc < 0)
      return;
    else
    {
      if(rc > 0)
      {
        if(arr[rc] > arr[lc])
          lc = rc;
      }
    }

    if(arr[lc] > arr[i])
    {
      swap(lc, i);
      BubbleDown(lc);
    }

  }

}

  public int FindKthMax(int[] A, int k)
  {
    maxHeap h = new maxHeap(k);
    for(int i = 0; i < A.length; i += 1 )
    {
      if(count <= k)
        h.push(A[i]);
      else
      {
        if(A[i] < h.arr[0])
        {
          h.pop();
          h.push(A[i]);
          // substitute arr[0] with A[i], then do BubbleDown -- would be quicker
        }
      }
    }
    return h.arr[0];
  }


class main
{
  public static void main(String [] args)
  {
    int[] arr = {3,9,0,1,6,7};
    int k = 3;

    System.out.println(FindKthMax(arr, k));

  }
}
