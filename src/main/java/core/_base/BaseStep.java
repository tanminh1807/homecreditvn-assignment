package core._base;

import java.util.HashMap;
import java.util.Map;

public class BaseStep {
    private final Map<Class<?>, Object> initializedPage;
    private Map<String, Object> dataSaver;

    public BaseStep() {
        initializedPage = new HashMap<Class<?>, Object>();
        dataSaver = new HashMap<>();
    }

    protected <T extends BasePage> T on(Class<T> page) {
        T pageObject = null;
        try {
            if (initializedPage.get(page) == null) {
                pageObject = page.getDeclaredConstructor().newInstance();
                initializedPage.put(page, pageObject);
            } else {
                pageObject = page.cast(initializedPage.get(page));
            }
        } catch (Exception e) {
            throw new RuntimeException("The page is NOT able to open");
        }
        return pageObject;
    }
}