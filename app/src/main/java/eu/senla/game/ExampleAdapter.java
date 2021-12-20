package eu.senla.game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context context;
    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context context, ArrayList<ExampleItem> mExampleList) {
        this.context = context;
        this.mExampleList = mExampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        String image_Url = currentItem.getImage_Url();
        String create_names = currentItem.getValue_of_name();
        int create_count_player = currentItem.getValue_count_player();

        holder.text_name.setText(create_names);
        holder.text_counter_player.setText(create_count_player);
        Picasso.with(context).load(image_Url).fit().centerInside().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView text_name;
        public TextView text_counter_player;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_our_work);
            text_name = itemView.findViewById(R.id.names);
            text_counter_player = itemView.findViewById(R.id.count_player);
        }
    }
}
