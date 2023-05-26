package mggame;

import DomenskiObjekat.MemoryCard;
import mggame.listener.ShowCardListener;
import mggame.listener.HideCardListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author mario
 */
public class MgGame {

    public FXMLDocumentController fxcon;
    List<MemoryCard> memoryCardList;
    static MemoryCard clickedCard;

    public MgGame(FXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        this.fxcon = fxcon;
        try {
            MemoryCard[][] talon = createNewGame();

            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    MemoryCard mc = talon[i][j];
                    mc.setOnMouseExited(new HideCardListener(mc, clickedCard));
                    mc.setOnMouseClicked(new ShowCardListener(mc, clickedCard, this));
                    HBox hbox = new HBox(mc);
                    hbox.setAlignment(Pos.CENTER);
                    this.fxcon.grid.add(hbox, i, j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void gameStart() {
        System.out.println("Good luck!");
    }

    public List<MemoryCard> populateCardWithPicture() {
        memoryCardList = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i <= 7; i++) {
            MemoryCard k1 = new MemoryCard("/pics/pic" + String.valueOf(i) + ".png");
            k1.setId(String.valueOf(counter));
            memoryCardList.add(k1);

            MemoryCard k2 = new MemoryCard("/pics/pic" + String.valueOf(i) + ".png");
            k2.setId(String.valueOf(counter));
            memoryCardList.add(k2);

            counter++;
        }
        Collections.shuffle(memoryCardList);
        return memoryCardList;
    }

    private MemoryCard[][] createNewGame() {
        List<MemoryCard> lista = populateCardWithPicture();
        MemoryCard[][] newGame = new MemoryCard[4][4];
        int cntr = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                MemoryCard k = lista.get(cntr);
                newGame[i][j] = k;
                cntr++;
            }
        }
        return newGame;
    }

    public boolean gameIsFinished() {
        for (MemoryCard k : memoryCardList) {
            if (k.isFlipped() == false) {
                return false;
            }
        }
        return true;
    }

}
