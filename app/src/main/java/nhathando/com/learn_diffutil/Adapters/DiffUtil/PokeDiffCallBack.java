package nhathando.com.learn_diffutil.Adapters.DiffUtil;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

import nhathando.com.learn_diffutil.Models.Result;

public class PokeDiffCallBack extends DiffUtil.Callback {
    private final List<Result> mOldPokeList;
    private final List<Result> mNewPokeList;

    public PokeDiffCallBack(List<Result> mOldPokeList, List<Result> mNewPokeList) {
        this.mOldPokeList = mOldPokeList;
        this.mNewPokeList = mNewPokeList;
    }

    @Override
    public int getOldListSize() {
        return mOldPokeList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewPokeList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldPokeList.get(oldItemPosition).getName().compareTo(mNewPokeList.get(newItemPosition).getName()) == 0;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final Result oldPoke = mOldPokeList.get(oldItemPosition);
        final Result newPoke = mNewPokeList.get(newItemPosition);

        return oldPoke.getName().equals(newPoke.getName());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
