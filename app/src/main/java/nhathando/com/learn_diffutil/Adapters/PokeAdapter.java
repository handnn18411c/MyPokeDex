package nhathando.com.learn_diffutil.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nhathando.com.learn_diffutil.Adapters.DiffUtil.PokeDiffCallBack;
import nhathando.com.learn_diffutil.Models.Pokemon;
import nhathando.com.learn_diffutil.Models.Result;
import nhathando.com.learn_diffutil.R;

public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.PokeViewHolder> {

    private List<Result> mPokeList;

    public PokeAdapter(List<Result> pokeList){
        mPokeList = pokeList;
    }

    public static class PokeViewHolder extends RecyclerView.ViewHolder{
        private TextView poke_Name;
//        private TextView poke_Type;
//        private ImageView poke_Img;

        public PokeViewHolder(final View v){
            super(v);
            poke_Name = v.findViewById(R.id.txtPokeName);
        }
    }

    @NonNull
    @Override
    public PokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pokeView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.poke_list_item, parent, false);
        PokeViewHolder pokeViewHolder = new PokeViewHolder(pokeView);
        return pokeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PokeViewHolder holder, final int position) {
        holder.poke_Name.setText(mPokeList.get(position).getName());
        holder.poke_Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "This is "+mPokeList.get(position).getUrl(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPokeList.size();
    }

    public Result getPokemon(int adapterPosition){
        return mPokeList.get(adapterPosition);
    }

    public void updateResult(List<Result> pokeList) {
//        mPokeList = pokeList;
////        notifyDataSetChanged();
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new PokeDiffCallBack(this.mPokeList, pokeList));
        diffResult.dispatchUpdatesTo(this);
        this.mPokeList.clear();
        this.mPokeList.addAll(pokeList);
    }

}
