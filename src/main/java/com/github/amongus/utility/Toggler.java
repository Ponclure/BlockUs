<<<<<<< HEAD
package com.github.amongus.utility;

import java.util.function.Supplier;

public final class Toggler<T> implements Supplier<T> {

    private final T aObject;
    private final T bObject;

    private boolean toggled;

    public Toggler(T a, T b) {
        aObject = a;
        bObject = b;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public void toggle() {
        setToggled(!toggled);
    }

    @Override
    public T get() {
        return toggled ? bObject : aObject;
    }
}
=======
package com.github.amongus.utility;

import java.util.function.Supplier;

public final class Toggler<T> implements Supplier<T> {

    private final T aObject;
    private final T bObject;

    private boolean toggled;

    public Toggler(T a, T b) {
        aObject = a;
        bObject = b;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public void toggle() {
        setToggled(!toggled);
    }

    @Override
    public T get() {
        return toggled ? bObject : aObject;
    }
}
>>>>>>> 1034254cf00d02a3ef808f9e39b9ac3f6117983b
