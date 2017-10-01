package me.rv.game;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import me.rv.game.net.packets.Packet01Disconnect;

public class WindowHandler extends WindowAdapter {

    private final Game game;

    public WindowHandler(Game game) {
        this.game = game;
        this.game.frame.addWindowListener(this);
    }

    @Override
    public void windowClosing(WindowEvent event) {
        Packet01Disconnect packet = new Packet01Disconnect(this.game.player.getUsername());
        packet.writeData(this.game.socketClient);
    }
}
