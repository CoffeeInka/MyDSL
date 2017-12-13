package com.herokuapp;

import com.herokuapp.testconfigs.BaseTest;
import core.entities.element.LazyElement;
import org.junit.Test;

import static com.herokuapp.pages.ToDoMVC.*;
import static com.herokuapp.pages.ToDoMVC.TaskStatus.ACTIVE;
import static com.herokuapp.pages.ToDoMVC.TaskStatus.COMPLETED;
import static core.conditions.CollectionConditions.size;
import static core.conditions.CollectionConditions.textsOf;
import static core.conditions.ElementConditions.text;
import static core.conditions.ElementConditions.visible;

public class ToDoMVCLifeCycleTest extends BaseTest {

    @Test
    public void testSwitchFilterToAll() {
        givenAtActive(aTask(ACTIVE, "1"), aTask(COMPLETED, "2"));

        filterAll();
        tasks.shouldHave(textsOf("1", "2"));
    }

    @Test
    public void testSwitchFilterToCompleted() {
        given(aTask(ACTIVE, "1"), aTask(COMPLETED, "2"));

        filterCompleted();
        tasks.filter(visible()).shouldHave(textsOf("2"));
        tasks.find(text("2")).shouldBe(visible());
    }

    @Test
    public void testTasksLifeCycle() {
        given();

        add("A", "B");
        tasks.shouldHave(size(2));
        for (LazyElement element : tasks) {
            System.out.println(element.getText());
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
