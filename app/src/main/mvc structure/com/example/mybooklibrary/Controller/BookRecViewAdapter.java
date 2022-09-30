package com.example.mybooklibrary.Controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;
import com.example.mybooklibrary.R;
import com.example.mybooklibrary.model.Utils;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {
    private static final String TAG = "BookRecViewAdapter";

    private ArrayList<Book> books= new ArrayList<>();
    private Context mContext;
    private String parentActivity;

    public BookRecViewAdapter(Context mContext, String parentActivity) {
        this.mContext = mContext;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtBookName.setText(books.get(position).getName());
        // Clicking the book picture
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,BookActivity.class);
                // passing data with navigating user
                intent.putExtra("bookId",books.get(position).getId());
                mContext.startActivity(intent);
            }
        });
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.imgBook);

        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtShortDesc.setText(books.get(position).getShortDesc());
        if (books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.btnDownArrow.setVisibility(View.GONE);

            if (parentActivity.equals("allBooks")){
                holder.btnDelete.setVisibility(View.GONE);
            }
            else if (parentActivity.equals("alreadyRead")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName()+"?");
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromAlreadyRead(books.get(position))){
                                    Toast.makeText(mContext, "Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
            else if (parentActivity.equals("currentlyReading")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName()+"?");
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromCurrentlyReading(books.get(position))){
                                    Toast.makeText(mContext, "Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
            else if (parentActivity.equals("wantToRead")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName()+"?");
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromWantToRead(books.get(position))){
                                    Toast.makeText(mContext, "Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
            else{
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName()+"?");
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromFavoriteBook(books.get(position))){
                                    Toast.makeText(mContext, "Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
        }
        else{
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.btnDownArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgBook;
        private TextView txtBookName;

        private ImageView btnDownArrow, btnUpArrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtAuthor, txtShortDesc;
        private TextView btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent= itemView.findViewById(R.id.parent);
            imgBook= itemView.findViewById(R.id.imgBook);
            txtBookName= itemView.findViewById(R.id.txtBookName);

            btnDownArrow= itemView.findViewById(R.id.btnDownArrow);
            btnUpArrow= itemView.findViewById(R.id.btnUpArrow);
            expandedRelLayout= itemView.findViewById(R.id.expandedRelLayout);
            txtAuthor= itemView.findViewById(R.id.txtAuthor);
            txtShortDesc= itemView.findViewById(R.id.txtShortDesc);

            btnDelete=itemView.findViewById(R.id.btnDelete);

            btnDownArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book= books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            btnUpArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book= books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });



        }
    }
}
