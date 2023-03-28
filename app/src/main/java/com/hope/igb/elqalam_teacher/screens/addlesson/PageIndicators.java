package com.hope.igb.elqalam_teacher.screens.addlesson;

import android.os.Build;
import android.view.View;
import android.widget.SeekBar;
import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.screens.comman.views.BaseViewMvc;

import java.util.ArrayList;

public class PageIndicators extends BaseViewMvc {



    private final SeekBar seekBar;
    private final ArrayList<View> indicators;

    public PageIndicators(View rootView){
        setRootView(rootView);

        seekBar = findViewById(R.id.page_seekbar);
        indicators = new ArrayList<>(4);
        initIndicators();

    }

    private void initIndicators(){
        indicators.add(findViewById(R.id.page_indicator1_text));
        indicators.add(findViewById(R.id.page_indicator2_text));
        indicators.add(findViewById(R.id.page_indicator3_text));
        indicators.add(findViewById(R.id.page_indicator_last_image));
    }



    public void nextPage(int currentPage){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            seekBar.setProgress(estimateProgressAtPosition(currentPage+1), true);
        }else
            seekBar.setProgress(estimateProgressAtPosition(currentPage+1));


        indicators.get(currentPage+1).setBackgroundResource(R.drawable.d_add_lesson_page_indicator_selectedbg);
    }



    public void previousPage(int currentPage){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            seekBar.setProgress(estimateProgressAtPosition(currentPage - 1), true);
        }else
            seekBar.setProgress(estimateProgressAtPosition(currentPage - 1));


        indicators.get(currentPage).setBackgroundResource(R.drawable.d_add_lesson_page_indicator_unselectedbg);
    }



    private int estimateProgressAtPosition(int position){
        return 25+(position * 25);
    }
}
