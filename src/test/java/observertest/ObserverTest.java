package com.hundredwordsgof.flyweightobserver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 * Test Observer pattern.
 */
public class ObserverTest {

  @Test
  public void testObserverAttach() throws CloneNotSupportedException {

    FlyweightSubjectFactory fwSFactory = new FlyweightSubjectFactory();

    FlyweightSubject subject = (FlyweightSubject) fwSFactory.getSubject("ObserverTest", "testSubject");

    UnSharedFlyweightObserver observer = new UnSharedFlyweightObserver(subject);
    subject.attach(observer);
    subject.setState(1);

    // changes via subject.setState is propagated towards observer
    assertEquals(1, ((FlyweightObserver) observer).getWhatObserverKnows());
  }
  
  @Test
  public void testObserverDettach() throws CloneNotSupportedException {

    FlyweightSubjectFactory fwSFactory = new FlyweightSubjectFactory();

    FlyweightSubject subject = (FlyweightSubject) fwSFactory.getSubject("ObserverTest", "testSubject");

    UnSharedFlyweightObserver observer = new UnSharedFlyweightObserver(subject);
    subject.attach(observer);
    subject.setState(1);

    subject.dettach(observer);
    subject.setState(0);

    // observer is detached so changes are not propageted
    assertEquals(1, ((FlyweightObserver) observer).getWhatObserverKnows());
  }
  
  @Test
  public void testObserverDettach() throws CloneNotSupportedException {

    FlyweightSubjectFactory fwSFactory = new FlyweightSubjectFactory();

    FlyweightSubject subject = (FlyweightSubject) fwSFactory.getSubject("ObserverTest", "testSubject");

    UnSharedFlyweightObserver observer = new UnSharedFlyweightObserver(subject);
    subject.attach(observer);
    subject.setState(1);

    subject.dettach(observer);
    subject.setState(0);

    // observer is detached so changes are not propageted
    assertEquals(1, ((FlyweightObserver) observer).getWhatObserverKnows());
  }
  
  @Test
  public void testNotifyObserver1() throws CloneNotSupportedException {

    FlyweightSubjectFactory fwSFactory = new FlyweightSubjectFactory();

    FlyweightSubject subject = (FlyweightSubject) fwSFactory.getSubject("ObserverTest", "testSubject");

    UnSharedFlyweightObserver observer1 = new UnSharedFlyweightObserver(subject);
    UnSharedFlyweightObserver observer2 = new UnSharedFlyweightObserver(subject);
    UnSharedFlyweightObserver observer3 = new UnSharedFlyweightObserver(subject);
    subject.attach(observer1);
    subject.attach(observer2);
    subject.attach(observer3);
    subject.setState(1);
    subject.notifyObservers();

    assertEquals(1, ((FlyweightObserver) observer1).getWhatObserverKnows());
    assertEquals(1, ((FlyweightObserver) observer2).getWhatObserverKnows());
    assertEquals(1, ((FlyweightObserver) observer3).getWhatObserverKnows());
  }
  
  @Test
  public void testNotifyObserver2() throws CloneNotSupportedException {

    FlyweightSubjectFactory fwSFactory = new FlyweightSubjectFactory();

    FlyweightSubject subject = (FlyweightSubject) fwSFactory.getSubject("ObserverTest", "testSubject");

    UnSharedFlyweightObserver observer1 = new UnSharedFlyweightObserver(subject);
    UnSharedFlyweightObserver observer2 = new UnSharedFlyweightObserver(subject);
    UnSharedFlyweightObserver observer3 = new UnSharedFlyweightObserver(subject);
    subject.attach(observer1);
    subject.attach(observer2);
    subject.attach(observer3);
    subject.setState(1);
    subject.notifyObservers();

    subject.dettach(observer1);
    subject.setState(0);
    subject.notifyObservers();

    // observer is detached so changes are not propageted
    assertEquals(1, ((FlyweightObserver) observer1).getWhatObserverKnows());
    assertEquals(0, ((FlyweightObserver) observer2).getWhatObserverKnows());
    assertEquals(0, ((FlyweightObserver) observer3).getWhatObserverKnows());
  }
}
