package com.herokuapp;

import com.herokuapp.testconfigs.BaseTest;
import org.junit.Test;

import static com.herokuapp.pages.ToDoMVC.TaskStatus.ACTIVE;
import static com.herokuapp.pages.ToDoMVC.TaskStatus.COMPLETED;
import static com.herokuapp.pages.ToDoMVC.*;


public class ToDoMVCAtActiveFilterTest extends BaseTest {

    @Test
    public void testComplete() {
        givenAtActive(ACTIVE, "1", "2");

        toggle("1");
        assertTasks("2");
        assertItemsLeft(1);
    }

    @Test
    public void testClearCompleted() {
        givenAtActive(aTask(COMPLETED, "1"), aTask(COMPLETED, "2"), aTask(ACTIVE, "3"));

        clearCompleted();
        assertTasks("3");
        assertItemsLeft(1);
    }
//
//    @Test
//    public void testEdit() {
//        givenAtActive(ACTIVE, "1", "2");
//
//        edit("2", "2 edited");
//        assertTasks("1", "2 edited");
//        assertItemsLeft(2);
//    }
//
//    @Test
//    public void testCancelEdit() {
//        givenAtActive(ACTIVE, "1", "2");
//
//        cancelEdit("2", "2 edit canceled");
//        assertTasks("1", "2");
//        assertItemsLeft(2);
//    }
//
//    @Test
//    public void testEditByClickOutOfTask() {
//        givenAtActive(ACTIVE, "1", "2");
//
//        editByClickOutOfTask("2", "2 edited");
//        assertTasks("1", "2 edited");
//        assertItemsLeft(2);
//    }

    @Test
    public void testDeleteTask(){
        givenAtActive(aTask(ACTIVE, "1"), aTask(ACTIVE, "2"));

        delete("1");
        assertTasks("2");
        assertItemsLeft(1);
    }

    @Test
    public void testSwitchFilterToAll() {
        givenAtActive(aTask(ACTIVE, "1"), aTask(COMPLETED, "2"));

        filterAll();
        assertTasks("1", "2");
        assertItemsLeft(1);
    }
}