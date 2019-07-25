package c.herokuprofiles.configuration;


import javax.sql.DataSource;
import java.net.URISyntaxException;

public interface BaseConfig {

      String getConfiguration();

      DataSource getDataSource() throws URISyntaxException;
}
