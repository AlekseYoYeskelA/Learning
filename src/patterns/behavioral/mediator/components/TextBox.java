package patterns.behavioral.mediator.components;

import patterns.behavioral.mediator.mediator.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class TextBox extends JTextArea implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return "TextBox";
    }
}
