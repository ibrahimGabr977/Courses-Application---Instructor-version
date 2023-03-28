package com.hope.igb.elqalam_teacher.screens.addlesson;


import android.view.LayoutInflater;
import android.view.View;

import com.hope.igb.elqalam_teacher.databinding.AddLessonBaseFragmentBinding;
import com.hope.igb.elqalam_teacher.screens.comman.views.BaseObservableMvc;

 class AddLessonBaseViewMvc extends BaseObservableMvc<AddLessonBaseViewMvc.AddLessonBaseListener> {

    protected interface AddLessonBaseListener {
        void onNextPageClicked(int position);
        void onPreviousClicked(int position);
        void onBackClicked();
    }

    private final AddLessonBaseFragmentBinding view_binding;
    private final PageIndicators pageIndicators;
    private static int page_position = 0;


    protected AddLessonBaseViewMvc(LayoutInflater inflater) {
        view_binding = AddLessonBaseFragmentBinding.inflate(inflater);
        setRootView(view_binding.getRoot());

        pageIndicators = new PageIndicators(getRootView());

        initClickableViews();
    }



    private void initClickableViews(){
        view_binding.nextPage.setOnClickListener(v -> onNextClicked());

        view_binding.previousPage.setOnClickListener(v-> OnPreviousPageClicked());

        view_binding.back.setOnClickListener(v -> onBackClicked());

    }

    private void onBackClicked() {
        for (AddLessonBaseListener listener : getListeners())
            listener.onBackClicked();
    }

    private void OnPreviousPageClicked() {

        for (AddLessonBaseListener listener : getListeners())
            listener.onPreviousClicked(page_position - 1);

        if (page_position == 1)
            view_binding.previousPage.setVisibility(View.GONE);

        pageIndicators.previousPage(page_position);

        page_position--;
    }

    private void onNextClicked() {

        view_binding.previousPage.setVisibility(View.VISIBLE);

        if (page_position < 3) {

            for (AddLessonBaseListener listener : getListeners())
                listener.onNextPageClicked(page_position +1);

            pageIndicators.nextPage(page_position);

            page_position++;
        }
    }


    protected int getFragmentsContainerLayout(){
        return view_binding.pagesFrameLayout.getId();
    }


}
