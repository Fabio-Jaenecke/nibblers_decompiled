package rx.observers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.Observer;
import rx.exceptions.CompositeException;

@Deprecated
public class TestObserver<T>
  implements Observer<T>
{
  private static final Observer<Object> e = new TestObserver.1();
  private final Observer<T> a;
  private final List<T> b = new ArrayList();
  private final List<Throwable> c = new ArrayList();
  private final List<Notification<T>> d = new ArrayList();
  
  public TestObserver()
  {
    this.a = e;
  }
  
  public TestObserver(Observer<T> paramObserver)
  {
    this.a = paramObserver;
  }
  
  final void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 32);
    localStringBuilder.append(paramString).append(" (");
    int i = this.d.size();
    localStringBuilder.append(i).append(" completion");
    if (i != 1) {
      localStringBuilder.append('s');
    }
    localStringBuilder.append(')');
    if (!this.c.isEmpty())
    {
      i = this.c.size();
      localStringBuilder.append(" (+").append(i).append(" error");
      if (i != 1) {
        localStringBuilder.append('s');
      }
      localStringBuilder.append(')');
    }
    paramString = new AssertionError(localStringBuilder.toString());
    if (!this.c.isEmpty())
    {
      if (this.c.size() != 1) {
        break label180;
      }
      paramString.initCause((Throwable)this.c.get(0));
    }
    for (;;)
    {
      throw paramString;
      label180:
      paramString.initCause(new CompositeException(this.c));
    }
  }
  
  public void assertReceivedOnNext(List<T> paramList)
  {
    if (this.b.size() != paramList.size()) {
      a("Number of items does not match. Provided: " + paramList.size() + "  Actual: " + this.b.size() + ".\n" + "Provided values: " + paramList + "\n" + "Actual values: " + this.b + "\n");
    }
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject2 = paramList.get(i);
      Object localObject1 = this.b.get(i);
      if (localObject2 == null) {
        if (localObject1 != null) {
          a("Value at index: " + i + " expected to be [null] but was: [" + localObject1 + "]\n");
        }
      }
      while (localObject2.equals(localObject1))
      {
        i += 1;
        break;
      }
      localObject2 = new StringBuilder().append("Value at index: ").append(i).append(" expected to be [").append(localObject2).append("] (").append(localObject2.getClass().getSimpleName()).append(") but was: [").append(localObject1).append("] (");
      if (localObject1 != null) {}
      for (localObject1 = localObject1.getClass().getSimpleName();; localObject1 = "null")
      {
        a((String)localObject1 + ")\n");
        break;
      }
    }
  }
  
  public void assertTerminalEvent()
  {
    if (this.c.size() > 1) {
      a("Too many onError events: " + this.c.size());
    }
    if (this.d.size() > 1) {
      a("Too many onCompleted events: " + this.d.size());
    }
    if ((this.d.size() == 1) && (this.c.size() == 1)) {
      a("Received both an onError and onCompleted. Should be one or the other.");
    }
    if ((this.d.isEmpty()) && (this.c.isEmpty())) {
      a("No terminal events received.");
    }
  }
  
  public List<Object> getEvents()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    localArrayList.add(this.c);
    localArrayList.add(this.d);
    return Collections.unmodifiableList(localArrayList);
  }
  
  public List<Notification<T>> getOnCompletedEvents()
  {
    return Collections.unmodifiableList(this.d);
  }
  
  public List<Throwable> getOnErrorEvents()
  {
    return Collections.unmodifiableList(this.c);
  }
  
  public List<T> getOnNextEvents()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void onCompleted()
  {
    this.d.add(Notification.createOnCompleted());
    this.a.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.c.add(paramThrowable);
    this.a.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.b.add(paramT);
    this.a.onNext(paramT);
  }
}


/* Location:              C:\dex2jar-2.0\com.rovio.Nibblers_12230-dex2jar.jar!\rx\observers\TestObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */