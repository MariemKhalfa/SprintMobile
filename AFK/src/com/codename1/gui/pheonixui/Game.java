/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.gui.pheonixui;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.nlcode.cd1.mario.MarioGame;
import com.nlcode.cn1.core.input.InputEvent;

/**
 *
 * @author Lynda
 */
public class Game {

    public Game() {
        
        Display.getInstance().setFramerate(100);
        
        int h = 640;
        int w = 240;
        MarioGame game = new MarioGame(w, h);

        //I wish to remove this in the future, but havent figured out this yet
        //(Dont want to create a custom form class... I want this to work with any form)
        Form objForm = new Form() 
        {
            @Override
            public void keyPressed(int keyCode) {
                InputEvent.registerKeyPress(keyCode);
            }

            @Override
            public void keyReleased(int keyCode) {
                InputEvent.registerKeyRelease(keyCode);
            }

            @Override
            public void pointerDragged(int[] x, int[] y) {
                InputEvent.registerTouchMovement(x, y);
            }

            @Override
            public void pointerPressed(int[] x, int[] y) {
                InputEvent.registerTouchPress(x, y);
            }

            @Override
            public void pointerReleased(int[] x, int[] y) {
                InputEvent.registerTouchRelease(x, y);
            }
        };
        objForm.setLayout(new BorderLayout());
        objForm.addComponent(BorderLayout.CENTER, game.getCanvas());
        objForm.show();

        game.run(objForm);
    }
    
}
