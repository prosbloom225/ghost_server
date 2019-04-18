package main.java.rengine.mod;

import java.util.List;
import java.util.ArrayList;
import main.java.rengine.actions.IAction;

import lombok.Getter;
import org.apache.log4j.Logger;

/**
 * Created by prosbloom on 11/4/17.
 */
public class PlayerActions {
    final static Logger log = Logger.getLogger(PlayerActions.class.getName());
    @Getter private static List<Class> actions;


    public static void init() {
        actions = new ArrayList<>();
    }
    public static <T extends IAction> void register(Class<T> action) {
        log.info("Registering action: " + action.getName());
        actions.add(action);
    }

    public static String count() {
        return "" + actions.size();
    }

    public static boolean isRegisteredAction(String actionName) {
        for (Class c : actions){
            if (c.getSimpleName().equals(actionName))
                return true;
        }
        return false;
    }

    public static String dumpActions() {
        String ret = "Actions: [";
        for (Class c : actions)
            ret += c.getName() + ",";
        return ret + "]";
    }
}
