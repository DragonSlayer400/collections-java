package ru.atlas.dev;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetTest {

    private final Set set = new HashSet();

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            set.add(new StudentGroup(i, "Group" + i));
        }
    }
    @After
    public void clearSet() throws Exception {
        set.clear();
    }

    @Test
    public void whenAdd3SimilarObjectsThenSizeIncreaseBy1(){
        assertEquals(100, set.size());
        assertTrue(set.add(new StudentGroup(101, "Group101")));
        assertFalse(set.add(new StudentGroup(101, "Group101")));
        assertFalse(set.add(new StudentGroup(101, "Group101")));
        assertEquals(101, set.size());
    }

    @Test
    public void whenSetClearedThenSize0(){
        set.clear();
        assertEquals(0, set.size());
    }

    @Test
    public void whenElementRemovedThenSizeDecrease(){
        assertTrue(set.remove(new StudentGroup(99, "Group99")));
        assertEquals(99, set.size());
        assertFalse(set.remove(new StudentGroup(99, "Group99")));
        assertEquals(99, set.size());
    }
}