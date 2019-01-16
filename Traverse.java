
class Traverse
{

  public Queue breadthFirst(Node root)
  {
    //String[] A = new String[count(root)];
    Queue q = new Queue();
    Queue s = new Queue();
    //int i = 0;
    q.enqueue(root);

    while(!q.isEmpty())
    {
      Node n = q.dequeue();
      if(n == null)
        s.enqueue(null);
      else
        s.enqueue(Integer.toString(n.val));

      q.enqueue(n.left);
      q.enqueue(n.right);// could enqueue null
      //i += 1;
    }
  }

// for complete binary tree
  public Node breadthInsert(int[] arr, int i) // start at 0
  {
    Node root;
    if(arr[i] == null)
      root = null;
    else
      root = new Node(arr[i]);

    if(i < arr.length)
    {
      //insert left Tree
      root.left = breadthInsert(arr, 2*i + 1);

      //insert right tree
      root.right = breadthInsert(arr, 2*i + 2);

    }
    return root;

  }

// for binary tree not full

  public Node breadthInsert1(Queue s) // Queue s = breadthFirst(Node r);
  {
    Queue n = new Queue();
    if(s == null)
      return null;
    else
      Node root = new Node(s.dequeue());
    while(! s.isEmpty())
    {
      root.left = s.dequeue();
      root.right = s.dequeue();
      if(root.left != null)
        n.enqueue(root.left);
      if(root.right != null)
        n.enqueue(root.right);

      root = n.dequeue();
    }

    return root;

  }


  public static void main(String[] args)


















}
