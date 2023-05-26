package ru.atlas.dev;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {

    private Map map = new HashMap();
    @After
    public void clearMap() throws Exception {
        map.clear();
    }

    @Test
    public void whenPut100ElementsThenSizeBecome100(){
        for (int i = 0; i < 100; i++) {
            Curator curator = new Curator(i, "Name" + i, "LastName" + i);
            StudentGroup studentGroup = new StudentGroup(i, "StudentGroup" + i);
            map.put(curator, studentGroup);
        }
        assertEquals(100, map.size());
    }

    @Test
    public void whenPut100ElementsWith10DifferentKeysThenSize10(){
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            Curator curator = new Curator(index, "Name" + index, "LastName" + index);
            StudentGroup studentGroup = new StudentGroup(index, "StudentGroup" + index);
            map.put(curator, studentGroup);
        }
        assertEquals(10, map.size());
    }

    @Test
    public void removeReturnTrueOnlyOnce(){
        for (int i = 0; i < 10; i++) {
            Curator curator = new Curator(i, "Name" + i, "LastName" + i);
            StudentGroup studentGroup = new StudentGroup(i, "StudentGroup" + i);
            map.put(curator, studentGroup);
        }
        assertEquals(10, map.size());
        Curator elementForDeleting = new Curator(5, "Name5", "LastName5");
        assertTrue(map.remove(elementForDeleting));
        assertEquals(9, map.size());
        assertFalse(map.remove(elementForDeleting));
    }

    @Test
    public void countOfKeysMustBeEqualsToCountOfValues(){
        for (int i = 0; i < 100; i++) {
            Curator curator = new Curator(i, "Name" + i, "LastName" + i);
            StudentGroup studentGroup = new StudentGroup(i, "StudentGroup" + i);
            map.put(curator, studentGroup);
        }
        assertEquals(100, map.size());
        assertEquals(100, map.keySet().size());
        assertEquals(100, map.values().size());
    }

    @Test
    public void methodGetMustReturnRightValue(){
        for (int i = 0; i < 100; i++) {
            Curator curator = new Curator(i, "Name" + i, "LastName" + i);
            StudentGroup studentGroup = new StudentGroup(i, "StudentGroup" + i);
            map.put(curator, studentGroup);
        }
        Curator key = new Curator(50, "Name50", "LastName50");
        StudentGroup value = map.get(key);
        String expectedStudentGroupName = "StudentGroup50";
        assertEquals(expectedStudentGroupName, value.getGroupName());
    }
}