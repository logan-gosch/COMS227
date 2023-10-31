package lab6;

import plotter.Plotter;
import plotter.Polyline;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PolylineReaderAndPrinter {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Polyline> list = readFile("test.txt");
        Plotter plotter = new Plotter();

        for (Polyline p : list)
        {
            plotter.plot(p);
        }
    }
    public static Polyline parseOneLine(String line) {
        Scanner lineReader = new Scanner(line);
        Polyline p;

        if (!lineReader.next().equals("red") || !lineReader.next().equals("green") || !lineReader.next().equals("blue")) {
            int width = lineReader.nextInt();
            String color = lineReader.next();
            p = new Polyline(color, width);
        } else {
            p = new Polyline(lineReader.next());
        }

        Point point;
        while (lineReader.hasNextInt()) {
            point = new Point(lineReader.nextInt(), lineReader.nextInt());
            p.addPoint(point);
        }

        return p;
    }

    public static ArrayList<Polyline> readFile(String fileName)
            throws FileNotFoundException {
        ArrayList<Polyline> polyList = new ArrayList<>();
        Scanner fileScanner = new Scanner(fileName);

        while (fileScanner.hasNextLine()) {
            Polyline p;
            String line = fileScanner.nextLine();

            if (!line.isEmpty() || !line.contains("#")) {
                p = parseOneLine(line);
                polyList.add(p);
            }
        }

        fileScanner.close();
        return polyList;
    }
}
