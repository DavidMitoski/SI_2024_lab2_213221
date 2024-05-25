package org.example;
import org.example.SILab2;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void checkEveryBranch() {
        RuntimeException exception;

        // Тест случај 1: allItems е null
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertTrue(exception.getMessage().contains("allItems list can't be null"));

        // Тест случај 2: item.getName() е null или празно
        assertFalse(SILab2.checkCart(create(new Item(null, "123456", 100, 0.1f)), 100));

        // Тест случај 3: item.getBarcode е null
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(create(new Item("Item1", null, 100, 0.1f)), 100));
        assertTrue(exception.getMessage().contains("No barcode!"));

        // Тест случај 4: item.getBarcode има невалидни карактери
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(create(new Item("Item1", "1234a6", 100, 0.1f)), 100));
        assertTrue(exception.getMessage().contains("Invalid character in item barcode!"));

        // Тест случај 5: item.getDiscount е поголем од 0
        assertFalse(SILab2.checkCart(create(new Item("Item1", "123456", 100, 0.1f)), 100));

        // Тест случај 6: item.getDiscount е 0 или помалку
        assertTrue(SILab2.checkCart(create(new Item("Item1", "123456", 100, 0)), 100));

        // Тест случај 7: item.getPrice е поголем од 300, item.getDiscount е поголем од 0 и првиот карактер на баркодот е '0'
        assertFalse(SILab2.checkCart(create(new Item("Item1", "0123456", 400, 0.1f)), 400));

        // Тест случај 8: sum е помала или еднаква на payment
        assertTrue(SILab2.checkCart(create(new Item("Item1", "123456", 100, 0.1f)), 90));

        // Тест случај 9: sum е поголема од payment
        assertFalse(SILab2.checkCart(create(new Item("Item1", "123456", 100, 0.1f)), 80));
    }

    @Test
    void checkMultipleConditions() {
        // Тест случај 1: Цената е поголема од 300, попустот е поголем од 0, баркодот почнува со '0'
        assertTrue(SILab2.checkCart(create(new Item("Item1", "0123456", 400, 0.1f)), 370));

        // Тест случај 2: Цената е поголема од 300, попустот е поголем од 0, баркодот не почнува со '0'
        assertFalse(SILab2.checkCart(create(new Item("Item1", "1123456", 400, 0.1f)), 360));

        // Тест случај 3: Цената е поголема од 300, попустот е 0 или помал, баркодот почнува со '0'
        assertFalse(SILab2.checkCart(create(new Item("Item1", "0123456", 400, 0.0f)), 400));

        // Тест случај 4: Цената е поголема од 300, попустот е 0 или помал, баркодот не почнува со '0'
        assertFalse(SILab2.checkCart(create(new Item("Item1", "1123456", 400, 0.0f)), 400));

        // Тест случај 5: Цената е 300 или помалку, попустот е поголем од 0, баркодот почнува со '0'
        assertFalse(SILab2.checkCart(create(new Item("Item1", "0123456", 300, 0.1f)), 270));

        // Тест случај 6: Цената е 300 или помалку, попустот е поголем од 0, баркодот не почнува со '0'
        assertFalse(SILab2.checkCart(create(new Item("Item1", "1123456", 300, 0.1f)), 270));

        // Тест случај 7: Цената е 300 или помалку, попустот е 0 или помал, баркодот почнува со '0'
        assertFalse(SILab2.checkCart(create(new Item("Item1", "0123456", 300, 0.0f)), 300));

        // Тест случај 8: Цената е 300 или помалку, попустот е 0 или помал, баркодот не почнува со '0'
        assertFalse(SILab2.checkCart(create(new Item("Item1", "1123456", 300, 0.0f)), 300));
    }

    private List<Item> create(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
}