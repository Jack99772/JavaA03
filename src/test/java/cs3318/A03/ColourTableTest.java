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
        // Write test for constructor with an invalid palette size
        // Expect an exception to be thrown
    }

    @Test
    void addValidColor() {
        // Write test for adding a valid RGB color to the table
        // Ensure that the color is added successfully
    }

    @Test
    void addInvalidColor() {
        // Write test for adding an invalid RGB color
        // Expect an exception to be thrown
    }

    @Test
    void addColorAtFullCapacity() {
        // Write test for adding a color when the table is at full capacity
        // Expect an exception to be thrown
    }

    @Test
    void addSameColorMoreThanOnce() {
        // Write test for adding the same color more than once
        // Define the expected behavior
    }

    // Add more tests as needed for other aspects of the ColourTable class
}
