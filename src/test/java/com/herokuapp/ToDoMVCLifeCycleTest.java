package com.herokuapp;

import com.herokuapp.testconfigs.BaseTest;
import core.entities.element.LazyElement;
import org.junit.Test;

import static com.herokuapp.pages.ToDoMVC.*;
import static core.conditions.ElementConditions.text;

public class ToDoMVCLifeCycleTest extends BaseTest {


    @Test
    public void testTasksLifeCycle() {
        given();

        add("A", "A");
        for (LazyElement element:tasks) {
            System.out.println(element.getText());
            element.shouldHave(text("A"));
        }


//        filterActive();
//        assertNoTasks();
//
//        add("B");
//        assertTasks("B");
//        assertItemsLeft(1);
//
//        toggleAll();
//        assertNoTasks();
//
//        filterCompleted();
//        assertTasks("A", "B");
//
//        toggle("A");
//        assertTasks("B");
//
//        clearCompleted();
//        assertNoTasks();
//
//        filterAll();
//        assertTasks("A");
    }


}
