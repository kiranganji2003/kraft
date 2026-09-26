package com.design.patterns.structural;

import java.util.HashMap;
import java.util.Map;

class TreeShape {
    String color;
    String type;

    public TreeShape(String color, String type) {
        this.color = color;
        this.type = type;
    }
}

class TreePosition {

    private static Map<String, TreeShape> treeShapeMap = new HashMap<>();

    int xAxis;
    int yAxis;
    TreeShape treeShape;

    TreePosition(int x, int y, String color, String type) {

        String key = color + " " + type;

        this.xAxis = x;
        this.yAxis = y;

        if(!treeShapeMap.containsKey(key)) {
            treeShapeMap.put(key, new TreeShape(color, type));
        }

        this.treeShape = treeShapeMap.get(key);
    }
}


public class Flyweight {
    public static void main(String[] args) {

        TreePosition tree1 = new TreePosition(1, 2, "green", "type1");
        TreePosition tree2 = new TreePosition(10, 2, "green", "type1");
        TreePosition tree3 = new TreePosition(11, 2, "blue", "type2");
        TreePosition tree4 = new TreePosition(13, 2, "blue", "type2");

    }
}
