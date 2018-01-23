package com.herokuapp.pages;

import core.entities.LazyCollection;
import core.entities.LazyElement;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

import static core.ConciseAPI.*;
import static core.conditions.CollectionConditions.size;
import static core.conditions.CollectionConditions.texts;
import static core.conditions.CustomConditions.jsReturnedTrue;
import static core.conditions.ElementConditions.*;

public class ToDoMVC {

    public static LazyCollection tasks = $$(By.cssSelector("#todo-list li"));
    public static LazyCollection filters = $$(By.cssSelector("#filters li a"));

    public static void add(String... tasksTexts) {
        for (String text : tasksTexts) {
            $(By.cssSelector("#new-todo")).setValue(text).pressEnter();
        }
    }

    public static void toggle(String taskText) {
        tasks.find(text(taskText)).$(".toggle").click();
    }

    public static void assertTasks(String... tasksTexts) {
        tasks.filter(visible()).shouldHave(texts(tasksTexts));
    }

    public static void assertNoTasks() {
        tasks.filter(visible()).shouldHave(size(0));
    }

    public static void assertItemsLeft(int count) {
        $(By.cssSelector("#todo-count strong")).shouldHave(text(Integer.toString(count)));
    }

    public static LazyElement startEdit(String oldText, String newText) {
        tasks.find(exactText(oldText)).$(".view>label").doubleClick();
        return tasks.find(cssClass("editing")).$(".edit").setValue(newText);
    }

    public static void edit(String oldTaskText, String newTaskText) {
        startEdit(oldTaskText, newTaskText).pressEnter();
    }

    public static void editByClickOutOfTask(String oldTaskText, String newTaskText) {
        startEdit(oldTaskText, newTaskText);
        $(By.cssSelector("#header h1")).click();
    }

    public static void cancelEdit(String oldTaskText, String newTaskText) {
        startEdit(oldTaskText, newTaskText).pressESCAPE();
    }

    public static void delete(String taskText) {
        tasks.find(text(taskText)).hover();
        tasks.find(text(taskText)).$(".destroy").click();
    }

    public static void clearCompleted() {
        $(By.cssSelector("#clear-completed")).click();
    }

    public static void toggleAll() {
        $(By.cssSelector("#toggle-all")).click();
    }

    public static void filterCompleted() {
        filters.find(text("Completed")).click();
    }

    public static void filterActive() {
        filters.find(text("Active")).click();
    }

    public static void filterAll() {
        filters.find(text("All")).click();
    }

    public static void assertAppIsLoaded() {
        waitFor(jsReturnedTrue(
                "return " +
                        "$._data($('#new-todo').get(0), 'events').hasOwnProperty('keyup')&& " +
                        "$._data($('#toggle-all').get(0), 'events').hasOwnProperty('change') && " +
                        "$._data($('#clear-completed').get(0), 'events').hasOwnProperty('click')"));
    }

    public static void givenAtActive(Task... tasks) {
        given(tasks);
        filterActive();
    }

    public static void givenAtActive(TaskStatus status, String... taskTexts) {
        given(tasksWithStatus(status, taskTexts));
        filterActive();
    }

    public static void givenAtCompleted(Task... tasks) {
        given(tasks);
        filterCompleted();
    }

    public static void givenAtCompleted(TaskStatus status, String... taskTexts) {
        given(tasksWithStatus(status, taskTexts));
        filterCompleted();
    }

    public static void given(Task... tasks) {
        ensureUrl();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String jsCommand = "localStorage.setItem(\"todos-troopjs\", '[" + StringUtils.join(tasks, ",") + "]')";
        System.out.println(jsCommand);
        executeJavaScript(jsCommand);
        assertAppIsLoaded();
        refresh();
    }

    public static void given(TaskStatus status, String... taskTexts) {
        given(tasksWithStatus(status, taskTexts));
    }

    public static class Task {

        public TaskStatus status;
        public String taskText;

        Task(TaskStatus status, String taskText) {
            this.status = status;
            this.taskText = taskText;
        }

        @Override
        public String toString() {
            return String.format("{\"completed\":%s,\"title\":\"%s\"}", status, taskText);
        }
    }

    public static Task aTask(TaskStatus status, String taskText) {
        Task aTask = new Task(status, taskText);
        return aTask;
    }

    public enum TaskStatus {
        ACTIVE("false"),
        COMPLETED("true");

        public String status;

        TaskStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return status;
        }
    }

    public static void ensureUrl() {
        if (!getDriver().getCurrentUrl().equals("https://todomvc4tasj.herokuapp.com/")) {
            open("https://todomvc4tasj.herokuapp.com/");
        }
    }

    public static Task[] tasksWithStatus(TaskStatus status, String... taskTexts) {
        return Arrays.stream(taskTexts).map(taskText ->
                aTask(status, taskText)).
                toArray(size -> new Task[size]);
    }

    public static Actions actions() {
        Actions actions = new Actions(getDriver());
        return actions;
    }
}
