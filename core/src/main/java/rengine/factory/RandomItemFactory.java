package main.java.rengine.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.rengine.base.BaseItem;
import main.java.rengine.model.ItemNamesModel;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by prosbloom on 11/6/17.
 */
public class RandomItemFactory {
    private final static Logger log = Logger.getLogger(RandomItemFactory.class.getName());
    protected final static String itemFile = "rengine/item/ItemNames.json";
    protected ItemNamesModel names;

    public RandomItemFactory() {
        try {
            File f = new File(RandomItemFactory.class.getClassLoader().getResource(itemFile).getPath());
            ObjectMapper om = new ObjectMapper();
            names= om.readValue(f, ItemNamesModel.class);
        } catch (IOException e) {
            log.error("Could not load " + getClass().getName() + " ");
        }

    }
    private String generateName() {
        Random r = new Random();
       String name = String.format("%s %s %s %s",
               names.prefixes[r.nextInt(names.prefixes.length)],
               names.bases[r.nextInt(names.bases.length)],
               names.preposition,
               names.suffixes[r.nextInt(names.suffixes.length)]);
       log.info("RNG NAME: " + name);
       return name;
    }

    public BaseItem generate(int ilvl) {
        BaseItem item = BaseItem.builder()
                .setIlvl(ilvl)
                .setName(generateName())
                .build();
        return item;
    }
}
