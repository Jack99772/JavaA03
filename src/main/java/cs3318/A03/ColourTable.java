package cs3318.A03;

import java.util.ArrayList;
import java.util.List;

public class ColourTable {
    private int paletteSize;
    private final List<Integer> colors;

    // Default constructor with no arguments
    public ColourTable() {
        // Default behavior, you can initialize default values if needed
        this.colors = new ArrayList<>();
    }

    // Constructor with a palette size parameter
    public ColourTable(int paletteSize) {
        this.paletteSize = paletteSize;
        this.colors = new ArrayList<>();
        // Additional initialization logic if needed
    }

    // Getter method for palette size
    public int getPaletteSize() {
        return paletteSize;
    }

    // Method to add a color to the table
    public void add(int color) {
        // Check if the palette is not full before adding a color
        if (colors.size() < paletteSize) {
            colors.add(color);
        } else {
            throw new IllegalStateException("Palette is at full capacity");
        }
    }

    // Method to check if the table contains a specific color
    public boolean contains(int color) {
        return colors.contains(color);
    }

    // Other methods...

}
