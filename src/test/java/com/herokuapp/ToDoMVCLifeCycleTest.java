package com.herokuapp;

import com.herokuapp.testconfigs.BaseTest;
import org.junit.Test;

import static com.herokuapp.pages.ToDoMVC.*;

public class ToDoMVCLifeCycleTest extends BaseTest {


    @Test
    public void testTasksLifeCycle() {
        given();

        add("1");
        toggle("1");
        assertTasks("1");

        filterActive();
        assertNoTasks();

        add("2");
        assertTasks("2");
        assertItemsLeft(1);

        toggleAll();
        assertNoTasks();

        filterCompleted();
        assertTasks("1", "2");

        toggle("1");
        assertTasks("2");

        clearCompleted();
        assertNoTasks();

        filterAll();
        assertTasks("1");
//        tasks.shouldHave(size(2));
//        for (LazyElement element : tasks) {
//            System.out.println(element.getText());
//        }

    }


}
