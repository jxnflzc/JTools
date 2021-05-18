package io.github.jxnflzc.pattern.observer;

/**
 * @author jxnflzc
 * @version 1.0
 */
public interface Observer {
    /**
     * Update the observer when the subject changes
     * @param arg Info
     */
    void update(Object arg);
}
