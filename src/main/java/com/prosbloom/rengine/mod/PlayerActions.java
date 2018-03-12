package com.prosbloom.rengine.mod;

import java.util.List;
import java.util.ArrayList;
import com.prosbloom.rengine.actions.IAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by prosbloom on 11/4/17.
 */
public class PlayerActions {
    private static List<Class> actions;

    public static void init() {
        actions = new ArrayList<>();
    }
    public static <T extends IAction> void register(Class<T> action) {
        actions.add(action);
    }

    public static String count() {
        return "" + actions.size();
    }
}
