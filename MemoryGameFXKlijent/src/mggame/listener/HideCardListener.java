package mggame.listener;

import DomenskiObjekat.MemoryCard;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author mario
 */
public class HideCardListener implements EventHandler {

    MemoryCard mc;
    static MemoryCard openedCard;

    public HideCardListener(MemoryCard mc, MemoryCard openedCard) {
        this.mc = mc;
        this.openedCard = openedCard;
    }

    @Override
    public void handle(Event t) {
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (openedCard != mc && !mc.isFlipped()) {
            mc.close();
        }
    }

}