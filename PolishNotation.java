class Stack
{
  private class Node
  {
    private double value;
    private Node next;

    private Node(double value, Node next)
    {
      this.value = value;
      this.next = next;
    }

  }

  private Node top;

  public Stack()
  {
    top = null;
  }

  public boolean isEmpty()
  {
    return top == null;
  }

  public void push(double value)
  {
    top = new Node(value, top);
  }

  public void pop()
  {
    if(isEmpty())
      throw new IllegalStateException("Empty Stack");
    else
      top = top.next;
  }

  public double peek()
  {
    if(isEmpty())
      throw new IllegalStateException("Empty Stack");
    else
      return top.value;
  }
}



class PolishNotation // dextends Stack
{
  public Stack stack;
  //public String str;

  public PolishNotation()
  {
    //str = s;
    stack = new Stack();
  }
  public boolean isNum(String s)
  {
    try
    {
      double d = Double.parseDouble(s);
    }
    catch(NumberFormatException nfe)
    {
      return false;
    }

    return true;
  }

  // public int calc(Node root)
  // {
  //   if(root == null)
  //     return;
  //   if(root.value == "+")
  //     return calc(root.left) + calc(root.right);
  //   else if(root.value == "-")
  //     return calc(root.left) - calc(root.right);
  //   else if(root.value == "*")
  //     return calc(root.left) * calc(root.right);
  //   else if(root.value == "/")
  //     return calc(root.left) / calc(root.right);
  //   else
  //     return Double.parseDouble(root.value);
  // }

  public double convert(String s)
  {
    try
    {
      double d = Double.parseDouble(s);
      return d;
    }
    catch(NumberFormatException nfe)
    {
      return -100;
    }
  }

  public double calc(String s)
  {
    for (int i = 0; i < s.length(); i += 1)
    {
      if(isNum(Character.toString(s.charAt(i))))
        stack.push(convert(Character.toString(s.charAt(i))));
      else
      {
        stack.pop();
        double first = stack.peek();
        System.out.println(first);
        stack.pop();
        double second = stack.peek();
        //System.out.print(" ");
        System.out.println(first);
        if((Character.toString(s.charAt(i))) == "+")
          stack.push(second + first);
        if((Character.toString(s.charAt(i))) == "-")
          stack.push(second - first);
        if((Character.toString(s.charAt(i))) == "*")
          stack.push(second * first);
        if((Character.toString(s.charAt(i))) == "/")
          stack.push(second / first);
      }
    }

    return 0;
    //return stack.peek();
  }

}

class Main
{
  public static void main(String[] args)
  {
    String s = "12+34*+56*7/+";
    PolishNotation exp = new PolishNotation();

    System.out.println(exp.calc(s));
  }
}
