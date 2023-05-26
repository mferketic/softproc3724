package mggame.listener;

import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author mario
 */
public class GameStartListener implements EventHandler {

    mggame.MgGame mgGame;

    public GameStartListener(mggame.MgGame mgGame) {
        this.mgGame = mgGame;
    }

    @Override
    public void handle(Event t) {
        mgGame.gameStart();
    }

}
