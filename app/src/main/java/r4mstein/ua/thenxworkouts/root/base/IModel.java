package r4mstein.ua.thenxworkouts.root.base;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public interface IModel<P extends IPresenter> {
    void setPresenter(P _presenter);
    void removePresenter();
    boolean isHasPresenter();
}
