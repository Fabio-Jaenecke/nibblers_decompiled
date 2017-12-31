package bolts;

public class Capture<T>
{
  private T a;
  
  public Capture() {}
  
  public Capture(T paramT)
  {
    this.a = paramT;
  }
  
  public T get()
  {
    return (T)this.a;
  }
  
  public void set(T paramT)
  {
    this.a = paramT;
  }
}


/* Location:              C:\dex2jar-2.0\com.rovio.Nibblers_12230-dex2jar.jar!\bolts\Capture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */