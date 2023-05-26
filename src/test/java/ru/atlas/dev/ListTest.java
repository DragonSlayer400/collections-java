package ru.atlas.dev;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {
    private final List list = new LinkedList();
    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 50; i++) {
            list.add(new StudentGroup(
                    i,
                    "StudentGroup" + i
            ));
        }
    }
    @After
    public void clearList() throws Exception {
        list.clear();
    }
    @Test
    public void whenAdded50ElementsThenSizeMustBe50(){
        assertEquals(50, list.size());
    }
    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased(){
        assertTrue(list.removeAt(37));
        assertEquals(49, list.size());
    }
    @Test
    public void whenElementRemovedThenSizeMustBeDecreased(){
        StudentGroup group = new StudentGroup(111, "KST-23");
        list.add(group);
        assertEquals(51, list.size());
        assertTrue(list.remove(group));
        assertEquals(50, list.size());
    }
    @Test
    public void whenNonExistentElementRemovedReturnFalse(){
        StudentGroup group = new StudentGroup(34, "SIS-23");
        assertFalse(list.remove(group));
        assertEquals(50, list.size());
    }
    @Test
    public void whenListClearedThenSizeMustBe0(){
        list.clear();
        assertEquals(0, list.size());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException(){
        list.get(90);
    }
    @Test
    public void methodGetReturnedRightValue(){
        StudentGroup group = list.get(0);
        assertEquals("StudentGroup0", group.getGroupName());
    }
    @Test
    public void insertIntoMiddle(){
        StudentGroup group = new StudentGroup(789, "BI-BOZ-22");
        list.add(group, 25);
        StudentGroup groupFromList = list.get(25);
        assertEquals("BI-BOZ-22", groupFromList.getGroupName());
        assertEquals(51, list.size());
    }
    @Test
    public void insertIntoFirstPosition(){
        StudentGroup group = new StudentGroup(111, "BI-BOZ-22");
        list.add(group, 0);
        StudentGroup groupFromList = list.get(0);
        assertEquals("BI-BOZ-22", groupFromList.getGroupName());
        assertEquals(51, list.size());
    }
    @Test
    public void insertIntoLastPosition(){
        StudentGroup group = new StudentGroup(111, "BI-BOZ-22");
        list.add(group, 50);
        StudentGroup groupFromList = list.get(50);
        assertEquals("BI-BOZ-22", groupFromList.getGroupName());
        assertEquals(51, list.size());
    }

}