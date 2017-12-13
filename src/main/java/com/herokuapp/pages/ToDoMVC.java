package com.herokuapp.pages;

import core.entities.collection.LazyCollection;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import java.util.Arrays;

import static core.ConciseAPI.*;
import static core.conditions.ElementConditions.text;
import static core.conditions.ElementConditions.visible;

public class ToDoMVC {

    public static LazyCollection tasks = $$(By.cssSelector("#todo-list li"));
    public static LazyCollection filters = $$(By.cssSelector("#filters li a"));

    public static void add(String... tasksTexts) {
        for (String text : tasksTexts) {
            $(By.cssSelector("#new-todo")).setValue(text).pressEnter();
        }
    }

//    public static void toggle(String taskText) {
//        $(listElementWithText(tasks, taskText), ".toggle").click();
//    }

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


}
