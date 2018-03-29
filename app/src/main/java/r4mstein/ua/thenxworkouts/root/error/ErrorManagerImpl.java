package r4mstein.ua.thenxworkouts.root.error;

import android.content.Context;

import javax.inject.Inject;

import r4mstein.ua.thenxworkouts.R;

/**
 * Created by Alex Shtain on 28.03.2018.
 */
public final class ErrorManagerImpl implements IErrorManager {

    private Context mContext;

    @Inject
    public ErrorManagerImpl(final Context _context) {
        mContext = _context;
    }

    @Override
    public String getTitle(final Type _type) {
        switch (_type) {
            case INFO:
                return mContext.getString(R.string.dialog_title_info);
            case ERROR:
                return mContext.getString(R.string.dialog_title_error);
            case WARNING:
                return mContext.getString(R.string.dialog_title_warning);

            default: throw new IllegalArgumentException("Illegal incoming type");
        }
    }

    @Override
    public String getErrorMessage(String _operationName, String _message) {
        return String.format("%s failed, cause: \n%s", _operationName, _message);
    }
}
