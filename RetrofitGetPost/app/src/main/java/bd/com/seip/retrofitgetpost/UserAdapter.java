package bd.com.seip.retrofitgetpost;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.postId.setText("Post Id : " + String.valueOf(user.getPostId()));
        holder.id.setText("Id : " + String.valueOf(user.getId()));
        holder.name.setText("Name  : " + user.getName());
        holder.email.setText("Email : " + user.getEmail());
        holder.body.setText("Body : " + user.getBody());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView postId, id, name, email, body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            postId = itemView.findViewById(R.id.postIdTv);
            id = itemView.findViewById(R.id.idTv);
            name = itemView.findViewById(R.id.nameTv);
            email = itemView.findViewById(R.id.emailTv);
            body = itemView.findViewById(R.id.bodyTv);
        }
    }
}
