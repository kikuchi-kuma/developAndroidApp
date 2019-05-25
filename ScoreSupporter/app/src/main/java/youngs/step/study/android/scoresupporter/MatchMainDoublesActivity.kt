package youngs.step.study.android.scoresupporter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MatchMainDoublesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_main_doubles)

        //「自分の名前1」テキストにPlayInputDoublesActivityから渡された「自分の名前」を設定
        val player1Text = findViewById<TextView>(R.id.sc_dou_myplayer1) as TextView
        player1Text.text = "${intent.extras.get("player1")}"
        //「自分の名前2」テキストにPlayInputDoublesActivityから渡された「自分の名前」を設定
        val player2Text = findViewById<TextView>(R.id.sc_dou_myplayer2) as TextView
        player2Text.text = "${intent.extras.get("player2")}"
        //「相手の名前1」テキストにPlayInputDoublesActivityから渡された「自分の名前」を設定
        val player3Text = findViewById<TextView>(R.id.sc_dou_oppplayer1) as TextView
        player3Text.text = "${intent.extras.get("player3")}"
        //「相手の名前2」テキストにPlayInputDoublesActivityから渡された「自分の名前」を設定
        val player4Text = findViewById<TextView>(R.id.sc_dou_oppplayer2) as TextView
        player4Text.text = "${intent.extras.get("player4")}"

        // 「Topに戻る」ボタンを設定
        val prevButton = findViewById<Button>(R.id.prev) as Button
        // 「スコアの記録」ボタンを設定
        val nextButton = findViewById<Button>(R.id.next) as Button

        //prevButtton　クリックイベント(クリック時の動作)
        prevButton.setOnClickListener {

            //「Topに戻る」ボタン遷移時にDebugログを出力させる
            // tagは23文字以内で設定
            Log.d("MatchMainDoubles", "prevButton Clicked!")

            //MainActivityに遷移(MatchConfigurationActivityを終了)
            //MainActivityに遷移
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //nextButtton　クリックイベント(クリック時の動作)
        nextButton.setOnClickListener {

            //「スコアの記録」ボタン遷移時にDebugログを出力させる
            // tagは23文字以内で設定
            Log.d("MatchMainDoubles", "nextButton Clicked!")

            //次のActivityに遷移

        }
    }
}
