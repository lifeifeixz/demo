package org.gongxaing.made;

/**
 * @author flysLi
 * @date 2018/3/27
 */
public interface MadeObserverable {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver();
}
