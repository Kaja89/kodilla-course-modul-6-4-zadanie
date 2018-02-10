package com.kodilla.testing.shape;

import java.lang.reflect.Array;
import java.util.*;

public class ShapeCollector {
    ArrayList<Shape> shapes = new ArrayList<>();

    public boolean addFigure(Shape shape){
        if(shape == null){
            System.out.println("You can't add object not existing!");
            return false;
        }
        shapes.add(shape);
        System.out.println("Shape " + shape.getShapeName() + " add");
        return true;
    }

    public boolean removeFigure(Shape shape){
        if(shape == null){
            System.out.println("You can't remove object not existing!");
            return false;
        }
        shapes.remove(shape);
        System.out.println("Your shape has been deleted");
        return true;
    }

    public Shape getFigure(int n){
        System.out.println("Your shape: " + shapes.get(n));
        return shapes.get(n);
    }

    public ArrayList<Shape> showFigures(){
        ArrayList<Shape> shown = new ArrayList<>();
        for(Shape figure: shapes){
            System.out.println(figure);
            shown.add(figure);
        }
        return shown;
    }
}
