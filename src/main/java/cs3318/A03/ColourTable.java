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
        // Check if the palette size is a power of two and within the specified range
        if (!isPowerOfTwo(paletteSize) || paletteSize < 2 || paletteSize >= 1025) {
            throw new IllegalArgumentException("Invalid palette size");
        }

        // Initialize the palette size and other necessary logic
        this.paletteSize = paletteSize;
        this.colors = new ArrayList<>();
    }

    // Helper method to check if a number is a power of two
    private boolean isPowerOfTwo(int number) {
        return (number & (number - 1)) == 0 && number > 0;
    }

    // Getter method for palette size
    public int getPaletteSize() {
        return paletteSize;
    }

    // Method to add a color to the table
    public void add(int color) {
        // Check if the palette is not full before adding a color
        if (colors.size() >= paletteSize) {
            throw new IllegalStateException("Palette is at full capacity");
        }

        // Check if the color is already present in the palette
        if (colors.contains(color)) {
            throw new IllegalArgumentException("Color is already present in the palette");
        }

        // Check if the color is a 24-bit RGB color (within the valid range)
        if (!isValidRgbColor(color)) {
            throw new IllegalArgumentException("Invalid RGB color");
        }

        // Add the color to the palette
        colors.add(color);
    }
    // Validate the RGB color
    private boolean isValidRgbColor(int color) {
        // Check if the color is a 24-bit RGB color (within the valid range)
        return (color >= 0 && color <= 0xFFFFFF);
    }

    // Getter method for colors (returns a copy of the internal list)
    public List<Integer> getColors() {
        return new ArrayList<>(colors);
    }

    // Method to check if the table contains a specific color
    public boolean contains(int color) {
        return colors.contains(color);
    }

    // Other methods...

}
