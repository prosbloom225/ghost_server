package com.prosbloom.rengine.client;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

/**
 * This first tutorial, demonstrating setting up a simple {@link Terminal} and performing some basic operations on it.
 * @author Martin
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = null;
        try {
            terminal = defaultTerminalFactory.createTerminal();
            terminal.putCharacter('H');
            terminal.putCharacter('e');
            terminal.putCharacter('l');
            terminal.putCharacter('l');
            terminal.putCharacter('o');
            terminal.putCharacter('\n');
            terminal.flush();
            Thread.sleep(2000);
            TerminalPosition startPosition = terminal.getCursorPosition();
            terminal.setCursorPosition(startPosition.withRelativeColumn(3).withRelativeRow(2));
            terminal.flush();
            Thread.sleep(2000);
            terminal.setBackgroundColor(TextColor.ANSI.BLUE);
            terminal.setForegroundColor(TextColor.ANSI.YELLOW);
            terminal.putCharacter('Y');
            terminal.putCharacter('e');
            terminal.putCharacter('l');
            terminal.putCharacter('l');
            terminal.putCharacter('o');
            terminal.putCharacter('w');
            terminal.putCharacter(' ');
            terminal.putCharacter('o');
            terminal.putCharacter('n');
            terminal.putCharacter(' ');
            terminal.putCharacter('b');
            terminal.putCharacter('l');
            terminal.putCharacter('u');
            terminal.putCharacter('e');
            terminal.flush();
            Thread.sleep(2000);

            /*
            In addition to colors, most terminals supports some sort of style that can be selectively enabled. The most
            common one is bold mode, which on many terminal implementations (emulators and otherwise) is not actually
            using bold text at all but rather shifts the tint of the foreground color so it stands out a bit. Let's
            print the same text as above in bold mode to compare.

            Notice that startPosition has the same value as when we retrieved it with getTerminalSize(), the
            TerminalPosition class is immutable and calling the with* methods will return a copy. So the following
            setCursorPosition(..) call will put us exactly one row below the previous row.
             */
            terminal.setCursorPosition(startPosition.withRelativeColumn(3).withRelativeRow(3));
            terminal.flush();
            Thread.sleep(2000);
            terminal.enableSGR(SGR.BOLD);
            terminal.putCharacter('Y');
            terminal.putCharacter('e');
            terminal.putCharacter('l');
            terminal.putCharacter('l');
            terminal.putCharacter('o');
            terminal.putCharacter('w');
            terminal.putCharacter(' ');
            terminal.putCharacter('o');
            terminal.putCharacter('n');
            terminal.putCharacter(' ');
            terminal.putCharacter('b');
            terminal.putCharacter('l');
            terminal.putCharacter('u');
            terminal.putCharacter('e');
            terminal.flush();
            Thread.sleep(2000);

            /*
            Ok, that's enough for now. Let's reset colors and SGR modifiers and move down one more line
             */
            terminal.resetColorAndSGR();
            terminal.setCursorPosition(terminal.getCursorPosition().withColumn(0).withRelativeRow(1));
            terminal.putCharacter('D');
            terminal.putCharacter('o');
            terminal.putCharacter('n');
            terminal.putCharacter('e');
            terminal.putCharacter('\n');
            terminal.flush();

            Thread.sleep(2000);

            /*
            Beep and exit
             */
            terminal.bell();
            terminal.flush();
            Thread.sleep(200);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            if(terminal != null) {
                try {
                    terminal.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

