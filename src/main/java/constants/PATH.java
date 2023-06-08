package constants;

import java.nio.file.Paths;

public interface PATH {
    String PROPERTIES = Paths.get("src", "test", "resources", "properties").toFile().getAbsolutePath();
}