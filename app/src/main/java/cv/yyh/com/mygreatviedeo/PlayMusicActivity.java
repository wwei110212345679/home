package cv.yyh.com.mygreatviedeo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.squareup.picasso.Picasso;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 类功能描述：</br>
 * 音乐播放器
 * @author yuyahao
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
public class PlayMusicActivity extends Activity{
    private JCVideoPlayerStandard jc_music;
    private Button btn_play_musiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playmusicactivity);
        jc_music = (JCVideoPlayerStandard) findViewById(R.id.jc_music);

        jc_music.setUp("http://abv.cn/music/红豆.mp3"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "播放音乐");
        Picasso.with(this)
                .load("http://img4.jiecaojingxuan.com/2016/11/23/00b026e7-b830-4994-bc87-38f4033806a6.jpg@!640_360")
                .into(jc_music.thumbImageView);
        findViewById(R.id.btn_play_musiv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

}
