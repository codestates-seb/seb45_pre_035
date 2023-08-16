package com.preproject_35.function;
import java.util.Stack;

public class BrowserHistory {
    private Stack<String> backStack;
    private Stack<String> forwardStack;

    public BrowserHistory() {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
    }

    public void navigateTo(String url) {
        backStack.push(url);
        forwardStack.clear();
        System.out.println("Navigated to: " + url);
    }

    public void goBack() {
        if (!backStack.isEmpty()) {
            forwardStack.push(backStack.pop());
            System.out.println("Went back to: " + getCurrentPage());
        } else {
            System.out.println("Cannot go back, no history.");
        }
    }

    public void goForward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(forwardStack.pop());
            System.out.println("Went forward to: " + getCurrentPage());
        } else {
            System.out.println("Cannot go forward, no history.");
        }
    }

    public String getCurrentPage() {
        return backStack.isEmpty() ? "No page" : backStack.peek();
    }
}

