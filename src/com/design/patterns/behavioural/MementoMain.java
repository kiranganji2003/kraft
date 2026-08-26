package com.design.patterns.behavioural;

import java.util.Stack;

class Document {
    private String text;
    private History history = new History();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void save() {
        history.save(this);
    }

    public void undo() {
        history.undo(this);
    }

    @Override
    public String toString() {
        return "Document{" +
                "text='" + text + '\'' +
                '}';
    }
}

class Snapshot {
    private final String text;

    public Snapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

interface Memento {
    void save(Document document);
    void undo(Document document);
}

class History implements Memento {

    private Stack<Snapshot> versions = new Stack<>();

    @Override
    public void save(Document document) {

        if(!document.getText().isBlank()) {
            versions.push(new Snapshot(document.getText()));
        }

    }

    @Override
    public void undo(Document document) {

        if(!versions.isEmpty()) {
            document.setText(versions.pop().getText());
        }

    }
}



public class MementoMain {

    public static void main(String[] args) {

        Document document = new Document();
        document.setText("kiran");
        document.save();

        document.setText("venkatesh");
        document.save();

        document.setText("ganji");

        System.out.println(document);
        document.undo();
        System.out.println(document);

    }

}
