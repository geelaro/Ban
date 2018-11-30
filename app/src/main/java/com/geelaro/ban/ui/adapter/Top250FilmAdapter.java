package com.geelaro.ban.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DefaultDatabaseErrorHandler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geelaro.ban.R;
import com.geelaro.ban.bean.top250.Root;
import com.geelaro.ban.bean.top250.Subjects;
import com.geelaro.ban.utils.DisplayImgUtil;

import java.security.KeyStore;

import javax.security.cert.Certificate;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.internal.tls.OkHostnameVerifier;

/**
 * Created by LEE on 2018/3/8.
 */

public class Top250FilmAdapter extends RecyclerView.Adapter<Top250FilmAdapter.FilmViewHolder> {
    private Context mContext;
    private Root mRooot;

    public Top250FilmAdapter(Context context, Root root) {
        mContext = context;
        mRooot = root;
    }


    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_film_top250,parent,false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, int position) {
        holder.bindItem(mRooot.getSubjects().get(position), position);
    }

    @Override
    public int getItemCount() {
        return mRooot == null ? 0 : mRooot.getSubjects().size();
    }

    class FilmViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_image)
        ImageView ivFilm;
        @BindView(R.id.movie_title)
        TextView tvFilm;
        @BindView(R.id.movie_english_name)
        TextView tvFilmEnglish;
        @BindView(R.id.movie_date)
        TextView tvMovieDate;
        @BindView(R.id.movie_score)
        TextView tvFilmGrade;

        FilmViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        private void bindItem(Subjects subjects, int positon) {
            DisplayImgUtil.display(mContext, subjects.getImages().getLarge(), ivFilm);
            KeyStore.getDefaultType();
            tvFilm.setText(subjects.getTitle());
            tvFilmEnglish.setText(subjects.getOriginal_title());
            tvMovieDate.setText(subjects.getYear());
            tvFilmGrade.setText("评分:" + subjects.getRating().getAverage());
//            llItemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent=new Intent(context,FilmDetailActivity.class);
//                    intent.putExtra(FilmDetailActivity.EXTRA_ID,subjects.getId());
//                    context.startActivity(intent);
//                }
//            });

        }
    }
}
