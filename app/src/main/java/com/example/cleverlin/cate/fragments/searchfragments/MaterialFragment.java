package com.example.cleverlin.cate.fragments.searchfragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.adapter.viewholder.SearchResultAdapter;
import com.example.cleverlin.cate.bean.ResultBean;
import com.example.cleverlin.cate.presenter.SearchPresenter;
import com.example.cleverlin.cate.view.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by cleverlin on 2017/8/19.
 */

public class MaterialFragment extends Fragment {

    @BindView(R.id.search_input)
    EditText searchInput;
    @BindView(R.id.recycle_hint)
    ListView recycleHint;
    Unbinder unbinder;
    @BindView(R.id.search_btn)
    Button search_btn;
    @BindView(R.id.recycle_result)
    RecyclerView recycleResult;
    @BindView(R.id.delete)
    ImageView delete;
    @BindView(R.id.flowlayout)
    FlowLayout flowlayout;
    @BindView(R.id.hot_label)
    TextView hotLabel;
    @BindView(R.id.history_record)
    ListView historyRecord;
    @BindView(R.id.history_tv)
    TextView historyTv;
    @BindView(R.id.clear_history)
    Button clearHistory;
    /**
     * 搜素
     */
    private SearchResultAdapter searchResultAdapter;
    private List<ResultBean> resultData;
    private SearchPresenter searchPresenter;
    private boolean change = false;
    private ArrayAdapter<String> mArrAdapter;
    private List<String> hintString;

    private ArrayAdapter<String> mHistoryAdapter;
    private List<String> historyString;
    private SharedPreferences mPref;
    /*
    * 标签
    * */
    // private FlowLayout mFlowLayout;
    private LayoutInflater mInflater;
    private String[] mVals = new String[]{"Java", "111111111", "1","Java", "111", "12"
    ,"Java", "2111211", "14333"};//数据模拟，实际应从网络获取此数据

    //搜索历史
    private List<String> historyKeywords;
    public static final String KEY_HISTORY = "key_history";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_material, container, false);

        unbinder = ButterKnife.bind(this, view);

        init();
        initFlowView();
        initHistory();
        return view;
    }

    private void initHistory() {
        mPref = getContext().getSharedPreferences("history", Context.MODE_PRIVATE);
        historyKeywords = new ArrayList<String>();
        String history = mPref.getString(KEY_HISTORY, "");
        if (!TextUtils.isEmpty(history)) {
            List<String> list = new ArrayList<String>();
            for (Object o : history.split(",")) {
                list.add((String) o);
            }
            historyKeywords = list;
        }
        if (historyKeywords.size() > 0) {
            historyRecord.setVisibility(View.VISIBLE);
        } else {
            historyRecord.setVisibility(View.GONE);
        }
        mHistoryAdapter = new ArrayAdapter<String>(getContext(), R.layout.item_search_history, historyKeywords);
        historyRecord.setAdapter(mHistoryAdapter);
        historyRecord.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                searchInput.setText(historyKeywords.get(i));
                historyRecord.setVisibility(View.GONE);
                historyTv.setVisibility(View.GONE);
                clearHistory.setVisibility(View.GONE);

            }
        });
        mHistoryAdapter.notifyDataSetChanged();
    }

    private void initFlowView() {
        mInflater = LayoutInflater.from(getContext());
        initFlowData();
    }

    /**
     * 将数据放入流式布局
     */
    private void initFlowData() {
        for (int i = 0; i < mVals.length; i++) {
            TextView tv = (TextView) mInflater.inflate(
                    R.layout.search_label_tv, flowlayout, false);
            tv.setText(mVals[i]);
            final String str = tv.getText().toString();
            //点击事件
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //加入搜索历史纪录记录
                    Toast.makeText(getActivity(), str, Toast.LENGTH_LONG).show();
                }
            });
            flowlayout.addView(tv);
        }
    }

    public void init() {
        searchPresenter = new SearchPresenter(this);
        searchInput.addTextChangedListener(new EditChangedListener());
        //        recycleHint.setLayoutManager(new LinearLayoutManager(getContext()));
        //        recycleHint.setItemAnimator(new DefaultItemAnimator());
        recycleResult.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleResult.setItemAnimator(new DefaultItemAnimator());

    }

    public void initResultData(List<ResultBean> data) {
        resultData = data;
        int cnt = resultData.size();
        // hintAdapter = new HintAdapter(getContext(), resultData);
        hintString = new ArrayList<>(cnt);
        for (int i = 0; i < cnt; i++) {
            hintString.add(resultData.get(i).getName());
        }
        mArrAdapter = new ArrayAdapter<String>(getActivity(), R.layout.item_search_history, hintString);
        mArrAdapter.notifyDataSetChanged();
        recycleHint.setAdapter(mArrAdapter);
        recycleHint.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), hintString.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void onSearch() {
        flowlayout.setVisibility(View.GONE);
        hotLabel.setVisibility(View.GONE);
        recycleHint.setVisibility(View.GONE);
        recycleResult.setVisibility(View.VISIBLE);
        searchResultAdapter = new SearchResultAdapter(getContext(), resultData);
        //  Log.d("resultData", resultData.size() + "");
        searchResultAdapter.notifyDataSetChanged();
        recycleResult.setAdapter(searchResultAdapter);
    }

    @OnClick({R.id.delete, R.id.search_btn,R.id.clear_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.delete:
                searchInput.setText("");
                resultData.clear();
                break;
            case R.id.search_btn:
                onSearch();
                save();
                change = false;
                Toast.makeText(getActivity(), "sava success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clear_history:
                clearHistory();
        }
    }

    private void clearHistory() {
        mPref=getContext().getSharedPreferences("history",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=mPref.edit();
        editor.remove(KEY_HISTORY).commit();
        historyKeywords.clear();
        mHistoryAdapter.notifyDataSetChanged();
        historyRecord.setVisibility(View.GONE);
        Toast.makeText(getActivity(), "清楚搜索历史成功", Toast.LENGTH_LONG).show();

    }

    private void save() {
        historyTv.setVisibility(View.GONE);
        clearHistory.setVisibility(View.GONE);
        historyRecord.setVisibility(View.GONE);
        String nowValue = searchInput.getText().toString();
        String beforeValue = mPref.getString(KEY_HISTORY, "");
        if (!TextUtils.isEmpty(nowValue) && !(beforeValue.contains(nowValue))) {
            SharedPreferences.Editor editor = mPref.edit();
            if (historyKeywords.size() > 5) {
                historyKeywords.remove(historyKeywords.size() - 1);
            }
            editor.putString(KEY_HISTORY, nowValue + "," + beforeValue);
            editor.commit();
            historyKeywords.add(0, nowValue);
        }
    }

//    @OnClick(R.id.clear_history)
//    public void onViewClicked() {
//    }

    private class EditChangedListener implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            searchPresenter.searchResult(charSequence.toString());
            if (!"".equals(charSequence.toString())) {
                flowlayout.setVisibility(View.GONE);
                hotLabel.setVisibility(View.GONE);
                recycleHint.setVisibility(View.VISIBLE);
                delete.setVisibility(View.VISIBLE);
                clearHistory.setVisibility(View.GONE);
                historyTv.setVisibility(View.GONE);
                historyRecord.setVisibility(View.GONE);
                search_btn.setEnabled(true);


            } else {
                clearHistory.setVisibility(View.VISIBLE);
                historyTv.setVisibility(View.VISIBLE);
                historyRecord.setVisibility(View.VISIBLE);
                flowlayout.setVisibility(View.VISIBLE);
                hotLabel.setVisibility(View.VISIBLE);
                recycleHint.setVisibility(View.GONE);
                delete.setVisibility(View.GONE);

            }
            if (!change) {
                recycleResult.setVisibility(View.GONE);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}
