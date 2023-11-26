package cs3318.A03;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cs3318.A03.ColourTable;
class ColourTableTest {

    @Test
    void constructorValidPaletteSize() {
        // Arrange
        int validPaletteSize = 8; // Choose a valid palette size

        // Act
        ColourTable colourTable = new ColourTable(validPaletteSize);

        // Assert
        assertNotNull(colourTable, "ColourTable object should not be null");
        // Add more assertions based on the expected behavior of your constructor
        assertEquals(validPaletteSize, colourTable.getPaletteSize(), "Palette size should match");
        // Add more assertions if your constructor initializes other properties
    }

    @Test
    void constructorInvalidPaletteSize() {
        // Arrange
        int invalidPaletteSize = 1; // Choose an invalid palette size

        // Act & Assert
        // Use assertThrows to check that the specified type of exception (IllegalArgumentException) is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            // This lambda expression contains the code that is expected to throw the exception
            // Attempt to create a ColourTable with an invalid palette size
            new ColourTable(invalidPaletteSize);
        });
    }

    @Test
    void addValidColor() {
        // Arrange
        ColourTable colourTable = new ColourTable(8); // Create a ColourTable with a valid palette size
        int validRGBColor = 0xFF00FF; // Choose a valid RGB color (example: purple)

        // Act
        // Write the code to add the valid RGB color to the table
        colourTable.add(validRGBColor);

        // Assert
        // Add assertions to ensure that the color is added successfully
        assertTrue(colourTable.contains(validRGBColor), "Valid RGB color should be added");
        // You might add more assertions based on your specific requirements
    }

    @Test
    void addInvalidColor() {
        // Arrange
        ColourTable colourTable = new ColourTable(4); // Set a valid palette size for testing
        int invalidColor = 0xFFFFFF0; // An invalid RGB color (outside the valid range)

        // Act & Assert
        // Use assertThrows to check that the specified type of exception (IllegalArgumentException) is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            // This lambda expression contains the code that is expected to throw the exception
            // Attempt to add an invalid RGB color
            colourTable.add(invalidColor);
        });
    }

    @Test
    void addColorAtFullCapacity() {
        // Arrange
        ColourTable colourTable = new ColourTable(2); // Set a small palette size for testing
        int firstColor = 0xFF0000; // First color
        int secondColor = 0x00FF00; // Second color

        // Act
        colourTable.add(firstColor);
        colourTable.add(secondColor);

        // Assert
        assertThrows(IllegalStateException.class, () -> {
            // Attempt to add a third color when the table is at full capacity
            colourTable.add(0x0000FF);
        }, "Expected IllegalStateException to be thrown, but nothing was thrown.");
    }

    @Test
    void addSameColorMoreThanOnce() {
        // Arrange
        ColourTable colourTable = new ColourTable(4); // Set a valid palette size for testing
        int redColor = 0xFF0000; // Red color

        // Act & Assert
        // Use assertThrows to check that the specified type of exception (IllegalArgumentException) is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            // This lambda expression contains the code that is expected to throw the exception
            // Attempt to add the same color more than once
            colourTable.add(redColor);
            colourTable.add(redColor);
        });
    }

    // Add more tests as needed for other aspects of the ColourTable class
}
