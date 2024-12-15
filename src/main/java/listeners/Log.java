package listeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.Logger;

public class Log {
    protected static final Logger log = LogManager.getLogger();

    public void info(String s) {
        log.info(s);
    }

    public void error(String s) {
        log.error(s);
    }

    public void warn(String s) {
        log.warn(s);
    }

    public static void clearLogs() {
        Configuration config = ((LoggerContext) LogManager.getContext(false)).getConfiguration();
        RollingFileAppender appender = config.getAppender("MyAppender");

        if (appender != null) {
            appender.stop();
            appender.start();
        }

        Configurator.reconfigure(config);
    }
}
