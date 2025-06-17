package com.github.nyaon08.rtustudio.og.util;

import com.github.nyaon08.rtustudio.og.model.OgMaterial;

import java.util.ArrayList;
import java.util.List;

public class MaterialUtil {

    public static String getRandomBlockData(List<OgMaterial> materials) {
        List<String> select = new ArrayList<>();
        for (OgMaterial material : materials) {
            for (int i = 0; i < material.probability(); i++) {
                select.add(material.material());
            }
        }
        return select.get((int) (Math.random() * select.size()));
    }

}
