package utilities;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {

    public static Logger getLogger(Class<?> clazz) {
    	Logger logger = Logger.getLogger(clazz.getName());
        logger.setLevel(Level.INFO);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        consoleHandler.setFormatter(new SimpleFormatter());

        if (logger.getHandlers().length == 0) {
            logger.addHandler(consoleHandler);
        }

        return logger;

}

    
    
}