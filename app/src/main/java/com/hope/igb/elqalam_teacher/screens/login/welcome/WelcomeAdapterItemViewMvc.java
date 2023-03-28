package com.hope.igb.elqalam_teacher.screens.login.welcome;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.screens.comman.views.BaseObservableMvc;

 class WelcomeAdapterItemViewMvc extends BaseObservableMvc<WelcomeAdapterItemViewMvc.WelcomeItemListener> {

     protected interface WelcomeItemListener {
    }


    private final TextView title_view, content_view;
    private final ImageView imageView;


     WelcomeAdapterItemViewMvc(LayoutInflater inflater , ViewGroup parent) {
         setRootView(inflater.inflate(R.layout.welcome_pager_adapter, parent, false));

         imageView = findViewById(R.id.welcome_adapter_image);
         title_view = findViewById(R.id.welcome_adapter_title_text);
         content_view = findViewById(R.id.welcome_adapter_content_text);
     }



     protected void bindView(int imageRes, String title, String content ){
         imageView.setImageResource(imageRes);
         title_view.setText(title);
         content_view.setText(content);

     }


}
