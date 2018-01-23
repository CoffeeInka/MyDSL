package com.herokuapp;

import com.testconfigs.BaseTest;
import org.junit.Test;

import static com.herokuapp.pages.ToDoMVC.*;
import static com.herokuapp.pages.ToDoMVC.TaskStatus.ACTIVE;
import static com.herokuapp.pages.ToDoMVC.TaskStatus.COMPLETED;

public class ToDoMVCAtCompletedFilterTest extends BaseTest {

    @Test
    public void testDelete() {
        givenAtCompleted(COMPLETED, "1", "2");

        delete("1");
        assertTasks("2");
        assertItemsLeft(0);
    }

    @Test
    public void testReactivateAll() {
        givenAtCompleted(COMPLETED, "1", "2");

        toggleAll();
        assertNoTasks();
        assertItemsLeft(2);
    }

    @Test
    public void testDeleteByClearText() {
        givenAtCompleted(COMPLETED, "1", "2");

        edit("2", "");
        assertTasks("1");
        assertItemsLeft(0);
    }

    @Test
    public void testSwitchFilterToActive() {
        givenAtCompleted(aTask(COMPLETED, "1"), aTask(COMPLETED, "2"), aTask(ACTIVE, "3"));

        filterActive();
        assertTasks("3");
        assertItemsLeft(1);
    }
}
