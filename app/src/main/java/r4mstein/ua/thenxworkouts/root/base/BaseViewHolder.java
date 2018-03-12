package r4mstein.ua.thenxworkouts.root.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Alex Shtain on 10.03.2018.
 */

public abstract class BaseViewHolder<D extends BaseDataHolder> extends RecyclerView.ViewHolder {
    private D data;
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    public final D getData() {
        return data;
    }
    public void setData(final D _data) {
        this.data = _data;
    }
}
