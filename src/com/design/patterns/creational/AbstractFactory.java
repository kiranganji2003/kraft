package com.design.patterns.creational;

interface Button {
    void renderButton();
}

interface Checkbox {
    void renderCheckbox();
}

class WindowsButton implements Button {

    @Override
    public void renderButton() {
        System.out.println("windows button has been created");
    }
}

class WindowsCheckbox implements Checkbox {

    @Override
    public void renderCheckbox() {
        System.out.println("windows checkbox has been created");
    }
}

class MacButton implements Button {

    @Override
    public void renderButton() {
        System.out.println("mac button has been created");
    }
}

class MacCheckbox implements Checkbox {

    @Override
    public void renderCheckbox() {
        System.out.println("mac checkbox has been created");
    }
}

interface WidgetFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements WidgetFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements WidgetFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {

        WidgetFactory windowsWidget = new WindowsFactory();
        Button windowsButton = windowsWidget.createButton();
        Checkbox windowsCheckbox = windowsWidget.createCheckbox();

        windowsButton.renderButton();
        windowsCheckbox.renderCheckbox();

        WidgetFactory macWidget = new MacFactory();
        macWidget.createButton().renderButton();
        macWidget.createCheckbox().renderCheckbox();

    }
}
