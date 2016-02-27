package razerdp.friendcircle.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import razerdp.friendcircle.R;
import razerdp.friendcircle.api.network.base.BaseResponse;
import razerdp.friendcircle.api.network.request.FriendCircleRequest;
import razerdp.friendcircle.utils.FriendCircleAdapterUtil;

public class FriendCircleDemoActivity extends FriendCircleBaseActivity {
    private FriendCircleRequest mCircleRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View header= LayoutInflater.from(this).inflate(R.layout.item_header,null,false);
        bindListView(R.id.listview,header, FriendCircleAdapterUtil.getAdapter(this,mMomentsInfos));
        initReq();
        //mListView.manualRefresh();
    }

    private void initReq() {
        mCircleRequest=new FriendCircleRequest(1001,0,8);
        mCircleRequest.setOnResponseListener(this);
    }

    @Override
    public ImageView bindRefreshIcon() {
        return (ImageView) findViewById(R.id.rotate_icon);
    }

    @Override
    public void onPullDownRefresh() {
        mCircleRequest.setStart(0);
        mCircleRequest.execute();
    }

    @Override
    public void onLoadMore() {
        mCircleRequest.execute();
    }

    @Override
    public void onSuccess(BaseResponse response) {
        super.onSuccess(response);
    }
}
