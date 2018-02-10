package com.kodilla.testing.shape;

import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeTestSuite(){
        System.out.println("Beginning of the test");
    }

    @AfterClass
    public static void afterTestSuite(){
        System.out.println("The end of test suite");
    }

    @Before
    public void beforeEachTest(){
        testCounter++;
        System.out.println("\nStarting test nr " + testCounter);
    }


    @Test
    public void addFigureNotExisting(){
        //Given
        Shape circle = null;
        ShapeCollector collector = new ShapeCollector();

        //When
        boolean result = collector.addFigure(circle);

        //Then
       // Assert.assertEquals(null, collector.getFigure(0));
        Assert.assertFalse(result);
    }

    @Test
    public void testAddFigure(){
        //Given
        Shape circle = new Circle(4, "circle");
        ShapeCollector collector = new ShapeCollector();

        //When
        boolean result = collector.addFigure(circle);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testRemoveFigure(){
        //Given
        Shape triangle = new Triangle(3, 4, "triangle");
        ShapeCollector collector = new ShapeCollector();

        //When
        collector.addFigure(triangle);
        boolean result = collector.removeFigure(triangle);
        List<Shape> figures = collector.showFigures();

        //Then
        Assert.assertTrue(result);
       // Assert.assertEquals(null, figures);
    }

    @Test
    public void testGetFigure(){
        //Given
        Shape square = new Square(2, "square");
        ShapeCollector collector = new ShapeCollector();

        //When
        collector.addFigure(square);
        Shape result = collector.getFigure(0);

        //Then
        Assert.assertEquals(square, result);
    }

    @Test
    public void testShowFigures(){
        //Given
        Shape square = new Square(2, "square");
        Shape circle = new Circle(4, "circle");
        Shape triangle = new Triangle(3, 4, "triangle");
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(square);
        collector.addFigure(circle);
        collector.addFigure(triangle);

        //When
        List<Shape> result = collector.showFigures();

        List<Shape> expectedList = new ArrayList<>();
        expectedList.add(square);
        expectedList.add(circle);
        expectedList.add(triangle);

        //Then
        Assert.assertEquals(expectedList, result);
    }
}
