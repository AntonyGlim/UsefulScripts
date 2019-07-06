package logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * In this class we load logger properties from file
 * Fnd configured logger
 * https://www.mkyong.com/logging/log4j-hello-world-example/
 */
public class LoadLoggerProperties {

    private static final Logger logger = Logger.getLogger(LoadLoggerProperties.class);

    public static void main(String args[]) throws IOException {

        //loading properties
        String logProperties =
                "src/main/java/"
                + LoadLoggerProperties.class.getPackage().getName().replaceAll("[.]", "/")
                + "/log4j.properties"
        ;
        Path path = Paths.get(logProperties).toAbsolutePath();
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
            PropertyConfigurator.configure(properties);
        }

        //testing logger
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
    }
}
