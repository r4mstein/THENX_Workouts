package r4mstein.ua.thenxworkouts.root.error;

/**
 * Created by Alex Shtain on 28.03.2018.
 */
public interface IErrorManager {

    enum Type {
        ERROR, WARNING, INFO
    }

    String getTitle(Type _type);
    String getErrorMessage(String _operationName, String _message);
}
