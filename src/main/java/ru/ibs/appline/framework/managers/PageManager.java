package ru.ibs.appline.framework.managers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ibs.appline.framework.pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class PageManager {
    private static Logger LOGGER = LoggerFactory.getLogger("PageManager.class");
    private static PageManager pageManager;
    private Map<String, BasePage> pagesBox = new HashMap<>();

    private PageManager() {

    }

    public static PageManager getInstance() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * @return возвращает любого из наследников BasePage
     * <p>
     * Все страницы хранятся в специальном ящике,при старте фреймворка ящик пуст,
     * но он не null,т.к. поле мы проинициализировали сразу. Когда нам нужна определенная
     * страница,то ящик смотрит внутрь себя и проверяет если он совсем пустой или запрашиваемой
     * страницы в нем нет, то он создает новый экземпляр этой страницы и ложит в себя, в дальнейшем
     * если к нему снова обратятся по поводу данной страницы,то он отдаст эту же страницу,что онсоздал ранее.
     */
    public <T extends BasePage> T getPage(Class<T> page) {
        if (pagesBox.isEmpty() || pagesBox.get(page.getName()) == null) {
            try {
                pagesBox.put(page.getName(), page.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (T) pagesBox.get(page.getName());
    }

    /**
     Функция очищает pagesBox,при выключении фреймворка,
     чтобы страницы были заново проинициализированы.
     */
    void cleanPagesBox() {
        this.pagesBox.clear();
    }
}
