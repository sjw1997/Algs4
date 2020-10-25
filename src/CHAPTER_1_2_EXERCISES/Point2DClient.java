package CHAPTER_1_2_EXERCISES;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Point2DClient {
    public static void main(String[] args) {
        int x0 = Integer.parseInt(args[0]);
        int y0 = Integer.parseInt(args[1]);
        int N = Integer.parseInt(args[2]);

        StdDraw.setCanvasSize(600, 400);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();

        Point2D a[] = new Point2D[N];
        for (int i = 0; i < N; i++) {
            int x = StdRandom.uniform(100);
            int y = StdRandom.uniform(100);
            a[i] = new Point2D(x, y);
            a[i].draw();
        }

        Point2D p = new Point2D(x0, y0);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.02);
        p.draw();

        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BLUE);
        Arrays.sort(a, p.polarOrder());
        for (int i = 0; i < N; i++) {
            p.drawTo(a[i]);
            StdDraw.show();
            StdDraw.pause(100);
        }
    }
}
