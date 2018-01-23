package com.herokuapp;

import com.testconfigs.BaseTest;
import org.junit.Test;

import static com.herokuapp.pages.ToDoMVC.*;
import static com.herokuapp.pages.ToDoMVC.TaskStatus.ACTIVE;
import static com.herokuapp.pages.ToDoMVC.TaskStatus.COMPLETED;

public class ToDoMVCAtAllFilterTest extends BaseTest {

    @Test
    public void testCompleteAll() {
        given(aTask(ACTIVE, "1"), aTask(COMPLETED, "2"));

        toggleAll();
        assertTasks("1", "2");
        assertItemsLeft(0);
    }

    @Test
    public void testClearCompleted() {
        given(COMPLETED, "1");

        clearCompleted();
        assertNoTasks();
    }

    @Test
    public void testReactivate() {
        given(aTask(ACTIVE, "1"), aTask(COMPLETED, "2"));

        toggle("2");
        assertTasks("1", "2");
        assertItemsLeft(2);
    }

    @Test
    public void testEdit() {
        given(ACTIVE, "1");

        edit("1", "1 edited");
        assertTasks("1 edited");
        assertItemsLeft(1);
    }

    @Test
    public void testDelete() {
        given(aTask(COMPLETED, "1"), aTask(ACTIVE, "2"));

        delete("1");
        assertTasks("2");
        assertItemsLeft(1);
    }

    @Test
    public void testCancelEdit() {
        given(aTask(ACTIVE, "1"), aTask(COMPLETED, "2"));

        cancelEdit("2", "2 edit canceled");
        assertTasks("1", "2");
        assertItemsLeft(1);
    }

    @Test
    public void testSwitchFilterToCompleted() {
        given(aTask(ACTIVE, "1"), aTask(COMPLETED, "2"));

        filterCompleted();
        assertTasks("2");
        assertItemsLeft(1);
    }
}

