package youngs.step.study.android.scoresupporter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

const val SINGLES_CODE = 1

class PlayerInputSinglesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_input_singles)

        //「自分の名前」テキストを設定
        val player1Text = findViewById<EditText>(R.id.sin_myplayer) as EditText
        //「相手の名前」テキストを設定
        val player2Text = findViewById<EditText>(R.id.sin_oppplayer) as EditText

        // 「前の画面に戻る」ボタンを設定
        val prevButton = findViewById<Button>(R.id.prev) as Button
        // 「入力完了」ボタンを設定
        val nextButton = findViewById<Button>(R.id.next) as Button

        //prevButtton　クリックイベント(クリック時の動作)
        prevButton.setOnClickListener {

            //「前の画面に戻る」ボタン遷移時にDebugログを出力させる
            // tagは23文字以内で設定
            Log.d("PlayerInputSingles", "prevButton Clicked!")

            //MainActivityに遷移(MatchConfigurationActivityを終了)
            finish()
        }

        //nextButtton　クリックイベント(クリック時の動作)
        nextButton.setOnClickListener {

            //「入力完了」ボタン遷移時にDebugログを出力させる
            // tagは23文字以内で設定
            Log.d("PlayerInputSingles", "nextButton Clicked!")

            //次のActivityに遷移
            //intentを設定
            val intent = Intent(this, MatchMainSinglesActivity::class.java)
            //「自分の名前」テキストに入力された値を設定
            intent.putExtra("player1", player1Text.text.toString())
            //「相手の名前」テキストに入力された値を設定
            intent.putExtra("player2", player2Text.text.toString())
            //MatchMainSinglesActivityに遷移
            startActivityForResult(intent, SINGLES_CODE)

        }
    }
}
