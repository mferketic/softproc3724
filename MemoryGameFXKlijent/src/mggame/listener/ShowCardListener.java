package mggame.listener;

import DomenskiObjekat.MemoryCard;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author mario
 */
public class ShowCardListener implements EventHandler {

    MemoryCard mc;
    static MemoryCard openedCard;
    mggame.MgGame kongui;

    public ShowCardListener(MemoryCard mc, MemoryCard openedCard, mggame.MgGame kongui) {
        this.kongui = kongui;
        this.mc = mc;
        this.openedCard = openedCard;
    }

    @Override
    public void handle(Event t) {

        if (mc.isFlipped()) {
            return;
        }
        if (openedCard != null && !openedCard.isFlipped()) {
            if (openedCard != mc && openedCard.equals(mc)) {
                openedCard.open();
                mc.open();
            } else {
                mc.showCard();
                openedCard.close();
                openedCard = null;
            }
        } else {
            openedCard = mc;
            openedCard.showCard();
        }
        if (kongui.gameIsFinished()) {
            kongui.fxcon.giveUp.setVisible(false);
            kongui.fxcon.oneMoreTry.setVisible(true);
        }
    }

}
