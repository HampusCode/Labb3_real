import javax.swing.*;

class ButtonFactory implements ButtonFactoryInterface {
    @Override
    public JButton createButton(String buttonText) {
        return new JButton(buttonText);
    }
}