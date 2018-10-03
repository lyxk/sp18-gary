package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final long SEED = 1132098;
    private static final Random RANDOM = new Random(SEED);

    private static int computeHeight(int size) {
        return 2 * size;
    }

    private static int computeWidth(int size) {
        return 3 * size - 2;
    }

    /** Returns the start position and end position */
    private static int[] drawUpper(int size, int rowNumber) {
        int[] result = new int[2];
        result[0] = size - rowNumber - 1;
        result[1] = size + rowNumber * 2;
        return result;
    }

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(3);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.NOTHING;
            default: return Tileset.NOTHING;
        }
    }

    public static TETile[][] addHexagon(int size) {
        int Height = computeHeight(size);
        int Width = computeWidth(size);
        TETile[][] grid = new TETile[Width][Height];
        int[] positions;

        for(int i = 0; i < Width; i++) {
            for(int j = 0; j < Height; j++) {
                grid[i][j] = Tileset.NOTHING;
            }
        }

        for(int j = 0; j < size; j += 1) {
            positions = drawUpper(size, j);
            int start = positions[0];
            int num = positions[1];
            for(int i = 0; i < num; i++) {
                grid[start + i][j] = Tileset.FLOWER;
            }
        }

        for(int j = size; j < Height; j++) {
            positions = drawUpper(size, Height - 1 - j);
            int start = positions[0];
            int num = positions[1];
            for(int i = 0; i < num; i++) {
                grid[start + i][j] = Tileset.FLOWER;
            }
        }
        return grid;
    }

    public static void drawHexagon(int size) {
        TERenderer ter = new TERenderer();
        ter.initialize(computeWidth(size), computeHeight(size));
        TETile[][] hexagon = addHexagon(size);
        ter.renderFrame(hexagon);
    }

    public static void main(String[] args) {
        drawHexagon(3);
    }
}
