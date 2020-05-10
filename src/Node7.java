
public class Node7
{
  private String name;
  private int weight;
  private Node7[] above;
   public Node7(String v, int w, Node7[] n)
  {
     name=v;
     above=n;
     weight = w;
  }
   public String getName()
  {
     return name;
  }
   public Node7[] getabove()
  {
     return above;
  }
   public int getWeight() {
	   return weight;
   }
   public void setName(String newv)
  {
     name=newv;
  }
   public void setabove(Node7[] newn)
  {
     above=newn;
  }
   public void setWeight(int neww) {
	   weight = neww;
   }
}